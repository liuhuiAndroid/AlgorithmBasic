package class16;

import java.util.ArrayList;

/**
 * 点结构的描述
 */
public class Node {
	// 自己的值
	public int value;
	// 多少个点指向自己
	public int in;
	// 指向别人
	public int out;
	// 邻居
	public ArrayList<Node> nexts;
	// 从他出发有几个直接的边
	public ArrayList<Edge> edges;

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
