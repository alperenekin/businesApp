package Businessapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StorageTank<E extends Uncountable> extends Storage{
	private Queue<E> tank;
	public StorageTank() {
		tank=new LinkedList<E>();
	}
	public void printVolume() {
		System.out.println(tank.peek().getVolume());
	}
	@Override
	public E decreaseAmount(double amount) {//if there is unctounable element inside decrease volume of it
		if(!isEmpty()) {//if its volume becomes 0 remove it from tank.
			Uncountable first=tank.peek();
			if(tank.size()>0){	
				first.decreaseVolume(amount);
			}
			if(first.getVolume()==0) {
				tank.remove();
			}
			if(first instanceof Milk) {
				Milk milk=new Milk(amount);
				return (E) milk;
			}
			else if(first instanceof Yeast) {
				Yeast yeast=new Yeast(amount);
				return (E) yeast;
			}
			else if(first instanceof Cacao) {
				Cacao cacao=new Cacao(amount);
				return (E) cacao;
			}
			else if(first instanceof Cream) {
				Cream cream=new Cream(amount);
				return (E) cream;
			}
		}
		else {
			System.out.println("It is empty!! You can not take more item!!");
			return null;//new uncountable
		}
		return null;
	}
	@Override
	public boolean isEmpty() {//check if it is empty
		if(tank.size()>0) {
			return false;
		}
		return true;
	}
	@Override
	public boolean isFull(Object item) {// check if it is full
		Uncountable first=tank.peek();
		if(getVolume()>(first.getVolume()+((E )item).getVolume())){
			return false;	
		}
		return true;
	}
	@Override
	public void add(Object item) {//if it is empty add directly, if it is not empty add on top of the first element by increasing its volume
		if(item instanceof Uncountable) {
			if (isEmpty()) {
				tank.add((E) item);
			}
			else {
				if(!isFull(item)) {
					Uncountable first=tank.peek();
					first.addVolume(((Uncountable) item).getVolume());
					item=null;
				}
				else {
					System.out.println("Tank is full!! You can not add!!");
				}
			}
		}
	}
	public double totalTankVolume() {
		double totalvolume=0;
		for(E object : tank){
		    totalvolume+=object.getVolume();
		}
		return totalvolume;
	}
}
