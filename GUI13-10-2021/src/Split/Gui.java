package Split;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Splitter");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	TextField txfName = new TextField();
	TextField txfEfternavn = new TextField();
	TextField txfKombination = new TextField();

	// -------------------------------------------------------------------------

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components 
		pane.setHgap(10);
		// set vertical gap between components 
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		Label lblefternavn = new Label("Efternavn: ");
		pane.add(lblefternavn, 3, 0);

		Label lblkombination = new Label("Full Name: ");
		pane.add(lblkombination, 0, 1);

		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		pane.add(txfName, 1, 0,2,1);
		pane.add(txfEfternavn, 4, 0, 2, 1);
		pane.add(txfKombination, 1, 1, 2, 1);

		// add a button to the pane (at col=1, row=1)
		Button btnUpperCase = new Button("Split Input");
		pane.add(btnUpperCase, 1, 2);
		GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

		btnUpperCase.setOnAction(event -> function());

		}

	private void function(){
		String[] kombination = txfKombination.getText().split(" ");
		txfName.setText(kombination[0]);
		txfEfternavn.setText(kombination[1]);
		}

		// add a button to the pane (at col=2, row=1)
	//----------------------------------------------------------------------------------------


	}

