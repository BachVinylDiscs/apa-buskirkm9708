//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Max Buskirk
//Date - February 28, 2019

import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
  public static int go(List<Integer> ray)
  {
    int sum=-1;
    if(ray.size()>0){
      sum=0;
      int first=ray.get(0);
      for(int i=0;i<ray.size();i++){
        if(ray.get(i)>first){
          sum+=ray.get(i);
        }
      }
    }
    return sum;
  }
}
