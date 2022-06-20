/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 *
 * @author Kobe Douglas
 */
public abstract class PowerUps extends Circle implements Renderable {

    private boolean collide;
    private int displayTime;

    /**
     *
     * @param ex the x value of the power up
     * @param why is the y value of the power up
     * @param w is the width of the power up
     * @param h is the height of the power up
     * @param c is the color of the power up
     */
    public PowerUps(double ex, double why, double w, double h, Color c) {
        super(ex, why, w, h, c);
    }

    /**
     *
     * @param ex the x value of the power up
     * @param why is the y value of the power up
     * @param w is the width of the power up
     * @param h is the height of the power up
     * @param p is the image of the power up
     */
    public PowerUps(double ex, double why, double w, double h, Image p) {
        super(ex, why, w, h, p);
    }

    /**
     *
     * @param ex the x value of the power up
     * @param why is the y value of the power up
     * @param w is the width of the power up
     * @param h is the height of the power up
     * @param c is the color of the power up
     * @param p is the image of the power up
     */
    public PowerUps(double ex, double why, double w, double h, Color c, Image p) {
        super(ex, why, w, h, c, p);
    }

    /**
     *
     * @param b sets the collision of the power up with the ball
     */
    public void setCollide(boolean b) {
        collide = b;
    }

    /**
     *
     * @return whether or not the power up is colliding with the ball
     */
    public boolean getCollide() {
        return collide;
    }

    /**
     *
     * @param t sets the display time that the power up will show for
     */
    public void setDisplayTime(int t) {
        displayTime = t;
    }

    /**
     *
     * @return the display time that the power up will show
     */
    public int getDisplayTime() {
        return displayTime;
    }

    /**
     *
     * @param canW is the canvas width
     * @param canH is the canvas height
     * @param goalW is the goal width
     * @param goalH is the goal height
     */
    public void randomize(double canW, double canH, double goalW, double goalH) {
        setX(Math.random() * (canW - 2 * goalW - 70) + goalW);
        setY(Math.random() * (canH - goalH - (canH / 2 - 35)) + (canH / 2 - 35) - 70);
    }

    /**
     *
     * @param canvas is the main canvas
     */
    public void draw(Canvas canvas) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        if (getImage() != null && getColor() != null) {
            graphics.setFill(getColor());
            graphics.fillOval(getX(), getY(), getWidth(), getHeight());
            graphics.setFill(new ImagePattern(getImage()));
                graphics.fillOval(getX() + 5, getY() + 5, getWidth() - 10, getHeight() - 10);
        } else {
            if (getImage() == null) {
                graphics.setFill(getColor());
                graphics.fillOval(getX(), getY(), getWidth(), getHeight());
            } else {
                graphics.setFill(new ImagePattern(getImage()));
                graphics.fillOval(getX(), getY(), getWidth(), getHeight());
            }
        }

    }

    /**
     *
     * @param s is the shape that is colliding with power up
     */
    @Override
    public void onCollision(Shape s) {

    }

}
