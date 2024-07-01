package net.trapezokomos.dashboard.repository;

import net.trapezokomos.dashboard.data.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long>, JpaSpecificationExecutor<Consumer> {
    boolean existsByEmail(String email);
}
