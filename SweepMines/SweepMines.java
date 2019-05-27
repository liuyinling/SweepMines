import java.util.Scanner;
class SweepMines{
	
	
	public static void main(String [] args){
		int l,c,flag;
		Board b = new Board();
		Scanner s = new Scanner(System.in);
		b.display();
		for(int i=0;i<10000;i++){
			System.out.println("Plese input coordinates and flag");
			l = s.nextInt();
			c = s.nextInt();
			flag = s.nextInt();
			b.play(l,c,flag);
			b.display();
		}
	}
	
}
