//package ponglab.act4;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private Wall topWall;
  private Wall bottomWall;
  private Wall leftWall;
  private Wall rightWall;
  private Score leftScore;
  private Score rightScore;
  private boolean[] keys;
  private BufferedImage back;


  public Pong()
  {
    //set up all variables related to the game
    ball=new Ball(100,100,10,10,Color.BLACK,1,1);
    leftPaddle=new Paddle(10,10,10,30,Color.RED,2);
    rightPaddle=new Paddle(780,10,10,30,Color.RED,2);
    topWall=new Wall(0,0,800,1);
    bottomWall=new Wall(0,599,800,1);
    leftWall=new Wall(0,0,1,600);
    rightWall=new Wall(799,0,1,600);
    leftScore=new Score();
    rightScore=new Score();
    keys = new boolean[4];
    
    setBackground(Color.WHITE);
    setVisible(true);
                
    new Thread(this).start();
    addKeyListener(this);               //starts the key thread to log key strokes
  }
        
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if (back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();


    ball.moveAndDraw(graphToBack);
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);
    topWall.draw(graphToBack);
    bottomWall.draw(graphToBack);
    leftScore.draw(graphToBack,50,10);
    rightScore.draw(graphToBack,700,10);


    //see if ball hits left wall or right wall
    if (ball.didCollideLeft(leftWall))
    {
      ball.setXSpeed(0);
      ball.setYSpeed(0);
      leftScore.setScore(0);
    }
    
    if(ball.didCollideRight(rightWall))
    {
      ball.setXSpeed(0);
      ball.setYSpeed(0);
      rightScore.setScore(0);
    }

    //see if the ball hits top wall or bottom wall 
    if(ball.didCollideTop(topWall)||ball.didCollideBottom(bottomWall))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }

    //see if the ball hits a paddle
    if(ball.didCollideLeft(leftPaddle))                
    {
      ball.setXSpeed(-ball.getXSpeed());
      leftScore.addScore(1);
    }
    
    if(ball.didCollideRight(rightPaddle))
    {
      ball.setXSpeed(-ball.getXSpeed());
      rightScore.addScore(1);
    }

    //see if the paddles need to be moved
    if (keys[0])
    {
      //move left paddle up and draw it on the window
      if(leftPaddle.getY()>10)
      leftPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[1])
    {
      //move left paddle down and draw it on the window
      if(leftPaddle.getY()+leftPaddle.getHeight()<590)
      leftPaddle.moveDownAndDraw(graphToBack);
    }
    if (keys[2])
    {
      if(rightPaddle.getY()>10)
      rightPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[3])
    {
      if(rightPaddle.getY()+rightPaddle.getHeight()<590)
      rightPaddle.moveDownAndDraw(graphToBack);
    }
    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
        
  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(8);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }     
}
