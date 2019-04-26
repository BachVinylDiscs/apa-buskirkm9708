//package ponglab.act4;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Max Buskirk

import java.awt.Color;
import java.awt.Graphics;

public class Score
{
  private int score;
  
  public Score()
  {
    score=0;
  }
  
  public paint(Graphics window)
  {
    window.drawString("Score: "+score,50,10);
  }
  
  public addPoint(int x)
  {
    score+=x;
  }
}
