package logger.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import logger.beans.Income;
import logger.dao.IncomeServiceDAO;
import logger.beans.Error;

@RestController
@RequestMapping("income")
public class IncomeController {
	
	@Autowired
	private IncomeServiceDAO incomeDAO;
	
	@PostMapping
	public ResponseEntity<?> storeIncome(@RequestBody Income income){
		try {
			incomeDAO.storeIncome(income);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>(Error.getServerError(ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> viewAllIncome(){
		try {
			return new ResponseEntity<>(incomeDAO.viewAllIncome(),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(Error.getServerError(ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("number")
	public ResponseEntity<?> viewAllIncomeNumber(){
		
		ArrayList<Income> incomes = new ArrayList<>();
		double sum = 0;
		try {
			incomes = incomeDAO.viewAllIncome();
			for (Income income : incomes) {
				sum += income.getAmount();
			}
			
			return new ResponseEntity<>(sum,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(Error.getServerError(ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("number/customerId/{customerId}")
	public ResponseEntity<?> viewIncomeByCustomerNumber(@PathVariable("customerId") int customerId){
		ArrayList<Income> incomes = new ArrayList<>();
		double sum = 0;		
		try {
			incomes = incomeDAO.viewIncomeByCustomer(customerId);
			for (Income income : incomes) {
				if(income.getDescription().toString() == "CUSTOMER_BUY_COUPON") {
					sum += income.getAmount();
				}
			}							
			return new ResponseEntity<>(sum,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(Error.getServerError(ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("customerId/{customerId}")
	public ResponseEntity<?> viewIncomeByCustomer(@PathVariable("customerId") int customerId){		
		try {
			
			return new ResponseEntity<>(incomeDAO.viewIncomeByCustomer(customerId),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(Error.getServerError(ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("companyId/{companyId}")
	public ResponseEntity<?> viewIncomeByCompany(@PathVariable("companyId") int companyId){
	
		try {	
			return new ResponseEntity<>(incomeDAO.viewIncomeByCompany(companyId),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(Error.getServerError(ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("number/companyId/{companyId}")
	public ResponseEntity<?> viewIncomeByCompanyNumber(@PathVariable("companyId") int companyId){
		ArrayList<Income> incomes = new ArrayList<>();
		double sum = 0;
		
		try {
			incomes = incomeDAO.viewIncomeByCompany(companyId);
			for (Income income : incomes) {
					sum += income.getAmount();				
			}
			return new ResponseEntity<>(sum,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(Error.getServerError(ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
