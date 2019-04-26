//package ponglab.act4;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Max Buskirk

import java.awt.Color;
import java.awt.Graphics;

public class Score
{
  private int score;
  private int xPos;
  private int yPos;
  
  public Score()
  {
    score=0;
    xPos=50;
    yPos=10;
  }
  
  public Score(int x,int y)
  {
    score=0;
    xPos=x;
    yPos=y;
  }
  
  public void draw(Graphics window)
  {
    window.setColor(Color.BLACK);
    window.drawString("Score: "+score,xPos,yPos);
  }
  
  public void draw(Graphics window,Color col)
  {
    window.setColor(col);
    window.drawString("Score: "+score,xPos,yPos);
  }
  
  public void addScore(int x)
  {
    window.setColor(Color.WHITE);
    window.drawString("Score: "+score,xPos,yPos);
    score+=x;
  }
  
  public void setScore(int x)
  {
    window.setColor(Color.WHITE);
    window.drawString("Score: "+score,xPos,yPos);
    score=x;
  }
}
