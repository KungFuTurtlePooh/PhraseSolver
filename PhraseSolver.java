/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private boolean solved = false;
  private Player player1;
  private Player player2;
  private Board game;

  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    this.player1 = new Player();
    this.player2 = new Player();
    this.game = new Board();
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;

    while (!solved) 
    {
      game.setLetterValue();
      System.out.println();
      System.out.println("Phrase: " + game.getSolvedPhrase());
      System.out.println("Current Letter Value: " + game.getLetterValue());



      String guess;
      /* your code here - game logic */
      if(currentPlayer%2 == 0)
      {
        System.out.println("Current Player: " + player2.getName());
        System.out.println("Input Guess: ");
        guess = input.nextLine();
      }
      else
      {
        System.out.println("Current Player: " + player1.getName());
        System.out.println("Input Guess: ");
        guess = input.nextLine();
      }
      
      if (guess.length() == 1) 
      {
        game.guessLetter(guess);
        if(currentPlayer%2 == 0)
        {
          player2.addPoints(game.getLetterValue());
        }
        else
        {
          player1.addPoints(game.getLetterValue());
        }
      }

      if (game.isSolved(guess))
      {
        if(currentPlayer%2 == 0)
        {
          player2.addPoints(10000000);
        }
        else
        {
          player1.addPoints(10000000);
        }
        solved = true;
      }
      if(game.getSolvedPhrase().indexOf("_") == -1)
      {
        solved = true;
      }
      System.out.println();
      currentPlayer++;
      
      /* your code here - determine how game ends */
      
    }
    System.out.println(game.getPhrase()); 
    if(player1.getPoints() > player2.getPoints())
    {
      System.out.println( player1.getName() + " Wins!");
    }
    else if(player1.getPoints() < player2.getPoints())
    {
      System.out.println( player2.getName() + " Wins!");
    }
    else
    {
      System.out.println("Tie");
    }

    System.out.println("Player 1: " + player1.getPoints());
    System.out.println("Player 2: " + player2.getPoints());
   
  }
  
  
}