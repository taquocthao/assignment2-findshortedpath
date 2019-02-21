import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GraphImpl implements Graph {

	// số đỉnh đồ thị
	private int numberNode;
	private ArrayList<Node> listNodes;
	
	public GraphImpl(int numberNode) {
		this.numberNode = numberNode;
		listNodes = new ArrayList<Node>();
	}
	
	@Override
	public void randomGraph(String filename) {
		Random random = new Random();
		int i;
		for(i = 1; i <= this.numberNode; i++) {
			/* ---- sinh ngẫu nhiên các đỉnh kề của một node----*/
			//số đỉnh kề của một node
			int numberAdjNode = random.nextInt(this.numberNode/2);
			
			System.out.println("node " + i + " has "+ numberAdjNode + " adjacent node");
			
			ArrayList<AdjacentNode> adjacentNodes = new ArrayList<>();
			
			while(numberAdjNode > 0) {
				numberAdjNode--;
				//phát sinh đỉnh kề ngẫu nhiên
				int adjNodeId = random.nextInt(this.numberNode);
				if(adjNodeId == i || adjNodeId == 0) {
					adjNodeId = random.nextInt(this.numberNode);
				}
				// phát sinh trọng số ngẫu nhiên giữa các đỉnh ( từ 1 -> 50 )
				int weighted = random.nextInt(50) + 1;
				adjacentNodes.add(new AdjacentNode(adjNodeId, weighted));
			}
			
			// khởi tạo một node
			Node node = new Node(i, adjacentNodes);
			// thêm một node vào đồ thị
			listNodes.add(node);
		}
		try {
			// xuất đồ thị ra file
			writeRandomGraphToFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void findShortedPathByLinkState(String filename) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findShortedPathByDistanceVector(String filename) {
		// TODO Auto-generated method stub

	}

	private void writeRandomGraphToFile(String filename) throws IOException {
		
		System.out.println("random new a graph...");
		int size = this.numberNode;
		File file = new File(filename);
		FileWriter writer = new FileWriter(file);
		
		writer.write(size +"\n");
		
		int i, j;
		
		for(i = 0; i < size; i++) {
			// lấy ra một node trong đồ thị
			Node node = listNodes.get(i);
			// lấy danh sách đỉnh kề của một đỉnh vừa lấy ra
			ArrayList<AdjacentNode> listAdjNode = node.getAdjacentNodes();
			for(j = 0 ; j < size; j++) {	
				if(i == j) {
					writer.write(0+"\t");
					continue;
				}
				boolean hasWrite = false;
				for(AdjacentNode adjNode : listAdjNode) {
					
					if((j + 1) == adjNode.getId()) {
						writer.write(adjNode.getWeighted() + "\t");
						hasWrite = true;
						break;
					}
				}
				if(hasWrite == true)
					continue;
				writer.write("0\t");
			}
			
			writer.write("\n");
		}
		writer.close();
		System.out.println("a graph has been created!");
	}
	
	private void writeResultFile(String filename) {
		
	}

}
