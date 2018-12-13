
public class Card  //B0444223�d����
{
	public enum Suit  //�C�| 
	{
		Clubs, Diamonds, Hearts, Spades
	}
	
	private Suit suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; // 1~13
	
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(Suit s, int r) //�غc�l
	{
		suit=s;
		rank = r;
	}
	public Card() //�t�Φ۰ʲ��ͪ��غc�l
	{
		// TODO Auto-generated constructor stub 	
	}
	
	
	// TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10
		// for rank)
		public void printCard() 
		{
			if(rank==1) //���J�P1�LACE
			{
				System.out.println(getSuit() + "," + "ACE");
			}
			else if(rank==11) //���J�P11�LJack
					
			{
				System.out.println(getSuit() + "," + "Jack");
				
			}
			else if(rank==12) //���J�P12�LQueen
				
			{
				System.out.println(getSuit() + "," + "Queen");
				
			}
             else if(rank==13) //���J�P13�LKing
				
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
