package demo3listview;

import java.util.ArrayList;
import java.util.Optional;

import com.sun.javafx.image.BytePixelSetter;
import demoopenwindow.Movie;
import demoopenwindow.MovieInputWindow;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

  
    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfTitel = new TextField();
    private final CheckBox cbSenior = new CheckBox("Senior");

    private void initContent(GridPane pane) {
        this.initPersons();

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

        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 4);

        Label lblTitel = new Label("Titel");
        pane.add(lblTitel, 0, 1);

        pane.add(txfName, 1, 0, 2, 1);
        pane.add(txfTitel, 1, 1, 2, 1);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 4, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        pane.add(cbSenior, 1, 3);

        Button btnAdd = new Button("Add Person");
        pane.add(btnAdd, 6, 3);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

    }

    // -------------------------------------------------------------------------
    // Button actions

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

    private void deleteAction() {
        int index = lvwPersons.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            persons.remove(index);
            txfName.clear();
            lvwPersons.getItems().setAll(persons);
        }
    }

    private void initPersons() {
        persons.add(new Person("Doktor", "Jan",  true));
        persons.add(new Person("Underviser", "Hans", false));
        persons.add(new Person("Mekaniker", "Pia", true));
        persons.add(new Person("Landmand", "Søren",  false));
        persons.add(new Person("Politimand", "Birgitte",  false));
    }

    // -------------------------------------------------------------------------
    // Selection changed action

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getFirstName());
        } else {
            txfName.clear();
        }
    }
}
