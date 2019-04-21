package controller;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Transition {
	public void smoothScaleUp(Node image) {
		ScaleTransition st = new ScaleTransition(Duration.millis(30), image);
		st.setFromX(1.0f);
		st.setFromY(1.0f);
		st.setToX(1.1f);
		st.setToY(1.1f);
		st.play();
	}
	
	public void smoothScaleUp(Node image, float from, float to) {
		ScaleTransition st = new ScaleTransition(Duration.millis(30), image);
		st.setFromX(from);
		st.setFromY(from);
		st.setToX(to);
		st.setToY(to);
		st.play();
	}
	
	public void smoothScaleDown(Node image) {
		ScaleTransition st = new ScaleTransition(Duration.millis(30), image);
		st.setFromX(1.1f);
		st.setFromY(1.1f);
		st.setToX(1.0f);
		st.setToY(1.0f);
		st.play();
	}
	
	public void smoothScaleDown(Node image, float from, float to) {
		ScaleTransition st = new ScaleTransition(Duration.millis(30), image);
		st.setFromX(from);
		st.setFromY(from);
		st.setToX(to);
		st.setToY(to);
		st.play();
	}
}
