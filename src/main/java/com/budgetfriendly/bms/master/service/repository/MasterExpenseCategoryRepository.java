package com.budgetfriendly.bms.master.service.repository;

import com.budgetfriendly.bms.master.service.entity.MasterExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterExpenseCategoryRepository extends JpaRepository<MasterExpenseCategory, Long> {

    Optional<MasterExpenseCategory> findByIdAndStatusTrue(Long categoryId);
}
