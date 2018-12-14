package Day3;
import java.util.ArrayList;

public class FabricClaim {

	int id;
	int xStart;
	int yStart;
	int xLength;
	int yLength;
	ArrayList<String> coords = new ArrayList<String>(); 
	
	public FabricClaim() {
		
	}
	
	public FabricClaim(String id, int xStart, int yStart, int xLength, int yLength) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getxStart() {
		return xStart;
	}

	public void setxStart(int xStart) {
		this.xStart = xStart;
	}

	public int getyStart() {
		return yStart;
	}

	public void setyStart(int yStart) {
		this.yStart = yStart;
	}

	public int getxLength() {
		return xLength;
	}

	public void setxLength(int xLength) {
		this.xLength = xLength;
	}

	public int getyLength() {
		return yLength;
	}

	public void setyLength(int yLength) {
		this.yLength = yLength;
	}
	
	public void setCoords() {
		ArrayList<String> coords = new ArrayList<String>();
		
			for(int i = xStart; i < xStart + xLength; i++) {
				for(int j = yStart; j < yStart + yLength; j++) {
					coords.add(Integer.toString(i) + "," + Integer.toString(j));
				}
			
	}
			this.coords = coords;
}
	public ArrayList<String> getCoords() {
		return coords;
	}
}
