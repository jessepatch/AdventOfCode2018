package Day3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

	static String fileName = "C:\\Training\\Save Data\\AoC-day3.txt";
	static ArrayList<FabricClaim> fabricClaims = new ArrayList<FabricClaim>();

	public static void main(String[] args) {
		readFromFile();
		howManyOverlap(fabricClaims);
	}

	public static void readFromFile() {

		Scanner scanner = null;

		try {
			scanner = new Scanner(new File(fileName));

		} catch (FileNotFoundException ex) {}

		while(scanner.hasNextLine()) {

			FabricClaim fabricClaim = new FabricClaim();
			String input = scanner.nextLine();
			String[] data1 = input.split(" @ ");

			fabricClaim.setId(Integer.parseInt(data1[0].substring(1)));

			String[] data2 = data1[1].split(",");

			fabricClaim.setxStart(Integer.parseInt(data2[0]));

			String[] data3 = data2[1].split(": ");

			fabricClaim.setyStart(Integer.parseInt(data3[0]));

			String[] data4 = data3[1].split("x");

			fabricClaim.setxLength(Integer.parseInt(data4[0]));
			fabricClaim.setyLength(Integer.parseInt(data4[1]));
			
			fabricClaim.setCoords();

			fabricClaims.add(fabricClaim);
		}

	}
	public static void readFromFile(String inputData) {
			
			String[] inputSplit = inputData.split("!");
			for(int i = 0; i < inputSplit.length; i++) {
			FabricClaim fabricClaim = new FabricClaim();

			String input = inputSplit[i];
			String[] data1 = input.split(" @ ");

			fabricClaim.setId(Integer.parseInt(data1[0].substring(1)));

			String[] data2 = data1[1].split(",");

			fabricClaim.setxStart(Integer.parseInt(data2[0]));

			String[] data3 = data2[1].split(": ");

			fabricClaim.setyStart(Integer.parseInt(data3[0]));

			String[] data4 = data3[1].split("x");

			fabricClaim.setxLength(Integer.parseInt(data4[0]));
			fabricClaim.setyLength(Integer.parseInt(data4[1]));
			
			fabricClaim.setCoords();

			fabricClaims.add(fabricClaim);
			}
		}

	

	public static void howManyOverlap(ArrayList<FabricClaim> fabricClaims) {

		int overlapCount = 0;
		ArrayList<String> checked = new ArrayList<String>();
		
		for(int i = 0; i < fabricClaims.size(); i++) {
			for(int j = 0; j < fabricClaims.get(i).getCoords().size(); j++) {
				for(int k = i + 1; k < fabricClaims.size(); k++) {
					for(int l = 0; l < fabricClaims.get(k).getCoords().size(); l++) {
						if(fabricClaims.get(i).getCoords().get(j).equals(fabricClaims.get(k).getCoords().get(l)) && !checked.contains(fabricClaims.get(i).getCoords().get(j))) {
							overlapCount++;
							checked.add(fabricClaims.get(k).getCoords().get(l));
						}
					}
				}
			}
		}
		System.out.println(overlapCount);
	}

}
