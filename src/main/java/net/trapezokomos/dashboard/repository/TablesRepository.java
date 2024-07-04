package net.trapezokomos.dashboard.repository;

import net.trapezokomos.dashboard.data.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TablesRepository extends JpaRepository<Tables, Long>, JpaSpecificationExecutor<Tables> {
    boolean existsByName(String name);
}
