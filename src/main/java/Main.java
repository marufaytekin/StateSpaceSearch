import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by maruf on 15/03/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        int [][] tiles0 = new int[][]{{1, 6, 4},{7, 0, 8},{2, 3, 5}};
        int [][] tiles1 = new int[][]{{5, 2, 3},{4, 7, 0},{8, 6, 1}};
        int [][] tiles2 = new int[][]{{4, 8, 2},{3, 6, 5},{1, 7, 0}};
        int [][] tiles3 = new int[][]{{5, 0, 4},{2, 3, 8},{7, 1, 6}};
        int [][] tiles4 = new int[][]{{5, 7, 4},{3, 0, 8},{1, 6, 2}};
        int [][] tiles5 = new int[][]{{2, 8, 5},{3, 6, 1},{7, 0, 4}};
        int [][] tiles6 = new int[][]{{5, 7, 0},{3, 2, 8},{1, 6, 4}};
        int [][] tiles7 = new int[][]{{5, 8, 7},{1, 4, 6},{3, 0, 2}};
        int [][] tiles8 = new int[][]{{7, 8, 5},{4, 0, 2},{3, 6, 1}};
        int [][] tiles9 = new int[][]{{6, 0, 5},{8, 7, 4},{3, 2, 1}};


        PuzzleState initial = new PuzzleState(null, tiles1);
        //AStarSolver solver = new AStarSolver();
        //DepthFirstSolver solver = new DepthFirstSolver();
        DepthLimitedSolver solver = new DepthLimitedSolver();
        //BreadthFirstSolver solver = new BreadthFirstSolver();
        //IterativeDeepeningSolver solver = new IterativeDeepeningSolver();
        //UniformCostSolver solver = new UniformCostSolver();
        //GreedySolver solver = new GreedySolver();
        List<State> path = solver.solve(initial);
        if (path == null) {
            System.out.println(solver.getClass().getName() + ": Goal not found !\n");
        } else {
            drawPath(path);
            System.out.print(solver.getClass().getName() + ": \n");
            System.out.print("The Nodes in Memory: " + solver.getQueueSize() + "\n");
            System.out.print("The cost was: " +
                    path.get(path.size() - 1).getDistance() + "\n");
            System.out.print("visited nodes = " + solver.getVisitedStateCount());
        }
    }

    private static void drawPath(List<State> path) {
        Iterator<State> iter = path.iterator();
        while (iter.hasNext()) {
            PuzzleState neighbor = (PuzzleState) iter.next();
            System.out.print(neighbor.toString());
            System.out.print("dist = ");
            System.out.print(neighbor.manhattan());
        }
        System.out.print("\n");
    }

}
