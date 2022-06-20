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
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Kobe Douglas
 */
public class Foot extends Circle implements Renderable, Updateable {

    private double angleStart;
    private double angleEnd;
    private double angle;
    private boolean kicking = false;

    /**
     *
     * @param ex is the x value of the foot
     * @param why is the y value of the foot
     * @param width is the width of the foot
     * @param height is the height of the foot
     * @param c is the color of the foot
     * @param side is the side of the foot
     * @param angle is the angle between the foot and the player
     */
    public Foot(double ex, double why, double width, double height, Color c, String side, double angle) {
        super(ex, why, width, height, c, side);
        setAngle(angle);
        setAngleStart(angle);
        if (side.equals("left")) {
            setAngleEnd(0);
        }
        if (side.equals("right")) {
            setAngleEnd(Math.PI);
        }
    }

    /**
     *
     * @param ex is the x value of the foot
     * @param why is the y value of the foot
     * @param width is the width of the foot
     * @param height is the height of the foot
     * @param p is the image of the foot
     * @param side is the side of the foot
     * @param angle is the angle between the foot and the player
     */
    public Foot(double ex, double why, double width, double height, Image p, String side, double angle) {
        super(ex, why, width, height, p, side);
        setAngle(angle);
        setAngleStart(angle);
        if (side.equals("left")) {
            setAngleEnd(0);
        }
        if (side.equals("right")) {
            setAngleEnd(Math.PI);
        }
    }

    /**
     *
     * @param a sets the starting angle of the foot
     */
    public void setAngleStart(double a) {
        angleStart = a;
    }

    /**
     *
     * @return the starting angle of the foot
     */
    public double getAngleStart() {
        return angleStart;
    }

    /**
     *
     * @return the ending angle of the foot
     */
    public double getAngleEnd() {
        return angleEnd;
    }

    /**
     *
     * @param a sets the ending angle of the foot
     */
    public void setAngleEnd(double a) {
        angleEnd = a;
    }

    /**
     *
     * @param a sets the angle between the player and his foot
     */
    public void setAngle(double a) {
        angle = a;
    }

    /**
     *
     * @return the angle between the player and his foot
     */
    public double getAngle() {
        return angle;
    }

    /**
     *
     * @param k sets whether or not the player is kicking
     */
    public void setKicking(boolean k) {
        kicking = k;
    }

    /**
     *
     * @return if the player is kicking or not
     */
    public boolean getKicking() {
        return kicking;
    }

    /**
     *
     * @param s is the shape colliding with the foot
     */
    @Override
    public void onCollision(Shape s) {

    }

    /**
     *
     * @param canvas is the main canvas
     */
    @Override
    public void update(Canvas canvas) {

    }

    /**
     *
     * @param canvas is the main canvas
     */
    public void draw(Canvas canvas) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        if (getImage() == null) {
            graphics.setFill(getColor());
        } else {
            graphics.setFill(new ImagePattern(getImage()));
        }
        
        graphics.save();
        if (getSide().equals("left"))
        graphics.transform(new Affine(new Rotate(Math.toDegrees(getAngle()) - 45, getXcenter(), getYcenter())));
        else 
            graphics.transform(new Affine(new Rotate(Math.toDegrees(getAngle()) - 135, getXcenter(), getYcenter())));
        graphics.drawImage(getImage(), getX(), getY(), getWidth(), getHeight());
        graphics.restore();
    }

}
