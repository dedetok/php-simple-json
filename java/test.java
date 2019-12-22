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
			System.out.println("one ");
			System.out.println(mCon.getHttp(mUrlStr, null));
			//System.out.println(mCon.getHttp(mUrlStr, mHM));
			System.out.println("two");
			System.out.println(mCon.getHttps(mUrlStrS, null));
			//System.out.println(mCon.getHttps(mUrlStrS, mHM));
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
