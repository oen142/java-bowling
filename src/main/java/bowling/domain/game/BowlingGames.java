package bowling.domain.game;

import java.util.List;

public class BowlingGames {

    private final List<Bowling> bowlings;


    private BowlingGames(List<Bowling> bowlings) {
        this.bowlings = bowlings;
    }

    public static BowlingGames of(List<Bowling> bowlings) {
        return new BowlingGames(bowlings);
    }

    public boolean isFrameTurnOver(int participationPeopleIndex, int frameIndex) {
        return bowlings.get(participationPeopleIndex)
                .isFrameFinished(frameIndex);
    }

    public boolean isBowlingGameEnd() {
        return bowlings.stream()
                .allMatch(Bowling::isGameFinished);
    }

    public int getParticipationPeopleCount() {
        return bowlings.size();
    }

    public Bowling getBowling(int index) {
        return bowlings.get(index);
    }
}
