package Opg3.guifx;

import Opg3.application.controller.Controller;
import Opg3.application.model.Company;
import Opg3.application.model.Customer;
import Opg3.application.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class CompanyPane extends GridPane {
	private TextField txfName, txfHours;
	private TextArea txaEmps, txaCus;
	private ListView<Company> lvwCompanies;

	public CompanyPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 0);

		lvwCompanies = new ListView<>();
		this.add(lvwCompanies, 0, 1, 1, 3);
		lvwCompanies.setPrefWidth(200);
		lvwCompanies.setPrefHeight(200);
		lvwCompanies.getItems().setAll(Controller.getCompanies());

		ChangeListener<Company> listener = (ov, oldCompny, newCompany) -> this.selectedCompanyChanged();
		lvwCompanies.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setEditable(false);

		Label lblHours = new Label("Weekly Hours:");
		this.add(lblHours, 1, 2);

		txfHours = new TextField();
		this.add(txfHours, 2, 2);
		txfHours.setEditable(false);

		Label lblEmps = new Label("Employees:");
		this.add(lblEmps, 1, 3);
		GridPane.setValignment(lblEmps, VPos.BASELINE);
		lblEmps.setPadding(new Insets(4, 0, 4, 0));

		txaEmps = new TextArea();
		this.add(txaEmps, 2, 3);
		txaEmps.setPrefWidth(200);
		txaEmps.setPrefHeight(100);
		txaEmps.setEditable(false);

		Label lblCus = new Label("Customers:");
		this.add(lblCus, 1, 4);
		GridPane.setValignment(lblCus, VPos.BASELINE);
		lblCus.setPadding(new Insets(4, 0, 4, 0));

		txaCus = new TextArea();
		this.add(txaCus, 2, 4);
		txaCus.setPrefWidth(200);
		txaCus.setPrefHeight(100);
		txaCus.setEditable(false);

		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 5, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		Button btnCreateCustomer = new Button("Create Customer");
		hbxButtons.getChildren().add(btnCreateCustomer);
		btnCreateCustomer.setOnAction(event -> this.CreateCustomer());

		if (lvwCompanies.getItems().size() > 0) {
			lvwCompanies.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		CompanyWindow dia = new CompanyWindow("Create Company");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwCompanies.getItems().setAll(Controller.getCompanies());
		int index = lvwCompanies.getItems().size() - 1;
		lvwCompanies.getSelectionModel().select(index);
	}

	private void updateAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {

			CompanyWindow dia = new CompanyWindow("Update Company", company);
			dia.showAndWait();

			// Wait for the modal dialog to close

			int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
			lvwCompanies.getItems().setAll(Controller.getCompanies());
			lvwCompanies.getSelectionModel().select(selectIndex);
		}
	}

	private void deleteAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {

			if (company.employeesCount() == 0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Delete Company");
				// alert.setContentText("Are you sure?");
				alert.setHeaderText("Are you sure?");
				Optional<ButtonType> result = alert.showAndWait();
				if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
					Controller.deleteCompany(company);
					lvwCompanies.getItems().setAll(Controller.getCompanies());
					this.updateControls();
				}

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Delete Company");
				alert.setHeaderText("Can't delete a company that has emlpoyees");
				// wait for the modal dialog to close
				alert.show();
			}
		}
	}

	private void CreateCustomer(){
		CustomerWindow newdia = new CustomerWindow("Create Customer");
		newdia.showAndWait();

		this.updateControls();

	}

	// -------------------------------------------------------------------------

	private void selectedCompanyChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			txfName.setText(company.getName());
			txfHours.setText("" + company.getHours());
			StringBuilder sb = new StringBuilder();
			for (Employee emp : company.getEmployees()) {
				sb.append(emp + "\n");
			}
			txaEmps.setText(sb.toString());
			StringBuilder sb2 = new StringBuilder();
			for (Customer cus : company.getCustomers()) {
				sb2.append(cus + "\n");
			}
			txaCus.setText(sb2.toString());
		} else {
			txfName.clear();
			txfHours.clear();
			txaEmps.clear();
			txaCus.clear();
		}
	}

}
