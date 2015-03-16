import java.util.Iterator;
import java.util.List;

/**
 * Created by maruf on 15/03/15.
 */
public class Main {
    public static void main(String[] args) {
        //0 1 2 3 4 5 6 7 8

        int[][] initial = new int[][]{{1, 2, 3}, {4, 5, 0}, {7, 6, 8}};
        PuzzleState initialState = new PuzzleState(null, initial);
        //AStarSolver solver = new AStarSolver();
        //DepthFirstSolver solver = new DepthFirstSolver();
        //DepthLimitedSolver solver = new DepthLimitedSolver();
        //BreadthFirstSolver solver = new BreadthFirstSolver();
        //IterativeDeepeningSolver solver = new IterativeDeepeningSolver();
        //UniformCostSolver solver = new UniformCostSolver();
        GreedyBFSolver solver = new GreedyBFSolver();
        List<State> path = solver.solve(initialState);
        if (path == null) {
            System.out.println(solver.getClass().getName() + ": Goal not found !\n");
        } else {
            drawPath(path);
            System.out.print(solver.getClass().getName() + ": \n");
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
