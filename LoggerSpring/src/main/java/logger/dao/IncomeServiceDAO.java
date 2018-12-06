package logger.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import logger.beans.Income;

@Repository
public class IncomeServiceDAO implements IncomeServiceTemplate {
	
	@Autowired
	private IncomeRepository incomeRepository;

	@SuppressWarnings("deprecation")
	@Override
	public Income storeIncome(Income income) {
		income.setId(0);
		int day = LocalDate.now().getDayOfMonth();
		int month = LocalDate.now().getMonthValue()-1;
		int year = Year.now().getValue()-1900;
		income.setDate(new Date (year, month, day));
		System.out.println(income);
		incomeRepository.save(income);
		return income;
	}

	@Override
	public ArrayList<Income> viewAllIncome() {
		return (ArrayList<Income>)incomeRepository.findAll();
	}

	@Override
	public ArrayList<Income> viewIncomeByCustomer(int customerId) {	
		return (ArrayList<Income>)incomeRepository.findIncomeByCustomerId(customerId);
	}

	@Override
	public ArrayList<Income> viewIncomeByCompany(int companyId) {
		return (ArrayList<Income>)incomeRepository.findIncomeByCompanyId(companyId);
	}
	


	
	
}
