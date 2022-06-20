/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Kobe Douglas
 */
public class MainMenu {
    
    private boolean open;
    private HBox hBox;
    private VBox mainMenu;
    private Button play;
    private Button playerSelection;
    private ImageView img;
    
    /**
     *
     */
    public MainMenu(){
        mainMenu = new VBox();
        img = new ImageView("Title.png");
        hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setSpacing(0);
        hBox.setPrefWidth(700);
        hBox.setPrefHeight(200);
        hBox.getStyleClass().add("title");
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.getStyleClass().add("menu-type-1");
        mainMenu.getChildren().add(img);
        addPlayButton();
        addPlayerSelectionButton();
    }
    private void addPlayButton(){
        play = new Button();
        play.setFont(new Font("Type Embellishments One LET", 52));
        play.setText("PLAY");
        play.setFocusTraversable(false);
        play.setTextFill(Color.BLACK);
        play.setPrefWidth(200);
        play.setPrefHeight(100);
        mainMenu.getChildren().add(play);
    }
    private void addPlayerSelectionButton(){
        playerSelection = new Button();
        playerSelection.setFont(new Font("Verdana", 52));
        playerSelection.setText("SELECT PLAYER");
        playerSelection.setFocusTraversable(false);
        playerSelection.setTextFill(Color.BLACK);
        playerSelection.setPrefWidth(500);
        playerSelection.setPrefHeight(100);
        mainMenu.getChildren().add(playerSelection);
    }

    /**
     *
     * @return the play button
     */
    public Button getPlayButton(){
        return play;
    }

    /**
     *
     * @return player selection button
     */
    public Button getPlayerSelectionButton(){
        return playerSelection;
    }

    /**
     *
     * @param o sets the mainmenu to open or closed
     */
    public void setOpen(boolean o){
        open = o;
    }

    /**
     *
     * @return whether the mainmenu is open or closed
     */
    public boolean getOpen(){
        return open;
    }
    
    /**
     *
     * @param root is the main node
     */
    public void open(StackPane root){
        root.getChildren().add(mainMenu);
        open = true;
    }
    
    /**
     *
     * @param root is the main node
     */
    public void close(StackPane root){
        root.getChildren().remove(mainMenu);
        open = false;
    }
}
