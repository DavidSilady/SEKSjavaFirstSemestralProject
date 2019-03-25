package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SceneController implements Switchable {
	public void setScene (javafx.event.ActionEvent actionEvent, String sceneName) throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/" + sceneName + ".fxml"));
		Parent signUpParent = loader.load();
		Scene signUpScene = new Scene(signUpParent);
		Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		
		window.setScene(signUpScene);
		window.show();
	}
	
	@Override
	public void switchStage (KeyEvent actionEvent, String sceneName) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + sceneName +".fxml"));
		((Node) actionEvent.getSource()).getScene().getWindow().hide();
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		//stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("SEKS | " + sceneName);
		stage.setScene(new Scene(root1, 1280, 720));
		stage.show();
	}
	
	public void switchStage (javafx.event.ActionEvent actionEvent, String sceneName) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + sceneName +".fxml"));
		((Node) actionEvent.getSource()).getScene().getWindow().hide();
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		//stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("SEKS | " + sceneName);
		stage.setScene(new Scene(root1, 1280, 720));
		stage.show();
	}
}
