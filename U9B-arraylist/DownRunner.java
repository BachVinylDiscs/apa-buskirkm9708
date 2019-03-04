//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Max Buskirk
//Date - March 4, 2019
import java.util.ArrayList;
import java.util.List;
public class DownRunner
{
  public static void main( String args[] )
  {
    ArrayList<Integer> arrl;
    arrl=new ArrayList<Integer>();
    int[] arr={250,19,17,15,13,11,10,9,6,3,2,1,-455};
    for(int i:arr){
      arrl.add(i);
    }
    System.out.println(ListDown.go(arrl));
  }
}
