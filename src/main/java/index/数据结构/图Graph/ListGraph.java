package index.数据结构.图Graph;

/**
 * 邻接表的表示法
 */
public class ListGraph {

    /**
     * 图的顶点数组，每个元素为链表头结点
     */
    private ListGraphNode[] nodes;

    public ListGraph(int[] vertexes) {
        nodes = new ListGraphNode[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            nodes[i] = new ListGraphNode(vertexes[i], null);
        }
    }

    public void addEdges(int start, int[] end) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].value == start) {
                ListGraphNode node = nodes[i];
                for (int j = 0; j < end.length; j++) {
                    node.next = new ListGraphNode(end[j], null);
                    node = node.next;
                }
            }
        }
    }

    public void printListGraph() {
        for (int i = 0; i < nodes.length; i++) {
            ListGraphNode node = nodes[i];
            do {
                System.out.print(node.value);
                System.out.print(" ");
                node = node.next;
            } while (node != null);
            System.out.println();
        }
    }
}
