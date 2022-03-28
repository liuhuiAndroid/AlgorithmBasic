package class16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的拓扑排序算法
 * 1。在图中找到所有入度为0的点输出
 * 2。把所有入度为0的点在图中删掉，继续找入度为0的点输出，周而复始
 * 3。图的所有点都被删除后，一次输出都顺序就是拓扑排序
 * 要求：有向图且其中没有环
 * 应用：事件安排、编译顺序
 * 不能循环依赖：拓扑排序
 * 拓扑排序不唯一
 */
// OJ链接：https://www.lintcode.com/problem/topological-sorting
public class Code03_TopologicalOrderBFS {

    // 不要提交这个类，提交下面的
    public static class DirectedGraphNode {
        // value
        public int label;
        // 直接邻居，类似邻接表法
        public ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    /**
     * 拓扑排序
     */
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        for (DirectedGraphNode cur : graph) {
            indegreeMap.put(cur, 0);
        }
        for (DirectedGraphNode cur : graph) {
            for (DirectedGraphNode next : cur.neighbors) {
                indegreeMap.put(next, indegreeMap.get(next) + 1);
            }
        }
        Queue<DirectedGraphNode> zeroQueue = new LinkedList<>();
        for (DirectedGraphNode cur : indegreeMap.keySet()) {
            if (indegreeMap.get(cur) == 0) {
                zeroQueue.add(cur);
            }
        }
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        while (!zeroQueue.isEmpty()) {
            DirectedGraphNode cur = zeroQueue.poll();
            ans.add(cur);
            for (DirectedGraphNode next : cur.neighbors) {
                indegreeMap.put(next, indegreeMap.get(next) - 1);
                if (indegreeMap.get(next) == 0) {
                    zeroQueue.offer(next);
                }
            }
        }
        return ans;
    }

}
