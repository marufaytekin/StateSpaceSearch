import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by maruf on 14/03/15.
 */
public abstract class AbstractSearch implements Search {

    private Set<State> visited = new HashSet();

    public List<State> search(State initialState) {
        //Reset visited and open lists
        visited.clear();
        clearOpen();
        addState(initialState);
        while (hasElements()) {
            State s = nextState();
            if (s.isSolution())
                return findPath(s);
            visited.add(s);
            Iterable<State> moves = s.getPossibleMoves();
            for (State move : moves) {
                if (!visited.contains(move))
                    addState(move);
            }
        }
        return null;
    }

    public int getVisitedStateCount() {
        return visited.size();
    }

    private List<State> findPath(State solution) {
        LinkedList<State> path = new LinkedList();
        while (solution != null) {
            path.addFirst(solution);
            solution = solution.getParent();
        }
        return path;
    }

    protected abstract boolean hasElements();

    protected abstract State nextState();

    protected abstract void addState(State s);

    protected abstract void clearOpen();

    protected abstract int getQueueSize();

}
