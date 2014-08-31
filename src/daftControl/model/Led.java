package daftControl.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Led {
	int x;
	int y;
	private boolean lit;
	transient Circle c;
	
	public Led (int x, int y, Circle c) {
		this.x = x;
		this.y = y;
		this.lit = false;
		this.c = c;
		c.setOnMouseClicked((event) -> this.toggleLed());
	}
	
	private void toggleLed() {
		setLit(!lit);
	}
	
	public boolean isLit() {
		return lit;
	}
	
	public void setLit(boolean lit) {
		this.lit = lit;
		if (lit == true) {
			c.setFill(Color.BLUE);
			
			
		} else {
			c.setFill(Color.RED);
		}
	}
}
