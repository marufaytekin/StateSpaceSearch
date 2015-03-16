import java.util.List;

/**
 * Created by maruf on 15/03/15.
 */

public class IterativeDeepeningSolver {
    private int depth = 0;
    private int maxDepth = 100;
    private boolean goalFound = false;
    private DepthLimitedSolver dlSolver = new DepthLimitedSolver();

    public List<State> solve(State initialState) {
        while (!goalFound) {
            List<State> path = dlSolver.solve(initialState, depth);
            if (path != null || depth == maxDepth)
                return path;
            else
                depth++;
        }
        return null;
    }

    public int getVisitedStateCount() {
        return dlSolver.getVisitedStateCount();
    }

}

