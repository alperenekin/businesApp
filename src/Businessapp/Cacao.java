package Businessapp;

public class Cacao extends SolidUncountable{
	public Cacao(double volume) {
		super(volume,1);// to set the cost according to volume
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
