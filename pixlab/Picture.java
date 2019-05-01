//package pixlab;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void keepOnlyRed(int r1,int r2,int c1,int c2)
  {
    Pixel[][] pixels=this.getPixels2D();
    for(int i=r1;i<r2;i++)
    {
      for(int j=c1;j<c2;j++)
      {
	pixels[i][j].setGreen(0);
	pixels[i][j].setBlue(0);
      }
    }
  }
  
  public void keepOnlyGreen(int r1,int r2,int c1,int c2)
  {
    Pixel[][] pixels=this.getPixels2D();
    for(int i=r1;i<r2;i++)
    {
      for(int j=c1;j<c2;j++)
      {
	pixels[i][j].setRed(0);
	pixels[i][j].setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue(int r1,int r2,int c1,int c2)
  {
    Pixel[][] pixels=this.getPixels2D();
    for(int i=r1;i<r2;i++)
    {
      for(int j=c1;j<c2;j++)
      {
	pixels[i][j].setRed(0);
	pixels[i][j].setGreen(0);
      }
    }
  }
  
  public void keepOnlyRed()
  {
    Pixel[][] pixels=this.getPixels2D();
    for(Pixel[] row:pixels)
    {
      for(Pixel pix:row)
      {
	pix.setGreen(0);
	pix.setBlue(0);
      }
    }
  }

  public void keepOnlyGreen()
  {
    Pixel[][] pixels=this.getPixels2D();
    for(Pixel[] row:pixels){
      for(Pixel pix:row)
      {
	pix.setRed(0);
	pix.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
    Pixel[][] pixels=this.getPixels2D();
    for(Pixel[] row:pixels){
      for(Pixel pix:row)
      {
	pix.setRed(0);
	pix.setGreen(0);
      }
    }
  }

  public void negate()
  {
    Pixel[][] pixels=this.getPixels2D();
    for(Pixel[] row:pixels)
    {
      for(Pixel pix:row)
      {
	pix.setRed(255-pix.getRed());
	pix.setGreen(255-pix.getGreen());
	pix.setBlue(255-pix.getBlue());
      }
    }
  }

  public void grayscale()
  {
    Pixel[][] pixels=this.getPixels2D();
    int avg=0;
    for(Pixel[] row:pixels)
    {
      for(Pixel pix:row)
      {
	avg=(int)((pix.getRed()+pix.getGreen()+pix.getBlue())/3);
	pix.setRed(avg);
	pix.setGreen(avg);
	pix.setBlue(avg);
      }
    }
  }

  public void fixUnderwater()
  {
    grayscale();
  }

  public void blur(int x,int y,int w,int h)
  {
    Pixel[][] pixels=this.getPixels2D();
    Pixel up=null;
    Pixel upleft=null;
    Pixel left=null;
    Pixel downleft=null;
    Pixel down=null;
    Pixel downright=null;
    Pixel right=null;
    Pixel upright=null;
    Color averageColor=null;
    for(int row=x+1;row<x+w-1;row++){
      for(int col=y+1;col<y+h-1;col++){
	up=pixels[row-1][col];
	upleft=pixels[row-1][col-1];
	left=pixels[row][col-1];
	downleft=pixels[row+1][col-1];
	down=pixels[row+1][col];
	downright=pixels[row+1][col+1];
	right=pixels[row][col+1];
	upright=pixels[row-1][col+1];
        int r=(up.getRed()+upleft.getRed()+left.getRed()+downleft.getRed()+down.getRed()+downright.getRed()+right.getRed()+upright.getRed())/8;
	int g=(up.getGreen()+upleft.getGreen()+left.getGreen()+downleft.getGreen()+down.getGreen()+downright.getGreen()+right.getGreen()+upright.getGreen())/8;
	int b=(up.getBlue()+upleft.getBlue()+left.getBlue()+downleft.getBlue()+down.getBlue()+downright.getBlue()+right.getBlue()+upright.getBlue())/8;
	averageColor=new Color(r,g,b);
        pixels[row][col].setColor(averageColor);
      }
    }
  }

  /** Method that mirrors the picture around a
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width/2; col < width; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height/2; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = height / 2; row < height; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  public void mirrorDiagonal()
  {
    Pixel[][] pixels=this.getPixels2D();
    Pixel blPixel=null;
    Pixel trPixel=null;
    for(int row=0;row<pixels.length;row++)
    {
      for(int col=0;col<row;col++)
      {
        blPixel=pixels[row][col];
	trPixel=pixels[col][row];
	trPixel.setColor(blPixel.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }

  public void mirrorArms()
  {
    int mirrorRow=192;
    Pixel topPixel=null;
    Pixel bottomPixel=null;
    Pixel[][] pixels=this.getPixels2D();
    for(int row=158;row<mirrorRow;row++){
      for(int col=103;col<170;col++){
        topPixel=pixels[row][col];
	bottomPixel=pixels[2*mirrorRow-row][col];
	bottomPixel.setColor(topPixel.getColor());
      }
      for(int col=239;col<295;col++){
        topPixel=pixels[row][col];
	bottomPixel=pixels[2*mirrorRow-row][col];
	bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  public void mirrorGull()
  {
    int mirrorCol=220;
    Pixel rightPixel=null;
    Pixel leftPixel=null;
    Pixel[][] pixels=this.getPixels2D();
    for(int row=235;row<325;row++){
      for(int col=237;col<347;col++){
        rightPixel=pixels[row][col];
	leftPixel=pixels[row][2*mirrorCol-col];
	leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  public void mirrorRectangle(int x1,int y1,int x2,int y2,boolean vertical,int m)
  {
    Pixel from=null;
    Pixel to=null;
    Pixel[][] pixels=this.getPixels2D();
    if(vertical){
      for(int row=x1;row<x2;row++){
        for(int col=y1;col<y2;col++){
          from=pixels[row][col];
	  to=pixels[row][2*m-col-1];
	  to.setColor(from.getColor());
	}
      }
    }else{
      for(int row=x1;row<x2;row++){
	for(int col=y1;col<y2;col++){
	  from=pixels[row][col];
	  to=pixels[2*m-row-1][col];
	  to.setColor(from.getColor());
	}
      }
    }
  }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow=0,toRow=startRow;fromRow<fromPixels.length&&toRow<toPixels.length;fromRow++,toRow++)
    {
      for(int fromCol=0,toCol=startCol;fromCol<fromPixels[0].length&&toCol<toPixels[0].length;fromCol++,toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  public void copy(Picture fromPic,int r1,int r2,int c1,int c2,int startRow,int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow=r1,toRow=startRow;fromRow<r2||toRow<toPixels.length;fromRow++,toRow++)
    {
      for (int fromCol=c1,toCol=startCol;fromCol<c2||toCol<toPixels[0].length;fromCol++,toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
	toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void myCollage()
  {
    Picture beach=new Picture("beach.jpg");
    Picture seagull=new Picture("seagull.jpg");
    Picture swan=new Picture("swan.jpg");
    this.copy(beach,0,0,478,638,0,0);
    this.copy(seagull,234,234,320,345,390,475);
    this.copy(swan,68,76,280,391,68,76);
    this.mirrorRectangle(0,0,240,320,false,240);
    this.keepOnlyRed(240,0,479,320);
    this.mirrorRectangle(240,320,479,639,false,240);
    this.keepOnlyGreen(0,320,240,639);
    this.keepOnlyBlue(240,320,479,639);
    this.write("collage.jpg");
  }

  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture redMoto = new Picture("redMotorcycle.jpg");
    redMoto.blur(185,160,20,20);
    redMoto.blur(185,160,20,20);
    redMoto.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
