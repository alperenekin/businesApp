package Businessapp;

import java.util.Stack;
//new DryStorage<countable> container
public class DryStorageContainer<E extends Countable> extends Container{
	
	private Stack<E> container;
	public DryStorageContainer() {
		container=new Stack<E>();
		setLocation("Factory");
	}
	public void addToContainer(Object item) {//adds to container as long as there is place
			try {
				if(item instanceof Uncountable) {
					throw new ItemNotCountableException(); //throw exception when uncountable try to be added
				}
				else {
					if(!isFull(item)) {
						container.add((E) item);
					}
					else {
						System.out.println("Container is full!! You can not add");
						return;
					}
				}
			} catch (ItemNotCountableException e) {
				System.out.println(e.getMessage());
			}
			
	}

	@Override
	public E takeFromContainer() {
		if(!isEmpty()) { //Take item from container as long as it is not empty
			return container.pop();
		}
		else {
			System.out.println("Container is Empty!!!");
			return null;
		}
	}
	@Override
	public boolean isEmpty() {
		if(container.size()>0) {
			return false;
		}
		return true;
	}
	@Override
	public boolean isFull(Object item) {//if the newly added object exceeds container volume,it means it is full
		if(getVolume()>=totalVolumeInContainer()+((E )item).getVolume()){
			return false;
		}
		return true;
	}
	private double totalVolumeInContainer() {// returns the sum of volumes in container.So shows how full it is
		double totalVolume=0;
		for(Countable obj : container)
		{
			totalVolume+=obj.getVolume();
		}
		return totalVolume;
	}
	@Override
	public int getSize() {
		return container.size();
	}

	@Override
	public Countable containerFirstElement() {
		return container.firstElement();
	}
}	
