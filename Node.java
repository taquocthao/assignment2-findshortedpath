
import java.util.ArrayList;

public class Node {
	
	private int id;
	private ArrayList<AdjacentNode> adjacentNodes;
	
	public Node(int id, ArrayList<AdjacentNode> adjacentNodes) {
		this.id = id;
		this.adjacentNodes = adjacentNodes;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}

	public ArrayList<AdjacentNode> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(ArrayList<AdjacentNode> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	
	
}
