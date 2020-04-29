package Businessapp;

import java.util.ArrayList;

public abstract class Storage<E>{
	private double volume;
	public Storage() {
		setVolume(10000);//total volume of a storage place
	}
	public abstract E decreaseAmount(double amount);
	public abstract boolean isEmpty();
	public abstract boolean isFull(Object item);
	public abstract void add(E item);
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
}
