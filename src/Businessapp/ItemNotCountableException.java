package Businessapp;

@SuppressWarnings("serial")
public class ItemNotCountableException extends Exception {
	public ItemNotCountableException() {
		super("Item is not countable!You can not store!!");
	}
	public ItemNotCountableException(String message) {
		super(message);
	}
}
