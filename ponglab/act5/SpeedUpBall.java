//package ponglab.act5;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{
  public SpeedUpBall(int x, int y, int w, int h, Color c, int xs, int ys)
  {
    super(x,y,w,h,c,xs,ys);
  }

  public boolean speedUp(Block block)
  {
    if(didCollideLeft(block)||didCollideRight(block)||didCollideTop(block)||didCollideBottom(block)){
      if(getXSpeed()>=0){
        setXSpeed(getXSpeed()+1);
      }else{
        setXSpeed(getXSpeed()-1);
      }
      if(getYSpeed()>=0){
        setYSpeed(getYSpeed()+1);
      }else{
        setYSpeed(getYSpeed()-1);
      }
    }
  }
}

