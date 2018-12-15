
public class Table {

 static final int MAXPLAYER = 4;//一桌坐4人 
   private Deck AllCards; //儲存所有的牌 
   private Player[] players ;//儲存所有玩家 
   private Dealer dealer;//儲存一個莊家 
   int[] pos_betArray ;//儲存每個玩家一局的下注 
   private Card face_up_card_of_dealer; 
    
   public Table ( int nDeck)
   { 
    AllCards = new Deck(nDeck); 
    players = new Player[MAXPLAYER]; 
   } 
    
   public void set_player(int pos, Player p)//把玩家放到牌桌上
   { 
    players[pos] = p; 
   } 
    
   public Player[] get_player()
   {//回傳所有的Player 
    return players; 
   } 
  
   public void set_dealer(Dealer d)//把dealer放到牌桌上
   { 
    dealer = d; 
   } 
    
   public  Card get_face_up_card_of_dealer()
   { //回傳dealer打開的那張牌，也就是第二張牌

    return face_up_card_of_dealer; 
   } 
    
   private void ask_each_player_about_bets()
   { 
    int n =0; 
    pos_betArray =new int[players.length]; 
    for ( Player x : players) 
    { 
     x.say_hello(); //玩家打招呼
     x.makebet(); //玩家下注
     pos_betArray[n] = x.bet; //儲存每個玩家的下注 
     n++; 
    } 
   } 
    
   private void distribute_cards_to_dealer_and_players()
   {//發牌給玩家和莊家 
    for ( Player x : players)//發牌給每位玩家 
    { 
     x.setOneRoundCard(AllCards.getOneCard(true)); 
     x.setOneRoundCard(AllCards.getOneCard(true)); 
    } 
    dealer.setOneRoundCard(AllCards.getOneCard(false));//發暗牌給莊家 
    dealer.setOneRoundCard(AllCards.getOneCard(true));//發亮牌給莊家 
    face_up_card_of_dealer = dealer.getOneRoundCard().get(1);//儲存莊家第二張牌 
    System.out.print("Dealer's face up card is "); 
    dealer.getOneRoundCard().get(1).printCard(); 
   } 
    
   private void ask_each_player_about_hits()
   { //ask每個玩家還要不要牌 
    for (Player x : players) 
    { 
     System.out.println(x.getname()+"'s Cards now:"); 
     x.printAllCard(); 
     while ( x.hit_me(this)) //ask是否要加新的牌 
     { 
      x.setOneRoundCard(AllCards.getOneCard(true));//Add new牌 
      System.out.println("Hit! "+x.getname()+"'s Cards now:"); //玩家要牌時印出
      x.printAllCard(); 
     } 
     System.out.println("Pass hit!"); 
     System.out.println(x.getname()+"'s hit is over!"); 
    } 
   } 
  
   private void ask_dealer_about_hits()
   {//ask莊家要不要牌 
    while ( dealer.hit_me(this)) 
    { 
     dealer.setOneRoundCard(AllCards.getOneCard(true));//add new 
    } 
    System.out.println("Dealer's hit is over!"); //完成後印出
   } 
  
 
   private void calculate_chips()//印出莊家的點數和牌"Dealer's card value is "+總點數+" ,Cards:"+牌們 (提示: printAllCard())

   { 
    System.out.println("Dealer's card value is "+dealer.getTotalValue()+" ,Cards:"); 
    dealer.printAllCard(); 
    int m = dealer.getTotalValue(); 
    int n = 0; 
    for ( Player x : players) 
    { 
     int o = x.getTotalValue(); 
     int b = pos_betArray[n]; 
     n++; 
     System.out.println(x.getname()+"'s Cards: "); 
     x.printAllCard(); 
     System.out.print(x.getname()+" card value is "+x.getTotalValue()); 
     //比較牌和莊家 
     if ( m >21 &&  o>21)//兩者都爆掉 
     { 
      System.out.println(", chips have no change! The Chips now is: "+x.getcurrentchips()); 
     } 
     else if ( m>21 && o<=21)//玩家win
     { 
      x.increasechips(b); 
      System.out.println(", Get "+b+"Chips, the Chips now is: "+ x.getcurrentchips()); 
     } 
     else if ( m<=21 && o>21)//玩家lose
     { 
      x.increasechips(-b); 
      System.out.println(", Loss "+b+"Chips, the Chips now is: "+ x.getcurrentchips()); 
     } 
     else if ( m<=21 && o<=21)//兩個都沒爆
     { 
      if ( m > o)//玩家輸lose
      { 
       x.increasechips(-b); 
       System.out.println(", Loss "+b+"Chips, the Chips now is: "+ x.getcurrentchips()); 
      } 
      else if ( m < o)//玩家win 
      { 
       x.increasechips(b); 
       System.out.println(", Get "+b+"Chips, the Chips now is: "+ x.getcurrentchips()); 
      } 
      else if ( m == o)//相等 
      { 
       System.out.println(", chips have no change! The Chips now is: "+x.getcurrentchips()); 
       } 
   } 
   } 
   } 
  
   public int[] get_palyers_bet(){ 
    return pos_betArray; 
   } 
    
   public void play(){ 
    ask_each_player_about_bets();//ask chip(籌碼) 
    distribute_cards_to_dealer_and_players();//發牌 
    ask_each_player_about_hits();//ask玩家要不要加牌 
    ask_dealer_about_hits();  //ask莊家要不要加牌 
    calculate_chips(); 
   } 
}