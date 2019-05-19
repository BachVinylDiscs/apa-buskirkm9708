//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing implements Collidable<MovingThing>
{
  private int speed;
  private Image image;

  public Alien()
  {
    this(0,0,50,50,10);
  }

  public Alien(int x, int y)
  {
    this(x,y,50,50,10);
  }

  public Alien(int x, int y, int s)
  {
    this(x,y,50,50,s);
  }

  public Alien(int x, int y, int w, int h, int s)
  {
    super(x,y,w,h);
    speed=s;
    try
    {
      URL url = getClass().getResource("alien.jpg");
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
    if(dir.equals("LEFT"))
      setX(getX()-1);
    if(dir.equals("RIGHT"))
      setX(getX()+1);
    if(dir.equals("DOWN"))
      setY(getY()+1);
  }

  public boolean didCollideLeft(MovingThing block)
  {
    return getX()<=block.getX()+block.getWidth()&&getX()>block.getX()&&getY()>block.getY()-getHeight()&&getY()<block.getY()+block.getHeight();
  }
  
  public boolean didCollideRight(MovingThing block)
  {
    return getX()+getWidth()>=block.getX()&&getX()+getWidth()<block.getX()+block.getWidth()&&getY()>block.getY()-getHeight()&&getY()<block.getY()+block.getHeight();
  }
  
  public boolean didCollideTop(MovingThing block)
  {
    return getY()<=block.getY()+block.getHeight()&&getY()>block.getY()&&getX()>block.getX()-getWidth()&&getX()<block.getX()+block.getWidth();
  }
  
  public boolean didCollideBottom(MovingThing block)
  {
    return getY()+getHeight()>=block.getY()&&getY()+getHeight()<block.getY()+block.getHeight()&&getX()>block.getX()-getWidth()&&getX()<block.getX()+block.getWidth();
  }
  
  public boolean didCollide(MovingThing block)
  {
    return didCollideLeft(block)||didCollideRight(block)||didCollideTop(block)||didCollideBottom(block);
  }

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return "";
  }
}
