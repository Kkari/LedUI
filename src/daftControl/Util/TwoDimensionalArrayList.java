package daftControl.Util;

import java.util.ArrayList;

public class TwoDimensionalArrayList<T> extends ArrayList<ArrayList<T>>{
	
	private static final long serialVersionUID = 2951902114880513661L;

	public void add (int index1, int index2,T element) {
		
		if (this.size() < index1 + 1) 
			while (this.size() != index1 + 1)
				this.add(new ArrayList<>());
		
		if (this.get(index1).size() < index2 + 1)
			while(this.get(index1).size() != index2 + 1)
				this.get(index1).add(null);
		
		this.get(index1).set(index2, element);
	}
	
	public T get(int index1, int index2) {
		return this.get(index1).get(index2);
	}
}
