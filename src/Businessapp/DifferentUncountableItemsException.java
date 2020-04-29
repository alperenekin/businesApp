package Businessapp;

public class DifferentUncountableItemsException extends Exception {
	public DifferentUncountableItemsException() {
		super("Different uncountables can not be added!");
	}
	public DifferentUncountableItemsException(String message) {
		super(message);
	}
}
