//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
  private int xDim;
  private int yDim;
  private Ship ship;
  private Bullets ammo;
  private AlienHorde horde;
  private Bullets shots;
  private int delete;

  private boolean[] keys;
  private BufferedImage back;

  public OuterSpace(int x,int y)
  {
    setBackground(Color.black);
    xDim=x;
    yDim=y;
    keys = new boolean[5];

    //instantiate other instance variables
    //Ship, Alien
    
    ship=new Ship(10,10,50,50);
    horde=new AlienHorde(6);
    ammo=new Bullets();
    this.addKeyListener(this);
    new Thread(this).start();
    delete=-1;

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint(Graphics window)
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();

    graphToBack.setColor(Color.BLUE);
    graphToBack.drawString("StarFighter ", 25, 50 );
    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,xDim,yDim);
    ship.draw(graphToBack);
    horde.drawEmAll(graphToBack);
    horde.moveEmAll(xDim,yDim);
    delete=horde.removeDeadOnes(ammo.getList(),yDim);
    ammo.drawEmAll(graphToBack);
    ammo.moveEmAll();
    if(delete>-1)
    ammo.cleanEmUp(horde.getList(),delete);

    if(ship.getX()>0)
    {
      if(keys[0])
      {
        ship.move("LEFT");
      }
    }
    if(ship.getX()+ship.getWidth()<xDim)
    {
      if(keys[1])
      {
        ship.move("RIGHT");
      }
    }
    if(ship.getY()>0)
    {
      if(keys[2])
      {
        ship.move("UP");
      }
    }
    if(ship.getY()+2*ship.getHeight()<yDim)
    {
      if(keys[3])
      {
        ship.move("DOWN");
      }
    }
/*    if(keyReleased(KeyEvent.VK_SPACE))
    {
      ammo.add((int)(2*ship.getX()+ship.getWidth())/2-5,ship.getY()-15);
    }
*/
    twoDGraph.drawImage(back, null, 0, 0);
  }


  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = true;
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
      ammo.add((int)(2*ship.getX()+ship.getWidth())/2-5,ship.getY()-15);
    }
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
    //no code needed here
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
}

