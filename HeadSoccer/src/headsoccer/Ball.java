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
// JAVA QUADRANTS
//  Q1 :: angle >= 0 && angle < Math.PI / 2
//  Q2 :: angle > Math.PI / 2 && angle < Math.PI
//  Q3 :: angle < -1 * Math.PI / 2 && angle > -1 * Math.PI
//  Q4 :: angle < 0 && angle > -1 * Math.PI / 2
// REGULAR QUADRANTS (FIRST) CORRESPONDING TO JAVA QUADRANTS (SECOND)
//  Q1 :: Q4
//  Q2 :: Q3
//  Q3 :: Q2
//  Q4 :: Q1
public class Ball extends Circle implements Renderable, Updateable {

    private boolean scored = false;
    private boolean rGoal = false, lGoal = false;
    private boolean power = false;
    private double angle;
    private int switchDir = -1;

    /**
     *
     */
    public Ball() {
        super();
        setXvel(1);
        setYvel(-1);
    }

    /**
     *
     * @param xC is the xcenter of the ball
     * @param yC is the ycenter of the ball
     * @param radii is the radius of the ball
     * @param c is the color of the ball
     */
    public Ball(double xC, double yC, double radii, Color c) {
        super(xC, yC, radii, c);
    }

    /**
     *
     * @param xC is the xcenter of the ball
     * @param yC is the ycenter of the ball
     * @param radii is the radius of the ball
     * @param p is the image of the ball
     */
    public Ball(double xC, double yC, double radii, Image p) {
        super(xC, yC, radii, p);
    }

    /**
     *
     * @param ex is the x value of the ball
     * @param why is the y value of the ball
     * @param w is the width of the ball
     * @param h is the height of the ball
     */
    public Ball(double ex, double why, double w, double h) {
        super(ex, why, w, h);
        setXvel(6);
        setYvel(-2);
    }

    /**
     *
     * @param ex is the x value of the ball
     * @param why is the y value of the ball
     * @param w is the width of the ball
     * @param h is the height of the ball
     * @param co is the color of the ball
     */
    public Ball(double ex, double why, double w, double h, Color co) {
        super(ex, why, w, h, co);
        setXvel(2);
        setYvel(-5);
    }

    /**
     *
     * @param b sets the ball to scored or not
     */
    public void setScored(boolean b) {
        scored = b;
    }

    /**
     *
     * @return whether the ball is scored or not
     */
    public boolean getScored() {
        return scored;
    }

    /**
     *
     * @param r sets the ball to scored on the right goal or not
     */
    public void setRscored(boolean r) {
        rGoal = r;
    }

    /**
     *
     * @return whether or not the ball was scored on the right goal
     */
    public boolean getRscored() {
        return rGoal;
    }

    /**
     *
     * @param l sets the ball to scored on the left goal or not
     */
    public void setLscored(boolean l) {
        lGoal = l;
    }

    /**
     *
     * @return whether or not the ball was scored on the left goal
     */
    public boolean getLscored() {
        return lGoal;
    }

    /**
     *
     * @param p sets the ball to having power or not
     */
    public void setPower(boolean p) {
        power = p;
    }

    /**
     *
     * @return whether or not the ball has power
     */
    public boolean getPower() {
        return power;
    }

    /**
     *
     * @param a sets the rotation angle of the ball
     */
    public void setAngle(double a) {
        angle = a;
    }

    /**
     *
     * @return the rotation angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     *
     * @param s is the shape that collided with the ball
     */
    public void onCollision(Shape s) {
        power = false;
        if (s instanceof Wall) {
            if (s.getWall().equals("left")) {
                setXvel(getXvel() * -1);
                setXcenter(s.getX() + s.getWidth() + getR());
            } else if (s.getWall().equals("right")) {
                setXvel(getXvel() * -1);
                setXcenter(s.getX() - getR());
            } else if (s.getWall().equals("top")) {
                setYvel(getYvel() * -1);
                setYcenter(s.getY() + s.getHeight() + getR());
            } else {
                setYvel(getYvel() * -1);
                setYcenter(s.getY() - getR());
                switchDir *= -1;
            }
        }

        if (s instanceof Rectangle && !(s instanceof Goal)) {
            if (getX() <= s.getX()) { //right goal
                if (getX() + getWidth() - s.getX() + getXvel() < s.getY() + s.getHeight() + getYvel() - getY() && getXvel() > 0) {
                    setXvel(getXvel() * -1);
                } else {

                }
            }
            if (getX() + getWidth() >= s.getX() + s.getWidth()) { //left goal
                if (s.getX() + s.getWidth() - getX() + getXvel() < s.getY() + s.getHeight() + getYvel() - getY() && getXvel() < 0) {
                    setXvel(getXvel() * -1);
                } else {

                }
            }
            if (getX() + getR() >= s.getX() && getXcenter() <= s.getX() + s.getWidth() && getY() < s.getY()) {
                setYvel(getYvel() * -1);
                setY(s.getY() - (getR() * 2));
            }
            if (getX() + getR() >= s.getX() && getXcenter() <= s.getX() + s.getWidth() && getY() + getHeight() > s.getY() + s.getHeight()) {
                setYvel(getYvel() * -1);
                setY(s.getY() + s.getHeight());
            }
        }

        if (s instanceof Goal) {
            Goal g = (Goal) s;
            if (getX() >= g.getX() && getX() + getWidth() <= g.getX() + g.getWidth() && getY() >= g.getY() && getY() + getHeight() <= g.getY() + g.getHeight()) {
                if (g.getSide().equals("right")) {
                    setRscored(true);
                } else {
                    setLscored(true);
                }
            }
        }
        if (s instanceof PowerUps) {
            if (s instanceof BigBall) {
                ((BigBall) s).setCollide(true);
            }
            if (s instanceof SmallBall) {
                ((SmallBall) s).setCollide(true);
            }
            if (s instanceof SmallGoal) {
                ((SmallGoal) s).setCollide(true);
            }
            if (s instanceof BigGoal) {
                ((BigGoal) s).setCollide(true);
            }
            if (s instanceof BigPlayer){
                ((BigPlayer) s).setCollide(true);
            }
            if (s instanceof SmallPlayer){
                ((SmallPlayer) s).setCollide(true);
            }
//            power = true;
        }
        if (s instanceof Circle && !(s instanceof PowerUps)) {
            Circle c = (Circle) s;
            double angle = Math.atan2((getYcenter() - c.getYcenter()), (getXcenter() - c.getXcenter()));
            double vAngle = Math.atan2(getYvel(), getXvel()) - Math.PI;
            double diff = angle - vAngle;
            double finalAngle = vAngle + (2 * diff);
            double magOfVelBall = Math.sqrt(Math.pow(getXvel(), 2) + Math.pow(getYvel(), 2));
            double[] sharedVector = {Math.cos(angle), Math.sin(angle)};
            double[] veloVect = {c.getXvel(), c.getYvel()};
            double dotProd = sharedVector[0] * veloVect[0] + sharedVector[1] * veloVect[1];
            double[] projectionParallel = {dotProd * sharedVector[0], dotProd * sharedVector[1]};
            setXcenter(c.getXcenter() + sharedVector[0] * (c.getR() + getR()));
            setYcenter(c.getYcenter() + sharedVector[1] * (c.getR() + getR()));
            setXvel(magOfVelBall * Math.cos(finalAngle) + projectionParallel[0]);
            setYvel(magOfVelBall * Math.sin(finalAngle) + projectionParallel[1]);
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
        graphics.save();
        graphics.transform(new Affine(new Rotate(Math.toDegrees(getAngle()) * switchDir, getXcenter(), getYcenter())));
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
        graphics.restore();
    }

    /**
     *
     * @param canvas is the main canvas
     */
    public void update(Canvas canvas) {
        setY(getY() + getYvel());
        setX(getX() + getXvel());
        if (getYvel() != 0){
        setAngle((getXvel()  * getYvel()) / 5);
        } else {
            setAngle(-1 * getXvel() / 2);
        }
    }
}
