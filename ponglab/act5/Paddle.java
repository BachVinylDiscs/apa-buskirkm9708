package ponglab.act5;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
  //instance variables
  private int speed;

  public Paddle(int x,int y,int w,int h,Color c,int s)
  {
    super(x,y,w,h,c);
    speed=s;
  }

  public void moveUpAndDraw(Graphics window)
  {
    draw(window,Color.WHITE);
    setY(getY()-speed);
    draw(window);
  }

  public void moveDownAndDraw(Graphics window)
  {
    draw(window,Color.WHITE);
    setY(getY()+speed);
    draw(window);
  }

  public int getSpeed()
  {
    return speed;
  }

  public String toString()
  {
    return super.toString()+"\nSpeed is "+speed;
  }
}
