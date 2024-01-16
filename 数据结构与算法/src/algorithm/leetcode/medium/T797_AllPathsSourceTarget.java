package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/12/7 17:17 星期四
 * @title 所有可能的路径
 */
public class T797_AllPathsSourceTarget {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //始终从0开始，所以总是需要把节点0加入
        path.add(0);
        dfs(graph,0);
        return results;
    }
    //深度搜索，第一个参数是要遍历的图，第二参数是当前节点编号
    public void dfs(int[][] graph, int n){
        //如果遍历到最后一个节点，则停止遍历
        if(n == graph.length - 1){
            //达到目标节点，保存此条路径并结束搜索
            results.add(new ArrayList<>(path));
            return;
        }
        //遍历当前节点所有关联的节点
        for(int i=0; i<graph[n].length; i++){
            //将当前节点保存在本次搜索路径中
            path.add(graph[n][i]);
            //继续遍历与当前节点关联的节点
            dfs(graph,graph[n][i]);
            //回溯(ArrayList的remove()方法传入整数会被作为下标，使用path.size()-1可以严格控制删除最后一个元素)
            path.remove(path.size()-1);
        }
    }
}
