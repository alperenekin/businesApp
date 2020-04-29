package Businessapp;

import java.util.ArrayList;

public class WareHouse extends Facility{
	private StorageTank<Milk> milkTank;
	private StorageTank<Cream> creamTank;
	private StorageTank<Yeast> yeastTank;
	private StorageTank<Cacao> cacaoTank;
	public WareHouse(){
		milkTank=new StorageTank<Milk>();
		creamTank=new StorageTank<Cream>();
		yeastTank=new StorageTank<Yeast>();
		cacaoTank=new StorageTank<Cacao>();
	}

	public double buyMilk(double volume) {
		Milk milk=new Milk(volume);
		milkTank.add(milk);	
		return milk.getCost();
	}
	public double buyCacao(double volume) {//buys cacao
		Cacao cacao=new Cacao(volume);
		cacaoTank.add(cacao);
		return cacao.getCost();
	}
	public double buyCream(double volume) {//buys cream
		Cream cream=new Cream(volume);
		creamTank.add(cream);
		return cream.getCost();
	}
	public double buyYeast(double volume) {//buys yeast
		Yeast yeast=new Yeast(volume);
		yeastTank.add(yeast);
		return yeast.getCost();
	}
	public void loadFromStorageToContainer(Container container,String item1,double amount) {
		container.addToContainer(takeUncountableFromFacility(item1,amount));//takes uncountable from storage and adds to container
	}
	public void loadFromContainerToStorage(Container container) {
		while(!container.isEmpty()) {//take everything from container and add to storage
			addUncountableToFacility(container.takeFromContainer());
		}
	}
	private Uncountable takeUncountableFromFacility(String item,double amount) {
		if (item.equals("Milk")) { //takes uncountable from facility and returns it
			Milk milk=milkTank.decreaseAmount(amount); 
			return milk;
		}
		else if(item.equals("Cream")) { 
			Cream cream=creamTank.decreaseAmount(amount);
			return cream;
		}
		else if(item.equals("Yeast")) {
			Yeast yeast=yeastTank.decreaseAmount(amount);
			return yeast;
		}
		else if(item.equals("Cacao")) {
			Cacao cacao=cacaoTank.decreaseAmount(amount);
			return cacao;
		}
		else{
			return null;
		}
	}
	private void addUncountableToFacility(Object item) {
		if (item instanceof Milk) { //add uncoutableobject to storage in facility
			milkTank.add(item);
		}
		else if(item instanceof Cream) {
			creamTank.add(item);
		}
		else if(item instanceof Yeast) {
			yeastTank.add(item);
		}
		else if(item instanceof Cacao){
			cacaoTank.add(item);
		}
	}
	public String storageAmounts() {
		return "In milktank " +milkTank.totalTankVolume()+ "L of Milk inside\n" + 
	"In cream tank " +creamTank.totalTankVolume()+ "L of Cream inside\n" +
    "In yeastTank " +yeastTank.totalTankVolume()+"L of yeast inside\n" +
	"In cacaoTank " +cacaoTank.totalTankVolume()+"L of cacao inside\n" ;
	}
}
