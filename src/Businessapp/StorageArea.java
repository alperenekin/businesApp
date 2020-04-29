package Businessapp;

import java.util.LinkedList;
import java.util.Queue;

public class StorageArea<E extends Countable> extends Storage{//generic olmalý
	private Queue<E> tank;
	public StorageArea() {
		tank=new LinkedList<E>();
	}
	public int getSize() {
		return tank.size();
	}
	public E decreaseAmount(double amount) {	
		if(!isEmpty()) {
			return tank.poll();
		}
		else {
			System.out.println("The Tank is empty!!!You can not take more item!");	
			return null;
		}	
				
	}
	public boolean isEmpty() {
		if(tank.size()>=0) {
			return false;
		}
		return true;
	}
	@Override
	public boolean isFull(Object item) {//cheks if container is full
		if(getVolume()>=totalVolumeInContainer()+((E )item).getVolume()){
			return false;
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void add(Object item) {//adds item as long as it is not full
		if(!isFull(item)){
			tank.add((E) item);
		}
		else {
			System.out.println("There is not enough space in Tank!!!");
		}
	}
	public double totalVolumeInContainer() {
		double totalVolume=0;
		for(Countable obj : tank)
		{
			totalVolume+=obj.getVolume();
		}
		return totalVolume;
	}

	
}
