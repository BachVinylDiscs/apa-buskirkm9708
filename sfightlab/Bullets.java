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

public class Bullets
{
  private List<Ammo> ammo;

  public Bullets()
  {
    ammo=new ArrayList<Ammo>();
  }

  public void add(int x,int y)
  {
    ammo.add(new Ammo(x,y));
  }

  //post - draw each Ammo
  public void drawEmAll(Graphics window)
  {
    for(Ammo a:ammo){
      a.draw(window);
    }
  }

  public void moveEmAll()
  {
    for(Ammo a:ammo){
      a.move("UP");
    }
  }

  public void cleanEmUp(List<Alien> horde,int m)
  {
    ammo.remove(m);
  }

  public List<Ammo> getList()
  {
    return ammo;
  }

  public String toString()
  {
    return "";
  }
}
