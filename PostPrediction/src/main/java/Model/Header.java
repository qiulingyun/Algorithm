package Model;

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
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getJournalEntryType() {
		return journalEntryType;
	}

	public void setJournalEntryType(String journalEntryType) {
		this.journalEntryType = journalEntryType;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	@Override
	public String toString() {
		return "Header [companyCode=" + companyCode + ", fiscalYear=" + fiscalYear + ", journalEntryType="
				+ journalEntryType + ", transactionCurrency=" + transactionCurrency + "]";
	}
	
	
}
