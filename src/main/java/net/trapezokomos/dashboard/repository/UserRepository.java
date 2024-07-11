package net.trapezokomos.dashboard.repository;

import net.trapezokomos.dashboard.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);

    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);

//    @Query("select user from User user " +
//            "where lower(user.firstName) like lower(concat('%', :searchTerm, '%')) " +
//            "or lower(user.lastName) like lower(concat('%', :searchTerm, '%'))")
//    List<User> search(@Param("searchTerm") String searchTerm);
}
