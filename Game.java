import javax.swing.*;
import javax.imageio.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.lang.*;

public class Game{
  Container gameDisplay;
  JLabel cookiesAmount;
  JButton cookieIncreaser;
  private int cookies = 0;
  
  Game(JFrame display){
    gameDisplay = display.getContentPane();
    gameDisplay.setLayout(new GridLayout(5, 1));
    cookiesAmount = new JLabel("Cookies: " + cookies);
    cookiesAmount.setHorizontalAlignment(JLabel.CENTER);
    cookieIncreaser = new JButton(); 
    cookieIncreaser.setBorder(null);
    cookieIncreaser.setContentAreaFilled(false);
    try {
      Image img = ImageIO.read(getClass().getResource("Cookie.png"));
    cookieIncreaser.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
    
    cookieIncreaser.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        System.out.println("chomp");
        cookies++;
    }});
    java.util.Timer progressUpdater = new java.util.Timer();
    progressUpdater.scheduleAtFixedRate(new TimerTask() {
      public void run() {
        cookiesAmount.setText("Cookies: " + cookies);
      }
    }, 0, 25);
    gameDisplay.add(cookiesAmount);
    gameDisplay.add(cookieIncreaser);
  }
  
}