/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase = "";
  private String phrase = "";
  private int currentLetterValue = 0; 

  /* your code here - constructor(s) */ 
  public Board() {
    phrase = loadPhrase();
    setLetterValue();
  }
  
  /* your code here - accessor(s) */
  public String getPhrase() {
    return this.phrase;
  }

  public String getSolvedPhrase() {
    return this.solvedPhrase;
  }

  public int getLetterValue() {
    return this.currentLetterValue;
  }
  

  /* your code here - mutator(s)  */

  

  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    return phrase.equals(guess);
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  /* Finds out if the player's guessed letter appears in the phrase & 
  *  updates the solvedPhrase to show which characters have been found.
  *  
  *  Preconditions: Guess is populated and has 1 character in it.
  *  
  *  Postconditions: Method returns true/false and updates the solvedPhrase
  *  to show where your guess appears in the string.
  *
  */ 
  public boolean guessLetter(String guess)
  {
    // Sets foundLetter to a default value of false
    boolean foundLetter = false; 
    // Sets newSolvedPhrase to a default value of "" {Empty String}
    String newSolvedPhrase = "";
    
    // For loop which loops through each letter in phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      // Determines if the letter in phrase equals guess
      if (phrase.substring(i, i + 1).equals(guess))
      {
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      // Else, it keeps the set original character to show that the character was not found at that letter placement
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";
      }
    }
    // Sets the solvedPhrase attribute to a new updated one
    solvedPhrase = newSolvedPhrase;
    // returns true or false if the guessed letter appears in the phrase.
    return foundLetter;
  } 
} 