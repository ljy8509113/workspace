package array.basic;

public class ArrayInit2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score[];
		score = new int[] {2, 4, 7};
		
		for(int i=0; i<score.length; i++)
			System.out.print(score[i]+" ");
		
		score = new int[] {25, 45, 75};
		System.out.printf("%d %d %d", score[0], score[1], score[2]);
		
	}

}
