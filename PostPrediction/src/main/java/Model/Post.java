package Model;

import java.util.Date;

import Utility.AddPrefixZero;

public class Post {
	private String companyCode;
	private String fiscalYear;
	private String accountNumber;
	private String costCenter;
	private String profitCenter;
	private AccountMasterData accountMasterData;
	private CostCenterMasterData costCenterMasterData;
	private ProfitCenterMasterData profitCenterMasterData;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	public AccountMasterData getAccountMasterData() {
		return accountMasterData;
	}

	public void setAccountMasterData(AccountMasterData accountMasterData) {
		this.accountMasterData = accountMasterData;
	}

	public CostCenterMasterData getCostCenterMasterData() {
		return costCenterMasterData;
	}

	public void setCostCenterMasterData(CostCenterMasterData costCenterMasterData) {
		this.costCenterMasterData = costCenterMasterData;
	}

	public ProfitCenterMasterData getProfitCenterMasterData() {
		return profitCenterMasterData;
	}

	public void setProfitCenterMasterData(ProfitCenterMasterData profitCenterMasterData) {
		this.profitCenterMasterData = profitCenterMasterData;
	}

	@Override
	public String toString() {
		return "Post [companyCode=" + companyCode + ", fiscalYear=" + fiscalYear + ", accountNumber=" + accountNumber
				+ ", costCenter=" + costCenter + ", profitCenter=" + profitCenter + ", accountMasterData="
				+ accountMasterData + ", costCenterMasterData=" + costCenterMasterData + ", profitCenterMasterData="
				+ profitCenterMasterData + "]";
	}
	
	public boolean addPrefixZero(){
		accountNumber = AddPrefixZero.addPrefixZero(accountNumber, AccountMasterData.LENGTH);
		costCenter = AddPrefixZero.addPrefixZero(costCenter, CostCenterMasterData.LENGTH);
		profitCenter = AddPrefixZero.addPrefixZero(profitCenter, ProfitCenterMasterData.LENGTH);
		
		return true;
	}
	
}
