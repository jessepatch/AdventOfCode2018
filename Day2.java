import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {

	static String fileName = "C:\\Training\\Save Data\\AoC-day2.txt";
	static ArrayList<String> allIds = new ArrayList<String>();

	public static void main(String[] args) {
		compareBoxId();
		findDifferences();
	}
	
	public static void compareBoxId() {
		int twoCount = 0;
		int threeCount = 0;
		int checkSum = 0;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));

		} catch (FileNotFoundException ex) {}

		while(scanner.hasNext()) {
		String id = scanner.next();
		allIds.add(id);
		int tempTwoCount = 0;
		int tempThreeCount = 0;

		for(int i = 0; i < id.length(); i++) {

			int matchCount = 0;

			
			for(int j = i + 1; j < id.length(); j++) {
				if(id.charAt(i) == id.charAt(j)) {
					matchCount++;
				}
			}
			if(matchCount == 1) {
				tempTwoCount++;
			} else if (matchCount == 2) {
				tempThreeCount++;
			}
			
		}
		if(tempThreeCount > 0) {
			threeCount++;
		}
		if(tempTwoCount - tempThreeCount > 0) {
			twoCount++;
		}
		
		}
		
		checkSum = twoCount * threeCount;
		System.out.println("CheckSum = " + checkSum);
	}
	
	public static void findDifferences() {
		int differenceCount = 0;
		String string1 = "";
		String string2 = "";
		int differenceAt = 0;
		
		for(int i = 0; i < allIds.size(); i++) {
			for(int j = i + 1; j < allIds.size(); j++) {
				differenceCount = 0;
				for(int k = 0; k < allIds.get(i).length(); k++) {
				if(allIds.get(i).charAt(k) != allIds.get(j).charAt(k)) {
					differenceCount++;
					differenceAt = k;
				}
				}
				if( differenceCount == 1) {
					string1 = allIds.get(i);
					string2 = allIds.get(j);
					String inCommon = string1.substring(0, differenceAt) + string1.substring(differenceAt + 1);
					System.out.println("They have " + inCommon + " in common");
				}
			}
		}
		
		
	}
}
