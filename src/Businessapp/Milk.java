package Businessapp;

public class Milk extends FluidUncountable{
	

	public Milk(double volume) {//to calculate cost of milk according to volume
		super(volume,0.25);
	}

	@Override
	public void addVolume(double volume) {
		setVolume(getVolume()+volume);
	}

	@Override
	public void decreaseVolume(double volume) {
		setVolume(getVolume()-volume);
	}
}
