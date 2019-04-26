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
  
  public draw(Graphics window,int x,int y)
  {
    window.drawString("Score: "+score,x,y);
  }
  
  public addScore(int x)
  {
    score+=x;
  }
  
  public setScore(int x)
  {
    score=x;
  }
}
