package Businessapp;
public class Factory extends Facility{
	private StorageTank<Milk> milkTank;;
	private StorageTank<Cream> creamTank;
	private StorageTank<Yeast> yeastTank;
	private StorageTank<Cacao> cacaoTank;
	private StorageArea<BoxedMilk> boxedmilkarea;
	private StorageArea<Yoghurt> yoghurtarea;
	private StorageArea<Chocolate> chokoarea;
	public Factory() {
		milkTank=new StorageTank<Milk>();
		creamTank=new StorageTank<Cream>();
		yeastTank=new StorageTank<Yeast>();
		cacaoTank=new StorageTank<Cacao>();
		boxedmilkarea=new StorageArea<BoxedMilk>();
		yoghurtarea=new StorageArea<Yoghurt>();
		chokoarea=new StorageArea<Chocolate>();
	}
	public void loadFromStorageToContainer(Container container,String item1,double amount) {//checks whether item is conutable or uncountable,according to it put items to container
		if(item1.equals("Milk") || item1.equals("Cream") || item1.equals("Yeast") || item1.equals("Cacao")){
			container.addToContainer(takeUncountableFromStorage(item1,amount));
		}	
		else{
			
			double numberOfCountableObject=amount;
			for(int i=0;i<numberOfCountableObject;i++) {
				container.addToContainer(takeCountableFromStorage(item1,amount));	
			}
		}
	}
	public void loadFromContainerToStorage(Container container) {
		if(container.containerFirstElement() instanceof Uncountable) {
			while(!container.isEmpty()) {//take items from container till container is empty
				addUncountableToStorage(container.takeFromContainer());//then add items to storage places
			}
		}
		else if(container.containerFirstElement() instanceof Countable) {
			while(!container.isEmpty()) {//take items from container till container is empty
				addCountableToStorage(container.takeFromContainer());//then add items to storage places
			}
		}
	}
	public void produceChocolate() {// produces chocolate according to formula
		Milk milk =milkTank.decreaseAmount(500);
		milk=null;
		Cream cream=creamTank.decreaseAmount(200);
		cream=null;
		Cacao cacao=cacaoTank.decreaseAmount(300);
		cacao=null;
		double chokoamount=800;
		while(chokoamount>0) {
			Chocolate choko=new Chocolate();
			chokoamount=chokoamount-choko.getVolume();
			chokoarea.add(choko);
		}
	}
	public void produceBoxedMilk() {//prdouces Boxed Milk according to formula
		Milk milk=milkTank.decreaseAmount(1000);
		milk=null;
		double boxedmilkamount=1000;
		while(boxedmilkamount>0) {
			BoxedMilk boxedmilk=new BoxedMilk();
			boxedmilkamount-=boxedmilk.getVolume();
			boxedmilkarea.add(boxedmilk);
		}
	}
	public void produceYoghurt() {//produces Yoghurt according to formula
		Milk milk=milkTank.decreaseAmount(1500);
		milk=null;
		Yeast yeast=yeastTank.decreaseAmount(100);
		yeast=null;
		double yoghurtamount=700;
		while(yoghurtamount>0) {
			Yoghurt yoghurt=new Yoghurt();
			yoghurtamount-=1;
			yoghurtarea.add(yoghurt);
		}
	}
	
	private Uncountable takeUncountableFromStorage(String item,double amount) {
		if (item.equals("Milk")) { // take uncountable item from storage and returns its object
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
		else {
			return null;
		}
	
	}
	private Countable takeCountableFromStorage(String item,double amount) {
		if(item.equals("Chocolate")) {//takes coutnable item from storage and returns its object
			Chocolate choko=chokoarea.decreaseAmount(amount);
			return choko;
		}
		else if(item.equals("Boxed Milk")) {
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
	private void addUncountableToStorage(Object item) {
		if (item instanceof Milk) { //adds uncoutnable object to storage
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
	private void addCountableToStorage(Object item) {
		if(item instanceof Chocolate){ //adds countable object to storage
			chokoarea.add(item);
		}
		else if(item instanceof BoxedMilk){
			boxedmilkarea.add(item);
		}
		else if(item instanceof Yoghurt){
			yoghurtarea.add(item);
		}
	}
	public String storageAmounts() {
		return "In milktank " +milkTank.totalTankVolume()+ " L of Milk inside\n" + 
	"In cream tank " +creamTank.totalTankVolume()+ " L of Cream inside\n" +
    "In yeastTank " +yeastTank.totalTankVolume()+" L of yeast inside\n" +
	"In cacaoTank " +cacaoTank.totalTankVolume()+" L of cacao inside\n" +
    "In chocolate area " +chokoarea.totalVolumeInContainer()+" L of chocolate\n" +
	"In boxed milk area "+boxedmilkarea.totalVolumeInContainer()+ " L of boxed milk\n"+
    "In yoghurt area " +yoghurtarea.totalVolumeInContainer()+" L of boxed milk\n";
	}
}
