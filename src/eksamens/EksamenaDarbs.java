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
                "Kāds var būt cikla skaitītājs?",
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
                {"a) Cikls, kura izpildes reižu skaits jau iepriekš ir zināms", "b) Cikls, kas nodrošina darbības kopas atkārtošanos vairākas reizes", "c) Cikls kura nosacījums tiek pārbaudīts katru reizi pirms tā darbības", "d) Cikls, kas nejaušu daudzumu reižu atkārtojas"},
                {"a) Mainīgā nosaukums", "b) Cikla mainīgā sākuma vērtība", "c) Rindiņu daudzums zem cikla", "d) Cikla beigu nosacījums"},
                {"a) Burtu virkne", "b) Viens simbols", "c) Vesels skaitlis", "d) Boolean"},
                {"a) Patiess", "b) Nepatiess", "c) Patiess un nepatiess reizē", "d) Neviens no minētajiem"},
                {"a)for(int i = 1; i<=10; --i)", "b) for(int i = 1; i<10; i++)", "c) for(int i = 1; i<=4; i++)", "d) for (;;)"},
                {"a) Aizpildīt masīvu ar skaitļiem", "b) Izvadīt masīvu", "c) Izprintēt skaitļus no 1-10", "d) Definēt mainīgos"},
                {"a) ( )", "b) { }", "c) [ ]", "d) Nevienas"},
                {"a) 'kakis'", "b) i", "c) #", "d) l"},
                {"a) Ja nosacījums ir patiess, tas vienmēr izprintē '+'", "b) For cikls vienmēr atkārtojas 3 reizes", "c)For cikls darbību beidz, kad tā nosacījums ir nepatiess", "d) For cikls vienmēr izpilda nosacījumu vismaz 1 reizi"},
                {"a) Pareizi iestatīt sākuma vērtību", "b) Pareizi iestatīt nosacījumu", "c)Pareizi iestatīt iterācijas soli", "d)Ielikt for ciklu starp pēfiņām"}
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
                int rezultats = 0;

                if (atbildes[0].contains("a)") && atbildes[0].contains("b)") && atbildes[0].contains("c)")) 
                	rezultats += 2;
                else
                	rezultats--;;
                
                if (atbildes[1].contains("a)") && atbildes[1].contains("b)") && atbildes[1].contains("d)")) 
                    rezultats += 2;
                else
                	rezultats--;

                if (atbildes[2].contains("b)") && atbildes[2].contains("c)")) 
                    rezultats += 2;
                else
                	rezultats--;

                if (atbildes[3].contains("a)") && atbildes[3].contains("b)")) {
                    rezultats += 2;
                }
                else
                	rezultats--;

                if (atbildes[4].contains("a)") && atbildes[4].contains("d)")) {
                    rezultats += 2;
                }
                else
                	rezultats--;

                if (atbildes[5].contains("a)") && atbildes[5].contains("b)") && atbildes[5].contains("c)")) {
                    rezultats += 2;
                }
                else
                	rezultats--;

                if (atbildes[6].contains("a)") && atbildes[6].contains("b)")) {
                    rezultats += 2;
                }
                else
                	rezultats--;

                if (atbildes[7].contains("b)") && atbildes[7].contains("d)")) {
                    rezultats +=2;
                }
                else
                	rezultats--;
                
                if (atbildes[8].contains("c)") && atbildes[8].contains("d)")) {
                    rezultats += 2;
                }
                else
                	rezultats--;

                if (atbildes[9].contains("a)") && atbildes[9].contains("b)") && atbildes[9].contains("c)")) {
                    rezultats += 2;
                }
                else
                	rezultats--;
                JOptionPane.showMessageDialog(frame2, "Tavs rezultāts ir " + rezultats + " punkti.");
                
                StringBuilder rezultati = new StringBuilder();
                for (int i = 0; i < atbildes.length; i++) {
                    rezultati.append("Jautājums ").append(i + 1).append(": ").append(atbildes[i]).append("\n");
                }
                JOptionPane.showMessageDialog(frame2, rezultati.toString(), "Tavi rezultāti",
                        JOptionPane.INFORMATION_MESSAGE);
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
		
	

