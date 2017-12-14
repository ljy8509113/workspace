public class MyJavac{
	public static void main(String [] args){		
		for(int i=0; i<args.length; i++){
			if(i == 1){
				System.out.print(args[i]+"\n");
			}else{
				System.out.print(args[i]+" ");
			}				
				
		}
	}
}