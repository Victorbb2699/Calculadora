package dad.javafx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {
	private double real;
	private DoubleProperty imaginario = new SimpleDoubleProperty();
	
	public Complejo() {
		super();
		
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public DoubleProperty getImaginario() {
		return imaginario;
	}

	public void setImaginario(DoubleProperty imaginario) {
		this.imaginario = imaginario;
	}
}
