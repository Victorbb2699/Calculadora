package dad.javafx;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Application {

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
		resultB.setOnAction(e -> onresultBnAcction(e));

		comboOperando = new ComboBox<String>();
		comboOperando.getItems().addAll("+", "-", "*", "/");
		comboOperando.setMaxWidth(60);

		VBox primerBox = new VBox(5, comboOperando);
		primerBox.setAlignment(Pos.CENTER);

		HBox opc = new HBox(5, text1, text2);
		opc.setAlignment(Pos.CENTER);

		HBox opc2 = new HBox(5, text3, text4);
		opc.setAlignment(Pos.CENTER);

		Separator separador = new Separator();

		HBox opc3 = new HBox(5, text5, text6);
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

	}

	private void onresultBnAcction(ActionEvent e) {
		Complejo num1 = new Complejo();
		Complejo num2 = new Complejo();
		Complejo num3 = new Complejo();
		Complejo num4 = new Complejo();

		num1.setReal(Double.parseDouble(text1.getText()));
		num2.setImaginario((DoubleProperty) text2.getProperties());
		num3.setReal(Double.parseDouble(text3.getText()));
		num4.setImaginario((DoubleProperty) text4.getProperties());
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
