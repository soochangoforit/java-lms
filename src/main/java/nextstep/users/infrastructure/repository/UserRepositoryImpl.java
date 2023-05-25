package nextstep.users.infrastructure.repository;

import nextstep.users.domain.NsUser;
import nextstep.users.domain.UserRepository;
import nextstep.users.infrastructure.dao.NsUserEntityRepository;
import nextstep.users.infrastructure.entity.NsUserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * root Domain의 Repository 느낌
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    private final NsUserEntityRepository nsUserEntityRepository;

    public UserRepositoryImpl(NsUserEntityRepository nsUserEntityRepository) {
        this.nsUserEntityRepository = nsUserEntityRepository;
    }

    @Override
    public NsUser findByUserId(String userId) {
        Optional<NsUserEntity> nsUserEntity = nsUserEntityRepository.findByUserId(userId);
        return nsUserEntity.map(NsUserEntity::toDomain).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }

}
