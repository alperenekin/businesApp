package Businessapp;

import java.util.ArrayList;

//Sell iþlemi var,centera transfer etme iþlemi var
public class DistributionCenter extends Facility{
	private StorageArea<BoxedMilk> boxedmilkarea;
	private StorageArea<Yoghurt> yoghurtarea;
	private StorageArea<Chocolate> chokoarea;	
	public DistributionCenter() {
		boxedmilkarea=new StorageArea<BoxedMilk>();
		yoghurtarea=new StorageArea<Yoghurt>();
		chokoarea=new StorageArea<Chocolate>();	
	}

	public double sellChocolate(double amount) {// to sell chocolate 
		double price=0;
		while(amount>0) {
			Chocolate chocolate=chokoarea.decreaseAmount(amount);//pop la nulla
			amount-=1;
			price+=chocolate.getCost();
			chocolate=null;
		}
		
		return price;
	}
	public double sellBoxedMilk(double amount){
		double price=0;
		while(amount>0) {
		    BoxedMilk boxedmilk=boxedmilkarea.decreaseAmount(amount);//pop la nulla
			amount-=1;
			price+=boxedmilk.getCost();
			boxedmilk=null;
		}
		return price;
	}
	public double sellYoghurt(double amount) {
		double price=0;
		while(amount>0) {
			Yoghurt yoghurt=yoghurtarea.decreaseAmount(amount);//pop la nulla4
			amount-=1;
			price+=yoghurt.getCost();
			yoghurt=null;
		}
		return price;

	}
	public void loadFromContainerToStorage(Container container) {
		while(!container.isEmpty()) {//take items from container till container is empty
			addCountableToStorage(container.takeFromContainer());//then add items to storage places
		}
		
	}
	public void loadFromStorageToContainer(Container container,String item1,double amount) {
		double numberOfCountableObject=amount; //takes given number of item from Storage and puts to container
		for(int i=0;i<numberOfCountableObject;i++) {
			container.addToContainer(takeCountableFromStorage(item1,amount));	
		}
	}
	private void addCountableToStorage(Object item) { //adds countable objects to storage
		if (item instanceof BoxedMilk) {
			boxedmilkarea.add(item);
		}
		else if(item instanceof Yoghurt) {
			yoghurtarea.add(item);
		}
		else if(item instanceof Chocolate) {
			chokoarea.add(item);
		}

	}
	private Countable takeCountableFromStorage(String item,double amount) {
		if(item.equals("Chocolate")) { //takes contable objects from storage
			Chocolate choko=chokoarea.decreaseAmount(amount);
			return choko;
		}
		else if(item.equals("Boxedmilk")) {
			BoxedMilk boxedmilk=boxedmilkarea.decreaseAmount(amount);
			return boxedmilk;
		}
		else if(item.equals("Yoghurt")) {
			Yoghurt yoghurt=yoghurtarea.decreaseAmount(amount);
			return yoghurt;
		}
		else {
			return null;
		}
	}
	public String storageAmounts() {
		return "In chocolate area " +chokoarea.totalVolumeInContainer()+" L of chocolate\n" +
	"In boxed milk area "+boxedmilkarea.totalVolumeInContainer()+ " L of boxed milk\n"+
    "In yoghurt area " +yoghurtarea.totalVolumeInContainer()+" L of yoghurt area\n";
	}
	
}
