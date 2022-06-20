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
public abstract class Shape {

    private double x, y, width, height;
    private Color c, sideColor;
    private Image pat;
    private String wall, side;
    private double xVel, yVel;
    private double thickness;

    /**
     *
     */
    public Shape() {
        width = 25;
        height = 25;
        x = 20;
        y = 20;
        c = Color.BLACK;

    }

    /**
     *
     * @param ex is the x value of the shape
     * @param why is the y value of the shape
     * @param w is the width of the shape
     * @param h is the height of the shape
     * @param co is the color of the shape
     */
    public Shape(double ex, double why, double w, double h, Color co) {
        setWidth(w);
        setHeight(h);
        setX(ex);
        setY(why);
        setColor(co);
        setImage(null);
    }

    /**
     *
     * @param ex is the x value of the shape
     * @param why is the y value of the shape
     * @param w is the width of the shape
     * @param h is the height of the shape
     * @param p is the image of the shape
     */
    public Shape(double ex, double why, double w, double h, Image p) {
        setWidth(w);
        setHeight(h);
        setX(ex);
        setY(why);
        setImage(p);
    }

    /**
     *
     * @param ex is the x value of the shape
     * @param why is the y value of the shape
     * @param w is the width of the shape
     * @param h is the height of the shape
     * @param c is the color of the shape
     * @param p is the image of the shape
     */
    public Shape(double ex, double why, double w, double h, Color c, Image p) {
        setWidth(w);
        setHeight(h);
        setX(ex);
        setY(why);
        setColor(c);
        setImage(p);
    }

    /**
     *
     * @param ex is the x value of the shape
     * @param why is the y value of the shape
     * @param w is the width of the shape
     * @param h is the height of the shape
     */
    public Shape(double ex, double why, double w, double h) {
        setWidth(w);
        setHeight(h);
        setX(ex);
        setY(why);
        setColor(Color.RED);
        setImage(null);
    }

    /**
     *
     * @param ex is the x value of the shape
     * @param why is the y value of the shape
     * @param w is the width of the shape
     * @param h is the height of the shape
     * @param s is the side of the shape
     */
    public Shape(double ex, double why, double w, double h, String s) {
        setWidth(w);
        setHeight(h);
        setX(ex);
        setY(why);
        setColor(Color.RED);
        setImage(null);
        setWall(s);
    }

    /**
     *
     * @param ex is the x value of the shape
     * @param why is the y value of the shape
     * @param w is the width of the shape
     * @param h is the height of the shape
     * @param c is the color of the shape
     * @param s is the side of the shape
     * @param thic is the thickness of the shape (only applies to goal posts)
     */
    public Shape(double ex, double why, double w, double h, Color c, String s, double thic) {
        setWidth(w);
        setHeight(h);
        setX(ex);
        setY(why);
        setColor(c);
        setImage(null);
        setSide(s);
        setThickness(thic);
    }

    /**
     *
     * @param ex is the x value of the shape
     * @param why is the y value of the shape
     * @param w is the width of the shape
     * @param h is the height of the shape
     * @param c is the color of the shape
     * @param s is the side of the shape
     */
    public Shape(double ex, double why, double w, double h, Color c, String s) {
        setWidth(w);
        setHeight(h);
        setX(ex);
        setY(why);
        setColor(c);
        setImage(null);
        setSide(s);
    }

    /**
     *
     * @param ex is the x value of the shape
     * @param why is the y value of the shape
     * @param w is the width of the shape
     * @param h is the height of the shape
     * @param p is the image of the shape
     * @param s is the side of the shape
     */
    public Shape(double ex, double why, double w, double h, Image p, String s) {
        setWidth(w);
        setHeight(h);
        setX(ex);
        setY(why);
        setColor(Color.RED);
        setImage(p);
        setSide(s);
    }
    
    /**
     *
     * @param w sets the width of the shape
     */
    public void setWidth(double w) {
        width = w;
    }

    /**
     *
     * @return the width of the shape
     */
    public double getWidth() {
        return width;
    }

    /**
     *
     * @param h sets the height of the shape
     */
    public void setHeight(double h) {
        height = h;
    }

    /**
     *
     * @return the height of the shape
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @param ex sets the x value of the shape
     */
    public void setX(double ex) {
        x = ex;
    }

    /**
     *
     * @return the x value of the shape
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @param why sets the y value of the shape
     */
    public void setY(double why) {
        y = why;
    }

    /**
     *
     * @return the y value of the shape
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @param co sets the color of the shape
     */
    public void setColor(Color co) {
        c = co;
    }

    /**
     *
     * @return the color of the shape
     */
    public Color getColor() {
        return c;
    }

    /**
     *
     * @param co sets the side color of the shape
     */
    public void setSideColor(Color co) {
        sideColor = co;
    }

    /**
     *
     * @return the side color of the shape
     */
    public Color getSideColor() {
        return sideColor;
    }

    /**
     *
     * @param p sets the image of the shape
     */
    public void setImage(Image p) {
        pat = p;
    }

    /**
     *
     * @return the image of the shape
     */
    public Image getImage() {
        return pat;
    }

    /**
     *
     * @param s sets the wall
     */
    public void setWall(String s) {
        wall = s;
    }

    /**
     *
     * @return the wall
     */
    public String getWall() {
        return wall;
    }

    /**
     *
     * @param s sets the side of the shape
     */
    public void setSide(String s) {
        side = s;
    }

    /**
     *
     * @return the side of the shape
     */
    public String getSide() {
        return side;
    }

    /**
     *
     * @param t sets the thickness of the shape
     */
    public void setThickness(double t) {
        thickness = t;
    }

    /**
     *
     * @return the thickness of the shape
     */
    public double getThickness() {
        return thickness;
    }

    /**
     *
     * @param x sets the x value of the shape
     */
    public void setXvel(double x) {
        xVel = x;
    }

    /**
     *
     * @return the x value of the shape
     */
    public double getXvel() {
        return xVel;
    }

    /**
     *
     * @param y sets the y value of the shape
     */
    public void setYvel(double y) {
        yVel = y;
    }

    /**
     *
     * @return the y value of the shape
     */
    public double getYvel() {
        return yVel;
    }

    /**
     *
     * @param s is the shape that collides with the other shape
     */
    public abstract void onCollision(Shape s);

    /**
     *
     * @param s is the shape that is checked for collision with the other shape
     */
    public abstract void checkCollision(Shape s);

    /**
     *
     * @param canvas is the main canvas
     */
    public void draw(Canvas canvas) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        if (this instanceof Goal || this instanceof CrossBar) {
            if (getImage() == null && getSide() == null) {
                graphics.setFill(getColor());
                graphics.fillRect(getX(), getY(), getWidth(), getHeight());
            } else if (getSide().equals("left")) {
                double slim = getThickness() / 5;
                int spacing = (int) (getWidth() - getThickness()) / 5;
                int yStart = (int) (getY() + spacing);
                int yEnd = (int) (getY() + getHeight());
                graphics.setFill(getColor());
                graphics.fillRect(getWidth() - getThickness(), getY(), getThickness(), getHeight());
                for (int vert = spacing; vert < getWidth() - getThickness(); vert += spacing) {
                    graphics.fillRect(vert, getY(), 1.5, getHeight());
                }
                for (int hrz = yStart; hrz < yEnd; hrz += spacing) {
                    graphics.fillRect(getX(), hrz, getWidth() - getThickness(), 1.5);
                }
                if (getSideColor() == null) {
                    graphics.setFill(Color.rgb(64, 64, 64));
                } else {
                    graphics.setFill(getSideColor());
                }
                graphics.fillRect(getWidth() - getThickness(), getY(), slim, getHeight());
                graphics.fillRect(getWidth() - slim, getY() - getThickness(), slim, getHeight() + getThickness());
                graphics.fillRect(getX(), getY() - getThickness(), getWidth(), slim);
                graphics.fillRect(getX(), getY() - slim, getWidth() - getThickness() + slim, slim);

            } else if (getSide().equals("right")) {
                double slim = getThickness() / 5;
                int spacing = (int) (getWidth() - getThickness()) / 5;
                int yStart = (int) (getY() + spacing);
                int yEnd = (int) (getY() + getHeight());
                int xEnd = (int) (getX() + getWidth() - 1.5);
                int xStart = (int) (getX() + getThickness());
                graphics.setFill(getColor());
                graphics.fillRect(getX(), getY(), getThickness(), getHeight());
                for (int vert = xEnd - spacing; vert > xStart; vert -= spacing) {
                    graphics.fillRect(vert, getY(), 1.5, getHeight());
                }
                for (int hrz = yStart; hrz < yEnd; hrz += spacing) {
                    graphics.fillRect(getX() + getThickness(), hrz, getWidth() - getThickness(), 1.5);
                }
                if (getSideColor() == null) {
                    graphics.setFill(Color.rgb(64, 64, 64));
                } else {
                    graphics.setFill(getSideColor());
                }
                graphics.fillRect(getX(), getY() - getThickness(), slim, getHeight() + getThickness());
                graphics.fillRect(getX() + getThickness() - slim, getY(), slim, getHeight());
                graphics.fillRect(getX(), getY() - getThickness(), getWidth(), slim);
                graphics.fillRect(getX() + getThickness() - slim, getY() - slim, getWidth() - getThickness() + slim, slim);
            } else {
                graphics.setFill(new ImagePattern(getImage()));
                graphics.fillRect(getX(), getY(), getWidth(), getHeight());
            }
        }
    }

    public String toString() {
        return "X :: " + getX() + "; Y :: " + getY() + " ; Width :: " + getWidth() + " ; Height :: " + getHeight();
    }
}
