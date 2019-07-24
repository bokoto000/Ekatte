package ekatte;

import java.util.ArrayList;

public class xlxsData {
	protected ArrayList<String> enteties = new ArrayList<String>();
	private String path = new String();
	public String getPath() {
		return path;
	}
	public void setPath(String newPath) {
		this.path=newPath;
	}
	public void addData(String entity) {
		enteties.add(entity);
	}
	public int getSize() {
		return enteties.size();
	}
	public ArrayList<String> getEntities(){
		return enteties;
	}
}
