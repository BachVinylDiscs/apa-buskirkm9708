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

  public Ship(int x, int y)
  {
    //add code here
  }

  public Ship(int x, int y, int s)
  {
    //add code here
  }

  public Ship(int x, int y, int w, int h, int s)
  {
<<<<<<< HEAD
    super(x, y, w, h);
=======
    this(x,y,w,h,10);
  }

  public Ship(int x,int y,int w,int h,int s)
  {
    super(x,y,w,h);
>>>>>>> fc7502eebbfb4afd4e8bab6a0c4240362bdb43ee
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
    //add more code
  }

  public int getSpeed()
  {
    return 0;
  }

  public void move(String direction)
  {
    //add code here
  }

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return super.toString() + getSpeed();
  }
}
