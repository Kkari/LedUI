package daftControl.view;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class MatrixController {
	
	private GridPane matrix;
	static final double MATRIX_GAP = 7;
	static final double LED_RADIUS = 7;
	
	public void initializeMatrix(Group mainGroup,int width, int height){
		
		matrix = new GridPane();
		matrix.setVgap(MATRIX_GAP);
		matrix.setHgap(MATRIX_GAP);
		
		mainGroup.getChildren().clear();
		mainGroup.getChildren().add(matrix);
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				Circle c = new Circle(LED_RADIUS,Color.RED);
				c.setOnMouseClicked((event) -> c.setFill(Color.BLUE));
				matrix.add(c, i, j);
			}
		}
	}
}
