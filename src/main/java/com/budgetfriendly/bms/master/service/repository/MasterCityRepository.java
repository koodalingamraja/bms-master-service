package com.budgetfriendly.bms.master.service.repository;


import com.budgetfriendly.bms.master.service.entity.MasterCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterCityRepository extends JpaRepository<MasterCity, Long> {

    Optional<MasterCity> findByIdAndStatusTrue(Long id);
}
