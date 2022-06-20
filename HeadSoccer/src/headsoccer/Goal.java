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
public class Goal extends Rectangle implements Renderable{
    private CrossBar bar;

    /**
     *
     * @param ex is the x value of the goal
     * @param why is the y value of the goal
     * @param w is the width of the goal
     * @param h is the height of the goal
     */
    public Goal(double ex, double why, double w, double h){
        super(ex, why, w, h);
        super.setColor(Color.CORAL);
        super.setSide("left");
        super.setThickness(10);
        bar = new CrossBar(ex, why - getThickness(), w, getThickness(), getColor(), null);
    }

    /**
     *
     * @param ex is the x value of the goal
     * @param why is the y value of the goal
     * @param w is the width of the goal
     * @param h is the height of the goal
     * @param c is the color of the goal
     */
    public Goal(double ex, double why, double w, double h, Color c){
        super(ex, why, w, h, c);
        super.setSide("left");
        super.setThickness(10);
        bar = new CrossBar(ex, why - getThickness(), w, getThickness(), c, null);
    }

    /**
     *
     * @param ex is the x value of the goal
     * @param why is the y value of the goal
     * @param w is the width of the goal
     * @param h is the height of the goal
     * @param c is the color of the goal
     * @param co is the color of the goal's bar
     * @param g is the side of the field on which the goal is
     * @param thic is the thickness of the goal posts
     */
    public Goal(double ex, double why, double w, double h, Color c, Color co, String g, double thic){
        super(ex, why, w, h, c, g, thic);
        bar = new CrossBar(ex, why - thic, w, thic, c, co);
        setSideColor(co);
    }

    /**
     *
     * @param b sets the goal's crossbar
     */
    public void setBar(CrossBar b){
        bar = b;
    }

    /**
     *
     * @return the goal's bar
     */
    public CrossBar getBar(){
        return bar;
    }

    /**
     *
     * @param s is the shape 
     */
    @Override
    public void onCollision(Shape s) {
        
    }

    /**
     *
     * @param s is the shape
     */
    @Override
    public void checkCollision(Shape s) {
        
    }
    
}
