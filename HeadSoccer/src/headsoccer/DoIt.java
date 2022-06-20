/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Kobe Douglas
 */
public class DoIt {

    /**
     *
     */
    public List<Renderable> Renderables;

    /**
     *
     */
    public List<Updateable> Updateable;

    /**
     *
     */
    public static List<Shape> GEs;
    private boolean open;
    private Canvas can;
    private HBox hBox;
    private Button pause;
    private Image pause50;

    /**
     *
     * @param canvas is the main canvas
     */
    public DoIt(Canvas canvas) {  
        Renderables = new ArrayList<Renderable>();
        Updateable = new ArrayList<Updateable>();
        GEs = new ArrayList<Shape>();
        can = canvas;
        
        
        hBox = new HBox();
        hBox.setAlignment(Pos.TOP_RIGHT);
        addPauseButton();
    }

    private void addPauseButton(){
        pause50 = new Image("pause50.png");
        pause = new Button();
        pause.setGraphic(new ImageView(pause50));
        pause.setPrefWidth(50);
        pause.setPrefHeight(50);
        pause.setStyle("-fx-background-color: transparent");
        pause.setAlignment(Pos.TOP_RIGHT);
        pause.setFocusTraversable(false);
        hBox.getChildren().add(pause);
    }

    /**
     *
     * @return the pause button
     */
    public Button getPauseButton(){
        return pause;
    }

    /**
     *
     * @param s is the shape being added
     */
    public void add(Shape s) {
        GEs.add(s);
        if (s instanceof Renderable) {
            Renderables.add((Renderable) s);
        }
        if (s instanceof Updateable) {
            Updateable.add((Updateable) s);
        }
    }
    
    /**
     *
     * @param index is the index at which to add shape
     * @param s is the shape being added
     */
    public void add(int index, Shape s) {
        GEs.add(index, s);
        if (s instanceof Renderable) {
            Renderables.add(index, (Renderable) s);
        }
        if (s instanceof Updateable) {
            Updateable.add(index, (Updateable) s);
        }
    }
    
    /**
     *
     * @param s is the shape being added
     */
    public void remove(Shape s){
        GEs.remove(s);
        if (s instanceof Renderable) {
            Renderables.remove((Renderable) s);
        }
        if (s instanceof Updateable) {
            Updateable.remove((Updateable) s);
        }
    }

    /**
     *
     * @param canvas is the main canvas
     */
    public void UpdateAll(Canvas canvas) {
        for (int i = 0; i < Updateable.size(); i++) {
            Updateable.get(i).update(canvas);
        }
    }

    /**
     *
     * @param canvas is the main canvas
     */
    public void DrawAll(Canvas canvas) {
        for (Renderable item : Renderables) {
            item.draw(canvas);
        }
    }

    /**
     *
     */
    public void CollideAll() {
        for (int i = 0; i < GEs.size(); i++) {
            for (int k = 0; k < GEs.size(); k++) {
                if (GEs.get(i) instanceof Ball && !(GEs.get(i) instanceof BigBall)) {
                    if (i != k) {
                        ((Circle) GEs.get(i)).checkCollision(GEs.get(k));
                    }
                }
                if (GEs.get(i) instanceof SoccerPlayer && !(GEs.get(k) instanceof Ball) && k != i) {
                    ((Circle) GEs.get(i)).checkCollision(GEs.get(k));
                }
            }
        }
    }
    
    /**
     *
     * @param root is the main node
     */
    public void open(StackPane root){
        root.getChildren().add(can);
        root.getChildren().add(hBox);
        open = true;
    }
    
    /**
     *
     * @param root is the main node
     */
    public void close(StackPane root){
        root.getChildren().remove(can);
        root.getChildren().remove(hBox);
        open = false;
    }
    
    /**
     *
     * @param o sets the game state to open or closed
     */
    public void setOpen(boolean o){
        open = o;
    }

    /**
     *
     * @return whether or not the game state is open
     */
    public boolean getOpen(){
        return open;
    }

}
