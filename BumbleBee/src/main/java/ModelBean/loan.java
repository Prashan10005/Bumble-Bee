package ModelBean;

import java.util.Date;

public class loan {
	public String cusNIC;
	public Double loanAmount;
	public Double usedAmount;
	public Double balance;
	public int installment;
	public Date nextDueDate;
	public Double nextPayment;
	public String getCusNIC() {
		return cusNIC;
	}
	public void setCusNIC(String cusNIC) {
		this.cusNIC = cusNIC;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Double getUsedAmount() {
		return usedAmount;
	}
	public void setUsedAmount(Double usedAmount) {
		this.usedAmount = usedAmount;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getInstallment() {
		return installment;
	}
	public void setInstallment(int installment) {
		this.installment = installment;
	}
	public Date getNextDueDate() {
		return nextDueDate;
	}
	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate = nextDueDate;
	}
	public Double getNextPayment() {
		return nextPayment;
	}
	public void setNextPayment(Double nextPayment) {
		this.nextPayment = nextPayment;
	}
	public loan(String cusNIC, Double loanAmount, Double usedAmount, Double balance, int installment, Date nextDueDate,
			Double nextPayment) {
		super();
		this.cusNIC = cusNIC;
		this.loanAmount = loanAmount;
		this.usedAmount = usedAmount;
		this.balance = balance;
		this.installment = installment;
		this.nextDueDate = nextDueDate;
		this.nextPayment = nextPayment;
	}
	
	
	
}
