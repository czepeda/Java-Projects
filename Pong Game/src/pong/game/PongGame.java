/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.game;

import processing.core.PApplet;
import processing.core.PFont;


/**
 *
 * @author czepeda
 */
public class PongGame extends PApplet {

    int x, y, xSpeed, ySpeed;
    int paddle_x, paddle_y;
    int lives = 3;
    PFont font;
    
  
    

    public void settings() {
        
        size(600, 600);
        
        x = 300;
        y = 300;
        
        xSpeed = -2;
        ySpeed = 8;
        
        
        paddle_x = 10;
        paddle_y = 300;
        
        
      

    }

    public void draw() {
        
       
       
       
        background(200);
        x = x + xSpeed;
        y = y + ySpeed;
        
        
        
        
        paddle_y = mouseY;
        //Is ball bouncing off the wall
        if (x > 600) xSpeed = -xSpeed;
        if (y > 600) ySpeed = -ySpeed;
        if (y < 0 ) ySpeed = -ySpeed;
        
        if (x < 0) {
            x = 300;
            y = 300;
            xSpeed = -2;
            ySpeed = 8;
            lives--;
            
        }
        if (lives == 0 ) {
            
            System.exit(0);
            
        }
        
        //Is ball bouncing off the paddle
        if ((x-30 < paddle_x + 10) && (y > paddle_y) && (y < paddle_y +100)) {
            xSpeed = -xSpeed;
        }
        
        
        
        ellipse(x, y, 60, 60);
        rect(paddle_x, paddle_y, 10, 100);
        
        //Lives 
        font = createFont("Georgia", 32);
        textFont(font);
        text("Lives " + lives, 450, 50);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PongGame.main("pong.game.PongGame");
        
    }

    
}