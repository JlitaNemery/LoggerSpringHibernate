package logger.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "Income")
public class Income {
	
	private int id;
	private String name;
	private Date date;
	private IncomeType description;
	private double amount;
	private int customerId;
	private int companyId;
	
	public Income() {}

	public Income(String name, Date date, IncomeType description, 
			double amount, int customerId, int companyId){
		setName(name);
		setDate(date);
		setDescription(description);
		setAmount(amount);
		setCustomerId(customerId);
		setCompanyId(companyId);
	}
	
	public Income(int id, String name, Date date, IncomeType description, 
			double amount, int customerId, int companyId){
		this(name, date, description, amount, customerId, companyId);
		setId(id);
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(nullable = false)
	public IncomeType getDescription() {
		return description;
	}

	public void setDescription(IncomeType description) {
		this.description = description;
	}

	@Column(nullable = false)
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Column(nullable = false)
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(nullable = false)
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String toString() {
		return "Income [id=" + id + ", name=" + name + ", date=" + date + ", "
				+ "description=" + description + ", amount=" + amount + "]";
	}
	

}
