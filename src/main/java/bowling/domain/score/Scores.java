package bowling.domain.score;

import bowling.domain.dto.ScoreResultDto;
import bowling.utils.ElementFindUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Scores {
    private final static int FIRST_SCORE = 1;
    private final static int SECOND_SCORE = 2;
    private final static int THIRD_SCORE = 3;

    private final List<Score> scores;

    public Scores() {
        this.scores = new ArrayList<>();
    }

    public void addScore(int point) {
        scores.add(createScore(point));
    }

    private Score createScore(int point) {
        if (CollectionUtils.isEmpty(scores)) {
            return ScoreFactory.generateScore(point);
        }

        return ElementFindUtils.findFirstElement(scores).nextScore(point);
    }

    public int totalScore() {
        return scores.stream()
                .mapToInt(Score::getPoint)
                .sum();
    }

    private boolean firstScore() {
        return scores.size() == FIRST_SCORE;
    }

    private boolean secondScore() {
        return scores.size() == SECOND_SCORE;
    }

    private boolean thirdScore() {
        return scores.size() == THIRD_SCORE;
    }

    public boolean isStrike() {
        if (CollectionUtils.isEmpty(scores)) {
            return false;
        }
        return ElementFindUtils.findFirstElement(scores).isStrike();
    }

    public boolean isSpare() {
        if (secondScore() || thirdScore()) {
            return ElementFindUtils.findLastElement(scores).isSpare();
        }
        return false;
    }

    public List<ScoreResultDto> convertSoreResultDtos() {
        return scores.stream()
                .map(ScoreResultDto::new)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public boolean isAvailableAdd() {
        if (CollectionUtils.isEmpty(scores)) {
            return true;
        }

        if (isStrike() || isSpare()) {
            return false;
        }

        return firstScore();
    }
}
