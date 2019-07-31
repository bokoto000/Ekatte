package ekatte;
import java.util.ArrayList;

import ekatte.xlxsData;

public class selistaData extends xlxsData {
	
	public void setEnteties(ArrayList<String> newEnteties){
		enteties=newEnteties;
	}
	public String toJsonString() {
		int n = enteties.size();
		StringBuilder s = new StringBuilder();
		s.append("[");
		//System.out.println(enteties.toString());
		for(int i=24;i<n;i+=12) {
			//System.out.println(enteties.get(i));
			String ekatte = enteties.get(i);
			String t_v_m = enteties.get(i+1);
			String name = enteties.get(i+2);
			String oblast = enteties.get(i+3);
			String obstina = enteties.get(i+4);
			String kmetstvo = enteties.get(i+5);
			String kind = enteties.get(i+6);
			String category = enteties.get(i+7);
			String altitude = enteties.get(i+8);
			String document = enteties.get(i+9);
			String tsb = enteties.get(i+10);
			String abc = enteties.get(i+11);
			//System.out.println(abc);
			String json = "{\"ekatte\":\""+ekatte+"\"," +"\"t_v_m\":\""+t_v_m+"\","+"\"name\":\""+name+"\","
					+"\"oblast\":\""+oblast+"\","+"\"obstina\":\""+obstina+"\","+"\"kmetstvo\":\""+kmetstvo+"\","
					+"\"kind\":\""+kind+"\","+"\"category\":\""+category+"\","+"\"altitude\":\""+altitude+"\","
					+"\"document\":\""+document+"\","+"\"tsb\":\""+tsb+"\","+"\"abc\":\""+abc+"\"}";
			s.append(json);
			System.out.println(json);
			if(i!=n-12)s.append(",");
		}
		s.append("]");
		//System.out.println(s);
		return s.toString();
	}
}
