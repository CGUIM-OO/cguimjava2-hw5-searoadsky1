
import java.util.ArrayList;

public class Player extends Person{
  private String name; //���a�m�W
  private int chips;   //���a�`�w�X
  public int bet=0;    //���a�U�`���w�X
	
  public Player(String name, int chips)//�������d
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
			System.out.println("�S��,���i�A�U�`�o~~");
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

	   public void say_hello() //�L�X����M�U���h���w�X
	   {
		   
		   System.out.println("�z�n�A�ڬO"+name+",");
		   System.out.println("�ڦ�"+chips+"chips.");
		   
	   }
}