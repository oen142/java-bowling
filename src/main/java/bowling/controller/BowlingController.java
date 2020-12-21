package bowling.controller;

import bowling.domain.Player;
import bowling.domain.frame.Frames;
import bowling.domain.game.Bowling;
import bowling.domain.game.BowlingGames;
import bowling.domain.point.Point;
import bowling.view.InputView;
import bowling.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BowlingController {

    public static void runBowlingGame() {
        int peopleCount = InputView.inputParticipatePeople();

        List<Bowling> bowlings = new ArrayList<>();
        for (int i = 0; i < peopleCount; i++) {
            Player player = InputView.inputPlayerName();
            Bowling bowling = Bowling.of(player, Frames.init());
            bowlings.add(bowling);
        }
        BowlingGames bowlingGames = BowlingGames.of(bowlings);


        int frameNumber = 0;
        int peopleIndex = 0;
        Bowling bowling = bowlingGames.getBowling(peopleIndex);
        while (!bowlingGames.isBowlingGameEnd()) {

            Point pointPitch = InputView.inputPitchBowl(bowling.getPlayerName());
            bowling.pitch(pointPitch);
            OutputView.printResult(bowlingGames);

            if (bowling.isFrameFinished(frameNumber)) {
                peopleIndex++;
                if (bowlingGames.getParticipationPeopleCount() == peopleIndex) {
                    peopleIndex = 0;
                }
                bowling = bowlingGames.getBowling(peopleIndex);
                continue;
            }
            frameNumber++;

        }
    }


}
