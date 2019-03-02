package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Header {
	private String companyCode;
	private String fiscalYear;
	private String journalEntryType;
	private String transactionCurrency;
	
	public Header() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
		if(this.companyCode != null){
			this.companyCode.trim().toUpperCase();
		}
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
		if(this.fiscalYear != null){
			this.fiscalYear.trim();
		}
	}

	public String getJournalEntryType() {
		return journalEntryType;
	}

	public void setJournalEntryType(String journalEntryType) {
		this.journalEntryType = journalEntryType;
		if(this.journalEntryType != null){
			this.journalEntryType.trim().toUpperCase();
		}
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
		if(this.transactionCurrency != null){
			this.transactionCurrency.trim().toUpperCase();
		}
	}

	@Override
	public String toString() {
		return "Header [companyCode=" + companyCode + ", fiscalYear=" + fiscalYear + ", journalEntryType="
				+ journalEntryType + ", transactionCurrency=" + transactionCurrency + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyCode == null) ? 0 : companyCode.hashCode());
		result = prime * result + ((journalEntryType == null) ? 0 : journalEntryType.hashCode());
		result = prime * result + ((transactionCurrency == null) ? 0 : transactionCurrency.hashCode());
		return result;
	}

	public boolean checkCompanyCode(){
		if(this.companyCode != null){
			if(this.companyCode.length() > 4){
				return false;
			}
		}
		return true;
	}
	
	public boolean checkFiscalYear(){
		if(this.fiscalYear != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(this.fiscalYear);
			} catch (ParseException e) {
				return false;
			}
		}
		return true;
	}
	
}
