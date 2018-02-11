package Model;

public class AccountMasterData {
	public static final int LENGTH = 10;
	private String chartOfAccounts;
	private String accountType;
	private String accountGroup;
	
	public AccountMasterData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountMasterData(String chartOfAccounts, String accountType, String accountGroup) {
		super();
		this.chartOfAccounts = chartOfAccounts;
		this.accountType = accountType;
		this.accountGroup = accountGroup;
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

	@Override
	public String toString() {
		return "AccountMasterData [chartOfAccounts=" + chartOfAccounts + ", accountType=" + accountType
				+ ", accountGroup=" + accountGroup + "]";
	}
	
	
}
