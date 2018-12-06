package logger.dao;

import java.util.ArrayList;

import logger.beans.Income;

public interface IncomeServiceTemplate {

	Income storeIncome(Income income);
	ArrayList<Income> viewAllIncome();
	ArrayList<Income> viewIncomeByCustomer(int customerId);
	ArrayList<Income> viewIncomeByCompany(int companyId);
}
