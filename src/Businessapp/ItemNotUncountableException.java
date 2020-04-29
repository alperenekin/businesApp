package Businessapp;

public class ItemNotUncountableException extends Exception {
	public ItemNotUncountableException() {
		super("Item is not uncountable!You can not store!");
	}
	public ItemNotUncountableException(String message) {
		super(message);
	}
}
