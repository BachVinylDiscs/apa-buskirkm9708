//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;

  public AlienHorde(int size)
  {
    aliens=new ArrayList<Alien>();
    for(int a=0;a<size;a++)
    {
      aliens.add(new Alien(a*50+10,10));
    }
  }

  public void add(Alien al)
  {
    aliens.add(al);
  }

  public void drawEmAll(Graphics window)
  {
    for(Alien a:aliens)
    {
      a.draw(window);
    }
  }

  public void moveEmAll(int x,int y)
  {
    for(Alien a:aliens)
    {
      if(((int)(a.getY()-10)/50)%2==1)
      {
        if(a.getX()<=0)
        {
          a.setY(a.getY()+50);
        }else{
          a.move("LEFT");
        }
      }
      if(((int)(a.getY()-10)/50)%2==0)
      {
        if(a.getX()+a.getWidth()>=x)
        {
          a.setY(a.getY()+50);
        }else{
          a.move("RIGHT");
        }
      } 
    }
  }

  public void removeDeadOnes(List<Ammo> ammo,int y)
  {
    for(Alien a:aliens){
      for(Ammo m:ammo){
	if(a.didCollide(m)||a.getY()+a.getHeight()>y){
	  aliens.remove(a);
	}
      }
    }
  }

  public List<Alien> getList()
  {
    return aliens;
  }

  public String toString()
  {
    return "";
  }
}
