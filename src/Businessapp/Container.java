package Businessapp;

public abstract class Container <E>{
	private String location;
	private double volume=1000;// the volume container can take
	public abstract void addToContainer(Object item);
	public abstract E takeFromContainer();
	public abstract boolean isEmpty();
	public abstract boolean isFull(Object item);
	public abstract int getSize();
	public abstract E containerFirstElement();
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
