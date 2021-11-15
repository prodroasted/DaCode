package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.text.DefaultEditorKit;
import java.awt.*;


public class NetCafeWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("NetCafe Administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private TextField txfNr;
    private CheckBox CBstandard, CBvip, CBbørn, CBturnering;
    private ComboBox Combopladser;

    private void initContent(GridPane pane){
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));

        pane.setHgap(10);

        pane.setVgap(10);


        Combopladser = new ComboBox();
        pane.add(Combopladser, 1, 0);

    }
}
