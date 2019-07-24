package ekatte;
import java.util.ArrayList;

import ekatte.xlxsData;

public class oblastiData extends xlxsData {
	
	public void setEnteties(ArrayList<String> newEnteties){
		enteties=newEnteties;
	}
	public void toJsonString() {
		int n = enteties.size();
		for(int i=0;i<n;i++) {
			System.out.println(enteties.get(i));
		}
	}
}
