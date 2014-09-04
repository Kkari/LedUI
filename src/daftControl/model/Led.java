package daftControl.model;

import java.io.Serializable;

import javafx.scene.shape.Circle;

public class Led implements Serializable{

	private static final long serialVersionUID = -8754039049224836277L;
	private int x;
	private int y;
	private boolean lit;
	
	public Led (int x, int y, Circle c) {
		this.x = x;
		this.y = y;
		this.lit = false;
	}
	
	public Led (int x, int y) {
		this.x = x;
		this.y = y;
		this.lit = false;
	}

	public boolean isLit() {
		return lit;
	}
	
	public void setLit(boolean lit) {
		this.lit = lit;
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
}
