
public class MainProgram {

	public static void main(String[] args) {
		// 51403242 -> 2 + 4 + 2 + 10 = 18
		Graph graph = new GraphImpl(18);
		// input1-MSSV-HoTen.txt
		graph.randomGraph("input1-51403242-TaQuocThao.txt");
		//tìm đường đi có chi phí thấp nhất với link state
		//graph.findShortedPathByLinkState("input1-51403242-TaQuocThao.txt");
		
		// phát sinh đồ thị mới có N đỉnh sau 60s
		
		try {
			System.out.println("Wait 60s for create new graph");
			System.out.println("waiting...");
			Thread.sleep(60*1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
