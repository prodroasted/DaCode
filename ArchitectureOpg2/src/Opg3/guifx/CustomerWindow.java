package Opg3.guifx;

import Opg3.application.controller.Controller;
import Opg3.application.model.Company;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerWindow extends Stage {
    private final Opg3.application.model.Customer customer;

    public CustomerWindow(String title, Opg3.application.model.Customer customer) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.customer = customer;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public CustomerWindow(String title) {
        this(title, null);
    }

    private TextField txfName;
    private CheckBox chbCompany;
    private ComboBox<Company> cbbCompany;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        chbCompany = new CheckBox("Company");
        pane.add(chbCompany, 0, 4);
        ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> selectedCompanyChanged(newValue);
        chbCompany.selectedProperty().addListener(listener);

        cbbCompany = new ComboBox<>();
        pane.add(cbbCompany, 0, 5);
        cbbCompany.getItems().addAll(Controller.getCompanies());
        cbbCompany.setDisable(true);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 8);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        initControls();
    }

    private void initControls() {
        if (customer != null) {
            txfName.setText(customer.getName());
        } else {
            txfName.clear();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");

        } else {

            boolean companyIsSelected = chbCompany.isSelected();
            Company newCompany = cbbCompany.getSelectionModel().getSelectedItem();

                // Call application.application.controller methods
                if (customer != null) {
                    Controller.updateCustomer(customer, name);
                    if (companyIsSelected) {
                        Controller.addCustomerToCompany(customer, newCompany);
                    } else {
                        Controller.removeCustomerFromCompany(customer, newCompany);
                    }
                } else {
                    if (companyIsSelected) {
                        Controller.createCustomer(name);
                    } else {
                        Controller.createCustomer(name);
                    }
                }
                hide();
            }
        }

    // -------------------------------------------------------------------------

    private void selectedCompanyChanged(boolean checked) {
        cbbCompany.setDisable(!checked);
    }

}
