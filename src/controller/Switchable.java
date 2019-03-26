package controller;

import javafx.scene.input.KeyEvent;

import java.awt.event.ActionEvent;

public interface Switchable {
	void switchStage (KeyEvent actionEvent, String sceneName) throws Exception;
	void switchStage (javafx.event.ActionEvent actionEvent, String sceneName) throws Exception;
}