/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Browser {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		final JTextField url = new JTextField(20);
                final JTextField proxy = new JTextField(20);
		JButton button = new JButton("Open Browser");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
				OpenBrowser.openURL(url.getText().trim(),
                                        proxy.getText().trim());
                            
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(new JLabel("URL:"));
		panel.add(url);
                panel.add(new JLabel("Proxy:"));
                panel.add(proxy);
		panel.add(button);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
        // TODO code application logic here
    }
    
}
