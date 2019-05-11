package controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Creates a pop up, that stops the application until an action is confirmed.
 * Usage: surround a body of code to be confirmed with
 * if(new ConfirmationPopUp.isConfirmed()) {
 *     //Body
 * }
 */
public class ConfirmationPopUp {
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private JFXButton cancelButton;
	
	@FXML
	private JFXButton hidePopUpButton;
	
	@FXML
	private Label typeLabel;
	
	@FXML
	private JFXButton confirmButton;
	private Boolean confirmed;
	
	public Boolean getConfirmed() {
		return this.confirmed;
	}
	public boolean isConfirmed() throws IOException {
		confirmed = false;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/confirmationPoPup.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(new Scene(root, 520, 220));
		stage.getScene().setFill(Color.TRANSPARENT);
		stage.showAndWait(); //waits for button input
		
		ConfirmationPopUp confirmationPopUp = fxmlLoader.getController();
		return confirmationPopUp.getConfirmed();
	}
	
	@FXML
	void initialize() {
		confirmed = false;
		cancelButton.setOnAction((ActionEvent event) -> {
			((Node) event.getSource()).getScene().getWindow().hide();
			confirmed = false;
		});
		confirmButton.setOnAction(event -> {
			((Node) event.getSource()).getScene().getWindow().hide();
			confirmed = true;
		});
	}
}

