/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 *
 * @author Kobe Douglas
 */
public abstract class Player extends Circle implements Updateable, Renderable {

    /**
     *
     */
    public Player() {
        super();

    }

    /**
     *
     * @param ex is the x value of the player
     * @param why is the y value of the player
     * @param w is the width of the player
     * @param h is the height of the player
     * @param co is the color of the player
     */
    public Player(double ex, double why, double w, double h, Color co) {
        super(ex, why, w, h, co);
    }

    /**
     *
     * @param ex is the x value of the player
     * @param why is the y value of the player
     * @param w is the width of the player
     * @param h is the height of the player
     * @param p is the image of the player
     */
    public Player(double ex, double why, double w, double h, Image p){
        super(ex, why, w, h, p);
    }

    /**
     *
     * @param ex is the x value of the player
     * @param why is the y value of the player
     * @param w is the width of the player
     * @param h is the height of the player
     */
    public Player(double ex, double why, double w, double h) {
        super(ex, why, w, h);
    }

    /**
     *
     * @param p is the player colliding with this player
     * @return
     */
    public boolean colliding(Player p) {
        double distance = Math.sqrt(Math.pow(getXcenter() - ((Circle) p).getXcenter(), 2) + Math.pow(getYcenter() - ((Circle) p).getYcenter(), 2) - 5);
        double rDistance = getR() + ((Circle) p).getR();
        if (distance <= rDistance) {
            return true;
        }
        return false;
    }
//    public abstract void checkCollision(Shape s);

    /**
     *
     */
    public void onCollision() {

    }

    /**
     *
     * @param canvas is the main canvas
     */
    @Override
    public void update(Canvas canvas) {

    }
}
