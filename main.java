package tictactoe;

import java.util.*;
import tictactoe.Board;

public class main {
  public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      Board board = new Board();
      int curr_player = 1;
      boolean exit_status = false;
      int curr_x = -1;
      int curr_y = -1;

      System.out.println("Welcome to Tic-Tac-Toe! Please follow the instructions below.");
      print_instructions();
      board.printBoard();
      prompt_next_turn(curr_player);

      String next_move = scanner.nextLine();
      while(exit_status!=true) {
        String[] next_move_arr = next_move.split(",");
        if(curr_player==-1) {
            curr_y = Integer.valueOf(next_move_arr[0]);
            curr_x = Integer.valueOf(next_move_arr[1]);
            boolean is_valid = board.playerMove(curr_x, curr_y, -1);
            boolean is_won = board.check_win(curr_x, curr_y, -1);
            if(is_won==true) {
              System.out.println("Sorry, Computer Wins!");
              board.printBoard();
              exit_status=true;
              continue;
            }
            board.printBoard();
        }
        else {
          if(next_move_arr.length!=2) {
            System.out.println("Illegal Input. Please try again.");
            next_move = scanner.nextLine();
            continue;
          }
          curr_y = Integer.valueOf(next_move_arr[0]);
          curr_x = Integer.valueOf(next_move_arr[1]);
          if(curr_y<0 || curr_x<0 || curr_y>2 || curr_x>2) {
            System.out.println("Illegal Move. Please try again.");
            next_move = scanner.nextLine();
            continue;
          }

          boolean is_valid = board.playerMove(curr_y, curr_x, curr_player);
          if(is_valid==false) {
            System.out.println("Cell is already occupied. Please try again.");
            next_move = scanner.nextLine();
            continue;
          }

          boolean is_won = board.check_win(curr_y, curr_x, curr_player);
          if(is_won==true) {
            String curr_player_str = "Player 1";
            System.out.println("Congratulations " + curr_player_str + " Wins !");
            board.printBoard();
            exit_status = true;
            continue;
          }
        }

        System.out.println("");
        System.out.println("-----Next turn------");
        curr_player *= -1;
        prompt_next_turn(curr_player);
        if(curr_player==1)
          next_move = scanner.nextLine();
        else
          next_move = "0,1";
      }
      System.out.println("Game Over.");
  }

  public static void print_instructions() {
    System.out.println("Instructions Here.");
  }
  public static void prompt_next_turn(int curr_player) {
    String curr_player_str = "Player 1";
    if(curr_player == -1) {
      curr_player_str = "the Computer";
    }

    System.out.println("It is " + curr_player_str + "s turn...");
  }

}
