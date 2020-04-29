package Businessapp;

public class BoxedMilk extends Countable{
	
	public BoxedMilk() {
		super(1,1); // to calculate cost of boxedmilk
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
