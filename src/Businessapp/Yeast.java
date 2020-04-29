package Businessapp;

public class Yeast extends SolidUncountable{
	
	public Yeast(double volume) {//calculates cost according to volume
		super(volume, 5);
	}
	public void addVolume(double volume) {
		setVolume(getVolume()+volume);
	}
	@Override
	public void decreaseVolume(double volume) {
		setVolume(getVolume()-volume);
	}
}
