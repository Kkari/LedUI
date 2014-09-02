package daftControl.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Led {
	private int x;
	private int y;
	private transient boolean lit;
	private transient Circle c;
	
	public Led (int x, int y, Circle c) {
		this.setX(x);
		this.setY(y);
		this.lit = false;
		this.setC(c);
		c.setOnMouseClicked((event) -> this.toggleLed());
	}
	
	public Led (int x, int y) {
		this.x = x;
		this.y = y;
		this.lit = false;
		this.c = null;
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
			getC().setFill(Color.BLUE);
			
			
		} else {
			getC().setFill(Color.RED);
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Circle getC() {
		return c;
	}

	public void setC(Circle c) {
		this.c = c;
		setLit(lit);
	}
}
