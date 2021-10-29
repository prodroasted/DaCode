package swapFrame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Swap Frame");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	TextField txfName = new TextField();
	TextField txfEfternavn = new TextField();


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
		Label lblName = new Label("SwapTwo:");
		pane.add(lblName, 0, 0);

		Label lblefternavn = new Label("SwapOne:");
		pane.add(lblefternavn, 3, 0);

		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		pane.add(txfName, 1, 0,2,1);
		pane.add(txfEfternavn, 4, 0, 2, 1);

		// add a button to the pane (at col=1, row=1)
		Button btnUpperCase = new Button("Swap");
		pane.add(btnUpperCase, 1, 2);
		GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

		btnUpperCase.setOnAction(event -> function());

		}

	private void function(){
		String temp = txfName.getText();
		txfName.setText(txfEfternavn.getText());
		txfEfternavn.setText(temp);

		}



		// add a button to the pane (at col=2, row=1)
	//----------------------------------------------------------------------------------------


	}

