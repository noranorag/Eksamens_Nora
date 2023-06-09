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
                JFrame frame = new JFrame("Jautājumi par ciklu ar skaitītāju");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 200);

                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                String[] jautajumi = {
                    "1?",
                    "2?",
                    "3?",
                    "4?",
                    "5?",
                    "6?",
                    "7?",
                    "8?",
                    "9?",
                    "10?"
                };

                String[][] opcijas = {
                    {"a", "b", "c", "d"},
                    {"a", "b", "c", "d"},
                    {"a", "b", "c", "d"},
                    {"a", "b", "c", "d"},
                    {"a", "b", "c", "d"},
                    {"a", "b", "c", "d"},
                    {"a", "b", "c", "d"},
                    {"a", "b", "c", "d"},
                    {"a", "b", "c", "d"},
                    {"a", "b", "c", "d"}
                };

                JLabel jautajumuLabel = new JLabel(jautajumi[0]);
                JCheckBox[] checkboxes = new JCheckBox[opcijas[0].length];
                JButton okPoga = new JButton("OK");

                panel.add(jautajumuLabel);
                for (int i = 0; i < checkboxes.length; i++) {
                    checkboxes[i] = new JCheckBox(opcijas[0][i]);
                    panel.add(checkboxes[i]);
                }
                panel.add(okPoga);

                String[] atbildes = new String[jautajumi.length];

                okPoga.addActionListener(new ActionListener() {
                    int indekssJaut = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        StringBuilder izveletasOpcijas = new StringBuilder();
                        for (int i = 0; i < checkboxes.length; i++) {
                            if (checkboxes[i].isSelected()) {
                                izveletasOpcijas.append(opcijas[indekssJaut][i]).append(" ");
                            }
                        }

                        if (izveletasOpcijas.toString().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Izvēlies vismaz vienu atbildi!");
                        } else {
                            atbildes[indekssJaut] = izveletasOpcijas.toString();

                            indekssJaut++;
                            if (indekssJaut < jautajumi.length) {
                                jautajumuLabel.setText(jautajumi[indekssJaut]);
                                for (int i = 0; i < checkboxes.length; i++) {
                                    checkboxes[i].setText(opcijas[indekssJaut][i]);
                                    checkboxes[i].setSelected(false);
                                }
                            } else {
                                JOptionPane.showMessageDialog(frame, "Survey completed!");
                                frame.dispose();

                                // Print answers
                                //for (int i = 0; i < questions.length; i++) {
                                    //System.out.println(questions[i] + ": " + answers[i]);
                                //}
                                System.out.println("dzivnieki - " + atbildes[0]);
                                System.out.println("\nfood - " + atbildes[1]);
                            }
                        }
                    }
                });

                frame.add(panel);
                frame.setVisible(true);
                
                
                
                
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
		
	

