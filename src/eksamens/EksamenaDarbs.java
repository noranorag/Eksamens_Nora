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
	
	private static boolean pabeigts = false;
	private static int rezultats = 0;
	private static String jautajumiN="";
	private static boolean nolasits=false;
	private static boolean izdarits=false;
	
	public static void main(String[] args) {
		
		try {
		
		String[] jautajumi = {
                "1.Kas ir cikls ar skaitītāju?",
                "2.Kādi parametri jānorāda for operātorā?",
                "3.Kāds var būt cikla skaitītājs?",
                "4.Kāds var būt nosacījums pēc tā pārbaudes ciklā?",
                "5.Kuri no kodiem veido bezgalīgu ciklu?",
                "6.Kādas lietas iespējamas ar for cikla palīdzību?",
                "7.Kādas iekavas tiek lietotas for cikla pierakstīšanā?",
                "8.Kurus no šiem varētu ierakstīt jautājuma zīmes vietā? for(int ?=1; ?<=3; ?++)",
                "9.Kuri fakti par for ciklu ir pareizi?",
                "10.Kā izvairīties no bezgalīgā cikla?"
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
            	if(izdarits==false) {
            	rezultats=0;
            	
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
                                pabeigts=true;
                                
                            }
                        } 
                        
                    }
                });

                frame.add(panel);
                frame.setVisible(true);
                izdarits=true;
            	} else
            		JOptionPane.showMessageDialog(null, "Tu jau vienreiz izdarīji testu!");
         
               
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
            	if(nolasits==false) {
            	if(pabeigts==true) {
                JOptionPane.showMessageDialog(frame2, "Spēles rezultāti");
                

                if (atbildes[0].contains("a)") && atbildes[0].contains("b)") && atbildes[0].contains("c)")) 
                	rezultats += 2;
                else {
                	rezultats--;;
                	jautajumiN = jautajumiN + jautajumi[0]+"\n";
                }
                
                if (atbildes[1].contains("a)") && atbildes[1].contains("b)") && atbildes[1].contains("d)")) 
                    rezultats += 2;
                else {
                	rezultats--;
                	jautajumiN = jautajumiN + jautajumi[1]+"\n";
                }

                if (atbildes[2].contains("b)") && atbildes[2].contains("c)")) 
                    rezultats += 2;
                else {
                	rezultats--;
                	jautajumiN = jautajumiN + jautajumi[2]+"\n";
                }

                if (atbildes[3].contains("a)") && atbildes[3].contains("b)")) 
                    rezultats += 2;
                else {
                	rezultats--;
                	jautajumiN = jautajumiN + jautajumi[3]+"\n";
                }

                if (atbildes[4].contains("a)") && atbildes[4].contains("d)")) 
                    rezultats += 2;
                
                else {
                	rezultats--;
                	jautajumiN = jautajumiN + jautajumi[4]+"\n";
                }

                if (atbildes[5].contains("a)") && atbildes[5].contains("b)") && atbildes[5].contains("c)")) 
                    rezultats += 2;
                else {
                	rezultats--;
                	jautajumiN = jautajumiN + jautajumi[5]+"\n";
                }

                if (atbildes[6].contains("a)") && atbildes[6].contains("b)")) 
                    rezultats += 2;
                else {
                	rezultats--;
                	jautajumiN = jautajumiN + jautajumi[6]+"\n";
                }

                if (atbildes[7].contains("b)") && atbildes[7].contains("d)")) 
                    rezultats +=2;
                else {
                	rezultats--;
                	jautajumiN = jautajumiN + jautajumi[7]+"\n";
                }
                
                if (atbildes[8].contains("c)") && atbildes[8].contains("d)")) 
                    rezultats += 2;
                else {
                	rezultats--;
                	jautajumiN = jautajumiN + jautajumi[8]+"\n";
                }

                if (atbildes[9].contains("a)") && atbildes[9].contains("b)") && atbildes[9].contains("c)")) 
                    rezultats += 2;
                else {
                	rezultats--;
                	jautajumiN = jautajumiN + jautajumi[9]+"\n";
                }
                JOptionPane.showMessageDialog(frame2, "Tavi iegūtie punkti: "+rezultats+"\nNepareizi atbildētie jautājumi: \n" + jautajumiN);
                
                nolasits=true;
            	} else
            		 JOptionPane.showMessageDialog(frame2, "Nav pabeigts tests!");    
            	} else 
            		JOptionPane.showMessageDialog(frame2, "Tavi iegūtie punkti: "+rezultats+"\nNepareizi atbildētie jautājumi: \n" + jautajumiN); 
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
        
		}catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Radās kļuda!");
        }
    }
}
		
	

