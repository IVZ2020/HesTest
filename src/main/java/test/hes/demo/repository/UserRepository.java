package test.hes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.hes.demo.entity.UserAccount;

import java.text.DateFormat;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
}
