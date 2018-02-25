package Model;

public class AccountMasterData {
	public static final int LENGTH = 10;
	private String accountNumber;
	private String chartOfAccounts;
	private String accountType;
	private String accountGroup;
	private String companyCode;
	private String shortText;
	private String longText;
	
	public AccountMasterData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getChartOfAccounts() {
		return chartOfAccounts;
	}

	public void setChartOfAccounts(String chartOfAccounts) {
		this.chartOfAccounts = chartOfAccounts;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getShortText() {
		return shortText;
	}

	public void setShortText(String shortText) {
		this.shortText = shortText;
	}

	public String getLongText() {
		return longText;
	}

	public void setLongText(String longText) {
		this.longText = longText;
	}

	public static int getLength() {
		return LENGTH;
	}

	@Override
	public String toString() {
		return "AccountMasterData [accountNumber=" + accountNumber + ", chartOfAccounts=" + chartOfAccounts
				+ ", accountType=" + accountType + ", accountGroup=" + accountGroup + ", companyCode=" + companyCode
				+ ", shortText=" + shortText + ", longText=" + longText + "]";
	}

	
	
	
}
