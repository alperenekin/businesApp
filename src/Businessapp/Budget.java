package Businessapp;

public class Budget {
	private double money;//number of money that company has
	private double profit;//profit of company
	public Budget(double money) {
		this.money=money;
		this.profit=0;
	}
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
}
