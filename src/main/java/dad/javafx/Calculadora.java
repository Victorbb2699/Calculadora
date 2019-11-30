package dad.javafx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Calculadora extends Application {

	private Complejo operando1R = new Complejo();
	private Complejo operando2R = new Complejo();
	private Complejo operando1I = new Complejo();
	private Complejo operando2I = new Complejo();

	private DoubleProperty resultadoR = new SimpleDoubleProperty();
	private DoubleProperty resultadoI = new SimpleDoubleProperty();
	private StringProperty operador = new SimpleStringProperty();

	private TextField text1;
	private TextField text2;
	private TextField text3;
	private TextField text4;
	private TextField text5;
	private TextField text6;
	private ComboBox<String> comboOperando;
	private Button resultB;

	@Override
	public void start(Stage primaryStage) throws Exception {

		text1 = new TextField();
		text1.setPromptText("0");
		text1.setMaxWidth(50);

		text2 = new TextField();
		text2.setPromptText("0");
		text2.setMaxWidth(50);

		text3 = new TextField();
		text3.setPromptText("0");
		text3.setMaxWidth(50);

		text4 = new TextField();
		text4.setPromptText("0");
		text4.setMaxWidth(50);

		text5 = new TextField();
		text5.setPromptText("0");
		text5.setMaxWidth(50);

		text6 = new TextField();
		text6.setPromptText("0");
		text6.setMaxWidth(50);

		resultB = new Button();
		resultB.setDefaultButton(true);
		resultB.setText("=");
		// resultB.setOnAction(e -> onresultBnAcction(e));

		comboOperando = new ComboBox<String>();
		comboOperando.getItems().addAll("+", "-", "*", "/");
		comboOperando.setMaxWidth(60);

		VBox primerBox = new VBox(5, comboOperando);
		primerBox.setAlignment(Pos.CENTER);

		HBox opc = new HBox(5, text1, new Label("+"), text2, new Label("i"));
		opc.setAlignment(Pos.CENTER);

		HBox opc2 = new HBox(5, text3, new Label("+"), text4, new Label("i"));
		opc.setAlignment(Pos.CENTER);

		Separator separador = new Separator();

		HBox opc3 = new HBox(5, text5, new Label("+"), text6, new Label("i"));
		opc.setAlignment(Pos.CENTER);

		VBox operaciones = new VBox(5, opc, opc2, separador, opc3);
		operaciones.setAlignment(Pos.CENTER);

		VBox result = new VBox(5, resultB);
		result.setAlignment(Pos.CENTER);

		HBox root = new HBox(5, primerBox, operaciones, result);
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("CalculadoraView.fxml");
		primaryStage.setScene(scene);
		primaryStage.show();

		// bindeos
		Bindings.bindBidirectional(text1.textProperty(), operando1R.getReal(), new NumberStringConverter());
		Bindings.bindBidirectional(text3.textProperty(), operando2R.getReal(), new NumberStringConverter());
		Bindings.bindBidirectional(text5.textProperty(), resultadoR, new NumberStringConverter());
		Bindings.bindBidirectional(text2.textProperty(), operando1I.getImaginario(), new NumberStringConverter());
		Bindings.bindBidirectional(text4.textProperty(), operando2I.getImaginario(), new NumberStringConverter());
		Bindings.bindBidirectional(text6.textProperty(), resultadoI, new NumberStringConverter());

		operador.bind(comboOperando.getSelectionModel().selectedItemProperty());

		// Bindings.bindBidirectional(text, property2);

		// listeners

		operador.addListener((o, ov, nv) -> onOperadorChanged(nv));

		comboOperando.getSelectionModel().selectFirst();
	}

	private void onOperadorChanged(String nv) {
		switch (nv) {
		case "+":
			resultadoR.bind(operando1R.getReal().add(operando2R.getReal()));
			resultadoI.bind(operando1I.getImaginario().add(operando2I.getImaginario()));
			break;
		case "-":
			resultadoR.bind(operando1R.getReal().subtract(operando2R.getReal()));
			resultadoI.bind(operando1I.getImaginario().subtract(operando2I.getImaginario()));
			break;
		case "*":
			resultadoR.bind((operando1R.getReal().multiply(operando2R.getReal())
					.subtract(operando1I.getImaginario().multiply(operando2I.getImaginario()))));
			resultadoI.bind(operando1R.getReal().multiply(operando2I.getImaginario())
					.subtract(operando2R.getReal().multiply(operando1I.getImaginario())));
			break;
		case "/":
			resultadoR.bind(operando1R.getReal().multiply(operando1I.getImaginario())
					.subtract(operando2R.getReal().multiply(operando2I.getImaginario())
							.divide(operando1I.getImaginario().multiply(operando1I.getImaginario()
									.add(operando2I.getImaginario().multiply(operando2I.getImaginario()))))));
			resultadoI.bind(operando2R.getReal()
					.multiply(operando1I.getImaginario()
							.add(operando1R.getReal().multiply(operando2I.getImaginario())
									.divide(operando1I.getImaginario().multiply(operando1I.getImaginario()
											.add(operando2I.getImaginario().multiply(operando2I.getImaginario())))))));
			break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
//