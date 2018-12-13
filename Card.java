
public class Card  //B0444223吳昀叡
{
	public enum Suit  //列舉 
	{
		Clubs, Diamonds, Hearts, Spades
	}
	
	private Suit suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; // 1~13
	
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(Suit s, int r) //建構子
	{
		suit=s;
		rank = r;
	}
	public Card() //系統自動產生的建構子
	{
		// TODO Auto-generated constructor stub 	
	}
	
	
	// TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10
		// for rank)
		public void printCard() 
		{
			if(rank==1) //普克牌1印ACE
			{
				System.out.println(getSuit() + "," + "ACE");
			}
			else if(rank==11) //普克牌11印Jack
					
			{
				System.out.println(getSuit() + "," + "Jack");
				
			}
			else if(rank==12) //普克牌12印Queen
				
			{
				System.out.println(getSuit() + "," + "Queen");
				
			}
             else if(rank==13) //普克牌13印King
				
			{
				System.out.println(getSuit() + "," + "King");
				
			}
             else
            {
            	 System.out.println(getSuit() + "," + getRank());
            	 
            }
			
			
			// Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as
			// Clubs Ace			 
			
		}
		
		public Suit getSuit() {
			
			
			return suit;
		}

		public int getRank() {
			
			
			return rank;
		}
	
	
	
	
	
	
	
	
	
	
	
}
