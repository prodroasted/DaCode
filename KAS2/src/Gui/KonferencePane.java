package Gui;

import Application.Controller.Controller;
import Application.Model.Konference;
import Application.Model.Tilmelding;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class KonferencePane extends GridPane {

    private ListView<Konference> lvwKonference;
    private TextArea txaTilmeldt, txaInfo;
    private Button btnVisDeltager, btnTilmeldKonf, btnOpretKonf;
    private Konference selectedKonference;
    private Tilmelding tilmelding;

    public KonferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        lvwKonference = new ListView<>();
        this.add(lvwKonference, 0, 1, 1, 3);
        lvwKonference.setPrefHeight(200);
        lvwKonference.setPrefWidth(400);
        lvwKonference.getItems().addAll(Controller.getKonference());

        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChange();
        lvwKonference.getSelectionModel().selectedItemProperty().addListener(listener);

        txaInfo = new TextArea();
        this.add(txaInfo, 1, 1);
        txaInfo.setPrefHeight(200);
        txaInfo.setPrefWidth(200);
        txaInfo.setEditable(false);

        btnVisDeltager = new Button("Vis Deltager");
        this.add(btnVisDeltager, 1, 2);
        btnVisDeltager.setVisible(false);
        btnVisDeltager.setOnAction(event -> deltagerWindow());

        btnTilmeldKonf = new Button("Tilmeld Konference");
        this.add(btnTilmeldKonf, 0, 5);
        btnTilmeldKonf.setDisable(true);
        btnTilmeldKonf.setOnAction(event -> tilmeldingsWindow());

        btnOpretKonf = new Button("Opret Konference");
        this.add(btnOpretKonf, 1, 5);
        btnOpretKonf.setOnAction(event -> opretKonferenceWindow());

    }

    public void tilmeldingsWindow() {
        Konference konference = lvwKonference.getSelectionModel().getSelectedItem();
        if (konference != null) {
            TilmeldWindow create = new TilmeldWindow("Opret Tilmelding", konference, null, null, null, tilmelding);
            create.showAndWait();
        }
    }

    public void opretKonferenceWindow() {
        OpretKonferenceWindow opret = new OpretKonferenceWindow("Opret Konference", selectedKonference);
        opret.showAndWait();

        lvwKonference.getItems().setAll(Controller.getKonference());
        int Index = lvwKonference.getItems().size() -1;
        lvwKonference.getSelectionModel().select(Index);
    }

    public void deltagerWindow(){
        Konference konference = lvwKonference.getSelectionModel().getSelectedItem();
        if(konference != null) {
            DeltagerWindow create = new DeltagerWindow("Se deltagere", konference, tilmelding);
            create.showAndWait();
        }

    }

    private void selectedKonferenceChange(){
        this.updateControls(); this.invisibleButton(); this.disabledButton();
    }

    public void disabledButton(){
        if (this.selectedKonference != null){
            btnTilmeldKonf.setDisable(false);
        }
    }

    public void updateControls() {
        this.selectedKonference = lvwKonference.getSelectionModel().getSelectedItem();
        if (this.selectedKonference != null){
            txaInfo.setText(selectedKonference.getNavn() + "\n" + "Lokation: " + selectedKonference.getLokation() + "\n" + "Pris: " + selectedKonference.getPris() + "\n" + "StartDato: " + selectedKonference.getStartDato() + "\n" + "SlutDato: " + selectedKonference.getSlutDato());
        }
    }

    public void invisibleButton(){

        if(this.selectedKonference != null){
            btnVisDeltager.setVisible(true);
        }
    }
}
