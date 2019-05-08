package model.Exceptions;

public class FieldNotFilledException extends RuntimeException {
	public FieldNotFilledException(String errorMessage) {
		super(errorMessage);
	}
}
