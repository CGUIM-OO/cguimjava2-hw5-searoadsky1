
import java.util.*; //B0444223�d����

class Deck 
{
	public int a = 0; //�k�s��
	public int b = 0; //�k�s��
	private ArrayList<Card> cards;//�P��  //�ŧi�}�C  arrayList��Java���ت�Class,�\��W�űj�j
	ArrayList<Card> usedCard = new ArrayList<Card>();
	ArrayList<Card> openCard=new ArrayList<Card>();//HW4�s�񥴶}���P�A�B�b�~�P�ɭn�M��
	public int nUsed = 0;//�ϥιL���d���ƶq�A���]�쥻�O0

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) //���Ѽƪ��غc�l(�S���^�ǭ�)
	{
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end

		for (int i = 0; i < nDeck; i++)  //�X�ƵP
		{
		for(int x=0;x<4;x++) //1-4���
		  {
				for (int y = 1; y < 14; y++) //�Ʀr
				{
					if(x==0) 
					{
						Card card = new Card(Card.Suit.Clubs, y);
						cards.add(card);
					}
					 else if(x==1) 
					{
						Card card=new Card(Card.Suit.Diamonds,y);
						cards.add(card);
					}
					 else if(x==2) 
					{
						Card card=new Card(Card.Suit.Hearts,y);
						cards.add(card);
					}
					 else if(x==3) 
					{
						Card card=new Card(Card.Suit.Spades,y);
						cards.add(card);
					}
				}
		  }
		}

	}

	public Deck() {
		// TODO Auto-generated constructor stub
	}

	public Card getOneCard(boolean isOpened) //�q�~�n�P�A�H�K��@�i�P�C(52�i�P�H�K�D�@��) //boolean isOpened�OHW4�[��
	{
		Card n = new Card(null, 0);
		Random  r = new Random();
		if (nUsed == 52) 
		{
			shuffle();
		}

		n = cards.get(r.nextInt(52));
		for (int j = 0; j < usedCard.size(); j++) 
		{
			
			while (n.equals(usedCard.get(j))) 
			{
				n = cards.get(r.nextInt(52));
			}
		}
		/*
		 * while(n.equals(usedCard)) { n=cards.get(nc.nextInt(52)); }
		 */
		usedCard.add(a, n);
		nUsed++;
		a=a+1;
		
	//HW4�⥴�}���P�[�JopenCard
	if(isOpened==true) 
	{
	openCard.add(n);
	}

		return n;
	}


	public void shuffle() //�~�P
	{
		Random rnd = new Random();
		int rp = rnd.nextInt(52);
		Card rtemp = new Card(null,0); //Card rtemp = new Card(); ���g(null,0)�]�i
		Card emp = new Card(null,0);   //Card emp = new Card(); ���g(null,0)�]�i

		for (int i = 0; i < 52; i++) 
		{
			while (i == rp) 
			{
				rp = rnd.nextInt(52);
			}
			rtemp = cards.get(rp);
			cards.set(rp, cards.get(i));
			cards.set(i, rtemp);

		}

		usedCard.set(b, emp);
		nUsed = 0;
		
		//HW4�M��openCard�����e
		for(int i=0;i<openCard.size();i++) 
		{
					openCard.set(i, null);
		}
	}

	// TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck()
	{
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5 points)
		for (int i = 0; i < 52; i++) 
		{
			//
			// Card n=cards.get(i);
			// //System.out.println(n.getSuit()+","+n.getRank());
			// n.printCard();
			Card n = new Card(null, 0); 
			n = cards.get(i);
			n.printCard();

		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
	
	    //HW4�^�ǥ��}���P
		public ArrayList<Card> getOpenedCard(){
				return openCard;
		}
}