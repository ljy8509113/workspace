package problem;

public class Q2 {
	
	public static void print(Object obj) {
		if(obj instanceof Byte) {
			System.out.println(((Byte) obj).byteValue());
		}else if((obj instanceof Short)){
			System.out.println(((Short) obj).shortValue());
		}else if((obj instanceof Integer)){
			System.out.println(((Integer) obj).intValue());
		}else if((obj instanceof Long)){
			System.out.println(((Long) obj).longValue());
		}else if((obj instanceof Float)){
			System.out.println(((Float) obj).floatValue());
		}else if((obj instanceof Double)){
			System.out.println(((Double) obj).doubleValue());
		}else if((obj instanceof Character)){
			System.out.println(((Character) obj).charValue());
		}else if((obj instanceof Boolean)){
			System.out.println(((Boolean) obj).booleanValue());
		}
	}
	
	public static void main(String[] args) {
		Byte b = 1;
		Short s = 2;
		Integer i = 3;
		Long l = 4l;
		Float f = 5.0f;
		Double d = 6.0;
		Character c = 'c';
		Boolean bl = false;
		
		Q2 q2 = new Q2();
		q2.print(b);
		q2.print(s);
		q2.print(i);
		q2.print(l);
		q2.print(f);
		q2.print(d);
		q2.print(c);
		q2.print(bl);
		
		
	}
}
