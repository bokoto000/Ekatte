package ekatte;

public class FileData {
	
	private StringBuilder path;
	
	void setPath(String newPath) {
		StringBuilder newPathSB=new StringBuilder(newPath);
		path=newPathSB;
	}
	StringBuilder getPath() {
		return path;
	}

}
