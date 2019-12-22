package myca.dedetok.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class MyConnection {

	URL mUrl;
	HttpURLConnection mHttpURLConnection;
	HttpsURLConnection mHttpsURLConnection;

	/**
	 * 
	 * @param mUrlStr: url string
	 * @param mHM: data parameter
	 * @return: html text
	 * @throws IOException
	 */
	public String getHttp(String mUrlStr, HashMap<String,String> mHM) throws IOException {
		StringBuilder mSB = new StringBuilder();
		mSB.append(mUrlStr);
		if (mHM!=null) {
			mSB.append("?");
			for (Map.Entry<String, String> item : mHM.entrySet()) {
				mSB.append(item.getKey());
				mSB.append("=");
				mSB.append(item.getValue());
				mSB.append("&");
			}
			
		}
		
		// 1 Create Url connection 
		mUrl = new URL(mSB.toString());
        
		// 2 Retrieve the URLConnection object
		mHttpURLConnection = (HttpURLConnection) mUrl.openConnection();

		// 3 Set output capability on the URLConnection
		mHttpURLConnection.setRequestMethod("GET");
		mHttpURLConnection.setDoOutput(true);
		
		// 4 Get an output stream from the connection
		OutputStreamWriter out = new OutputStreamWriter(mHttpURLConnection.getOutputStream());
		out.close();

		// 5 Get an Input Stream from the connection
		InputStream mIS = mHttpURLConnection.getInputStream();
		
		return readIt(mIS);
	}
	
	/**
	 * 
	 * @param mUrlStr: url string
	 * @param mHM: data parameter
	 * @return: html text
	 * @throws IOException
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public String getHttps(String mUrlStr, HashMap<String,String> mHM) throws IOException, NoSuchAlgorithmException, KeyManagementException {
		StringBuilder mSB = new StringBuilder();
		mSB.append(mUrlStr);
		if (mHM!=null) {
			mSB.append("?");
			for (Map.Entry<String, String> item : mHM.entrySet()) {
				mSB.append(item.getKey());
				mSB.append("=");
				mSB.append(item.getValue());
				mSB.append("&");
			}
			
		}
		
		// 1 Create Url connection 
		mUrl = new URL(mSB.toString());
		
		// 2 Retrieve the URLConnection object
		mHttpsURLConnection = (HttpsURLConnection) mUrl.openConnection();
		
	        /** 20191205**/
	        //Log.i("DEBUG", "start hack"); // debug
	        //  add TLS version 1.2 support
	        //ProviderInstaller.installIfNeeded(getApplicationContext()); // java android
	        SSLContext sslContext;
		sslContext = SSLContext.getInstance("TLSv1.2");
	        sslContext.init(null, null, null);
	        sslContext.createSSLEngine();
	        mHttpsURLConnection.setSSLSocketFactory(sslContext.getSocketFactory());
	        //Log.i("DEBUG", "end hack"); // debug
		
		// 3 Set output capability on the URLConnection
		mHttpsURLConnection.setRequestMethod("GET");
		mHttpsURLConnection.setDoOutput(true);
		
		// 4 Get an output stream from the connection
		OutputStreamWriter out = new OutputStreamWriter(mHttpsURLConnection.getOutputStream());
		out.close();

		// 5 Get an Input Stream from the connection
		InputStream mIS = mHttpsURLConnection.getInputStream();
		
		return readIt(mIS);
	}	
	
	/**
	 * 
	 * @param mUrlStr: url string
	 * @param mHM: data parameter
	 * @return: html text
	 * @throws IOException
	 */
	public String postHttp(String mUrlStr, HashMap<String,String> mHM) throws IOException {
		StringBuilder mSB = new StringBuilder();
		mSB.append(mUrlStr);
		if (mHM!=null) {
			mSB.append("?");
			for (Map.Entry<String, String> item : mHM.entrySet()) {
				mSB.append(item.getKey());
				mSB.append("=");
				mSB.append(item.getValue());
				mSB.append("&");
			}
			
		}
		
		// 1 Create Url connection 
		mUrl = new URL(mUrlStr);
        
		// 2 Retrieve the URLConnection object
		mHttpURLConnection = (HttpURLConnection) mUrl.openConnection();

		// 3 Set output capability on the URLConnection
		mHttpURLConnection.setDoOutput(true);
		mHttpURLConnection.setRequestMethod("POST");
		
		// 4 Get an output stream from the connection
		OutputStreamWriter out = new OutputStreamWriter(mHttpURLConnection.getOutputStream());
		if (mSB!=null) {
			out.write("string=" + mSB.toString().getBytes());
		}
		out.close();

		// 5 Get an Input Stream from the connection
		InputStream mIS = mHttpURLConnection.getInputStream();
		
		return readIt(mIS);
	}
		
	/**
	 * 
	 * @param mUrlStr: url string
	 * @param mHM: data parameter
	 * @return: html text
	 * @throws IOException
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public String postHttps(String mUrlStr, HashMap<String,String> mHM) throws IOException, NoSuchAlgorithmException, KeyManagementException {
		StringBuilder mSB = new StringBuilder();
		mSB.append(mUrlStr);
		if (mHM!=null) {
			mSB.append("?");
			for (Map.Entry<String, String> item : mHM.entrySet()) {
				mSB.append(item.getKey());
				mSB.append("=");
				mSB.append(item.getValue());
				mSB.append("&");
			}
			
		}
		
		// 1 Create Url connection 
		mUrl = new URL(mUrlStr);
        
		// 2 Retrieve the URLConnection object
		mHttpURLConnection = (HttpURLConnection) mUrl.openConnection();

	        /** 20191205**/
	        //Log.i("DEBUG", "start hack"); // debug
	        //  add TLS version 1.2 support
	        //ProviderInstaller.installIfNeeded(getApplicationContext()); // java android
	        SSLContext sslContext;
		sslContext = SSLContext.getInstance("TLSv1.2");
	        sslContext.init(null, null, null);
	        sslContext.createSSLEngine();
	        mHttpsURLConnection.setSSLSocketFactory(sslContext.getSocketFactory());
	        //Log.i("DEBUG", "end hack"); // debug
		
		
		// 3 Set output capability on the URLConnection
		mHttpURLConnection.setDoOutput(true);
		mHttpURLConnection.setRequestMethod("POST");
		
		// 4 Get an output stream from the connection
		OutputStreamWriter out = new OutputStreamWriter(mHttpURLConnection.getOutputStream());
		if (mSB!=null) {
			out.write("string=" + mSB.toString().getBytes());
		}
		out.close();

		// 5 Get an Input Stream from the connection
		InputStream mIS = mHttpURLConnection.getInputStream();
		
		return readIt(mIS);
	}
	
    // Reads an InputStream and converts it to a String.
    private String readIt(InputStream stream) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            total.append(line);
        }
        return total.toString();
    }

}
