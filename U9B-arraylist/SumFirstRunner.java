//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Max Buskirk
//Date - AP Computer Science A
import java.util.ArrayList;
public class SumFirstRunner
{
  public static void main(String args[])
  {
    ArrayList<Integer> arrl;
    arrl=new ArrayList<Integer>();
    arrl.add(9);
    arrl.add(10);
    arrl.add(-88);
    arrl.add(100);
    arrl.add(-555);
    arrl.add(2);
    System.out.println(ListSumFirst.go(arrl));				
  }
}
