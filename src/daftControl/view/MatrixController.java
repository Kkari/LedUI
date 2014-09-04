package daftControl.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import daftControl.model.DesignSpace;
import daftControl.model.Led;

public class MatrixController {
	
	private int rightShift = 0;
	private Matrix m;
	private DesignSpace workspace;
	
	public void setWorkSpace(DesignSpace workspace) {
		this.workspace = workspace;
		remapCircles();
	}
	
	@FXML
	public void toolBarShiftRight() {
		rightShift++;
		
		if(workspace.getAllLeds().size() <= m.circles.size() + rightShift) {
			workspace.addColumn();
		}
		
		remapCircles();
	}
	
	@FXML
	public void toolBarShiftLeft() {
		if (rightShift != 0)
			rightShift--;
		remapCircles();
	}
	
	private void remapCircles() {
		
		for(int i = 0; i < m.circles.size(); i++) {
			for (int j = 0; j < m.circles.get(0).size(); j++) {
				bindCircleToLed(workspace.getAllLeds().get(i + rightShift, j), m.circles.get(i, j));
				syncCircle(workspace.getAllLeds().get(i + rightShift, j),m.circles.get(i, j));
			}
		}
	}
	
	private void bindCircleToLed(Led ld, Circle c) {
		c.setOnMouseClicked( new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent m) {
				ld.setLit(!ld.isLit());
				syncCircle(ld,c);
			}
		});
	}
	
	private void syncCircle(Led ld, Circle c) {
		if (ld.isLit())
			c.setFill(Color.BLUE);
		else
			c.setFill(Color.RED);
	}

	
	public MatrixController() {}

	public void setMatrix(Matrix m2) {
		this.m = m2;
	}
	
	
}
