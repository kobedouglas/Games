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
public class CrossBar extends Rectangle implements Renderable {

    /**
     *
     * @param ex is the x value of the crossbar
     * @param why is the y value of the crossbar
     * @param w is the width of the crossbar
     * @param h is the height of the crossbar
     */
    public CrossBar(double ex, double why, double w, double h){
        super(ex, why, w, h);
    }

    /**
     *
     * @param ex is the x value of the crossbar
     * @param why is the y value of the crossbar
     * @param w is the width of the crossbar
     * @param h is the height of the crossbar
     * @param c is the color of the crossbar
     * @param co is the side color that accents the crossbar
     */
    public CrossBar(double ex, double why, double w, double h, Color c, Color co){
        super(ex, why, w, h, c);
        setSideColor(co);
    }

    /**
     *
     * @param ex is the x value of the crossbar
     * @param why is the y value of the crossbar
     * @param w is the width of the crossbar
     * @param h is the height of the crossbar
     * @param c is the color of the crossbar
     * @param co is the side color that accents the crossbar
     * @param g is the side of the crossbar
     * @param thic is the thickness of the crossbar
     */
    public CrossBar(double ex, double why, double w, double h, Color c, Color co, String g, double thic){
        super(ex, why, w, h, c, g, thic);
        setSideColor(co);
    }

}
