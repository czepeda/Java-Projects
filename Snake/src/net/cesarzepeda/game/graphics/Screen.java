/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cesarzepeda.game.graphics;

import com.cesarzepeda.game.entities.Apple;
import com.cesarzepeda.game.entities.BodyPart;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author czepeda
 */
public class Screen extends JPanel implements Runnable {
    
    private static final long serialVersionUID = 1L;
    
    public static final int WIDTH = 800, HEIGHT = 800;
    
    private Thread thread;
    private boolean running = false;
    private BodyPart b;
    private ArrayList<BodyPart> snake;
    private int ticks = 0;
    
    private Apple apple;
    private ArrayList<Apple> apples;
    private Random r;
    
    private int xCoor = 10, yCoor = 10;
    
    private int size = 5;
    
    private Key key;
    
    private boolean right = true, left = false, up = false, down = false;
    
    public Screen() {
        setFocusable(true);
        key = new Key();
        addKeyListener(key);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        r = new Random();
        
        snake = new ArrayList<BodyPart>();
        apples = new ArrayList<Apple>();
        
        start();
    }
    
    public void tick() {
        
        if (snake.size() == 0) {
            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);
            
        }
        if (apples.size() == 0) {
            int xCoor = r.nextInt(79);
            int yCoor = r.nextInt(79);
            
            apple = new Apple(xCoor, yCoor, 10);
            apples.add(apple);
            
        }
        
        for (int i = 0; i < apples.size(); i++) {
            if (xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()) {
                size++;
                apples.remove(i);
                i--;
            }
        }
        
        for (int i = 0;
                i < snake.size();
                i++) {
            if (xCoor < 0) {
                xCoor = 79;
            }
            if (xCoor > 79) {
                xCoor = 0;
            }
            if (yCoor < 0) {
                yCoor = 79;
            }
            if (yCoor > 79) {
                yCoor = 0;
            }
        }
        
        ticks++;
        if (ticks > 1200000) {
            if (right) {
                xCoor++;
            }
            if (left) {
                xCoor--;
            }
            if (up) {
                yCoor--;
            }
            if (down) {
                yCoor++;
            }
            
            ticks = 0;
            
            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);
            
            if (snake.size() > size) {
                snake.remove(0);
            }
        }
        
    }
    
    public void paint(Graphics g) {
        
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(new Color(10, 50, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        
        for (int i = 0; i < WIDTH / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
        }
        for (int i = 0; i < HEIGHT / 10; i++) {
            g.drawLine(0, i * 10, WIDTH, i * 10);
        }
        
        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
        
        for (int i = 0; i < apples.size(); i++) {
            
            apples.get(i).draw(g);
            
        }
        
    }
    
    public void start() {
        running = true;
        thread = new Thread(this, "Game Loop");
        thread.start();
    }
    
    public void stop() {
        
    }
    
    public void run() {
        while (running) {
            tick();
            repaint();
            
        }
        
    }
    
    private class Key implements KeyListener {
        
        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_RIGHT && !left) {
                up = false;
                down = false;
                right = true;
            }
            
            if (key == KeyEvent.VK_LEFT && !right) {
                up = false;
                down = false;
                left = true;
            }
            
            if (key == KeyEvent.VK_UP && !down) {
                up = true;
                right = false;
                left = false;
            }
            
            if (key == KeyEvent.VK_DOWN && !up) {
                down = true;
                right = false;
                left = false;
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
