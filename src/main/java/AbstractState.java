/**
 * Created by maruf on 14/03/15.
 */
public abstract class AbstractState implements State {

    private State parent = null;

    private double distance = 0;

    private boolean isSolve = false;

    public AbstractState(State parent) {
        this.parent = parent;
        if (parent != null)
            this.distance = parent.getDistance() + 1;
    }

    public boolean isSolvable(){
        return this.isSolve;
    }

    public State getParent() {
        return parent;
    }

    public double getDistance() {
        return distance;
    }

}
