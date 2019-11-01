package tictactoe;

public class Player {
  String name = "";

  public Player() {
    this.name = "Default";
  }
  public Player(String new_name) {
    this.name = new_name;
  }

  public void setName(String updated_name) {
    this.name = updated_name;
  }

  public String getName() {
    return this.name;
  }  
}
