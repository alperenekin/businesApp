package Businessapp;

public class Chocolate extends Countable{
	public Chocolate() {
		super(0.5,4);// to set cost according to volume
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
