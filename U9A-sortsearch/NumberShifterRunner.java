//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifterRunner
{
  public static void main( String args[] ) throws IOException
  {
    Scanner squee=new Scanner(in);
    System.out.print("Enter array size: ");
    int size=squee.nextInt();
    System.out.println(Arrays.toString(NumberShifter.shiftEm(size)));
  }
}



