import java.util.HashSet;
import java.util.Set;

public class scannerTest {

	public static void main(String[] args) {
		int x;
		x = +3 +2;
		System.out.println(x);
		
		Set<String> s = new HashSet<String>();
		
		for (char c='0'; c<='9'; c++) {
		    s.add(c+"");
		}   
	
		System.out.println(s);
		
		s.add("-1");
		
		String y = "hello+";
		System.out.println(y.endsWith("+"));
	}
}
