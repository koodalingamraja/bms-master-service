package com.budgetfriendly.bms.master.service.repository;


import com.budgetfriendly.bms.master.service.entity.MasterRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterRealtionshipRepository extends JpaRepository<MasterRelationship, Long> {

    Optional<MasterRelationship> findByIdAndStatusTrue(Long relationshipId);
}
