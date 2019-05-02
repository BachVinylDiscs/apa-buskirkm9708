//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
  private int speed;
  private Image image;

  public Ship()
  {
    this(10,10,10,10,10);
  }

  public Ship(int x,int y)
  {
    this(x,y,10,10,10);
  }

  public Ship(int x,int y,int s)
  {
    this(x,y,10,10,s);
  }

  public Ship(int x,int y,int w,int h)
  {
    this(x,y,w,h,10);

  public Ship(int x,int y,int w,int h,int s)
  {
    super(x,y,w,h);
    speed=s;
    try
    {
      URL url = getClass().getResource("ship.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
  }


  public void setSpeed(int s)
  {
    speed=s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void move(String dir)
  {
    if(dir.equals("n")){
      setY(getY()-1);
    }

    if(dir.equals("nw")){
      setX(getX()-1);
      setY(getY()-1);
    }

    if(dir.equals("w")){
      setX(getX()-1);
    }

    if(dir.equals("sw")){
      setX(getX()-1);
      setY(getY()+1);
    }

    if(dir.equals("s")){
      setY(getY()+1);
    }

    if(dir.equals("se")){
      setX(getX()+1);
      setY(getY()+1);
    }

    if(dir.equals("e")){
      setX(getX()+1);
    }

    if(dir.equals("ne")){
      setX(getX()+1);
      setY(getY()-1);
    }
  }

  public void draw(Graphics window)
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return super.toString()+getSpeed();
  }
}
