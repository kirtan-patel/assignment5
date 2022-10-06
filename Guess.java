/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_000863115;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kirtan, 000863115 this file is the model where all the logic happens
 */
public class Guess {
    private int guessNumber;//stores what the user inputed 
    private int actualNumber;//stores the random int value
    private int lives = 5;//default live count
    private int points=400;//default point count
    /**
     * 
     * @return the updated live
     */
    public int getLives() {
        return lives;
    }
    /**
     * 
     * @return updated points
     */
    public int getPoints() {
        return points;
    }
    /**
     * 
     * @return returns the userInput number
     */
    public int getGuessNumber() {
        return guessNumber;
    }
    /**
     * 
     * @param guessNumber sets the guess number from userInput
     */
    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }
    /**
     * 
     * @return the actual number to be guessed
     */
    public int getActualNumber() {
        return actualNumber;
    }
  /**
   * 
   * @return a random number 
   */
    public int randomNumber() {
        actualNumber = (int) (1 * Math.random() * 10);
        return actualNumber;
    }
    /**
     * 
     * @param guess function that takes in user guess and compares it to check if it matches with some game logic
     */
    public void Check(int guess) {
        guessNumber = guess;// assigns the parameter guess to the guessNumber variable
        //if statement to check is lives are above 1 then do the following
        if (lives>=1) {
            //if number is guessed
            if (actualNumber == guess) {
            JFrame h = new JFrame();
            pointSystem();// calls the function pointSystem to calculate the points
            JOptionPane.showMessageDialog(h, "Wow you guessed it, you scored "+points);

        } else {
             //when user does not get the guess, live is minused by 1 and pointSYstem reduces the points based on live count
            JFrame h = new JFrame("opsss");
            lives--;
                System.out.println(lives);
            pointSystem();
            //displays message if the number gussed is higgher or lower than the actaul number
                if (guessNumber>actualNumber) {
                    JOptionPane.showConfirmDialog(h, "Opps, your number is bigger than what i am");
                } else {
                    JOptionPane.showConfirmDialog(h, "Opps, your number is smaller than what i am");
                }
        }
        }else{
            JFrame h = new JFrame("opsss");
            JOptionPane.showMessageDialog(h, "Opps, you ran out of lifes. Your points= "+points+" The number was: "+actualNumber);
            System.exit(0);
        }
        
    }
/**
 * Function that shows the answer, referenced to view class on the giveUp button
 */
    public void showAnswer() {
        JFrame h = new JFrame();
        JOptionPane.showMessageDialog(h, "The correct number was " + actualNumber);
        System.exit(0);
    }
/**
 * pointSystem function depending on your lives 
 */
    public void pointSystem() {
        if (lives == 5) {
            points = 400;
        } else if (lives == 4) {
            points = points-100;
        } else if (lives == 3) {
            points = points-100;
        } else if (lives == 2) {
            points = points-100;
        } else if (lives == 1) {
            points = points-150;
        } else {
            points = 0;
        }
    }

}
