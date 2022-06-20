/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author Kobe Douglas
 */
public class BigPlayer extends PowerUps{

    /**
     *
     * @param canW is the canvas width
     * @param canH is the canvas height
     * @param goalW is the goal width
     * @param goalH is the goal height
     * @param c is the color of the power up
     * @param p is the image of the power up
     * @param w is the width of the power up
     * @param h is the height of the power up
     */
    public BigPlayer(double canW, double canH, double goalW, double goalH, Color c, Image p, double w, double h){
        super(Math.random() * (canW - 2 * goalW - w) + goalW, Math.random() * (canH - goalH - (canH / 2 - (w/2))) + (canH / 2 - (w/2)) - w, w, h, c, p);
        setXvel(0);
        setYvel(0);
    }
}
