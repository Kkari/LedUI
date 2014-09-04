package daftControl.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import daftControl.Util.TwoDimensionalArrayList;
import daftControl.Util.Util;
import daftControl.Util.Util.FileChooserConfiguration;
import daftControl.Util.Util.purpose;

//TODO: implement save and load in this class
//TODO: DesignSpace <- AnimationSpace inherit
public class DesignSpace implements Serializable{
	
	private static final long serialVersionUID = 4827084843402518502L;
	public ArrayList<Led>  activeLeds = new ArrayList<>();
	private transient TwoDimensionalArrayList<Led> allLeds = new TwoDimensionalArrayList<>();
	transient final static String EXTENSION = ".dsg";
	
	public DesignSpace(int width, int height) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				getAllLeds().add(i, j, new Led(i,j));
			}
		}
	}
	
	public void addColumn() {
		addColumn(allLeds.get(0).size());
	}
	
	public void addColumn(int height) {
		int temp = getAllLeds().size();
		for(int i = 0; i < height; i++) {
			getAllLeds().add(temp, i, new Led(temp, i));
		}
	}
	
	public void save() {
		getActiveLeds();
		File file = Util.getNameAndLocation(purpose.SAVE,new FileChooserConf("Save Design"));
		
		if(file == null) return;
		
		String file_name = file.toString();
		if (!file_name.endsWith(EXTENSION))
			file_name += EXTENSION;
		
		saveToFile(new File(file_name));
	}
	
	private void saveToFile (File f) {
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
			
			/*for(Led ld : activeLeds)
				os.writeObject(ld);*/
			os.writeObject(this);
			os.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private ArrayList<Led> getActiveLeds() {
		
		activeLeds.clear();
		
		for (ArrayList<Led> list : getAllLeds()) {
			for(Led ld : list) {
				if (ld.isLit() == true)
					activeLeds.add(ld);
			}
		}
		return activeLeds;
	}

	public TwoDimensionalArrayList<Led> getAllLeds() {
		return allLeds;
	}

	public void setAllLeds(TwoDimensionalArrayList<Led> allLeds) {
		this.allLeds = allLeds;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T extends DesignSpace> T loadFromFile() {
		
		File file = Util.getNameAndLocation(purpose.OPEN,new FileChooserConf("Open Design"));
		T dsp = null;
		
		try ( ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file))) {
				dsp = (T) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return dsp;
	}
	
	public void activeToAllLeds (int width, int height) {
		
		allLeds = new TwoDimensionalArrayList<>();
		int max = 0;
		
		for (Led ld : activeLeds) {
			if(ld.getX() > max)
				max = ld.getX();
		}
		
		while(allLeds.size() < Math.max(max, width))
			addColumn(height);
		
		for (Led ld : activeLeds) {
			allLeds.add(ld.getX(), ld.getY(), ld);
		}
	}
	
	private static class FileChooserConf implements FileChooserConfiguration {
		
		String title;
		
		public FileChooserConf(String title) {
			this.title = title;
		}
		
		@Override
		public void configure(FileChooser fc) {
			fc.setTitle(title);
			fc.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter(EXTENSION, "*" + EXTENSION));
		}
	}
}
