package net.trapezokomos.dashboard.repository;

import net.trapezokomos.dashboard.data.ReservationTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationTransactionRepository extends JpaRepository<ReservationTransaction, Long>, JpaSpecificationExecutor<ReservationTransaction>  {
}
