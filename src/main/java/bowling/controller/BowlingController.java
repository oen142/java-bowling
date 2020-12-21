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


        while (!bowlingGames.isBowlingGameEnd()) {
            Point pointPitch = InputView.inputPitchBowl(bowlingGames.getPlayerName());
            bowlingGames.pitch(pointPitch);
            OutputView.printResult(bowlingGames);

        }
    }


}
