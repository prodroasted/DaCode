package Gui;

import Application.Controller.Controller;
import Application.Model.Hotel;
import Application.Model.Konference;
import Application.Model.Tilvalg;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class HotelPane extends GridPane {
    private Hotel selectedHotel;
    private Tilvalg shownTilvalg;
    private ListView<Hotel> lvwHoteller;
    private TextArea txaTilvalg;
    private Button btnOpretHotel;

    public HotelPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        lvwHoteller = new ListView<>();
        this.add(lvwHoteller, 0, 0);
        this.lvwHoteller.setPrefHeight(200);
        this.lvwHoteller.setPrefWidth(400);
        this.lvwHoteller.getItems().addAll(Controller.getHotels());

        ChangeListener<Hotel> listener = (ov, oldHotel, newHoteller) -> this.selectedHotelChange();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener);

        txaTilvalg = new TextArea();
        this.add(txaTilvalg, 1, 0);
        this.txaTilvalg.setPrefHeight(200);
        this.txaTilvalg.setPrefWidth(200);

        btnOpretHotel = new Button("Opret Hotel");
        this.add(btnOpretHotel, 1, 5);
        btnOpretHotel.setOnAction(event -> opretHotelWindow());

    }

    public void opretHotelWindow(){
        OpretHotelWindow opret = new OpretHotelWindow("Opret Hotel", selectedHotel, null);
        opret.showAndWait();

        lvwHoteller.getItems().setAll(Controller.getHotels());
        int Index = lvwHoteller.getItems().size() -1;
        lvwHoteller.getSelectionModel().select(Index);
    }

    public void updateControls() {
        this.selectedHotel = lvwHoteller.getSelectionModel().getSelectedItem();
        if (this.selectedHotel != null) {
            txaTilvalg.setText(this.selectedHotel.getTilvalg() + "\n");
        }
    }

    public void selectedHotelChange() {
        this.updateControls();
    }
}
