package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import application.model.Yatzy;

import java.util.Arrays;

public class YatzyGui extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// Shows the face values of the 5 dice.
	private TextField[] txfValues;
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds;
	// Shows the results previously selected .
	// For free results (results not set yet), the results
	// corresponding to the actual face values of the 5 dice are shown.
	private TextField[] txfResults;
	// Shows points in sums, bonus and total.
	private TextField[] txfSumBonusSumTotal; // txfSumSame, txfBonus, txfSumOther, txfTotal;
	// Shows the number of times the dice has been rolled.
	private Label lblRolled;

	private final int[] lockedResults = new int[15];

	private Button btnRoll;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// initialize txfValues, chbHolds, btnRoll and lblRolled
		// TODO
		this.txfValues = new TextField[5];
		this.chbHolds = new CheckBox[5];

		for (int i = 0; i < txfValues.length; i++) {
			TextField txfvalue = new TextField();
			txfvalue.setEditable(false);
			txfvalue.setPrefSize(75, 75);
			txfvalue.setFont(new Font(35));
			txfvalue.setAlignment(Pos.CENTER);

			CheckBox chbhold = new CheckBox("hold");
			chbhold.setFont(new Font(10));
			GridPane.setHalignment(chbhold, HPos.CENTER);

			dicePane.add(txfvalue, i, 0);
			this.txfValues[i] = txfvalue;

			dicePane.add(chbhold, i, 1);
			this.chbHolds[i] = chbhold;
		}

		Button btnRoll = new Button("Roll");
		btnRoll.setFont(new Font(20));
		//btnRoll.setOnAction(event -> this.rollHandle);
		GridPane.setHalignment(btnRoll, HPos.CENTER);

		Label lblRolled = new Label("Rolled: 0");
		lblRolled.setFont(new Font(10));
		GridPane.setHalignment(lblRolled, HPos.CENTER);

		dicePane.add(btnRoll, 3, 2);
		this.btnRoll = btnRoll;

		dicePane.add(lblRolled, 4, 2);
		this.lblRolled = lblRolled;


		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");
		int w = 50; // width of the text fields

		// Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
		// TODO

		String[] txfResults = {"1´s", "2´s", "3´s", "4´s", "5´s", "6´s", "One Pair", "Two Pair", "Three of a kind",
				"Four of a kind", "Full house", "Small Straight", "Large Straight", "Chance", "Yatzy!"};
		this.txfResults = new TextField[15];

		for (int i = 0; i < txfResults.length; i++) {
			Label lblresult = new Label(txfResults[i]);
			lblresult.setFont(new Font(10));

			TextField txfresult = new TextField();
			txfresult.setEditable(false);
			txfresult.setDisable(true);
			txfresult.setPrefSize(w, 22);
			txfresult.setFont(new Font(10));
			txfresult.setAlignment(Pos.CENTER_RIGHT);
			//txfresult.setOnMouseClicked(this::handleLockResult);

			scorePane.add(lblresult, 0, i);
			scorePane.add(txfresult, 1, i);
			this.txfResults[i] = txfresult;
		}

		String[][] lbls = {{"sum:", "Bonus:"}, {"sum", "Total"}};
		int[] rows = {5, 14};
		this.txfSumBonusSumTotal = new TextField[4];

		for (int row = 0; row < rows.length; row++) {
			for (int col = 0; col < lbls.length; col++) {
				Label lbl = new Label(lbls[row][col]);
				lbl.setFont(new Font(10));

				TextField txf = new TextField("0");
				txf.setEditable(false);
				txf.setPrefSize(w, 22);
				txf.setFont(new Font(10));
				txf.setAlignment(Pos.CENTER_RIGHT);

				txf.setStyle("-fx-font-weight: bold; -fx-text-fill: blue; -fx-font-size: 7pt;");

				scorePane.add(lbl, col * 2 + 2, rows[row]);
				scorePane.add(txf, col * 2 + 3, rows[row]);
				this.txfSumBonusSumTotal[row * 2 + col] = txf;

			}

		}
		Arrays.fill(this.lockedResults, 1);
	}

	// -------------------------------------------------------------------------

	private Yatzy dice = new Yatzy();

	// Create a method for btnRoll's action.
	// Hint: Create small helper methods to be used in the action method.
	// TODO
	private void handleBtnRoll() {

		this.throwDice();

		this.updateValues();

	}

	private void throwDice(){
		boolean[] holds = new boolean[5];
		for (int i = 0; i < holds.length; i++) holds[i] = this.chbHolds[i].isSelected();
		this.dice.throwDice(holds);
	}

	private void updateValues() {
		int [] faceValues = this.dice.getValues();

		for (int i = 0; i < faceValues.length; i++) this.txfValues[i].setText(Integer.toString(faceValues[i]));
		this.lblRolled.setText("Rolled " + this.dice.getThrowCount());
	}

	private void rollAndHoldsDisabled (boolean shouldBeDisabled) {
		this.btnRoll.setDisable(shouldBeDisabled);
		for (CheckBox cnbHold : this.chbHolds) cnbHold.setDisable(shouldBeDisabled);
	}

	private void updateResults() {
		int[] results = this.dice.getResults();
		for (int i = 0; i < results.length; i++) {
			if (this.lockedResults[i] == -1) {
				this.txfResults[i].setText(Integer.toString(results[i]));
				this.txfResults[i].setDisable(false);
			} else {
				this.txfResults[i].setDisable(true);
			}
		}
	}



	// -------------------------------------------------------------------------

	// Create a method for mouse click on one of the text fields in txfResults.
	// Hint: Create small helper methods to be used in the mouse click method.
	// TODO

	private int findTxfIndex (TextField txf) {
		for (int i = 0; i < this.txfResults.length; i++) {
			if (this.txfResults[i] == txf) return i;
		}
		return -1;
	}



	private void updateSums () {

	}

}
