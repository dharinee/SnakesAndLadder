import java.util.*;
import java.lang.*;
import java.io.*;

public class snakesnladder
{
	int board[]= new int[100];
	int s[][], l[][], snakes,ladder,player , pos[] ;
    String	names[]; 
	public  void createboard()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter number of snakes");
		snakes=scan.nextInt(); 
		s = new int[snakes][2];
		scan.nextLine();
		System.out.println("Enter the position of snakes");
        
        for(int i=0;i<snakes;i++)
		{
            System.out.println("Enter for snake "+(i+1));
            String line=scan.nextLine();
            String[] part=line.split(",");
            s[i][0]=Integer.parseInt(part[0]); 
            s[i][1]=Integer.parseInt(part[1]); 
        }
		
		System.out.println("Enter number of ladders");
		ladder=scan.nextInt(); 
		l = new int[ladder][2];
		scan.nextLine();
		System.out.println("Enter the position of ladders");
        
        for(int i=0;i<ladder;i++)
		{
            System.out.println("Enter for ladder "+(i+1));
            String next=scan.nextLine();
            String part[]=next.split(",");
            l[i][0]=Integer.parseInt(part[0]); 
            l[i][1]=Integer.parseInt(part[1]); 
        }
		
	}
	public void play()
	{
		System.out.println("Game start:");
		boolean finish = false;
		Scanner scan = new Scanner(System.in);
		while(!finish)
		{
			for(int i=0;i<player;i++)
			{
				boolean accept = false;
				int value=1;
				while(!accept)
				{
				System.out.println("Enter player " +names[i]+"'s turn");
				value=scan.nextInt();
				System.out.println("value="+value);
				if((value<=6)&&(value>=1))
				{
					accept=true;
				}
				else
					System.out.println("Enter value on dice between 1 and 6");
				
				}
				int nextPos = value + pos[i];
				if(nextPos>100)
				{
					System.out.println("Not a valid move. Try again in next turn.");
					nextPos=pos[i];
					
				}
				else if(nextPos==100)
				{
					System.out.println("Congrats!! Player" +names[i]+ " Won");
					finish=true;
					return;
				
				}
				else
				{
					for(int j=0;j<snakes;j++)
					{
						if(nextPos==s[j][0])
						{
							nextPos=s[j][1];
							System.out.println("Snake " +s[j][0]+ "," +s[j][1]);
							break;
						}
					}
					for(int j=0;j<ladder;j++)
					{
						if(nextPos==l[j][0])
						{
							nextPos=l[j][1];
							System.out.println("Ladder " +l[j][0]+ "," +l[j][1]);
							break;
						}
					}
				}
				pos[i]=nextPos;
				System.out.println("Positions:");
				for(int j=0;j<player;j++)
				{
					System.out.println(names[j] +"->" + pos[j]);
				}
			}
		}
		
	}
	public void players()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of players");
		player=scan.nextInt(); 
		scan.nextLine();
        names=new String[player]; 
        pos=new int[player];        
        for(int i=0;i<player;i++)
		{
            System.out.println("Enter for name for player " +(i+1) );
            names[i]=scan.nextLine(); 
            pos[i]=0; 
        }
	}
	public static void main(String[] args)
	{
		System.out.println("WELCOME");		
		snakesnladder game1= new snakesnladder();
		
		game1.createboard();
		game1.players();
		game1.play();
		System.exit(0);
		
		
	}
}