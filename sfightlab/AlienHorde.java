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
    for(int a=0;a<aliens.size();a++)
    {
      aliens.add(new Alien(a*10+10,10));
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

  public void moveEmAll(String dir)
  {
    for(Alien a:aliens)
    {
      a.move(dir);
    }
  }

  public void removeDeadOnes(List<Ammo> shots)
  {

  }

  public String toString()
  {
    return "";
  }
}
