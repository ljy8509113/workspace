public class Reservation {
	public static void main(String [] args){
		int [][] seat = {
			{0,0,0,0},
			{0,1,0,0},
			{0,0,1,0},
			{0,0,1,1}
		};
		
		if(args.length == 2){
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			
			if(x > 3 || y > 3){
				System.out.println("입력 오류");
			}else{
				if(seat[x][y] == 0)
				System.out.println("예약 가능");
			else
				System.out.println("예약 불가");		
			}
			
		}else{
			System.out.println("입력 오류");
		}		
	}
}