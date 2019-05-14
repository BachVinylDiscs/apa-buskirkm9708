//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
  private int speed;

  public Ammo()
  {
    this(0,0,0);
  }

  public Ammo(int x,int y)
  {
    this(x,y,0);
  }

  public Ammo(int x,int y,int s)
  {
    super(x,y,10,10,s);
  }

  public void setSpeed(int s)
  {
    speed=s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void draw(Graphics window,int x,int y)
  {
    window.setColor(Color.YELLOW);
    window.fillRect(x,y,10,10);
  }
        
        
  public void move(String direction)
  {
    if(dir.equals("UP"))
      setY(getY()-1);
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

  public String toString()
  {
    return super.toString() + getSpeed();
  }
}
