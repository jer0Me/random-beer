package com.jerome.random.beer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {

    @Query(
            value = "SELECT count(*) FROM Beer",
            nativeQuery = true
    )
    Long countAll();
}
