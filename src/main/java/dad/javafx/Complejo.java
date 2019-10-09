package dad.javafx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {
	private DoubleProperty real = new SimpleDoubleProperty();
	private DoubleProperty imaginario = new SimpleDoubleProperty();

	public Complejo() {
		super();
	}

	public void setReal(DoubleProperty real) {
		this.real = real;
	}

	public DoubleProperty getImaginario() {
		return imaginario;
	}

	public void setImaginario(DoubleProperty imaginario) {
		this.imaginario = imaginario;
	}

	public DoubleProperty getReal() {
		return real;
	}
}
