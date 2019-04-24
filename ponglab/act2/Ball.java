//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x,int y)
  {
    super(x,y);
  }

  public Ball(int x,int y,int w,int h)
  {
    super(x,y,w,h);
  }

  public Ball(int x,int y,int w,int h,Color c)
  { 
    super(x,y,w,h,c);
  }

  public Ball(int x,int y,int w,int h,Color c,int xs,int ys)
  {
    super(x,y,w,h,c);
    setXSpeed(xs);
    setYSpeed(ys);
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
    draw(window,Color.WHITE);
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

  public String toString()
  {
    return super.toString()+"\nXSpeed is "+xSpeed+"\nYSpeed is "+ySpeed;
  }
}
