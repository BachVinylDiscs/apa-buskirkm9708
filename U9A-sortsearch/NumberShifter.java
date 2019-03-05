//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Max Buskirk

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
  public static int[] makeLucky7Array(int size)
  {
    int[] arr=new int[size];
    for(int i=0;i<arr.length;i++){
      arr[i]=(int)(10*Math.random()+1);
    }
    return arr;
  }
  public static int[] shiftEm(int size)
  {
    int[] arr=makeLucky7Array(size);
    System.out.println(Arrays.toString(arr));
    int temp=0;
    int j=0;
    for(int i=0;i<arr.length;i++){
      if(arr[i]==7){
        temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
        j++;
      }
    }
    return arr;
  }
}
