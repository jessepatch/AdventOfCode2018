import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
	static String fileName = "C:\\Training\\Save Data\\AoC-day1.txt";

	public static void main(String[] args) {
	findTotal();
	}
	
public static void findTotal() {
		Scanner scanner = null;
		ArrayList<Integer> matchArray = new ArrayList<Integer>();
		ArrayList<String> repeatArray = new ArrayList<String>();
		int matchValue = 0;
		int total = 0;
		boolean foundIt = false;
		try {
			scanner = new Scanner(new File(fileName));
			
		 } catch (FileNotFoundException ex) {
		 }
		
		
		while(scanner.hasNext()) {
			
		String mess = scanner.next();
		repeatArray.add(mess);
		if(mess.charAt(0) == '-') {
			total = total - Integer.parseInt(mess.substring(1));
			matchArray.add(total);
		}
		if(mess.charAt(0) == '+') {
			total = total + Integer.parseInt(mess.substring(1));
			matchArray.add(total);
		}
		for(int j = 0; j < matchArray.size() - 1; j++) {
			if(total == matchArray.get(j)) {
				matchValue = total;
				System.out.println("Match value:" + matchValue);
			}
		}
		}
		
		System.out.println(total);
		
		//Part 2 starts here
		while(!foundIt) {
		for(int q = 0; q < repeatArray.size(); q++) {
		if(repeatArray.get(q).charAt(0) == '-') {
			total = total - Integer.parseInt(repeatArray.get(q).substring(1));
			matchArray.add(total);
		}
		if(repeatArray.get(q).charAt(0) == '+') {
			total = total + Integer.parseInt(repeatArray.get(q).substring(1));
			matchArray.add(total);
		}
		for(int j = 0; j < matchArray.size() - 1; j++) {
			if(total == matchArray.get(j)) {
				matchValue = total;
				foundIt = true;
				System.out.println("Match value:" + matchValue);
				System.exit(0);
			}
		}
		}
}
}


}
