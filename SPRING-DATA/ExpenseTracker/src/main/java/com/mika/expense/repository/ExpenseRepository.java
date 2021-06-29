package com.mika.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mika.expense.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
	
}