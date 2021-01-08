package my.learning.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;

public class RestClient {

	private String username;
	private String password;
	private int responseCode;
	private String response;
	
	public RestClient(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public RestClient() {
		// Empty constructor
	}
	
	public void connect(String endpointUrl, String method, String content) throws IOException{
		URL url = new URL(endpointUrl);
		URLConnection conn = null;
		responseCode = -1;
		response = null;
		try{
			conn = url.openConnection();				
			if(username!=null && password != null){
				byte[] bytes = (username + ":" + password).getBytes();
				conn.setRequestProperty("Authorization",  "Basic " + DatatypeConverter.printBase64Binary(bytes));
			}
			conn.setRequestProperty("Content-Type", "application/json");
			if(conn instanceof HttpURLConnection){
				HttpURLConnection httpConn = ((HttpURLConnection) conn);
				if(method.equalsIgnoreCase("PATCH")){
					httpConn.setRequestProperty("X-HTTP-Method-Override", "PATCH");
					httpConn.setRequestMethod("POST");
				}else{
					httpConn.setRequestMethod(method);
				}
			}else if(conn instanceof HttpsURLConnection){
				HttpsURLConnection httpsConn = ((HttpsURLConnection) conn);
				if(method.equalsIgnoreCase("PATCH")){
					httpsConn.setRequestProperty("X-HTTP-Method-Override", "PATCH");
					httpsConn.setRequestMethod("POST");
				}else{
					httpsConn.setRequestMethod(method);
				}
			}
			if(content != null){
				conn.setDoOutput(true);
				OutputStream os = conn.getOutputStream();
				os.write(content.getBytes());
				os.flush();
			}
			conn.connect();
			if(conn instanceof HttpURLConnection){
				responseCode  = ((HttpURLConnection) conn).getResponseCode();
			}else if(conn instanceof HttpsURLConnection){
				responseCode = ((HttpsURLConnection) conn).getResponseCode();
			}
			
			BufferedReader br = null;
			if(responseCode >= 400){
				if(conn instanceof HttpURLConnection){
					br  = new BufferedReader(new InputStreamReader(((HttpURLConnection) conn).getErrorStream()));
				}else if(conn instanceof HttpsURLConnection){
					br = new BufferedReader(new InputStreamReader(((HttpsURLConnection) conn).getErrorStream()));
				}
			}else{
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			StringBuffer sb = new StringBuffer();
			String readLine = null;
			while((readLine = br.readLine())!=null){
				sb.append(readLine).append("\n");
			}
			response = sb.toString();
		}finally{
			if(conn != null){
				if(conn instanceof HttpURLConnection){
					((HttpURLConnection) conn).disconnect();
				}else if(conn instanceof HttpsURLConnection){
					((HttpsURLConnection) conn).disconnect();
				}
			}
		}
	}
	
	public int getResponseCode() {
		return responseCode;
	}	

	public String getResponse() {
		return response;
	}
	
	public static void main(String[] args){
		RestClient rc = new RestClient("351199@voip.centurylink.com", "Portal@1");
		try {
			// GET Example
			rc.connect("http://lxomavd213.dev.qintra.com:1080/hvds/rest/users?groupId=a-146488", "GET", null);
			System.out.println("Response Code: " + rc.getResponseCode());
			System.out.println("Response: " + rc.getResponse());
			
			// POST Example
			String content = "{\"userId\": \"axkota2001002@voip.centurylink.com\",\"password\": \"Rest12@123\",\"vmpin\": \"\"}";
			rc.connect("http://lxomavd213.dev.qintra.com:1080/hvds/rest/users/password-vmpin", "POST", content);
			System.out.println("Response Code: " + rc.getResponseCode());
			System.out.println("Response: " + rc.getResponse());
			
			// PATCH Example
			content = "{\n    \"groupId\": \"a-146491\",\n    \"telephoneNumber\": \"3035140238\"\n}";
			rc.connect("http://voip-user-service-dev.kubeodc.corp.intranet/api/com/ctl/voip/service/autoAttendant/351199/a-146488/2062001004", "PATCH", content);
			System.out.println("Response Code: " + rc.getResponseCode());
			System.out.println("Response: " + rc.getResponse());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
