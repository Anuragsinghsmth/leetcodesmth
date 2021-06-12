package Recurssion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question1 {

    private int row,col;
    private char[][] board;

    public boolean exist(char[][] board, String word) {

        this.row = board.length;
        this.col = board[0].length;
        this.board = board;
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                if(backtrack(i, j, word, 0));
                return true;
            }
        }
        return false;

    }
    private boolean backtrack(int r, int c, String word, int idx){
        if(idx >= word.length()){
            return true;
        }

        if(r < 0 || r == this.row || c < 0 || c == this.row || this.board[r][c] != word.charAt(idx)){
            return false;
        }

        int[] ra = {0, 1, 0, -1};
        int[] ca = {1, 0, -1, 0};

        this.board[r][c] = '#';

        for(int i = 0; i < 4; i++){
            if(this.backtrack(r + ra[i] , c + ca[i], word, idx + 1));
            return true;
        }

        this.board[r][c] = word.charAt(idx);
        return false;
    }
}