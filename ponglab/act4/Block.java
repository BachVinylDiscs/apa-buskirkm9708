//package ponglab.act4;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Max Buskirk

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;
  private Color color;

  public Block(int x,int y,int w,int h,Color col)
  {
    setPos(x,y);
    width=w;
    height=h;
    color=col;
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

  public void setWidth(int w)
  {
    width=w;
  }

  public void setHeight(int h)
  {
    height=h;
  }

  public void setColor(Color col)
  {
    color=col;
  }

  public void draw(Graphics window)
  {
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }
  
  public void draw(Graphics window, Color col)
  {
    window.setColor(col);
    window.fillRect(getX(),getY(),getWidth(),getHeight());
  }
 
  public boolean equals(Object obj)
  {
    Block other=(Block)obj;
    return xPos==other.getX()&&yPos==other.getY()&&width==other.getWidth()&&height==other.getHeight()&&color==other.getColor();
  }   

  //add the other get methods
  public int getX()
  {
    return xPos;
  }

  public int getY()
  {
    return yPos;
  }

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }

  public Color getColor()
  {
    return color;
  }

  public String toString()
  {
    return "Position is ("+xPos+","+yPos+")\nWidth is "+width+"\nHeight is "+height+"\nColor is "+color;
  }
}
