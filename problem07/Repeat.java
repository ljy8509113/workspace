import java.io.IOException;
public class Repeat{
	public static void main(String [] args){		
		/*
		for(int i=0; i<10; i++){
			System.out.println("Hello");
		}
		*/
		
		if(args.length != 4){
			errorMsg();
		}else if(args.length == 2){
			if(args[0].equals("-message")){
				System.out.println(args[1]);
			}else{
				errorMsg();
			}
		}else{			
			if(args[0].equals("-message") && args[2].equals("-repeat")){
				int size = Integer.parseInt(args[3]);
				for(int i=0; i<size; i++){
					System.out.println(args[1]);
				}								
			}else{
				errorMsg();
			}			
		}			
	}
	
	public static void errorMsg(){
		System.out.println("명령 구문이 올바르지 않습니다.");
		System.out.println("사용법 : ");
		System.out.println("java RepeatPrint [-options]");
		System.out.println("-message <출력할 메시지 입력>");
		System.out.println("-repeat <메시지 출력 반복횟수>");
	}
}