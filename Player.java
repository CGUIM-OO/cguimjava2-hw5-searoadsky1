
import java.util.ArrayList;

public class Player extends Person{
  private String name; //玩家姓名
  private int chips;   //玩家總籌碼
  public int bet=0;    //玩家下注的籌碼
	
  public Player(String name, int chips)//此局的卡
{
	 this.name=name;
	 this.chips= chips;
}

       public  String getname()
       {
	   return name;
       }
       
	   public int  makebet()
	   {
		   if(bet>chips)
		   {
			System.out.println("沒錢,不可再下注囉~~");
			return bet;   
		   }		  
		   else
		   return bet=1;
	   }
 	   
	   public boolean hit_me(Table table)
	   {
		   
		   if(getTotalValue()<17)return true;
		   else return false;
	   }
	   
	   public int getcurrentchips()
	   {
		   return chips;
	   }
	   public void increasechips(int diff)
	   {
	   
	   chips+=diff;
	   }

	   public void say_hello() //印出角色和各有多少籌碼
	   {
		   
		   System.out.println("您好，我是"+name+",");
		   System.out.println("我有"+chips+"chips.");
		   
	   }
}