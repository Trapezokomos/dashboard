package net.trapezokomos.dashboard.repository;

import net.trapezokomos.dashboard.data.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingDetailsRepository extends JpaRepository<BillingDetails, Long>, JpaSpecificationExecutor<BillingDetails> {

}
