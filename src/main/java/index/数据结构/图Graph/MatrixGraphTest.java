package index.数据结构.图Graph;

import org.junit.Before;
import org.junit.Test;

public class MatrixGraphTest {

    MatrixGraph graph;

    @Before
    public void setup() {
        int[] vertexes = {1, 2, 3, 4};
        graph = new MatrixGraph(vertexes);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);

    }

    @Test
    public void main() {
        graph.printMatrix();
    }

    @Test
    public void dfs(){
        graph.depthFirstTravel();
    }

    @Test
    public void bfs(){
        graph.breadthFirstTravel();
    }
}
