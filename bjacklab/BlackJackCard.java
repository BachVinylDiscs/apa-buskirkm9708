//Name -
//Date -
//Class -
//Lab  - 

public class BlackJackCard extends Card
{
  public BlackJackCard()
  {
    super();
  }

  public BlackJackCard(int n,String s)
  {
    super(n,s);
  }

  public int getValue()
  {
    if(getFace()==1){
      return 11;
    }
    if(getFace()>=11&&getFace()<=13){
      return 10;
    }
    return getFace();
  }
        
}
