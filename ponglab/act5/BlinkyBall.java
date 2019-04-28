package ponglab.act5;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

  public BlinkyBall(int x,int y,int w,int h,Color c,int xs,int ys)
  {
    super(x,y,w,h,c,xs,ys);
  }

  public Color randomColor()
  {
    int r = 256*Math.random();
    int g = 256*Math.random();
    int b = 256*Math.random();
    return new Color(r,g,b);
  }

  public void colorChangeMoveDraw(Graphics window)
  {
    setColor(randomColor());
    moveAndDraw(window);
  }
}
