public class Array {
	public static void main(String [] args){
		String mon = "월";
		String tue = "화";
		String wed = "수";
		String thr = "목";
		String fri = "금";
		String sat = "토";
		String sun = "일";
		
		System.out.print(mon);
		System.out.print(tue);
		System.out.print(wed);
		System.out.print(thr);
		System.out.print(fri);
		System.out.print(sat);
		System.out.print(sun + "\n");
		String [] week = {"월","화","수","목","금","토","일"};
		
		for(int i=0; i<week.length; i++){
			System.out.print(week[i] + " ");
		}
		
		System.out.println("\n");
		
		String [][] fruitArray = new String [3][4];
		fruitArray[0][0] = "귤";
		fruitArray[0][1] = "상";
		fruitArray[0][2] = "10";
		fruitArray[0][3] = "상큼하다";
		
		fruitArray[1][0] = "사과";
		fruitArray[1][1] = "중";
		fruitArray[1][2] = "25";
		fruitArray[1][3] = "달다";
		
		fruitArray[2][0] = "배";
		fruitArray[2][1] = "상";
		fruitArray[2][2] = "20";
		fruitArray[2][3] = "달달하다";
		
		for(int i=0; i<fruitArray.length; i++){
			for(int j=0; j<4; j++){
				
					switch(j){
						case 0 : 
							System.out.print("이름 : "); 
							break;
						case 1 : 
							System.out.print("품질 : "); 
							break;
						case 2 : 
							System.out.print("갯수 : "); 
							break;
						case 3 : 
							System.out.print("맛 : "); 
							break;
					}
					System.out.println(fruitArray[i][j]);
				
			}
		}
		
	}
}