//package ponglab.act4;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Block
{
  public Wall()
  {
    super(0,0,800,1);
  }

  public Wall(int x,int y)
  {
    super(x,y,800,1);
  }

  public Wall(int x,int y,int w,int h)
  {
    super(x,y,w,h);
  }
}
