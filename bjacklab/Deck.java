//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
  public static final int NUMFACES = 13;
  public static final int NUMSUITS = 4;
  public static final int NUMCARDS = 52;

  public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

  private int topCardIndex;
  private ArrayList<BlackJackCard> cards;

  public Deck()
  {
    topCardIndex=NUMCARDS-1;
    cards=new ArrayList<BlackJackCard>();
    for(String s:SUITS){
      for(int n=1;n<=13;n++){
        cards.add(new BlackJackCard(n,s));
      }
    }
  }

  //modifiers
  public void shuffle()
  {
    for(int i=cards.size()-1;i>-1;i--){
		  int r=(int)((i+1)*Math.random());
		  BlackJackCard temp=cards.set(r,cards.get(i));
		  cards.set(i,temp);
		}
    topCardIndex=NUMCARDS-1;
  }

  //accessors
  public int size()
  {
    return cards.size();
  }

  public int numCardsLeft()
  {
    return topCardIndex+1;
  }

  public BlackJackCard nextCard()
  {
    return cards.get(topCardIndex--);
  }

  public String toString()
  {
    return cards + "   topCardIndex = " + topCardIndex;
  } 
}
