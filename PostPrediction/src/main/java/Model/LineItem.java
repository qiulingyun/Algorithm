package Model;

import Utility.AddPrefixZero;

public class LineItem {
	private String accountNumber;
	private String debit;
	private String credit;
	private String costCenter;
	private String profitCenter;
	
	public LineItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDebit() {
		return debit;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getProfitCenter() {
		return profitCenter;
	}

	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}

	@Override
	public String toString() {
		return "LineItem [accountNumber=" + accountNumber + ", debit=" + debit + ", credit=" + credit + ", costCenter="
				+ costCenter + ", profitCenter=" + profitCenter + "]";
	}

	public boolean addPrefixZero(){
		accountNumber = AddPrefixZero.addPrefixZero(accountNumber, AccountMasterData.LENGTH);
		costCenter = AddPrefixZero.addPrefixZero(costCenter, CostCenterMasterData.LENGTH);
		profitCenter = AddPrefixZero.addPrefixZero(profitCenter, ProfitCenterMasterData.LENGTH);
		
		return true;
	}
}
