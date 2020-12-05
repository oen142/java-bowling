package step1.qna.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    public User JAVAJIGI;
    public User SANJIGI;

    @BeforeEach
    void setUp() {
        JAVAJIGI = new User.UserBuilder()
                .buildUserId("javajigi")
                .buildPassWord("password")
                .buildName("name")
                .buildEmail("javajigi@slipp.net")
                .build();
        SANJIGI = new User.UserBuilder()
                .buildUserId("sanjigi")
                .buildPassWord("password")
                .buildName("name")
                .buildEmail("sanjigi@slipp.net")
                .build();
    }

    @Test
    @DisplayName("유저가 잘 생성되는지 확인한다.")
    void create() {
        //given
        User javaJigi = new User.UserBuilder()
                .buildUserId("javajigi")
                .buildPassWord("password")
                .buildName("name")
                .buildEmail("javajigi@slipp.net")
                .build();
        //then
        assertThat(JAVAJIGI).isEqualTo(javaJigi);

    }
}
