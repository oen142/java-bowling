package bowling.domain.game;

public class BowlingGamesCursor {
    private int peopleCursor;
    private int frameNumberCursor;

    private BowlingGamesCursor() {
        this.peopleCursor = 0;
        this.frameNumberCursor = 0;
    }

    public static BowlingGamesCursor of() {
        return new BowlingGamesCursor();
    }

    public int increasePeopleCursor() {
        return this.peopleCursor++;
    }

    public int increaseFrameNumberCursor() {
        return this.frameNumberCursor++;
    }

    public void resetPeopleCursor() {
        this.peopleCursor = 0;
    }

    public int getPeopleCursor() {
        return peopleCursor;
    }

    public int getFrameNumberCursor() {
        return frameNumberCursor;
    }
}
