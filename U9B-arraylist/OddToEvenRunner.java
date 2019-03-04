//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -
import java.util.ArrayList;
import java.util.List;
public class OddToEvenRunner
{
  public static void main( String args[] )
  {
    ArrayList<Integer> arrl;
    arrl=new ArrayList<Integer>();
    int[] arr={7,1,5,3,11,5,6,7,8,9,10,12345,11};
    for(int i:arr){
      arrl.add(i);
    }
    System.out.println(ListOddToEven.go(arrl));
  }
}
