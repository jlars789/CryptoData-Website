package database;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DBUpdate implements Runnable {
	
	public static final String COINCAP_URL = "api.coincap.io";
	public static OkHttpClient client = new OkHttpClient();

	public DBUpdate() {
	}

	@Override
	public void run() {
		DBRunner.dataRefresh(getMassExchangeRate());
	}
	
	public static JSONArray getMassExchangeRate() {
		String url = "/v2/assets";
		Request request = buildCoinCapRequest(url);
		
		Response res=null;
		JSONArray arr = null;
		try {
			res = sendRequest(request);
			JSONObject par = new JSONObject(res.body().string());
			arr = par.getJSONArray("data");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static Request buildCoinCapRequest(String requestPath) {
		String url = "http://" +COINCAP_URL + requestPath + "?limit=400";
		Request request = new Request.Builder()
				.addHeader("Accept-Encoding", "deflate")
				.url(url)
				.build();
		return request;
	}
	
	public static Response sendRequest(Request request) throws IOException {
		Response response = client.newCall(request).execute();
		if(!response.isSuccessful()) {
			throw new IOException("API Call not successful. Error code: " + response.code() + ": " + response.message() + " " + response.body().string());
		} else {
			return response;
		}
	}

}
