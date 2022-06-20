/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Kobe Douglas
 */
public class PauseMenu {
    private boolean open;
    private HBox hBox;
    private VBox vBox;
    private Button resume, restart, mainMenu;
    private boolean resumeAdded;
    
    /**
     *
     */
    public PauseMenu(){
        resumeAdded = true;
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: transparent");
        vBox.getStyleClass().add("menu-type-2");
        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);
        hBox.setStyle("-fx-background-color: transparent");
        
        addResumeButton();
        addMainMenuButton(); 
        addRestartButton();
        
        
        vBox.getChildren().add(hBox);
    }
    private void addResumeButton(){
        resume = new Button();
        resume.setFocusTraversable(false);
        resume.setFont(new Font("Verdana", 32));
        resume.setText("RESUME");
        resume.setTextFill(Color.BLACK);
        resume.setPrefWidth(200);
        resume.setPrefHeight(100);
        hBox.getChildren().add(resume);
    }

    /**
     *
     */
    public void removeResumeButton(){
        hBox.getChildren().remove(resume);
        resumeAdded = false;
    }

    /**
     *
     */
    public void addResumeButtonBack(){
        hBox.getChildren().remove(restart);
        hBox.getChildren().remove(mainMenu);
        hBox.getChildren().add(resume);
        hBox.getChildren().add(mainMenu);
        hBox.getChildren().add(restart);
        
        resumeAdded = true;
    }
    private void addRestartButton(){
        restart = new Button();
        restart.setFocusTraversable(false);
        restart.setFont(new Font("Verdana", 32));
        restart.setText("RESTART");
        restart.setTextFill(Color.BLACK);
        restart.setPrefWidth(200);
        restart.setPrefHeight(100);
        hBox.getChildren().add(restart);
    }
    private void addMainMenuButton(){
        mainMenu = new Button();
        mainMenu.setFocusTraversable(false);
        mainMenu.setFont(new Font("Verdana", 27));
        mainMenu.setText("MAIN MENU");
        mainMenu.setTextFill(Color.BLACK);
        mainMenu.setPrefWidth(200);
        mainMenu.setPrefHeight(100);
        hBox.getChildren().add(mainMenu);
    }

    /**
     *
     * @return the resume button
     */
    public Button getResumeButton(){
        return resume;
    }

    /**
     *
     * @return the restart button
     */
    public Button getRestartButton(){
        return restart;
    }

    /**
     *
     * @return the mainmenu button
     */
    public Button getMainMenuButton(){
        return mainMenu;
    }

    /**
     *
     * @param o sets the pausemenu to open or closed
     */
    public void setOpen(boolean o){
        open = o;
    }

    /**
     *
     * @return whether the pausemenu is open or closed
     */
    public boolean getOpen(){
        return open;
    }
    
    /**
     *
     * @param root is the main node
     */
    public void open(StackPane root){
        root.getChildren().add(vBox);
        
        open = true;
    }
    
    /**
     *
     * @param root is the main node
     */
    public void close(StackPane root){
        root.getChildren().remove(vBox);
        open = false;
    }

    /**
     *
     * @param r sets the resumeadded to true or false
     */
    public void setResumeAdded(boolean r){
        resumeAdded = r;
    }

    /**
     *
     * @return whether resume has been added or not
     */
    public boolean getResumeAdded(){
        return resumeAdded;
    }
}
