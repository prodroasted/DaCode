package guifx;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Hotel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class OpretBrugerWindow extends Stage {
    private Deltager deltager;

    public OpretBrugerWindow(String title){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private TextField txfNavn, txfAdresse, txfBy, txfLand,txfMobilNummer, txfFirmaNavn, txfSum;
    private Label lblError, lblNavn, lblAdresse, lblBy, lblLand, lblMobilNummer, lblFirmaNavn;
    private ComboBox<Hotel> ccbHotel;

    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        txfNavn = new TextField();
        pane.add(txfNavn, 1, 0);

        lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 0, 1);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 1, 1);

        lblBy = new Label("By:");
        pane.add(lblBy, 2, 1);

        txfBy = new TextField();
        pane.add(txfBy, 3, 1);

        lblLand = new Label("Land:");
        pane.add(lblLand, 4, 1);

        txfLand = new TextField();
        pane.add(txfLand, 5, 1);

        lblMobilNummer = new Label("Mobil Nummer:");
        pane.add(lblMobilNummer, 0, 2);

        txfMobilNummer = new TextField();
        pane.add(txfMobilNummer, 1, 2);

        lblFirmaNavn = new Label("Firma Navn:");
        pane.add(lblFirmaNavn, 2, 2);

        txfFirmaNavn = new TextField();
        pane.add(txfFirmaNavn, 3, 2);

        Label cblabel = new Label("Ledsager");
        pane.add(cblabel, 0, 4);
        CheckBox cbLedsager = new CheckBox();
        pane.add(cbLedsager, 0, 5);

        ccbHotel = new ComboBox<>();
        pane.add(ccbHotel, 1, 5);
        ccbHotel.getItems().addAll(Controller.getHotels());

        Label lblSum = new Label("Total:");
        pane.add(lblSum, 2, 6);

        txfSum = new TextField();
        pane.add(txfSum, 3, 6);
        txfSum.setEditable(false);


        Button ok = new Button("Accept");
        pane.add(ok, 3, 4);
        ok.setOnAction(event -> acceptAction());

        Button cancel = new Button("Cancel");
        pane.add(cancel, 4, 4);

        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        initControls();
    }

    public void acceptAction () {
        Korrekt korrekt = new Korrekt("Verificering");
        String navn = txfNavn.getText().trim();
        String adresse = txfAdresse.getText().trim();
        String by = txfBy.getText().trim();
        String land = txfLand.getText().trim();
        String firmaNavn = txfFirmaNavn.getText().trim();
        if (navn.length() == 0 || adresse.length() == 0 || by.length() == 0 || land.length() == 0) {
            lblError.setText("En af felterne mangler tekst");
        } else {
            int mobilNr = -1;
            try {
                mobilNr = Integer.parseInt(txfMobilNummer.getText().trim());
            } catch (NumberFormatException ex) {
                // Do nothing
            }
            if (mobilNr < 0) {
                lblError.setText("Mobil nummeret er ikke langt nok");
            }
            if (deltager != null) {
                Controller.updateDeltager(deltager, navn, adresse, by, land, firmaNavn, mobilNr);
            }
            korrekt.showAndWait();
        }
    }

    private void initControls(){
        if (deltager != null){
            txfNavn.setText(deltager.getNavn());
            txfAdresse.setText(deltager.getAdresse());
            txfLand.setText(deltager.getLand());
            txfBy.setText(deltager.getBy());
            txfMobilNummer.setText("" + deltager.getMobilnr());
        }
    }
}
