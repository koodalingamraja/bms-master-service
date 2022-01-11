package com.budgetfriendly.bms.master.service.repository;


import com.budgetfriendly.bms.master.service.entity.MasterRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterRoleRepository extends JpaRepository<MasterRole, Long> {

    Optional<MasterRole> findByIdAndStatusTrue(Long roleId);
}
