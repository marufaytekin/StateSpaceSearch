import java.util.List;

/**
 * Created by maruf on 15/03/15.
 */

public class IterativeDeepeningSearch {
    private int depth = 0;
    private int maxDepth = 30;
    private boolean goalFound = false;
    private DepthLimitedSearch dlSolver = new DepthLimitedSearch();

    public List<State> search(State initialState) {
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

    public int getQueueSize() {
        return dlSolver.getQueueSize();
    }

}

