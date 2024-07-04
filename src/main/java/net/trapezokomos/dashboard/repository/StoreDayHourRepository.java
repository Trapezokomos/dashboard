package net.trapezokomos.dashboard.repository;

import net.trapezokomos.dashboard.data.StoreDayHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDayHourRepository extends JpaRepository<StoreDayHour, Long>, JpaSpecificationExecutor<StoreDayHour> {


}
