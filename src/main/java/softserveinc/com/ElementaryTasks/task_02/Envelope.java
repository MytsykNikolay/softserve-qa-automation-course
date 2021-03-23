package softserveinc.com.ElementaryTasks.task_02;

public class Envelope implements Comparable<Envelope> {

    private final double verticalSide; // Size of  vertical envelope side
    private final double horizontalSide; // Size of horizontal envelope side

    private Envelope(double verticalSide, double horizontalSide) {
        this.verticalSide = verticalSide;
        this.horizontalSide = horizontalSide;
    }

    //if user tries to create envelope with sides <= 0
    public static Envelope createEnvelope(double verticalSide, double horizontalSide) throws IllegalArgumentException {
        if (verticalSide <= 0 || horizontalSide <= 0) {
            throw new IllegalArgumentException("Envelope cannot consist of negative or zero attributes");
        }
        return new Envelope(verticalSide, horizontalSide);
    }

    //if result < 0 then calling envelope can be fitted into envelope from parameters, else if - cannot.
    public boolean isFitInto(Envelope envelope) {
        return this.compareTo(envelope) < 0;
    }

    //Method to compare two Envelope objects
    //Return 0 if envelopes equal to each other or they cannot fit into each other
    //Return 1 if envelop that calls method is bigger than the one from parameter
    //Return -1 if it's smaller
    @Override
    public int compareTo(Envelope o) {
        if ((horizontalSide > o.horizontalSide && verticalSide > o.verticalSide)
                || (horizontalSide > o.verticalSide && verticalSide > o.horizontalSide)) {
            return 1;
        } else if ((horizontalSide < o.horizontalSide && verticalSide < o.verticalSide)
                || (horizontalSide < o.verticalSide && verticalSide < o.horizontalSide)) {
            return -1;
        }
        return 0;
    }
}
