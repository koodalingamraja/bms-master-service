package com.budgetfriendly.bms.master.service.repository;

import com.budgetfriendly.bms.master.service.entity.MasterExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterExpenseCategoryRepository extends JpaRepository<MasterExpenseCategory, Long> {
}
