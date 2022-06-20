/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
/**
 *
 * @author Kobe Douglas
 */
public interface Renderable {

    /**
     *
     * @param canvas is the main canvas
     */
    void draw(Canvas canvas);

    /**
     *
     * @return the color
     */
    Color getColor();
}
