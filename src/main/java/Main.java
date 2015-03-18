import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by maruf on 15/03/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        List<int[][]> data = new ArrayList();
        data.add(new int[][]{{0, 1, 3},{4, 2, 5},{7, 8, 6}});
        data.add(new int[][]{{1, 0, 3},{4, 2, 5},{7, 8, 6}});
        data.add(new int[][]{{1, 2, 3},{4, 0, 5},{7, 8, 6}});
        data.add(new int[][]{{1, 2, 3},{0, 4, 5},{7, 8, 6}});
        data.add(new int[][]{{1, 3, 0},{4, 2, 5},{7, 8, 6}});
        data.add(new int[][]{{4, 1, 3},{0, 2, 6},{7, 5, 8}});
        data.add(new int[][]{{1, 2, 3},{0, 7, 6},{5, 4, 8}});
        data.add(new int[][]{{2, 3, 5},{1, 0, 4},{7, 8, 6}});
        data.add(new int[][]{{2, 3, 5},{1, 4, 0},{7, 8, 6}});
        data.add(new int[][]{{2, 3, 5},{1, 0, 4},{7, 8, 6}});

        drawDataSet(data);
        AbstractSearch solver;
        solver = new AStarSearch();
        solve(solver, data);
        //solver = new DepthFirstSearch();
        //solve(solver, data );
        solver = new DepthLimitedSearch();
        solve(solver, data);
        solver = new BreadthFirstSearch();
        solve(solver, data);
        solver = new UniformCostSearch();
        solve(solver, data);
        solver = new GreedyBFSearch();
        solve(solver, data);
        solver = new IterativeDeepeningSearch();
        solve(solver, data);

    }

    private static void solve(AbstractSearch solver, List<int[][]> data)
    {
        List<Integer> nodesInMemory = new ArrayList() ;
        List <Double> cost = new ArrayList() ;
        List <Integer> visitedNodes = new ArrayList() ;
        for (int i=0; i<10; i++) {
            PuzzleState initial = new PuzzleState(null, data.get(i));
            List<State> path = solver.search(initial);
            if (path == null) {
                System.out.println("--------------------");
                System.out.println(solver.getClass().getName() + ": Goal not found !!!");
                System.out.println("--------------------");
            } else {
                //drawPath(path);
                nodesInMemory.add(solver.getQueueSize());
                cost.add(path.get(path.size() - 1).getDistance());
                visitedNodes.add(solver.getVisitedStateCount());
            }
        }

        System.out.println("--------------------");
        System.out.println(solver.getClass().getName());
        System.out.println("Nodes Expanded  : " + visitedNodes.toString() + "  |  ~" + avg(visitedNodes));
        System.out.println("Nodes in Memory : " + nodesInMemory.toString()+ "  |  ~" + avg(nodesInMemory));

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

    private static double avg(List<Integer> list) {
        int total = 0;
        for(int x : list ){
            total += x;
        }
        return (double)total / list.size();
    }

    private static void drawDataSet(List<int[][]> data ) {
        for(int[][] puzzle : data ){
            PuzzleState state = new PuzzleState(null, puzzle);
            System.out.println(state.toString());
        }
    }

}
