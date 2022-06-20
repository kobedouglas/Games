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
public class SoccerPlayer extends Player {

    private double footDiam;
    private Foot ft;

    /**
     *
     */
    public SoccerPlayer() {
        super();
        setXvel(0);
        setR(5);
    }

    /**
     *
     * @param ex is the x value of the player
     * @param why is the y value of the player
     * @param w is the width of the player
     * @param h is the height of the player
     * @param co is the color of the player
     */
    public SoccerPlayer(double ex, double why, double w, double h, Color co) {
        super(ex, why, w, h, co);
        setXvel(0);
        setR(w / 2);
    }

    /**
     *
     * @param ex is the x value of the player
     * @param why is the y value of the player
     * @param w is the width of the player
     * @param h is the height of the player
     * @param p is the image of the player
     */
    public SoccerPlayer(double ex, double why, double w, double h, Image p) {
        super(ex, why, w, h, p);
        setXvel(0);
        setR(w / 2);
    }

    /**
     *
     * @param ex is the x value of the player
     * @param why is the y value of the player
     * @param w is the width of the player
     * @param h is the height of the player
     * @param co is the color of the player
     * @param side is the side on which the player starts
     */
    public SoccerPlayer(double ex, double why, double w, double h, Color co, String side) {
        super(ex, why, w, h, co);
        setXvel(0);
        setR(w / 2);
        setSide(side);
        footDiam = w / 2.5;
        if (side.equals("left")) {
            setFoot(new Foot(ex + (w / 2) + (w / 2 + footDiam / 2) / (getR() + footDiam /2) - footDiam / 2, why + (h / 2) + (h / 2 + footDiam / 2) / (getR() + footDiam / 2) - footDiam / 2, footDiam, footDiam, Color.RED, "left", Math.PI / 3));
        }
        if (side.equals("right")) {
            setFoot(new Foot(ex + (w/ 2) - 200 - (w / 2 + footDiam / 2) / (getR() + footDiam /2) - footDiam / 2, why + (h / 2) + (h / 2 + footDiam / 2) / (getR() + footDiam / 2) - footDiam / 2, footDiam, footDiam, Color.YELLOWGREEN, "right", 2 * Math.PI / 3));
        }

    }

    /**
     *
     * @param ex is the x value of the player
     * @param why is the y value of the player
     * @param w is the width of the player
     * @param h is the height of the player
     * @param p is the image of the player
     * @param f is the image of the foot
     * @param c is the side color
     * @param side is the side on which the player starts
     */
    public SoccerPlayer(double ex, double why, double w, double h, Image p, Image f, Color c, String side) {
        super(ex, why, w, h, p);
        setSideColor(c);
        setXvel(0);
        setR(w / 2);
        setSide(side);
        footDiam = w / 2;
        if (side.equals("left")) {
            setFoot(new Foot(ex + (w / 2) + (w / 2 + footDiam / 2) / (getR() + footDiam /2) - footDiam / 2, why + (h / 2) + (h / 2 + footDiam / 2) / (getR() + footDiam / 2) - footDiam / 2, footDiam, footDiam, f, "left", Math.PI / 3));
        }
        if (side.equals("right")) {
            setFoot(new Foot(ex + (w/ 2) - 200 - (w / 2 + footDiam / 2) / (getR() + footDiam /2) - footDiam / 2, why + (h / 2) + (h / 2 + footDiam / 2) / (getR() + footDiam / 2) - footDiam / 2, footDiam, footDiam, f, "right", 2 * Math.PI / 3));
        }
    }

    /**
     *
     * @param ex is the x value of the player
     * @param why is the y value of the player
     * @param w is the width of the player
     * @param h is the height of the player
     */
    public SoccerPlayer(double ex, double why, double w, double h) {
        super(ex, why, w, h);
        setXvel(0);
        setR(w / 2);
    }

    /**
     *
     * @param vS sets the initial velocity of the player when he jumps
     */
    public void jump(double vS) {
        setYvel(vS);
    }

    /**
     * sets the initial velocity of the player when he jumps
     */
    public void jump() {
        setYvel(-5);
    }

    /**
     *
     * @param f sets the foot of the player
     */
    public void setFoot(Foot f) {
        ft = f;
    }

    /**
     *
     * @return the foot of the player
     */
    public Foot getFoot() {
        return ft;
    }

    /**
     *
     * @param s is the shape the soccer player is colliding with
     */
    @Override
    public void onCollision(Shape s) {
        if (s instanceof Wall) {
            if (s.getWall().equals("left")) {
                setXvel(0);
                setXcenter(s.getX() + s.getWidth() + getR());
            } else if (s.getWall().equals("right")) {
                setXvel(0);
                setXcenter(s.getX() - getR());
            } else if (s.getWall().equals("top")) {
                setYvel(0);
                setYcenter(s.getY() + s.getHeight() + getR());
            } else {
                setYvel(0);
                setYcenter(s.getY() - getR());
            }
        }
        if (s instanceof SoccerPlayer) {
            Circle c = (Circle) s;
            double angle = Math.atan2((getYcenter() - c.getYcenter()), (getXcenter() - c.getXcenter()));
            double[] sharedVector = {Math.cos(angle), Math.sin(angle)};
            int signX = 0;
            int signY = 0;
            if (sharedVector[0] < 0) {
                signX = 1;
            }
            if (sharedVector[1] < 0) {
                signY = 1;
            }
            if (sharedVector[0] >= 0) {
                signX = -1;
            }
            if (sharedVector[1] >= 0) {
                signY = -1;
            }
            double distance = Math.sqrt(Math.pow(c.getXcenter() - getXcenter(), 2) + Math.pow(c.getYcenter() - getYcenter(), 2));
            double tempXcent = getXcenter();
            double tempYcent = getYcenter();

            //added -c.getXvel() in setYcenter and -getXvel() in s.setYcenter()
            setXcenter(c.getXcenter() + ((sharedVector[0] * (c.getR() + getR()))) + ((getR() + c.getR()) - distance) / 2 * signX);
            setYcenter(c.getYcenter() + ((sharedVector[1] * (c.getR() + getR()))) + ((getR() + c.getR()) - distance - c.getXvel()) / 2 * signY);
            ((SoccerPlayer) s).setXcenter(c.getXcenter() + ((getR() + c.getR()) - distance) / 2 * signX);
            ((SoccerPlayer) s).setYcenter(c.getYcenter() + ((getR() + c.getR()) - distance - getXvel()) / 2 * signY);
        }
        
        if (s instanceof CrossBar) {
            if (getXcenter() <= s.getX() && getXvel() >= 0) {
                if (getX() + getWidth() - s.getX() < s.getY() + s.getHeight() - getY()) {
                    setXvel(0);
                    setXcenter(s.getX() - getR());
                } else {
                    setYvel(0);
                    if (getYcenter() < s.getY()) {
                        setYcenter(s.getY() - getR());
                    } else {
                        setYcenter(s.getY() + s.getHeight() + getR());
                    }
                }
            } else if (getXcenter() >= s.getX() + s.getWidth() && getXvel() <= 0) {
                if (s.getX() + s.getWidth() - getX() < s.getY() + s.getHeight() - getY()) {
                    setXvel(0);
                    setXcenter(s.getX() + s.getWidth() + getR());
                } else {
                    setYvel(0);
                    if (getYcenter() < s.getY()) {
                        setYcenter(s.getY() - getR());
                    } else {
                        setYcenter(s.getY() + s.getHeight() + getR());
                    }
                }
            } else if (getXcenter() > s.getX() && getXcenter() < s.getX() + s.getWidth()) {
                setYvel(0);
                if (getYcenter() < s.getY()) {
                    setYcenter(s.getY() - getR());
                } else {
                    setYcenter(s.getY() + s.getHeight() + getR());
                }
            }
        }
    }

    /**
     *
     * @param canvas is the main canvas
     */
    @Override
    public void update(Canvas canvas) {
        setX(getX() + getXvel());
        setY(getY() + getYvel());
        if (this.getSide().equals("left")) {
            if (ft.getAngle() >= 0.5) {
                ft.setAngle(ft.getAngle() + (ft.getYvel() / 50) - (ft.getXvel() / 50));
            }
            ft.setXcenter(getXcenter() + Math.cos(ft.getAngle()) * (getR() + ft.getR()));
            ft.setYcenter(getYcenter() + Math.sin(ft.getAngle()) * (getR() + ft.getR()));
        }
        if (this.getSide().equals("right")){
            if (ft.getAngle() <= Math.PI - 0.5){
                ft.setAngle(ft.getAngle() - (ft.getYvel() / 50) - (ft.getXvel() / 50));
            }
            ft.setXcenter(getXcenter() + Math.cos(ft.getAngle()) * (getR() + ft.getR()));
            ft.setYcenter(getYcenter() + Math.sin(ft.getAngle()) * (getR() + ft.getR()));
        }
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
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
        
        graphics.setStroke(getColor());
        graphics.setLineWidth(3);
        graphics.strokeOval(getX(), getY(), getWidth(), getHeight());
    }

}
