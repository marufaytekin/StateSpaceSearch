import java.util.List;

/**
 * Created by maruf on 15/03/15.
 */

public class IterativeDeepeningSearch extends AbstractSearch{
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

    @Override
    protected boolean hasElements() {
        return dlSolver.hasElements();
    }

    @Override
    protected State nextState() {
        return dlSolver.nextState();
    }

    @Override
    protected void addState(State s) {
        dlSolver.addState(s);

    }

    @Override
    protected void clearOpen() {
        dlSolver.clearOpen();
    }

    public int getQueueSize() {
        return dlSolver.getQueueSize();
    }

}

