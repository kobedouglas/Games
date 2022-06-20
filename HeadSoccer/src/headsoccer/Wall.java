/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

/**
 *
 * @author Kobe Douglas
 */
public class Wall extends Shape {

    /**
     *
     */
    public Wall(){
        super();
    }

    /**
     *
     * @param x is the x value of the goal
     * @param y is the y value of the goal
     * @param w is the width of the goal
     * @param h is the height of the goal
     * @param s is the side of the goal
     */
    public Wall(int x, int y, int w, int h, String s){
        super(x, y, w, h, s);
    }
    
    /**
     *
     * @param ball is the ball colliding with the wall
     */
    @Override
    public void onCollision(Shape ball) {
        // no code needed
    }

    /**
     *
     * @param s is the shape being checked for a collision with the wall
     */
    @Override
    public void checkCollision(Shape s) {
        
    }
}
