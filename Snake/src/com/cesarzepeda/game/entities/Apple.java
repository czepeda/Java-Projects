/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesarzepeda.game.entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author czepeda
 */
public class Apple {

    private int xCoor, yCoor, width, height;

    public Apple(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.width = tileSize;
        this.height = tileSize;

    }
    
    public void tick() {
        
    }

    
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xCoor * width, yCoor * height, width, height);
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
}
