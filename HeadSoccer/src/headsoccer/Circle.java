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
public abstract class Circle extends Shape {

    private double xCenter;
    private double yCenter;
    private double radius;
    private boolean collideBar = false;

    /**
     *
     */
    public Circle() {
        super(45, 45, 10, 10, Color.BLUE);
    }

    /**
     *
     * @param xC is the x center of the circle
     * @param yC is the y center of the circle
     * @param radii is the radius of the circle
     * @param c is the color of the circle
     */
    public Circle(double xC, double yC, double radii, Color c) {
        super(xC - radii, yC - radii, radii * 2, radii * 2, c);
        setR(radii);
        setXcenter(xC);
        setYcenter(yC);
    }

    /**
     *
     * @param xC is the x center of the circle
     * @param yC is the y center of the circle
     * @param radii is the radius of the circle
     * @param p is the image of the circle
     */
    public Circle(double xC, double yC, double radii, Image p) {
        super(xC - radii, yC - radii, radii * 2, radii * 2, p);
        setR(radii);
        setXcenter(xC);
        setYcenter(yC);
    }

    /**
     *
     * @param ex is the x value of the circle
     * @param why is the y value of the circle
     * @param w is the width of the circle
     * @param h is the height of the circle
     * @param co is the color of the circle
     */
    public Circle(double ex, double why, double w, double h, Color co) {
        super(ex, why, w, h, co);
        setR(w / 2); 
        setX(ex); 
        setY(why);
    }

    /**
     *
     * @param ex is the x value of the circle
     * @param why is the y value of the circle
     * @param w is the width of the circle
     * @param h is the height of the circle
     * @param p is the image of the circle
     */
    public Circle(double ex, double why, double w, double h, Image p) {
        super(ex, why, w, h, p);
        setR(w / 2);
        setX(ex);
        setY(why);
    }

    /**
     *
    * @param ex is the x value of the circle
     * @param why is the y value of the circle
     * @param w is the width of the circle
     * @param h is the height of the circle
     * @param c is the color of the circle
     * @param p is the image of the circle
     */
    public Circle(double ex, double why, double w, double h, Color c, Image p) {
        super(ex, why, w, h, c, p);
        setR(w / 2);
        setX(ex);
        setY(why);
    }

    /**
     *
     * @param ex is the x value of the circle
     * @param why is the y value of the circle
     * @param w is the width of the circle
     * @param h is the height of the circle
     */
    public Circle(double ex, double why, double w, double h) {
        super(ex, why, w, h);
        setR(w / 2);
        setX(ex);
        setY(why);
    }

    /**
     *
     * @param ex is the x value of the circle
     * @param why is the y value of the circle
     * @param w is the width of the circle
     * @param h is the height of the circle
     * @param co is the color of the circle
     * @param s is the side of the circle
     */
    public Circle(double ex, double why, double w, double h, Color co, String s) {
        super(ex, why, w, h, co, s);
        setR(w /2);
        setX(ex);
        setY(why);
    }

    /**
     *
     * @param ex is the x value of the circle
     * @param why is the y value of the circle
     * @param w is the width of the circle
     * @param h is the height of the circle
     * @param p is the image of the circle
     * @param s is the side of the circle
     */
    public Circle(double ex, double why, double w, double h, Image p, String s) {
        super(ex, why, w, h, p, s);
        setR(w /2);
        setX(ex);
        setY(why);
    }

    /**
     *
     * @param ex sets the x value and x center of the circle
     */
    public void setX(double ex) {
        super.setX(ex);
        xCenter = ex + getR();
    }

    /**
     *
     * @param why sets the y value and y center of the circle
     */
    public void setY(double why) {
        super.setY(why);
        yCenter = why + getR();
    }

    /**
     *
     * @param xC sets the x center and x value of the circle
     */
    public void setXcenter(double xC) {
        xCenter = xC;
        setX(xC - getR());
    }

    /**
     *
     * @return the x center of the circle
     */
    public double getXcenter() {
        return xCenter;
    }

    /**
     *
     * @param yC sets the y center and y value of the circle
     */
    public void setYcenter(double yC) {
        yCenter = yC;
        setY(yC - getR());
    }

    /**
     *
     * @return the y center of the circle
     */
    public double getYcenter() {
        return yCenter;
    }

    /**
     *
     * @param radii sets the radius of the circle and the width and height
     */
    public void setR(double radii) {
        radius = radii;
        setWidth(radii * 2);
        setHeight(radii * 2);
    }

    /**
     *
     * @return the radius of the circle
     */
    public double getR() {
        return radius;
    }

    /**
     *
     * @param b sets whether or not the circle is colliding with the bar
     */
    public void setCollideBar(boolean b){
        collideBar = b;
    }

    /**
     *
     * @return whether or not the circle is colliding with the bar
     */
    public boolean getCollideBar(){
        return collideBar;
    }
    
    /**
     *
     * @param s is the shape checked in the collision
     */
    @Override
    public void checkCollision(Shape s) {
        if (s instanceof Circle) {
            Circle c = (Circle) s;
            double distance = Math.sqrt(Math.pow((getXcenter() + getXvel()) - (c.getXcenter() + c.getXvel()), 2) + Math.pow((getYcenter() + getYvel()) - (c.getYcenter() + c.getYvel()), 2));
            double rDistance = getR() + c.getR();

            if (distance <= rDistance) {
                onCollision(s);
            }
        }
        else if (s instanceof CrossBar) { // pretending circle is a rectangle
            if (getX() + getWidth() > s.getX() && getX() < s.getX() + s.getWidth()) {
                if (getY() < s.getY() + s.getHeight() && getY() + getHeight() > s.getY()) {
                    onCollision(s);
                    setCollideBar(true);
                } else{
                    setCollideBar(false);
                }
            }
        } else {
            if (getX() + getWidth() > s.getX() && getX() < s.getX() + s.getWidth()) {
                if (getY() < s.getY() + s.getHeight() && getY() + getHeight() > s.getY()) {
                    onCollision(s);
                    
                }
            }
        } 
    }

    /**
     *
     * @param s is the shape that circle is colliding with
     */
    @Override
    public abstract void onCollision(Shape s);

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
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }

}
