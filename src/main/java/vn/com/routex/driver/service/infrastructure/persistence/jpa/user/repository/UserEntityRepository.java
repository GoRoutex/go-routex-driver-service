package vn.com.routex.driver.service.infrastructure.persistence.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.user.entity.UserEntityAbstract;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntityAbstract, String> {
}
