package class16;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 宽度优先遍历：可以使用优先队列
 * 所有的图都可以认为是有向图
 * 图的表示方法很多：邻接表法、邻接矩阵法、数组表示法等等
 * 熟悉一种图结构，然后把题目的图转换一下
 */
public class Code01_BFS {

    /**
     * 从node出发，进行宽度优先遍历
     */
    public static void bfs(Node start) {
        if (start == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        // 防止回路
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

}
