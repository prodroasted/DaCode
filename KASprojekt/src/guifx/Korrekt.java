package guifx;

import application.controller.Controller;
import application.model.Deltager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Korrekt extends Stage {

    public Korrekt(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private TextArea txaOk;

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        txaOk = new TextArea();
        pane.add(txaOk, 0, 0);
        txaOk.setPrefHeight(200);
        txaOk.setPrefWidth(200);
        txaOk.setEditable(false);


        Button btnAccept = new Button("Accepter");
        pane.add(btnAccept, 2, 1);

        Button btnEdit = new Button("Edit");
        pane.add(btnEdit, 3, 1);


    }

}

