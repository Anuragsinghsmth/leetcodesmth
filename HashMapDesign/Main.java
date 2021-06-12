package HashMapDesign;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static class HashMap<K,V>{
        private class HMNode{
            K key;
            V value;
            HMNode(K k, V v){
                this.key = k;
                this.value = v;
            }
        }

        private int size;
        private LinkedList<HMNode> [] bucket;
        public HashMap() {
            initBucket(4);
            size = 0;
        }

        private void initBucket(int N){
            for(int i =0 ; i < N; i++){
                bucket[i] = new LinkedList<>();
            }
        }

        private int hasfun(K k){
            int has = k.hashCode();
            return Math.abs(has) % bucket.length;
        }

        private int getIndexWithinBucket(int bi, K k){
            int di = 0;
            for(HMNode node : bucket[bi]){
                if(node.key == k){
                    return di;
                }
            }
            return -1;
        }

        private void rehash(){
            LinkedList<HMNode>[] oldb = bucket;

            initBucket(oldb.length * 2);
            for(int i =0; i< oldb.length ;i++){
                for(HMNode node : oldb[i]){
                    put(node.key, node.value);
                }
            }

        }

        public void put(K k, V v){
            int bi = hasfun(k);
            int di = getIndexWithinBucket(bi, k);

            if(di != -1){
                HMNode node = bucket[bi].get(di);
                node.value = v;
            } else{
                bucket[bi].add(new HMNode(k, v));
                size++;
            }

            double lambda = size*1.0 / bucket.length;

            if(lambda > 2.0){
                rehash();
            }

        }

        public boolean containsKey(K k){
            int bi = hasfun(k);
            int di = getIndexWithinBucket(bi, k);

            if(di != -1){
                return true;
            } else{
                return false;
            }
        }

        public V remove(K k){

            int bi = hasfun(k);
            int di = getIndexWithinBucket(bi, k);
            if(di != -1){
                HMNode node = bucket[bi].remove(di);
                return node.value;
            } else{
                return null;
            }
        }

        public V get(K k){
            int bi = hasfun(k);
            int di = getIndexWithinBucket(bi, k);
            if(di != -1){
                HMNode node  = bucket[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public int size(){
            return size;
        }

        public ArrayList<K> keySet(){

            ArrayList<K> ans = new ArrayList<>();

            for(int i =0; i< bucket.length ;i++){
                for(HMNode node : bucket[i]){
                    ans.add(node.key);
                }
            }

            return new ArrayList();
        }

    }

    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

    }
}
