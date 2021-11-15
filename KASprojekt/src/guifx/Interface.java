package guifx;

import application.controller.Controller;
import application.model.Deltager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Interface extends Application {

    @Override
    public void init(){
        Controller.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tilmelding");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private TextArea txaOk;

    private void initContent (GridPane pane){
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Buttons and textfield's

        TextArea txaWelcome = new TextArea();
        pane.add(txaWelcome, 0, 0);
        txaWelcome.setText("Velkommen til din tilmelding af miljøkonferencer! \n For at blive oprettet some en deltager, \n venligst tryk på ''Opret Deltager'' og udfyld formularen");
        txaWelcome.setEditable(false);

        Button btnOpret = new Button("Opret Deltager");
        pane.add(btnOpret, 0, 2);
        btnOpret.setOnAction(event -> createDeltager());

    }

    public void createDeltager (){
        OpretBrugerWindow create = new OpretBrugerWindow("Opret Tilmelding");
        create.showAndWait();

    }
}