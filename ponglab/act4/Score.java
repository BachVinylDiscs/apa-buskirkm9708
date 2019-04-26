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
  
  public void draw(Graphics window,int x,int y)
  {
    window.setColor(Color.BLACK);
    window.drawString("Score: "+score,x,y);
  }
  
  public void draw(Graphics window,int x,int y,Color col)
  {
    window.setColor(col);
    window.drawString("Score: "+score,x,y);
  }
  
  public void addScore(int x)
  {
    window.setColor(Color.WHITE);
    window.drawString("Score: "+score,x,y);
    score+=x;
  }
  
  public void setScore(int x)
  {
    window.setColor(Color.WHITE);
    window.drawString("Score: "+score,x,y);
    score=x;
  }
}
