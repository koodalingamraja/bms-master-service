package com.budgetfriendly.bms.master.service.repository;


import com.budgetfriendly.bms.master.service.entity.MasterRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRoleRepository extends JpaRepository<MasterRole, Long> {
}
