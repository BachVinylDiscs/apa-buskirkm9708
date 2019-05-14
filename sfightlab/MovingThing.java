//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Moveable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  public MovingThing()
  {
    xPos = 10;
    yPos = 10;
    width = 10;
    height = 10;
  }

  public MovingThing(int x,int y)
  {
    xPos = x;
    yPos = y;
    width = 10;
    height = 10;
  }

  public MovingThing(int x,int y,int w,int h)
  {
    xPos=x;
    yPos=y;
    width=w;
    height=h;
  }

  public void setPos(int x,int y)
  {
    xPos=x;
    yPos=y;
  }

  public void setX(int x)
  {
    xPos=x;
  }

  public void setY(int y)
  {
    yPos=y;
  }

  public int getX()
  {
    return xPos;
  }

  public int getY()
  {
    return yPos;
  }

  public void setWidth(int w)
  {
    width=w;
  }

  public void setHeight(int h)
  {
    height=h;
  }

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }

  public boolean didCollideLeft(Ammo block)
  {
    return getX()<=block.getX()+block.getWidth()&&getX()>block.getX()&&getY()>block.getY()-getHeight()&&getY()<block.getY()+block.getHeight();
  }
  
  public boolean didCollideRight(Ammo block)
  {
    return getX()+getWidth()>=block.getX()&&getX()+getWidth()<block.getX()+block.getWidth()&&getY()>block.getY()-getHeight()&&getY()<block.getY()+block.getHeight();
  }
  
  public boolean didCollideTop(Ammo block)
  {
    return getY()<=block.getY()+block.getHeight()&&getY()>block.getY()&&getX()>block.getX()-getWidth()&&getX()<block.getX()+block.getWidth();
  }
  
  public boolean didCollideBottom(Ammo block)
  {
    return getY()+getHeight()>=block.getY()&&getY()+getHeight()<block.getY()+block.getHeight()&&getX()>block.getX()-getWidth()&&getX()<block.getX()+block.getWidth();
  }
  
  public boolean didCollide(Ammo block)
  {
    return didCollideLeft(block)||didCollideRight(block)||didCollideTop(block)||didCollideBottom(block);
  }


  public abstract void move(String direction);
  public abstract void draw(Graphics window);

  public String toString()
  {
    return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
  }
}
