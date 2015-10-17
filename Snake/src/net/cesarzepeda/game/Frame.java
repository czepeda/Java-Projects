/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cesarzepeda.game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import net.cesarzepeda.game.graphics.Screen;

/**
 *
 * @author czepeda
 */
public class Frame extends JFrame {

    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake");
        setResizable(false);

        init();
    }

    public void init() {
        setLayout(new GridLayout(1, 1, 0, 0));

        Screen s = new Screen();
        add(s);
        pack();

        setLocationRelativeTo(null);

        setVisible(true);

    }

    public static void main(String[] args) {

        new Frame();
    }

}
