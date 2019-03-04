//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Max Buskirk
//Date - March 4, 2019

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
  public static int go( List<Integer> ray )
  {
    int result=0;
    int odd=-1;
    for(int i=0;i<ray.size();i++){
      if(ray.get(i)%2==1){
        odd+=(i+1);
        break;
      }
    }
    if(odd>-1){
      int even=-1;
      for(int j=ray.size()-1;j>=odd;j--){
        if(ray.get(j)%2==0){
          even+=(j+1);
          break;
        }
      }
      if(even>-1){
        result=Math.abs(odd-even);
      }else{
        result=-1;
      }
    }else{
      result=-1;
    }
    return result;
  }
}
