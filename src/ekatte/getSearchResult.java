package ekatte;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class getSearchResult {
	public static String getSearchresults(String str) throws Exception{
		 
	      //Creating a HttpClient object
	      CloseableHttpClient httpclient = HttpClients.createDefault();

	      //Creating a HttpGet object
	      HttpGetWithEntity httpget = new HttpGetWithEntity("http://borisvelkovski.com:5000/get-data");
	      httpget.setHeader("Accept", "application/json; charset=UTF-8");
	      httpget.setHeader("Content-type", "application/json");
          String json = "{ \"name\":\""+str+"\"}";
          System.out.println(json);
          StringEntity stringEntity = new StringEntity(json, "UTF-8");
	      httpget.setEntity(stringEntity);
	      //Printing the method used
	      System.out.println("Request Type: "+httpget.getMethod());

	      //Executing the Get request
	      HttpResponse httpresponse = httpclient.execute(httpget);

	      Scanner sc = new Scanner(httpresponse.getEntity().getContent());

	      //Printing the status line
	      System.out.println(httpresponse.getStatusLine());
	      while(sc.hasNext()) {
	         return sc.nextLine();
	      }
	      return "Error";
	   }
}
