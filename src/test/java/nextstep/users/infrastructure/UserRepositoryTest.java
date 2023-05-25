package nextstep.users.infrastructure;

import nextstep.users.domain.NsUser;
import nextstep.users.domain.UserRepository;
import nextstep.users.infrastructure.dao.NsUserEntityRepository;
import nextstep.users.infrastructure.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
public class UserRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);


    @Autowired
    private JdbcOperations jdbcOperations;

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl(new NsUserEntityRepository(jdbcOperations));
    }

    @Test
    void findByUserId() {
        NsUser nsUser = userRepository.findByUserId("javajigi");
        assertThat(nsUser).isNotNull();
        LOGGER.debug("NsUser: {}", nsUser);
    }
}
