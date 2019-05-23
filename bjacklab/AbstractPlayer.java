//Name -
//Date - 
//Class -
//Lab  - 

import java.util.ArrayList;

public abstract class AbstractPlayer implements Playerable
{
  private ArrayList<BlackJackCard> hand;
  private int winCount;

  //constructors
  public AbstractPlayer()
  {
    hand=new ArrayList<BlackJackCard>;
    winCount=0;
  }

  public void addCardToHand(BlackJackCard temp)
  {
    hand.add(temp);
  }

  public void resetHand( )
  {
    for(int i=0;i<hand.size();i++){
      hand.remove(0);
    }
  }

  public abstract boolean hit();

  public void setWinCount(int numwins)
  {
    winCount=numwins;
  }

  public int getWinCount() { return winCount; }

  public int getHandSize() { return hand.size(); }

  public int getHandValue()
  {
    //great example of polymorphism
    int total=0;
    for(BlackJackCard i:hand){
      total+=i.getValue();
    }
    return total;
  }

  public String toString()
  {
    return "hand = " + hand.toString() + " \n-  # wins " + winCount;
  }
}
