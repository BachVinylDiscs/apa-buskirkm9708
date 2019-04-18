//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Max Buskirk

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
  //instance variables and other methods not shown

  public static int[] getSortedDigitArray(int number) 
  {
    int num=((int)(Math.pow(10,number)-(int)Math.pow(10,number-1))*(int)Math.random())+(int)Math.pow(10,number-1);
    int[] arr=new int[number];
    for(int i:arr){
      i=num%10;
      num/=10;
    }
    for(int i=0;i<arr.length-1;i++){
      int min=i;
      for(int j=0;j<arr.length;j++){
        if(arr[j]<arr[min]){
          min=j;
        }
      }
      if(min!=i){
        int temp=arr[min];
        arr[min]=arr[i];
        arr[i]=temp;
      }
    }
    return arr;
  }
}
