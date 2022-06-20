/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import javafx.scene.paint.Color;

/**
 *
 * @author Kobe Douglas
 */
public class Rectangle extends Shape {

    /**
     *
     */
    public Rectangle(){
        super();
    }

    /**
     *
     * @param ex is the x value of the rectangle 
     * @param why is the y value of the rectangle
     * @param w is the width of the rectangle
     * @param h is the height of the rectangle
     */
    public Rectangle(double ex, double why, double w, double h){
        super(ex, why, w, h);
    }

    /**
     *
     * @param ex is the x value of the rectangle 
     * @param why is the y value of the rectangle
     * @param w is the width of the rectangle
     * @param h is the height of the rectangle
     * @param c is the color of the rectangle
     */
    public Rectangle(double ex, double why, double w, double h, Color c){
        super(ex, why, w, h, c);
    }

    /**
     *
     * @param ex is the x value of the rectangle 
     * @param why is the y value of the rectangle
     * @param w is the width of the rectangle
     * @param h is the height of the rectangle
     * @param c is the color of the rectangle
     * @param g is the side of the rectangle
     * @param thic is the thickness of the rectangle
     */
    public Rectangle(double ex, double why, double w, double h, Color c, String g, double thic){
        super(ex, why, w, h, c, g, thic);
    }

    /**
     *
     * @param s is the shape being checked for a collision with the rectangle
     */
    @Override
    public void checkCollision(Shape s) {
        //circle's got it covered
    }

    /**
     *
     * @param s is the shape colliding with the rectangle
     */
    @Override
    public void onCollision(Shape s) {
    }
}
