package Businessapp;

import java.util.Stack;

public class TankContainer <E extends FluidUncountable> extends Container{
	private Stack<E> container;
	public TankContainer() {
		container=new Stack<E>();
		setLocation("Factory");
	}
	@Override
	public void addToContainer(Object item) {
		try {
			if(item instanceof Countable){
				throw new ItemNotUncountableException();
			}
			try {
				if(container.isEmpty()) {//if it is empty and not countable ,try to add
					container.add((E) item);
				}
				else {//if the type is same with the object inside ,it can be added
					FluidUncountable first=container.firstElement();
					if(!isFull(item)){
						if(item instanceof Milk && container.firstElement() instanceof Milk || item instanceof Cream && container.firstElement() instanceof Cream) {
							first.addVolume(((FluidUncountable) item).getVolume());
							item=null;
						}
						else {
							throw new DifferentUncountableItemsException();
						}
					}
					else {
						System.out.println("Container is full! You can not add more!");
						return;
					}
				}
			}catch (DifferentUncountableItemsException e) {
				System.out.println(e.getMessage());
			}	
				
		}catch (ItemNotUncountableException e) {
			System.out.println(e.getMessage());
		}
}

	@Override
	public E takeFromContainer() {
		if(!isEmpty()) {
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
	public boolean isFull(Object item) {
		FluidUncountable first=container.firstElement();
		if(getVolume()>=(first.getVolume()+((E )item).getVolume())){
			return false;	
		}
		return true;
	}

	@Override
	public int getSize() {
		container.size();
		return container.size();
	}

	@Override
	public FluidUncountable containerFirstElement() {
		return container.firstElement();
	}
}
