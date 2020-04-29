package Businessapp;

public class Company {
	private WareHouse warehouse;
	private Factory factory;	
	private DistributionCenter center;
	private Budget budget;
	private Container<Countable> drystorage;
	private Container<SolidUncountable> opentop;
	private Container<FluidUncountable> tankcontainer;
	public Company() {
		warehouse=new WareHouse();
		factory=new Factory();
		center=new DistributionCenter();
		drystorage=new DryStorageContainer<Countable>();
		opentop=new OpenTopContainer<SolidUncountable>();
		tankcontainer=new TankContainer<FluidUncountable>();
		budget=new Budget(10000);
	}
	public double companyProfit() {
		return budget.getProfit();
	}
	public void buyIngredient(String ingredient,double volume) {//to buy ingredient when there is budget
		double cost=0;
		if(budget.getMoney()<=0) {
			System.out.println("You dont have enough money!!");
		}
		else {
			if(ingredient.equals("Milk")) {
				cost=warehouse.buyMilk(volume);
			}
			else if(ingredient.equals("Cream")) {
				cost=warehouse.buyCream(volume);
			}
			else if(ingredient.equals("Yeast")) {
				cost=warehouse.buyYeast(volume);
			}
			else if(ingredient.equals("Cacao")) {
				cost=warehouse.buyCacao(volume);
			}
		}
		budget.setMoney(budget.getMoney()-cost);
		budget.setProfit(budget.getProfit()-cost);
	}
	public void sellProduct(String ingredient,double amount) { // to sell product
		double income=0;
		if(ingredient.equals("Chocolate")) {
			income=center.sellChocolate(amount);
		}
		else if(ingredient.equals("Yoghurt")) {
			income=center.sellYoghurt(amount);
		}
		else if(ingredient.equals("Boxed Milk")) {
			income=center.sellBoxedMilk(amount);
		}
		amount-=1;
		budget.setMoney(budget.getMoney()+income);
		budget.setProfit(budget.getProfit()+income);
		
	}
	public void produceProduct(String product) { //to produce given product
		if(product.equals("Chocolate")) {
			factory.produceChocolate();
		}
		else if(product.equals("Yoghurt")) {
			factory.produceYoghurt();
		}
		else if(product.equals("Boxed Milk")) {
			factory.produceBoxedMilk();
		}
	}
		
	public void unloadContainer(String container) { //unload container in given location
		Container containerObject=inputContainer(container);
		if(containerObject.getLocation().equals("Warehouse")) {
			warehouse.loadFromContainerToStorage(containerObject);
		}
		else if(containerObject.getLocation().equals("Factory")) {
			System.out.println("burda");
			factory.loadFromContainerToStorage(containerObject);
		}
		if(containerObject.getLocation().equals("Center")) {
			center.loadFromContainerToStorage(containerObject);
			
		}
	}

	public void loadContainer(String container,String item,double amount) {//load container in given location
		Container containerObject=inputContainer(container);
		if(containerObject.getLocation().equals("Warehouse")) {
			warehouse.loadFromStorageToContainer(containerObject, item,amount);
		}
		else if(containerObject.getLocation().equals("Factory")) {
			factory.loadFromStorageToContainer(containerObject, item,amount);
		}
		else if(containerObject.getLocation().equals("Center")) {
			center.loadFromStorageToContainer(containerObject, item,amount);
		}

	}
	public void transferContainer(String container,String destination) {// change container location to given destination
		Container containerObject=inputContainer(container);
		if(containerObject.getLocation().equals(destination)) {
			System.out.println("You can not tranport without changing destination");
		}
		else{
			containerObject.setLocation(destination);
		}
		budget.setMoney(budget.getMoney()-100);
		budget.setProfit(budget.getProfit()-100);
	}
	private Container inputContainer(String container) {//gets the Container object by using container name
		Container containerObject=null;
		if(container.equals("Open Top")) {
			containerObject=opentop;
		}
		else if(container.equals("Dry Storage")) {
			containerObject=drystorage;
		}
		else if(container.equals("Tank")) {
			containerObject=tankcontainer;
		}
		return containerObject;

	}
	public void printContainerInfo() {
		System.out.println("Dry Storage location = "+drystorage.getLocation()+"-Container size="+drystorage.getSize());
		System.out.println("Open top location="+opentop.getLocation()+"-Open Top size="+opentop.getSize());
		System.out.println("Tank container location="+tankcontainer.getLocation()+"-Tank Contaner size="+tankcontainer.getSize());
	}
	public String storageInfo(String facility) { // to get info about storage places in facilities
		if(facility.equals("Warehouse")) {
			return warehouse.storageAmounts();
		}
		else if(facility.equals("Factory")) {
			return factory.storageAmounts();
		}
		else if(facility.equals("Center")) {
			return center.storageAmounts();
		}
		else {
			return null;
		}
	}
}
