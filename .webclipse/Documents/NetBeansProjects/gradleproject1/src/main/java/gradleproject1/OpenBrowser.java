/*
 *To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;

import javax.swing.JOptionPane;
import java.net.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author User
 */
public class OpenBrowser {
    
     public static void openURL(String url) {
		String osName = System.getProperty("os.name");
                ArrayList<String> proxies = new ArrayList<>();
                proxies.add("168.228.224.68");
                proxies.add("176.65.252.182");
                proxies.add("178.18.34.26");
                proxies.add("95.38.214.32");
                proxies.add("95.107.173.35");
                for (int i=0; i<proxies.size(); i++){
                
		try {
                    //Proxy proxy =new Proxy(Proxy.Type.HTTP, new InetSocketAddress("123.0.0.1",8080));
                    //URL urls = new URL(url);
                    //HttpURLConnection uc = (HttpURLConnection)urls.openConnection(proxy);
                   
                    System.setProperty("Http.proxyHost",proxies.get(i));
			if (osName.startsWith("Windows"))
                            
				Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler " + url);
                              

                              
                                //uc.connect();
			else {
				String[] browsers = { "firefox", "opera", "konqueror",
						"epiphany", "mozilla", "netscape" };
				String browser = null;
				for (int count = 0; count < browsers.length && browser == null; count++)
					if (Runtime.getRuntime().exec(
							new String[] { "which", browsers[count] })
							.waitFor() == 0)
						browser = browsers[count];
                                
				Runtime.getRuntime().exec(new String[] { browser, url });
                                
                                //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("123.0.0.1",8080));
                                //URL urls = new URL(url);
                               // HttpURLConnection uc = (HttpURLConnection)urls.openConnection(proxy);
                               // uc.connect();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in opening browser"
					+ ":\n" + e.getLocalizedMessage());
		}
                
                }
	}
    
}
