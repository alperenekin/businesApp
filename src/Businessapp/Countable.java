package Businessapp;

public abstract class Countable {
	private double volume;//the volume of a countable object
	private double cost; //the cost of an object
	public Countable(double volume,double price) { //to calculate cost 
		this.volume=volume;
		cost=this.volume*price; 	
	}
	public abstract void addVolume(double volume);
	public abstract void decreaseVolume(double volume);
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}
