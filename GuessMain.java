/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_000863115;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author kirtan, 000863115, kirtankumar patel. This is the Main view file for the guess game
 * 
 */
public class GuessMain extends Application {
    //declare components to be used in the game
    private final Guess guess = new Guess();
    private Label lb;
    private TextField userInput;
    private Label desc;
    private Label life;
    private int currentLife=5;
    
//
    /**
     * 
     * @param event an action event for the button check
     * function check that class the guessValue from the mocel class and compares it with the userInput 
     */
    private void Check(ActionEvent event) {
        int guessValue = Integer.parseInt(userInput.getText());// converting the input number from the user to a int
        currentLife = currentLife-1;// updating life state
        guess.Check(guessValue);// calling check function from model class
        life.setText("Down to: "+currentLife+" lives");//updating text for life count 
        System.out.println(currentLife);//debug
    }
//    private int updateLife(){
//        currentLife= currentLife-1;
//        return currentLife;
//    }
    /**
     * 
     * @param event an action for the button giveUp
     * Function shows the correct answer when a person gives up
     */
    private void giveUp(ActionEvent event) {
        guess.showAnswer();
    }

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        root.setId("pane");
        Scene scene = new Scene(root, 600, 300);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Guess The Number");
        primaryStage.setScene(scene);
        guess.randomNumber();
        // declare
        Label test = new Label(String.valueOf(guess.getActualNumber()));
        System.out.println("The correct number is "+guess.getActualNumber());
        lb = new Label("What number am i thinking?");
        desc = new Label("I am a number between 0-10");
        userInput = new TextField();
        Button checkAnswer = new Button("Check");
        checkAnswer.setId("check");
        Button giveUp = new Button("Give up");
        giveUp.setId("giveUp");
        checkAnswer.setOnAction(this::Check);//setting action to function check when check button is clicked
        life = new Label("Your lives: "+currentLife);

        // add all elements
        root.getChildren().addAll(userInput, lb, checkAnswer, desc, giveUp, life);
        // relocate
        test.relocate(0, 0);
        checkAnswer.relocate(140, 74);
        lb.relocate(50, 50);
        desc.relocate(50, 280);
        userInput.relocate(205, 45);
        giveUp.relocate(250, 74);
        life.relocate(500, 0);
        // button action
        
        giveUp.setOnAction(this::giveUp);// setting action to giveUp function when the button is clicked
        // show stage
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
