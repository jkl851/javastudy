package prob05;

public class Account {
	private String accountNo;
	private double balance;
	
	public Account(String account) {
		this.accountNo = account;
		System.out.println(account + "계좌가 개설되었습니다.");
	}

	public void save(double m) {
		System.out.println(accountNo +"계좌에 "+ m +"만원이 입금되었습니다.");
		this.balance += m;
	}

	public void deposit(double m) {
		System.out.println(accountNo +"계좌에 "+ m +"만원이 출금되었습니다.");
		this.balance -= m;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}
}
