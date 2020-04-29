package Businessapp;

public class Yoghurt extends Countable{
	
	public Yoghurt() {//calculates cost of yoghurt
		super(2, 2);
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
