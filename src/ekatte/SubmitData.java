package ekatte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SubmitData {

	private static URL url;
	
	public SubmitData() throws MalformedURLException {
	}
	public static void submitData(oblastiData oblData, obstiniData obsData, selistaData selData) throws IOException{
		 try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
	            HttpPost httpPost = new HttpPost("http://borisvelkovski.com:5000/save-oblasti");
	            httpPost.setHeader("Accept", "application/json; charset=UTF-8");
	            httpPost.setHeader("Content-type", "application/json");
	            System.out.println(obsData.toJsonString());
	            String json = "{\"data\": {\"oblasti\":"+oblData.toJsonString()+
	            		",\"obstini\":"+obsData.toJsonString()+
	            		",\"selista\":"+selData.toJsonString()+"}}";
	            StringEntity stringEntity = new StringEntity(json, "UTF-8");
	            httpPost.setEntity(stringEntity);
	            //System.out.println("Executing request " + httpPost.getRequestLine());
	            //System.out.println(selData.toJsonString());
	            // Create a custom response handler
	            ResponseHandler < String > responseHandler = response -> {
	                int status = response.getStatusLine().getStatusCode();
	                if (status >= 200 && status < 405) {
	                    HttpEntity entity = response.getEntity();
	                    return entity != null ? EntityUtils.toString(entity) : null;
	                } else {
	                    throw new ClientProtocolException("Unexpected response status: " + status);
	                }
	            };
	            String responseBody = httpclient.execute(httpPost, responseHandler);
	            System.out.println("----------------------------------------");
	            System.out.println(responseBody);
	        }
	}
}

//{"data": {"oblasti":[{"oblast":"BLG","ekatte":"04279","name":"Благоевград","region":"BG41","document":"1896","abc":"1"},{"oblast":"BGS","ekatte":"07079","name":"Бургас","region":"BG34","document":"1678","abc":"2"},{"oblast":"VAR","ekatte":"10135","name":"Варна","region":"BG33","document":"1896","abc":"3"},{"oblast":"VTR","ekatte":"10447","name":"Велико Търново","region":"BG32","document":"1896","abc":"4"},{"oblast":"VID","ekatte":"10971","name":"Видин","region":"BG31","document":"1896","abc":"5"},{"oblast":"VRC","ekatte":"12259","name":"Враца","region":"BG31","document":"1483","abc":"6"},{"oblast":"GAB","ekatte":"14218","name":"Габрово","region":"BG32","document":"1483","abc":"7"},{"oblast":"DOB","ekatte":"72624","name":"Добрич","region":"BG33","document":"1483","abc":"8"},{"oblast":"KRZ","ekatte":"40909","name":"Кърджали","region":"BG42","document":"1483","abc":"9"},{"oblast":"KNL","ekatte":"41112","name":"Кюстендил","region":"BG41","document":"1483","abc":"10"},{"oblast":"LOV","ekatte":"43952","name":"Ловеч","region":"BG31","document":"1896","abc":"11"},{"oblast":"MON","ekatte":"48489","name":"Монтана","region":"BG31","document":"1483","abc":"12"},{"oblast":"PAZ","ekatte":"55155","name":"Пазарджик","region":"BG42","document":"1862","abc":"13"},{"oblast":"PER","ekatte":"55871","name":"Перник","region":"BG41","document":"1483","abc":"14"},{"oblast":"PVN","ekatte":"56722","name":"Плевен","region":"BG31","document":"1483","abc":"15"},{"oblast":"PDV","ekatte":"56784","name":"Пловдив","region":"BG42","document":"1483","abc":"16"},{"oblast":"RAZ","ekatte":"61710","name":"Разград","region":"BG32","document":"1483","abc":"17"},{"oblast":"RSE","ekatte":"63427","name":"Русе","region":"BG32","document":"1896","abc":"18"},{"oblast":"SLS","ekatte":"66425","name":"Силистра","region":"BG32","document":"1483","abc":"19"},{"oblast":"SLV","ekatte":"67338","name":"Сливен","region":"BG34","document":"1896","abc":"20"},{"oblast":"SML","ekatte":"67653","name":"Смолян","region":"BG42","document":"1483","abc":"21"},{"oblast":"SFO","ekatte":"68134","name":"София","region":"BG41","document":"1483","abc":"22"},{"oblast":"SOF","ekatte":"68134","name":"София (столица)","region":"BG41","document":"1483","abc":"23"},{"oblast":"SZR","ekatte":"68850","name":"Стара Загора","region":"BG34","document":"1896","abc":"24"},{"oblast":"TGV","ekatte":"73626","name":"Търговище","region":"BG33","document":"1483","abc":"25"},{"oblast":"HKV","ekatte":"77195","name":"Хасково","region":"BG42","document":"1896","abc":"26"},{"oblast":"SHU","ekatte":"83510","name":"Шумен","region":"BG33","document":"1896","abc":"27"},{"oblast":"JAM","ekatte":"87374","name":"Ямбол","region":"BG34","document":"1483","abc":"28"},],"obstini":"Test","selista":"Test"}}

/*"{\"data\": {\"oblasti\":"+oblData.toJsonString()+
",\"obstini\":"+obsData.toJsonString()+
",\"selista\":"+selData.toJsonString()+"}}";*/

