package index.数据结构.图Graph;

import org.junit.Before;
import org.junit.Test;

public class ListGraphTest {

    ListGraph graph;

    @Before
    public void setup() {
        int[] vertexes = {1, 2, 3, 4};
        graph = new ListGraph(vertexes);
        graph.addEdges(1,new int[]{2,3,4});
        graph.addEdges(2,new int[]{3});
        graph.addEdges(4,new int[]{3});

    }

    @Test
    public void main() {
        graph.printListGraph();
    }

}
