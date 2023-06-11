package eksamens;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class EksamenaDarbs {
	public static void main(String[] args) {
		
		String[] jautajumi = {
                "Kas ir cikls ar skaitītāju?",
                "Kādi parametri jānorāda for operātorā?",
                "Kāds svar būt cikla skaitītājs?",
                "Kāds var būt nosacījums pēc tā pārbaudes ciklā?",
                "Kuri no kodiem veido bezgalīgu ciklu?",
                "Kādas lietas iespējamas ar for cikla palīdzību?",
                "Kādas iekavas tiek lietotas for cikla pierakstīšanā?",
                "Kurus no šiem varētu ierakstīt jautājuma zīmes vietā? for(int ?=1; ?<=3; ?++)",
                "Kuri fakti par for ciklu ir pareizi?",
                "Kā izvairīties no bezgalīgā cikla?"
            };
		
		String[] atbildes = new String[jautajumi.length];
		
		String[][] opcijas = {
                {"Cikls, kura izpildes reižu skaits jau iepriekš ir zināms", "Cikls, kas nodrošina darbības kopas atkārtošanos vairākas reizes", "Cikls kura nosacījums tiek pārbaudīts katru reizi pirms tā darbības", "Cikls, kas nejaušu daudzumu reižu atkārtojas"},
                {"Mainīgā nosaukums", "Cikla mainīgā sākuma vērtība", "Rindiņu daudzums zem cikla", "Cikla beigu nosacījums"},
                {"Burtu virkne", "Viens simbols", "Vesels skaitlis", "Boolean"},
                {"Patiess", "Nepatiess", "Patiess un nepatiess reizē", "Neviens no minētajiem"},
                {"for(int i = 1; i<=10; --i)", "for(int i = 1; i<10; i++)", "for(int i = 1; i<=4; i++)", "for (;;)"},
                {"Aizpildīt masīvu ar skaitļiem", "Izvadīt masīvu", "Izprintēt skaitļus no 1-10", "Definēt mainīgos"},
                {"( )", "{ }", "[ ]", "Nevienas"},
                {"'kakis'", "i", "#", "l"},
                {"Ja nosacījums ir patiess, tas vienmēr izprintē '+'", "For cikls vienmēr atkārtojas 3 reizes", "For cikls darbību beidz, kad tā nosacījums ir nepatiess", "For cikls vienmēr izpilda nosacījumu vismaz 1 reizi"},
                {"Pareizi iestatīt sākuma vērtību", "Pareizi iestatīt nosacījumu", "Pareizi iestatīt iterācijas soli", "Ielikt for ciklu starp pēfiņām"}
            };
		
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
                frame.setSize(450, 200);

                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                

                JLabel jautajumuLabel = new JLabel(jautajumi[0]);
                JCheckBox[] checkboxes = new JCheckBox[opcijas[0].length];
                JButton okPoga = new JButton("OK");

                panel.add(jautajumuLabel);
                for (int i = 0; i < checkboxes.length; i++) {
                    checkboxes[i] = new JCheckBox(opcijas[0][i]);
                    panel.add(checkboxes[i]);
                }
                panel.add(okPoga);

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
                                JOptionPane.showMessageDialog(frame, "Tu pabeidzi!");
                                frame.dispose();
                                
                                System.out.println(atbildes[0]);
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
                JOptionPane.showMessageDialog(frame2, "Izdari šo 10 jautājumu testu un noskaidro, cik daudz tu \nzini par ciklu ar skaitītāju! Katra"
                		+ "pareizā atbilde tev dod\n +2 puntkus, bet katra nepareizā -1. Savus rezultātus \nun nepareizās atbildes vari apskatīt"
                		+ " sākuma ekrānā \nuzspiežot uz rezultātu pogas.");
                
            }
        });

        rezultatuPoga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame2, "Spēles rezultāti");
                
//                int punkti=0;
//                String str1 = "Cikls, kura izpildes reižu skaits jau iepriekš ir zināms Cikls, kas nodrošina darbības kopas atkārtošanos vairākas reizes";
//                for(int i=0; i<atbildes.length; i++) {
//                	if(atbildes[0].equals(str1)) {
//                		punkti = punkti +2;
//                	}
//                	
//                	
//                }
//                JOptionPane.showMessageDialog(frame2, punkti);
//                
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
		
	

