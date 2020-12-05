package step1.qna.domain;

import org.hibernate.annotations.Where;
import step1.qna.exception.CannotDeleteException;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Answers {

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @Where(clause = "deleted = false")
    @OrderBy("id ASC")
    private final List<Answer> answers = new ArrayList<>();

    public void validDelete(User loginUser) throws CannotDeleteException {
        boolean isMatchOwner = answers.stream()
                .anyMatch(answer -> !answer.isOwner(loginUser));
        if (isMatchOwner) {
        }

    }

}
