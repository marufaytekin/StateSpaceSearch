import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by maruf on 15/03/15.
 */
public class Main {

    static List<int[][]> data = new ArrayList();

    public static void main(String[] args) throws IOException {

        data.add(new int[][]{{0, 1, 3},{4, 2, 5},{7, 8, 6}});
        data.add(new int[][]{{0, 1, 3},{5, 4, 2},{7, 8, 6}});
        data.add(new int[][]{{1, 2, 7},{0, 4, 3},{6, 5, 8}});
        data.add(new int[][]{{3, 1, 0},{5, 2, 4},{7, 8, 6}});
        data.add(new int[][]{{4, 1, 3},{0, 2, 6},{7, 5, 8}});
        data.add(new int[][]{{1, 2, 3},{0, 7, 6},{5, 4, 8}});
        data.add(new int[][]{{2, 3, 5},{1, 0, 4},{7, 8, 6}});
        data.add(new int[][]{{1, 0, 2},{7, 5, 4},{8, 6, 3}});
        data.add(new int[][]{{5, 6, 2},{1, 8, 4},{7, 3, 0}});
        data.add(new int[][]{{5, 1, 8},{2, 7, 3},{4, 0, 6}});

        AbstractSearch solver;
        solver = new AStarSearch();
        solve(solver);
        //solver = new DepthFirstSolver();
        //search(solver, initial);
        solver = new DepthLimitedSearch();
        solve(solver);
        solver = new BreadthFirstSearch();
        solve(solver);
        solver = new UniformCostSearch();
        solve(solver);

        IterativeDeepeningSearch idSolver = new IterativeDeepeningSearch();

        /*List<State> path = idSolver.search(initial);
        if (path == null) {
            System.out.println("--------------------");
            System.out.println(idSolver.getClass().getName() + ": Goal not found !!!");
            System.out.println("--------------------");
        } else {
            //drawPath(path);
            System.out.println("--------------------");
            System.out.println(idSolver.getClass().getName());
            System.out.println("The Nodes in Memory: " + idSolver.getQueueSize());
            System.out.println("The cost was: " +
                    path.get(path.size() - 1).getDistance());
            System.out.println("visited nodes = " + idSolver.getVisitedStateCount());
        }*/
        solver = new GreedyBFSearch();
        solve(solver);

    }

    private static void solve(AbstractSearch solver)
    {
        System.out.println("=================================");
        int totalNodesInMemory = 0;
        int totalCost = 0;
        int totalVisitedNodes = 0;
        int cnt = 0;
        for (int i=0; i<10; i++) {
            PuzzleState initial = new PuzzleState(null, data.get(i));
            List<State> path = solver.search(initial);
            System.out.println("");
            System.out.println("Start State:" + initial.toString());
            if (path == null) {
                //System.out.println("--------------------");
                System.out.println(solver.getClass().getName() + ": Goal not found !!!");
            } else {
                //drawPath(path);
                System.out.println("The Nodes in Memory: " + solver.getQueueSize());
                System.out.println("The cost was: " +
                        path.get(path.size() - 1).getDistance());
                System.out.println("visited nodes = " + solver.getVisitedStateCount());
                totalNodesInMemory +=  solver.getQueueSize();
                totalCost += path.get(path.size() - 1).getDistance();
                totalVisitedNodes += solver.getVisitedStateCount();
                cnt++;
            }
        }

        System.out.println(solver.getClass().getName());
        System.out.println("Avg Nodes in Memory: " + (double)totalNodesInMemory / cnt);
        System.out.println("Avg cost was: " +  (double)totalCost / cnt);
        System.out.println("Avg visited nodes: " + (double) totalVisitedNodes / cnt);
        System.out.println("=================================");


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
