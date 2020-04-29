package Businessapp;

public class Cream extends FluidUncountable{
	
	public Cream(double volume) {//to calculate cost of a Cream
		super(volume, 0.30);
	}
	public void addVolume(double volume) {
		setVolume(getVolume()+volume);
	}
	@Override
	public void decreaseVolume(double volume) {
		setVolume(getVolume()-volume);
	}
}
