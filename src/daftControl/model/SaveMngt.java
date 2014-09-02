package daftControl.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import daftControl.Util.TwoDimensionalArrayList;

public class SaveMngt {
	ArrayList<Led> activeLeds = new ArrayList<>();
	TwoDimensionalArrayList<Led> allLeds;
	public enum Pages {DESIGN , ANIMATION };
	public Pages page;
	
	public void save(TwoDimensionalArrayList<Led> allLeds) {
		this.allLeds = allLeds;
		
		switch (page) {
		case DESIGN:
			saveDesign();
			break;
		case ANIMATION:
			break;
		}
		
	}
	
	private void saveDesign() {
		saveLeds(allLeds);
		saveToFile(getNameAndLocation("Save Design"));
	}
	
	private File getNameAndLocation(String Title) {
		
		Stage saveStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(Title);
		
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("dsgn", "*.dsgn"));
		saveStage.show();
		
		File file = fileChooser.showSaveDialog(saveStage);
		
		saveStage.close();
		return file;
	}
	
	private void saveLeds(TwoDimensionalArrayList<Led> allLed) {
		for (ArrayList<Led> list : allLed) {
			for(Led ld : list) {
				if (ld.isLit() == true)
					activeLeds.add(ld);
			}
		}
	}
	
	private void saveToFile (File f) {
		
		try {
			FileOutputStream fs = new FileOutputStream(f);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			for(Led ld : activeLeds)
				os.writeObject(ld);
			os.close();
			fs.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
