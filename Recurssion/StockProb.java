package Recurssion;

public class StockProb {
//    public int maxProfit(int[] prices) {
//        int l = prices.length;
//        int[] nge = new int[l];
//        nge[l-1] = prices[l-1];
//        for(int j = l-2; j>=0; j-- ){
//            nge[j] = Math.max(prices[j], nge[j+1]);
//        }
//
//        int max = Integer.MIN_VALUE;
//        for(int i= 0; i<l;i++){
//            int k = nge[i] - prices[i];
//            if(k>max){
//                max = k;
//            }
//        }
//
//        return max;
//    }

    public void moveZeroes(int[] nums) {
        int st =0;
        int en = nums.length-1;
        while(st<en){
            if(nums[st] == 0){
                int temp = nums[st];
                nums[0] = nums[en];
                nums[en] = temp;
                st++;
                en--;
            }
            else{
                st++;
            }
        }
    }
}
