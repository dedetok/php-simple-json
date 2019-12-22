import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import myca.dedetok.com.MyConnection;

public class test {

	public static void main(String[] args) {
		HashMap<String, String> mHM = new HashMap<String,String>();
		mHM.put("like", "besi");
		
		MyConnection mCon = new MyConnection();
		String mUrlStr = "http://garasiku.web.id/web/joomla/index.php";
		String mUrlStrS = "https://garasiku.web.id/web/joomla/index.php";
		try {
			System.out.println("--GET--");
			System.out.println("http: "+mCon.getHttp(mUrlStr, null));
			//System.out.println("http: "+mCon.getHttps(mUrlStr, mHM));
			System.out.println("https: "+mCon.getHttps(mUrlStrS, null));
			//System.out.println("https: "+mCon.getHttps(mUrlStrS, mHM));
			System.out.println("--POST--");
			System.out.println("http: "+mCon.postHttp(mUrlStr, null));
			System.out.println("https: "+mCon.postHttps(mUrlStrS, null));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
  
}
