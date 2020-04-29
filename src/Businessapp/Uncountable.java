package Businessapp;

public abstract class Uncountable {
	private double volume;
	private double cost;
	public Uncountable(double volume,double price) {
		this.volume=volume;
		cost=volume*price;
	}
	
	public abstract void addVolume(double volume);
	public abstract void decreaseVolume(double amount);
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getCost() {
		return cost;
	}
}
