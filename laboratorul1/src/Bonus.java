import java.util.LinkedList;
import java.util.Queue;

public class Bonus {
    private static int[][] adjMatrix;
    private static int[] visited;
    private static int componentsCount;
    private static String[][] components;

    private static String[] getComponentNodes(Optional obj, int node){
        Queue<Integer> queue = new LinkedList<>();
        String[] result = new String[obj.getNodeCount()];
        int nodesInComponent = 0;
        queue.add(node);
        visited[node] = 1;

        while(!queue.isEmpty()){
            int current = queue.remove();
            System.out.println(current);
            result[nodesInComponent++] = obj.getNodeName(node);
            for(int i = 0; i < obj.getNodeCount(); i++)
                if(adjMatrix[current][i] == 1 && visited[i] == 0){
                    queue.add(i);
                    visited[i] = 1;
                }
        }

        return result;
    }

    private static String[][] getConnectedComponents(Optional obj){
        visited = new int[obj.getNodeCount()];
        adjMatrix = obj.getAdjacencyMatrix();

        String[][] result = new String[obj.getNodeCount()][obj.getNodeCount()];

        for(int i = 0; i < obj.getNodeCount(); i++)
            if(visited[i] == 0)
                result[componentsCount++] = getComponentNodes(obj, i);
        return result;
    }

    private static void displayComponents(Optional obj){
        for(int i = 0; i < componentsCount; i++){
            System.out.println("Component " + (i+1) + " node names");
            for(int j = 0; j < obj.getNodeCount(); j++){
                if(components[i][j] != null)
                    System.out.println("\tNode : " + components[i][j]);
            }
        }
    }

    public static void bonus(Optional obj){
        components = getConnectedComponents(obj);
        if(componentsCount == 1){
            System.out.println("Graph is connected");
        }
        else {
            System.out.println("Graph is not connected");
        }
        displayComponents(obj);
    }
}
