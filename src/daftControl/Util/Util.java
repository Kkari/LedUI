package daftControl.Util;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Util {
	
	public enum kind {DESIGN, ANIMATION };
	public enum purpose {SAVE, OPEN};
	
	public interface FileChooserConfiguration {
		public void configure(FileChooser fc);
	}
	
	public static File getNameAndLocation(purpose prp, FileChooserConfiguration fcc) {
		
		Stage stage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fcc.configure(fileChooser);
		
		stage.show();
		
		File file;
		
		if(prp == purpose.OPEN)
			file = fileChooser.showOpenDialog(stage);
		else
			file = fileChooser.showSaveDialog(stage);
		
		stage.close();
		return file;
	}
	
}
