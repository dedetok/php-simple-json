package myca.dedetok.com;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

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

		// get response
		int responseCode = mHttpURLConnection.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode); // debug
		
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
		
		// 2020 01 04
		// manual add certificate string
		try {
			mHttpsURLConnection.setSSLSocketFactory(createSSLContext().getSocketFactory());
		} catch (CertificateException | KeyStoreException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		// 3 Set output capability on the URLConnection
		mHttpsURLConnection.setRequestMethod("GET");
		mHttpsURLConnection.setDoOutput(true);
		
		// 4 Get an output stream from the connection
		OutputStreamWriter out = new OutputStreamWriter(mHttpsURLConnection.getOutputStream());
		out.close();

		// get response
		int responseCode = mHttpsURLConnection.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode); // debug

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
		if (!mSB.toString().isEmpty()) {
			out.write("string=" + mSB.toString().getBytes());
		}
		out.close();

		// get response
		int responseCode = mHttpURLConnection.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode); // debug

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
		mHttpsURLConnection = (HttpsURLConnection) mUrl.openConnection();

		// 2020 01 04
		// manual add certificate string
		try {
			mHttpsURLConnection.setSSLSocketFactory(createSSLContext().getSocketFactory());
		} catch (CertificateException | KeyStoreException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		// 3 Set output capability on the URLConnection
		mHttpsURLConnection.setDoOutput(true);
		mHttpsURLConnection.setRequestMethod("POST");
		
		// 4 Get an output stream from the connection
		OutputStreamWriter out = new OutputStreamWriter(mHttpsURLConnection.getOutputStream());
		if (mHM!=null) {
			out.write(mSB.toString());
		}
		out.flush();
		out.close();

		// get response
		int responseCode = mHttpsURLConnection.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode); // debug

		// 5 Get an Input Stream from the connection
		InputStream mIS = mHttpsURLConnection.getInputStream();
		
		return readIt(mIS);
	}

	/*
	 * sample certificate string garasiku.web.id
	 * export or copy paste your certificate string from browser
	 */
	String certString = "-----BEGIN CERTIFICATE-----\r\n" + 
			"MIIGTTCCBTWgAwIBAgIQYwFvKKkENw6AprzeTBQWoDANBgkqhkiG9w0BAQsFADBy\r\n" + 
			"MQswCQYDVQQGEwJVUzELMAkGA1UECBMCVFgxEDAOBgNVBAcTB0hvdXN0b24xFTAT\r\n" + 
			"BgNVBAoTDGNQYW5lbCwgSW5jLjEtMCsGA1UEAxMkY1BhbmVsLCBJbmMuIENlcnRp\r\n" + 
			"ZmljYXRpb24gQXV0aG9yaXR5MB4XDTE5MTExMDAwMDAwMFoXDTIwMDIwODIzNTk1\r\n" + 
			"OVowGjEYMBYGA1UEAxMPZ2FyYXNpa3Uud2ViLmlkMIIBIjANBgkqhkiG9w0BAQEF\r\n" + 
			"AAOCAQ8AMIIBCgKCAQEAyO2lGVYVAUE/KNuIds4tg1aG3FsDURt+Qn/dN3Fc00G3\r\n" + 
			"rj8+afglg64J7gOL+FR+3o11W+rPffRiN62PAHOTQH5A3b4poIEsFJf6SDTNAuvo\r\n" + 
			"v+fffSG8AdjBDtR/G3s994HruhOkX19ucn/0HpxAXD1W3arTSKKdA8ZdQwMqZtNT\r\n" + 
			"1wEujfHt3LEYDL7rDE2crqOw+6H05kJV7kzDPjoMjjGE7AiUlDA//t1okQrWft/9\r\n" + 
			"soG1Tb7+W29clqZ7UzEeWyFGldknDhGf7vsth0Uz3QAOsqihs+ZcmEsnzLA1vgtj\r\n" + 
			"VZcXj49RBCSaHEKUTIEGsTlZZIA8VNt6nXkjnR2WLwIDAQABo4IDNTCCAzEwHwYD\r\n" + 
			"VR0jBBgwFoAUfgNaZUFrp34K4bidCOodjh1qx2UwHQYDVR0OBBYEFKamNJ13mwWn\r\n" + 
			"rXhh4JobK8WM1UO0MA4GA1UdDwEB/wQEAwIFoDAMBgNVHRMBAf8EAjAAMB0GA1Ud\r\n" + 
			"JQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjBJBgNVHSAEQjBAMDQGCysGAQQBsjEB\r\n" + 
			"AgI0MCUwIwYIKwYBBQUHAgEWF2h0dHBzOi8vc2VjdGlnby5jb20vQ1BTMAgGBmeB\r\n" + 
			"DAECATBMBgNVHR8ERTBDMEGgP6A9hjtodHRwOi8vY3JsLmNvbW9kb2NhLmNvbS9j\r\n" + 
			"UGFuZWxJbmNDZXJ0aWZpY2F0aW9uQXV0aG9yaXR5LmNybDB9BggrBgEFBQcBAQRx\r\n" + 
			"MG8wRwYIKwYBBQUHMAKGO2h0dHA6Ly9jcnQuY29tb2RvY2EuY29tL2NQYW5lbElu\r\n" + 
			"Y0NlcnRpZmljYXRpb25BdXRob3JpdHkuY3J0MCQGCCsGAQUFBzABhhhodHRwOi8v\r\n" + 
			"b2NzcC5jb21vZG9jYS5jb20wgZEGA1UdEQSBiTCBhoIPZ2FyYXNpa3Uud2ViLmlk\r\n" + 
			"ghZjcGFuZWwuZ2FyYXNpa3Uud2ViLmlkghRtYWlsLmdhcmFzaWt1LndlYi5pZIIX\r\n" + 
			"d2ViZGlzay5nYXJhc2lrdS53ZWIuaWSCF3dlYm1haWwuZ2FyYXNpa3Uud2ViLmlk\r\n" + 
			"ghN3d3cuZ2FyYXNpa3Uud2ViLmlkMIIBBAYKKwYBBAHWeQIEAgSB9QSB8gDwAHYA\r\n" + 
			"B7dcG+V9aP/xsMYdIxXHuuZXfFeUt2ruvGE6GmnTohwAAAFuUzNi8wAABAMARzBF\r\n" + 
			"AiAbXbHwluE3WNCuaDRm4LJ14nhviOaenKJm8+lDXX3xwwIhAMwZYecq6gb1aIkl\r\n" + 
			"hqCiXHJXhzRnfRTWj0a7Srv5iEieAHYAXqdz+d9WwOe1Nkh90EngMnqRmgyEoRIS\r\n" + 
			"hBh1loFxRVgAAAFuUzNi9QAABAMARzBFAiAnBf9n13w3nAS0Jw/R6rzOwwIlQcPv\r\n" + 
			"E6SJcfN8/FuoFAIhAPYow52uuEEt7SzFCxnws35AgRvtB6VKEk4WRb3SoBt7MA0G\r\n" + 
			"CSqGSIb3DQEBCwUAA4IBAQAropPbjHNwq+/91cdzmRPQW+fXVi4yroDzjggG+paL\r\n" + 
			"ul62XbpgWMeX4bjskEAuG0jbOiejAZFMMcdTGGIrmAw/ErcQ3U2AB4k3ilkOr5vr\r\n" + 
			"RX3dguPCDmZ12CDBpdSLfYVBKDQRXX/DNsuePr4vOS09XBMNJJdBBRvNW0jKh6Q+\r\n" + 
			"nRY/fmJSfRy9U7GF2QyGt9Ni2nphMwobW/UDOy0yHBEar0Fe+QP0sbmeNW9koCid\r\n" + 
			"gvDGs+Pm6tcG3KtcCpwGR1nWvFT6hvirYrxPbD3EzSBYzPBpD+LBZghe+06Ib8U9\r\n" + 
			"9Oug2n9mIHXsrSXDVXufaaOyWdch1yfAhuFWR5oEkZU3\r\n" + 
			"-----END CERTIFICATE-----";
	
	private SSLContext createSSLContext( ) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		// https://developer.android.com/training/articles/security-ssl
		// Load CAs from an InputStream
		// (could be from a resource or ByteArrayInputStream or ...)
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		// From https://www.washington.edu/itconnect/security/ca/load-der.crt
		//InputStream caInput = new BufferedInputStream(new FileInputStream("load-der.crt")); // load from file
		InputStream caInput = new ByteArrayInputStream(certString.getBytes("UTF-8"));
		Certificate ca;
		try {
		    ca = cf.generateCertificate(caInput);
		    //System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());
		} finally {
		    caInput.close();
		}

		// Create a KeyStore containing our trusted CAs
		String keyStoreType = KeyStore.getDefaultType();
		KeyStore keyStore = KeyStore.getInstance(keyStoreType);
		keyStore.load(null, null);
		keyStore.setCertificateEntry("ca", ca);

		// Create a TrustManager that trusts the CAs in our KeyStore
		String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
		tmf.init(keyStore);

		// Create an SSLContext that uses our TrustManager
		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, tmf.getTrustManagers(), null);

		return context;
		// Tell the URLConnection to use a SocketFactory from our SSLContext
		//URL url = new URL("https://certs.cac.washington.edu/CAtest/");
		//HttpsURLConnection urlConnection =
		//    (HttpsURLConnection)url.openConnection();
		//urlConnection.setSSLSocketFactory(context.getSocketFactory());
		//InputStream in = urlConnection.getInputStream();
		//copyInputStreamToOutputStream(in, System.out);
		
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
