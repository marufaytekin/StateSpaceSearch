import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by maruf on 14/03/15.
 */
public abstract class AbstractSolver implements Solver {

    private Set<State> visited = new HashSet();

    public List<State> solve(State initialState) {
        //Reset visited and open lists
        visited.clear();
        clearOpen();
        addState(initialState);
        while (hasElements()) {
            State s = nextState();
            //System.out.println(s.toString());
            if (s.isSolution())
                return findPath(s);
            visited.add(s);
            Iterable<State> moves = s.getPossibleMoves();
            for (State move : moves) {
                //System.out.println(move.toString());
                if (!visited.contains(move))
                    addState(move);
            }
            //System.out.print("visited nodes = " + visited.size());
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

}
