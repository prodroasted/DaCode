package Opgave3;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PersonInputWindow extends Stage {

    public PersonInputWindow(Stage stage) {

        stage.setTitle("ListView Demo3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfTitel = new TextField();
    private final CheckBox cbSenior = new CheckBox("Senior");


    private void initContent(GridPane pane) {

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblTitel = new Label("Titel");
        pane.add(lblTitel, 0, 1);

        pane.add(txfName, 1, 0, 2, 1);
        pane.add(txfTitel, 1, 1, 2, 1);
        pane.add(cbSenior, 1, 3);

        Button btnAdd = new Button("Add Person");
        pane.add(btnAdd, 6, 3);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());


    }

    private void addAction() {

        String name = txfName.getText().trim();
        String titel = txfTitel.getText().trim();

        if (name.length() > 0 && titel.length() > 0) {
            Person p = new Person(titel, name, cbSenior.isSelected());
            persons.add(p);
            lvwPersons.getItems().setAll(persons);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Please be sure, that both Name and Titel is given");
            alert.show();
        }
    }

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getFirstName());
        } else {
            txfName.clear();
        }
    }


    // -------------------------------------------------------------------------
    // Selection changed action


}

