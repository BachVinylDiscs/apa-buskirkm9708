//package pixlab;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.keepOnlyBlue();
    beach.explore();
  }

  public static void testKeepOnlyRed()
  {
    Picture beach = new Picture("beach.jpg");
    beach.keepOnlyRed();
    beach.explore();
  }

  public static void testKeepOnlyGreen()
  {
    Picture beach = new Picture("beach.jpg");
    beach.keepOnlyGreen();
    beach.explore();
  }

  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.negate();
    beach.explore();
  }

  public static void testGrayscale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.grayscale();
    beach.explore();
  }

  public static void testFixUnderwater()
  {
    Picture water = new Picture("water.jpg");
//    water.fixUnderwater();
    water.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }

  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }

  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
  }

  public static void testMirrorDiagonal()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorDiagonal();
    caterpillar.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.mirrorArms();
    snowman.explore();
  }

  public static void testMirrorGull()
  {
    Picture seagull = new Picture("seagull.jpg");
    seagull.mirrorGull();
    seagull.explore();
  }

  public static void testMirrorRectangle()
  {
    Picture beach = new Picture("beach.jpg");
    beach.mirrorRectangle(0,0,240,640,false,240);
    beach.explore();
  }

  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  public static void testMyCollage()
  {
    Picture collage = new Picture("640x480.jpg");
    collage.myCollage();
    collage.explore();
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetectionHoriz()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetectionHoriz(10);
    swan.explore();
  }
  
  public static void testEdgeDetectionVert()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetectionVert(10);
    swan.explore();
  }
  
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection2();
    swan.explore();
  }
  
  public static void testBlur(int x,int y,int w,int h,int n)
  {
    Picture redMoto = new Picture("redMotorcycle.jpg");
    for (int i = 0; i<n; i++){
      redMoto.blur(x,y,w,h);
    }
    redMoto.explore();
  }


  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testMirrorDiagonal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testMirrorRectangle();
    //testCollage();
    //testMyCollage();
    //testCopy();
    //testEdgeDetectionHoriz();
    //testEdgeDetectionVert
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
    //testBlur(180,160,25,25,10);
  }
}
