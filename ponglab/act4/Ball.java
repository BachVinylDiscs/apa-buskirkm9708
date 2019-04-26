package ponglab.act4;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable<Block>
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super();
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x,int y)
  {
    super(x,y);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x,int y,int w,int h)
  {
    super(x,y,w,h);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x,int y,int w,int h,Color c)
  { 
    super(x,y,w,h,c);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x,int y,int w,int h,Color c,int xs,int ys)
  {
    super(x,y,w,h,c);
    xSpeed = xs;
    ySpeed = ys;
  }
  
  public void setXSpeed(int x)
  {
    xSpeed=x;
  }

  public void setYSpeed(int y)
  {
    ySpeed=y;
  }

  public void moveAndDraw(Graphics window)
  {
    draw(window,Color.WHITE);    
    setX(getX()+xSpeed);
    setY(getY()+ySpeed);
    draw(window,getColor());
  }
   
  public boolean equals(Object obj)
  {
    Ball other=(Ball)obj;
    return super.equals(other)&&xSpeed==other.getXSpeed()&&ySpeed==other.getYSpeed();
  }   

  public int getXSpeed()
  {
    return xSpeed;
  }

  public int getYSpeed()
  {
    return ySpeed;
  }
  
  public boolean didCollideLeft(Block block)
  {
    return ball.getX()<=block.getX()+block.getWidth()&&ball.getX()>block.getX()&&ball.getY()>block.getY()-ball.getHeight()&&ball.getY()<block.getY()+block.getHeight();
  }
  
  public boolean didCollideRight(Block block)
  {
    return ball.getX()+ball.getWidth()>=block.getX()&&ball.getX()+ball.getWidth()<block.getX()+block.getWidth()&&ball.getY()>block.getY()-ball.getHeight()&&ball.getY()<block.getY()+block.getHeight();
  }
  
  public boolean didCollideTop(Block block)
  {
    return ball.getY()<=block.getY()+block.getHeight()&&ball.getY()>block.getY()&&ball.getX()>block.getX()-ball.getWidth()&&ball.getX()<block.getX()+block.getWidth();
  }
  
  public boolean didCollideBottom(Block block)
  {
    return ball.getY()+ball.getHeight()>=block.getY()&&ball.getY()+ball.getHeight()<block.getY()+block.getHeight()&&ball.getX()>block.getX()-ball.getWidth()&&ball.getX()<block.getX()+block.getWidth();
  }
  
  public String toString()
  {
    return super.toString()+"\nXSpeed is "+xSpeed+"\nYSpeed is "+ySpeed;
  }
}
