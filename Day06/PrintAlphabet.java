public class PrintAlphabet {
	public static void main(String [] args){
		String result = "";
		
		for(int i=65; i<91; i++){
			char c = (char)i;
			System.out.print(c + " ");
		}
		System.out.println("\n");
		int value = 5;
		for(int i=1; i<10; i++){
			System.out.println(value + " * "+ i + " = " + value * i);
		}		

		char h = '\0',e='\0',l='\0',o='\0';		
		for(int i=0; i<91; i++)
		{
			char c = (char)i;
			if(c == 'H'){
				h = c;
			}else if(c == 'E'){
				e = c;
			}else if(c == 'L'){
				l = c;
			}else if(c == 'O'){
				o = c;
			}
		}

		System.out.println("\n"+h+""+e+""+l+""+l+""+o+"");
	}
}