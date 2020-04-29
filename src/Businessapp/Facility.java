package Businessapp;

public abstract class Facility {
public abstract void loadFromStorageToContainer(Container container,String item,double amount);
public abstract void loadFromContainerToStorage(Container container);
public abstract String storageAmounts();
}
