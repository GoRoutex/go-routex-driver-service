package vn.com.routex.driver.service.infrastructure.persistence.adapter.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.user.model.User;
import vn.com.routex.driver.service.domain.user.port.UserRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.user.mapper.UserPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.user.repository.UserEntityRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserEntityRepository userEntityRepository;

    @Override
    public Optional<User> findById(String id) {
        return userEntityRepository.findById(id).map(UserPersistenceMapper::toDomain);
    }

    @Override
    public User save(User user) {
        return UserPersistenceMapper.toDomain(userEntityRepository.save(UserPersistenceMapper.toEntity(user)));
    }
}
