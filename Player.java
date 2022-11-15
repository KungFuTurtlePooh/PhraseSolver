/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private int points = 0;
  private String name;
  
  

  /* your code here - constructor(s) */ 
  public Player() {
    System.out.println("Enter a Name: ");
    this.name = new Scanner(System.in).nextLine();
    System.out.println("Hello and welcome to the game, " + this.name);
  }

  public Player(String inputName) {
    this.name = inputName;
    System.out.println("Hello and welcome to the game, " + this.name);
  }

  /* your code here - accessor(s) */ 
  public String getName() {
    return this.name;
  }

  public int getPoints() {
    return this.points;
  }

  /* your code here - mutator(s) */ 
  public void setName(String inputName) {
    this.name = inputName;
  }

  public void addPoints(int value) {
    this.points += value;
  }

}