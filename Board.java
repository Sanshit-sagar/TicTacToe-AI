package tictactoe;

import java.util.*;

public class Board {
    public String[][] board;
    public int[][] matrix;
    public int[] row_sum;
    public int[] col_sum;
    public int lr_diag_sum;
    public int rl_diag_sum;

    public Board() {
        board = new String[3][3];
        matrix = new int[3][3];

        for(int i = 0; i<3; i++) {
          for(int j = 0; j<3; j++) {
            board[i][j] = "-";
            matrix[i][j] = 0;
          }
        }

        row_sum = new int[3];
        col_sum = new int[3];
        lr_diag_sum = 0;
        rl_diag_sum = 0;
    }

    public void printBoard() {
      System.out.println("~ ~ ~ ~ ~");
      for(int i = 0; i<3; i++) {
        System.out.print("~ ");
        for(int j = 0; j<3; j++) {
          System.out.print(board[i][j] + " ");
        }
        System.out.println("~");
      }
      System.out.println("~ ~ ~ ~ ~");
    }

    public boolean playerMove(int y, int x, int player) {
      if(board[y][x]!="-")
        return false;

      if(player==1) {
        board[y][x] = "O";
        matrix[y][x]++;
        row_sum[y]++;
        col_sum[x]++;
        add_diagonal(y,x, 1);
      }
      else {
        board[y][x] = "X";
        matrix[y][x]--;
        row_sum[y]--;
        col_sum[x]--;
        add_diagonal(y,x,-1);
      }
      return true;
    }

    public void add_diagonal(int y,int x, int to_add) {
        if(y==1 && x==1) {
          lr_diag_sum += to_add;
          rl_diag_sum += to_add;
        }
        else if((y==0 && x==0) || (y==2 && x==2)) {
          lr_diag_sum += to_add;
        }
        else if((y==2 && x==0) || (y==0 && x==2)) {
          rl_diag_sum += to_add;
        }
    }

    public boolean check_win(int y, int x, int player) {
        if(y<0 || x<0 || y>2 || x>2) {
          return false;
        }

        if(player==1) {
          if((row_sum[y]==3) || (col_sum[x]==3))
            return true;
          else if (lr_diag_sum==3 || rl_diag_sum==3)
            return true;
        }
        else {
          if ((row_sum[y]==-3 || (col_sum[x])==-3))
            return true;
          else if(lr_diag_sum==-3 || rl_diag_sum==-3)
            return true;
        }
        return false;
    }

    public void check_stats() {
      System.out.println("");
      for(int i = 0; i<=2; i++) {
        System.out.println(row_sum[i] + "   " + col_sum[i]);
      }
      System.out.println("lr = " + lr_diag_sum);
      System.out.println("rl = " + rl_diag_sum);
      System.out.println("");
    }
}
