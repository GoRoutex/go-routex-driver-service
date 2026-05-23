package vn.com.routex.driver.service.infrastructure.persistence.jpa.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.routex.driver.service.domain.user.model.UserStatus;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.user.entity.UserEntity;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findById(String id);

    Optional<UserEntity> findByEmail(String email);

    Page<UserEntity> findByStatusNot(UserStatus status, Pageable pageable);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByPhoneNumberAndIdNot(String phoneNumber, String id);

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, String id);
}
