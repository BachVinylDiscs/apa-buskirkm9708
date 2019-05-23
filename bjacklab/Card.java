//Name -
//Date -
//Class -
//Lab  - 

public class Card
{
  public static final String FACES[]={"ZERO","ACE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

  private int face;
  private String suit;

  public Card()
  {
    face=0;
    suit="";
  }

  public Card(int n,String s)
  {
    face=n;
    suit=s;
  }

  public void setFace(int n)
  {
    face=n;
  }

  public void setSuit(String s)
  {
    suit=s;
  }

  public int getFace()
  {
    return face;
  }

  public String getSuit()
  {
    return suit;
  }

  public abstract int getValue();

  public boolean equals(Object obj)
  {
    Card other=(Card)obj;
    return face==other.getFace()&&suit==other.getSuit();
  }

  public String toString()
  {
    return FACES[face]+" of "+getSuit()+" | value = "+getValue();
  }

}
