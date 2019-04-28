//package ponglab.act5;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable<Block>
{
  private int xSpeed;
  private int ySpeed;

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
    return getX()<=block.getX()+block.getWidth()&&getX()>block.getX()&&getY()>block.getY()-getHeight()&&getY()<block.getY()+block.getHeight();
  }
  
  public boolean didCollideRight(Block block)
  {
    return getX()+getWidth()>=block.getX()&&getX()+getWidth()<block.getX()+block.getWidth()&&getY()>block.getY()-getHeight()&&getY()<block.getY()+block.getHeight();
  }
  
  public boolean didCollideTop(Block block)
  {
    return getY()<=block.getY()+block.getHeight()&&getY()>block.getY()&&getX()>block.getX()-getWidth()&&getX()<block.getX()+block.getWidth();
  }
  
  public boolean didCollideBottom(Block block)
  {
    return getY()+getHeight()>=block.getY()&&getY()+getHeight()<block.getY()+block.getHeight()&&getX()>block.getX()-getWidth()&&getX()<block.getX()+block.getWidth();
  }
  
  public String toString()
  {
    return super.toString()+"\nXSpeed is "+xSpeed+"\nYSpeed is "+ySpeed;
  }
}
