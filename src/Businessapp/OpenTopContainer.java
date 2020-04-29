package Businessapp;

import java.util.Stack;

public class OpenTopContainer <E extends SolidUncountable> extends Container {//Open top container oluþutururken generic yerine ne vermeli?
	private Stack<E> container;
	public OpenTopContainer() {
		container=new Stack<E>();
		setLocation("Factory");
	}
	@Override
	public void addToContainer(Object item) {
		try {
			if(item instanceof Countable){//countable can not be added
				throw new ItemNotUncountableException();
			}
			try {
				if(container.isEmpty()) {//adds if it is empty and item is uncountable
					container.add((E) item);
				}
				else {//if it is full ,check and add if they are same
					SolidUncountable first=container.firstElement();
					if(!isFull(item)){
						if(item instanceof Yeast && container.firstElement() instanceof Yeast || item instanceof Cacao && container.firstElement() instanceof Cacao) {
							first.addVolume(((SolidUncountable) item).getVolume());
							item=null;//add the volume and make the previous object null
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
	public E takeFromContainer() {//takes element from container as long as it  exists
		if(!isEmpty()) {
			return container.pop();
		}
		else {
			System.out.println("Container is Empty!!!");
			return null;
		}
	}

	@Override
	public boolean isEmpty() {//checks if there is element in container
		if(container.size()>0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isFull(Object item) {//checks if new item exceeds the container volume
		SolidUncountable first=container.firstElement();
		if(getVolume()>(first.getVolume()+((E )item).getVolume())){
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
	public SolidUncountable containerFirstElement() {
		return container.firstElement();
	}

}
