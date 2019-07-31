package ekatte;
import java.util.ArrayList;

import ekatte.xlxsData;

public class oblastiData extends xlxsData {
	
	public void setEnteties(ArrayList<String> newEnteties){
		enteties=newEnteties;
	}
	public String toJsonString() {
		int n = enteties.size();
		StringBuilder s = new StringBuilder();
		s.append("[");
		//System.out.println(enteties.toString());
		for(int i=12;i<n;i+=12) {
			//System.out.println(enteties.get(i));
			String oblast = enteties.get(i);
			String ekatte = enteties.get(i+1);
			String name = enteties.get(i+2);
			String region = enteties.get(i+3);
			String document = enteties.get(i+4);
			String abc = enteties.get(i+5);
			String json = "{\"oblast\":\""+oblast+"\"," +"\"ekatte\":\""+ekatte+"\","+"\"name\":\""+name+"\","
					+"\"region\":\""+region+"\","+"\"document\":\""+document+"\","+"\"abc\":\""+abc+"\"}";
			s.append(json);
			if(i!=n-12)s.append(",");
		}
		s.append("]");
		//System.out.println(s);
		return s.toString();
	}
}
