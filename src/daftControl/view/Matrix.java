package daftControl.view;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import daftControl.Util.TwoDimensionalArrayList;

public class Matrix {

	private GridPane matrix;
	
	TwoDimensionalArrayList<Circle> circles = new TwoDimensionalArrayList<Circle>();
	
	static final double MATRIX_GAP = 7;
	static final int MATRIX_HEIGHT = 5;
	static final int MATRIX_WIDTH = 5;
	static final double LED_RADIUS = 7;
	
	public void initializeMatrix(Group mainGroup){
		
		matrix = new GridPane();
		matrix.setVgap(MATRIX_GAP);
		matrix.setHgap(MATRIX_GAP);
		
		mainGroup.getChildren().clear();
		mainGroup.getChildren().add(matrix);
		
		for(int i = 0; i < MATRIX_WIDTH; i++) {
			for(int j = 0; j < MATRIX_HEIGHT; j++) {
				Circle c = new Circle(LED_RADIUS,Color.RED);
				circles.add(i, j, c);
				matrix.add(c, i, j);
			}
		}
	}
}
