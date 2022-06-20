/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Kobe Douglas
 */
public class PlayerSelection {
    private boolean open;
    private HBox hBox, bHBox;
    private BorderPane playerOne;
    private ToggleButton herman, thomas, bill, steve, mark;
    private ToggleButton aqua, mediumpurple, red, orange, green, blue;
    private Button back;
    private Image hermanpic, thomaspic, billpic, stevepic, markpic;
    private ToggleGroup togP, togC;
    
    /**
     *
     */
    public PlayerSelection(){
        togP = new ToggleGroup(); 
        togC = new ToggleGroup(); 
        
        playerOne = new BorderPane();
//        playerOne.setStyle("-fx-background-color: rgb(0, 0, 0);");
        playerOne.getStyleClass().add("menu-type-2");
        
        hBox = new HBox();
        hBox.getStyleClass().add("player-style");
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(40);
        hBox.setStyle("-fx-background-color: rgb(40, 40, 40);");
        
        bHBox = new HBox();
        bHBox.getStyleClass().add("color-style");
        bHBox.setAlignment(Pos.CENTER);
        bHBox.setSpacing(40);
        bHBox.setStyle("-fx-background-color: rgb(0, 0, 0);");
        
        addHermanButton();
        addBillButton();
        addMarkButton();
        addThomasButton();
        addSteveButton();
        
        addAquaButton();
        addMediumPurpleButton();
        addRedButton();
        addOrangeButton();
        addGreenButton();
        addBlueButton();
        
        addBackButton();
        
        playerOne.setCenter(hBox);
        playerOne.setBottom(bHBox);
    }
    private void addBackButton(){
        HBox topHBox = new HBox();
        topHBox.setAlignment(Pos.TOP_LEFT);
        topHBox.setStyle("-fx-background-color: black;");
        back = new Button();
        back.setFocusTraversable(false);
        back.setFont(new Font("Verdana", 42));
        back.setText("BACK");
        back.setPrefSize(180, 80);
        back.setAlignment(Pos.TOP_LEFT);
        topHBox.getChildren().add(back);
        playerOne.setTop(topHBox);
    }
    private void addAquaButton(){
        aqua = new ToggleButton();
        aqua.setToggleGroup(togC);
        aqua.setFocusTraversable(false);
        aqua.setStyle("-fx-background-color: AQUA;");
        aqua.setPrefWidth(200);
        aqua.setPrefHeight(200);
        bHBox.getChildren().add(aqua);
    }
    private void addMediumPurpleButton(){
        mediumpurple = new ToggleButton();
        mediumpurple.setToggleGroup(togC);
        mediumpurple.setFocusTraversable(false);
        mediumpurple.setStyle("-fx-background-color: MEDIUMPURPLE;");
        mediumpurple.setPrefWidth(200);
        mediumpurple.setPrefHeight(200);
        bHBox.getChildren().add(mediumpurple);
    }
    private void addRedButton(){
        red = new ToggleButton();
        red.setToggleGroup(togC);
        red.setFocusTraversable(false);
        red.setStyle("-fx-background-color: RED;");
        red.setPrefWidth(200);
        red.setPrefHeight(200);
        bHBox.getChildren().add(red);
    }
    private void addOrangeButton(){
        orange = new ToggleButton();
        orange.setToggleGroup(togC);
        orange.setFocusTraversable(false);
        orange.setStyle("-fx-background-color: ORANGE;");
        orange.setPrefWidth(200);
        orange.setPrefHeight(200);
        bHBox.getChildren().add(orange);
    }
    private void addGreenButton(){
        green = new ToggleButton();
        green.setToggleGroup(togC);
        green.setFocusTraversable(false);
        green.setStyle("-fx-background-color: GREEN;");
        green.setPrefWidth(200);
        green.setPrefHeight(200);
        bHBox.getChildren().add(green);
    }
    private void addBlueButton(){
        blue = new ToggleButton();
        blue.setToggleGroup(togC);
        blue.setFocusTraversable(false);
        blue.setStyle("-fx-background-color: BLUE;");
        blue.setPrefWidth(200);
        blue.setPrefHeight(200);
        bHBox.getChildren().add(blue);
    }
    private void addHermanButton(){
        hermanpic = new Image("herman150.jpg");
        herman = new ToggleButton();
        herman.setToggleGroup(togP);
        herman.setFocusTraversable(false);
        herman.setGraphic(new ImageView(hermanpic));
        herman.setPrefWidth(100);
        herman.setPrefHeight(100);
        hBox.getChildren().add(herman);
    }
    private void addThomasButton(){
        thomaspic = new Image("thomas150.jpg");
        thomas = new ToggleButton();
        thomas.setToggleGroup(togP);
        thomas.setFocusTraversable(false);
        thomas.setGraphic(new ImageView(thomaspic));
        thomas.setPrefWidth(100);
        thomas.setPrefHeight(100);
        hBox.getChildren().add(thomas);
    }
    private void addBillButton(){
        billpic = new Image("bill150.jpg");
        bill = new ToggleButton();
        bill.setToggleGroup(togP);
        bill.setFocusTraversable(false);
        bill.setGraphic(new ImageView(billpic));
        bill.setPrefWidth(100);
        bill.setPrefHeight(100);
        hBox.getChildren().add(bill);
    }
    private void addSteveButton(){
        stevepic = new Image("steve150.jpg");
        steve = new ToggleButton();
        steve.setToggleGroup(togP);
        steve.setFocusTraversable(false);
        steve.setGraphic(new ImageView(stevepic));
        steve.setPrefWidth(100);
        steve.setPrefHeight(100);
        hBox.getChildren().add(steve);
    }
    private void addMarkButton(){
        markpic = new Image("mark150.jpg");
        mark = new ToggleButton();
        mark.setToggleGroup(togP);
        mark.setFocusTraversable(false);
        mark.setGraphic(new ImageView(markpic));
        mark.setPrefWidth(100);
        mark.setPrefHeight(100);
        hBox.getChildren().add(mark);
    }
    
    /**
     *
     * @return the herman button
     */
    public ToggleButton getHermanButton(){
        return herman;
    }

    /**
     *
     * @return the thomas button
     */
    public ToggleButton getThomasButton(){
        return thomas;
    }

    /**
     *
     * @return the bill button
     */
    public ToggleButton getBillButton(){
        return bill;
    }

    /**
     *
     * @return the steve button
     */
    public ToggleButton getSteveButton(){
        return steve;
    }

    /**
     *
     * @return the mark button
     */
    public ToggleButton getMarkButton(){
        return mark;
    }

    /**
     *
     * @return the aqua button
     */
    public ToggleButton getAquaButton(){
        return aqua;
    }

    /**
     *
     * @return the purple button
     */
    public ToggleButton getMediumPurpleButton(){
        return mediumpurple;
    }

    /**
     *
     * @return the red button
     */
    public ToggleButton getRedButton(){
        return red;
    }

    /**
     *
     * @return the orange button
     */
    public ToggleButton getOrangeButton(){
        return orange;
    }

    /**
     *
     * @return the green button
     */
    public ToggleButton getGreenButton(){
        return green;
    }

    /**
     *
     * @return the blue button
     */
    public ToggleButton getBlueButton(){
        return blue;
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
     * @param o sets the player selection menu to be open or closed
     */
    public void setOpen(boolean o){
        open = o;
    }

    /**
     *
     * @return whether or not the player selection menu is open
     */
    public boolean getOpen(){
        return open;
    }
    
    /**
     *
     * @param root is the main node
     */
    public void open(StackPane root){
        root.getChildren().add(playerOne);
        open = true;
    }
    
    /**
     *
     * @param root is the main node
     */
    public void close(StackPane root){
        root.getChildren().remove(playerOne);
        open = false;
    }
}
