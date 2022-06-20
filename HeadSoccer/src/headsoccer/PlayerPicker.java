/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Kobe Douglas
 */
public class PlayerPicker {
    private boolean open;
    private HBox hBox;
    private BorderPane playerPicker;
    private Button playerOne, playerTwo, back;
    
    /**
     *
     */
    public PlayerPicker(){
        playerPicker = new BorderPane();
        playerPicker.getStyleClass().add("menu-type-1");
//        playerPicker.setStyle("-fx-background-color: rgb(0, 0, 0);");
        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(50);
        hBox.getStyleClass().add("hBox");
//        hBox.setStyle("-fx-background-color: rgb(0, 130, 240);");
        addPlayerOneButton();
        addPlayerTwoButton();
        addBackButton();
        playerPicker.setCenter(hBox);
    }
    private void addBackButton(){
        HBox topHBox = new HBox();
        topHBox.setAlignment(Pos.TOP_LEFT);
        topHBox.getStyleClass().add("hBox");
        back = new Button();
        back.setFocusTraversable(false);
        back.setFont(new Font("Verdana", 42));
        back.setText("BACK");
        back.setPrefSize(180, 80);
        back.setAlignment(Pos.TOP_LEFT);
        topHBox.getChildren().add(back);
        playerPicker.setTop(topHBox);
    }
    private void addPlayerOneButton(){
        playerOne = new Button();
        playerOne.setFocusTraversable(false);
        playerOne.setFont(new Font("Verdana", 52));
        playerOne.setText("PLAYER ONE");
        playerOne.setPrefWidth(450);
        playerOne.setPrefHeight(150);
        hBox.getChildren().add(playerOne);
    }
    private void addPlayerTwoButton(){
        playerTwo = new Button();
        playerTwo.setFocusTraversable(false);
        playerTwo.setFont(new Font("Verdana", 52));
        playerTwo.setText("PLAYER TWO");
        playerTwo.setPrefWidth(450);
        playerTwo.setPrefHeight(150);
        hBox.getChildren().add(playerTwo);
    }

    /**
     *
     * @return the playerone button
     */
    public Button getPlayerOneButton(){
        return playerOne;
    }

    /**
     *
     * @return the playertwo button
     */
    public Button getPlayerTwoButton(){
        return playerTwo;
    }

    /**
     *
     * @return the back button
     */
    public Button getBackButton(){
        return back;
    }

    /**
     *
     * @param o sets the playerpicker menu to be open or closed
     */
    public void setOpen(boolean o){
        open = o;
    }

    /**
     *
     * @return whether or not the playerpicker menu is open
     */
    public boolean getOpen(){
        return open;
    }
    
    /**
     *
     * @param root is the main node
     */
    public void open(StackPane root){
        root.getChildren().add(playerPicker);
        open = true;
    }
    
    /**
     *
     * @param root is the main node
     */
    public void close(StackPane root){
        root.getChildren().remove(playerPicker);
        open = false;
    }
}
