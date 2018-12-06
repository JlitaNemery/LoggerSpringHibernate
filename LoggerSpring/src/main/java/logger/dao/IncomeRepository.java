package logger.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import logger.beans.Income;

public interface IncomeRepository extends CrudRepository<Income, Integer> {
	
	@Query("select i from Income i where i.customerId= ?1 and i.companyId=0")
	ArrayList<Income> findIncomeByCustomerId(int customerId);
	
	@Query("select i from Income i where i.companyId= ?1 and i.customerId=0")
	ArrayList<Income> findIncomeByCompanyId(int companyId);

	
}
