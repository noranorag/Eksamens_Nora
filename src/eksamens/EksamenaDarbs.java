package eksamens;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EksamenaDarbs {
	public static void main(String[] args) {
		JFrame frame2 = new JFrame("Sākums");
        //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(300, 200);

        JButton sakumaPoga = new JButton("Sākt");
        JButton instrukcijuPoga = new JButton("Instrukcijas");
        JButton rezultatuPoga = new JButton("Rezultāti");
        JButton aizvertPoga = new JButton("Aizvērt");

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 1));
        panel2.add(sakumaPoga);
        panel2.add(instrukcijuPoga);
        panel2.add(rezultatuPoga);
        panel2.add(aizvertPoga);

        sakumaPoga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame2, "Atbidli uz 10 jautājumiem un uzzini, cik labi tu zini par ciklu ar skaitītāju");
                
                
            }
        });

        instrukcijuPoga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame2, "Instrukcijas");
            }
        });

        rezultatuPoga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame2, "Spēles rezultāti");
            }
        });

        aizvertPoga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
            }
        });

        do {
            frame2.add(panel2);
            frame2.setVisible(true);
        } while (!aizvertPoga.getModel().isPressed());
    }
}
		
	

