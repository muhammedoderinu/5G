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
import java.util.concurrent.TimeUnit;

/**
 *
 * @author User
 */
public class OpenBrowser {
    
     public static void openURL(String url, String proxy) {
		String osName = System.getProperty("os.name");
                ArrayList<String> proxies = new ArrayList<>();
                Process p;
                
		try {
                    
                   if(!proxy.isEmpty()){
                     System.getProperties().put("Http.proxyHost",proxy);
                       }
			if (osName.startsWith("Windows")){
                            p= Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler " + url);
                          for(int i=0;i<15;i++){
                              Proxy prox = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy, 8080));
                             URLConnection conn = new URL(url).openConnection(prox);
                         //URL myURL = new URL(url);
                      //URLConnection myURLConnection = myURL.openConnection();
                        //try (InputStream is = myURLConnection.getInputStream()) {}
                            }
                            
			
                        TimeUnit.SECONDS.sleep(30);
                        p.destroyForcibly();
                                    
                        
                        }else {
				String[] browsers = { "firefox","chrome", "opera", "konqueror",
						"epiphany", "mozilla", "netscape" };
				String browser = null;
				for (int count = 0; count < browsers.length && browser == null; count++)
					if (Runtime.getRuntime().exec(
							new String[] { "which", browsers[count] })
							.waitFor() == 0)
						browser = browsers[count];
                                
				p = Runtime.getRuntime().exec(new String[] { browser, url });
                                p.destroyForcibly();
                                p.exitValue();
                                p.destroy();
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
