package ADHA;



import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class First {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					First window = new First();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public First() {
		initialize();
		this.setTitle("FRONT PAGE");
	}

	private void setTitle(String string) {
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.white);
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblMalnadCollegeofEngineering = new JLabel("MALNAD COLLEGE OF ENGINEERING,HASSAN");
		lblMalnadCollegeofEngineering.setForeground(new Color(0, 128, 128));
		lblMalnadCollegeofEngineering.setHorizontalAlignment(SwingConstants.CENTER);
		lblMalnadCollegeofEngineering.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMalnadCollegeofEngineering.setBounds(361, 11, 640, 47);
		frame.getContentPane().add(lblMalnadCollegeofEngineering);
		//Image img01=new ImageIcon(this.getClass().getResource("icon2.jpg")).getImage();
		
		JLabel lblProjectReportOn = new JLabel("PROJECT REPORT ON  :");
		lblProjectReportOn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProjectReportOn.setBounds(462, 345, 228, 30);
		frame.getContentPane().add(lblProjectReportOn);
		
		JLabel lb = new JLabel("ANIMATION OF SORTING ALGORITHMS");
		lb.setForeground(Color.RED);
		lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb.setBounds(635, 345, 325, 30);
		frame.getContentPane().add(lb);
		
		JLabel lblSubmittedBy = new JLabel("SUBMITTED BY");
		lblSubmittedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubmittedBy.setBounds(579, 397, 143, 36);
		frame.getContentPane().add(lblSubmittedBy);
		
		JLabel lbl = new JLabel("Ashik Gowda N P                                          4MC16IS005");
		lbl.setForeground(new Color(128, 0, 0));
		lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl.setBounds(485, 444, 364, 36);
		frame.getContentPane().add(lbl);
		
		JLabel lblS = new JLabel("Dhanush G D                                            4MC16IS007");
		lblS.setForeground(new Color(128, 0, 0)); 
		lblS.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblS.setBounds(485, 469, 373, 36);
		frame.getContentPane().add(lblS);
		
		JLabel lblSw = new JLabel("Hemanth B R                                          4MC16IS010");
		lblSw.setForeground(new Color(128, 0, 0));
		lblSw.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSw.setBounds(485, 495, 373, 36);
		frame.getContentPane().add(lblSw);
		
		JLabel lblUnderTheGuidance = new JLabel("UNDER THE GUIDANCE OF :");
		lblUnderTheGuidance.setForeground(new Color(0, 0, 0));
		lblUnderTheGuidance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnderTheGuidance.setBounds(551, 542, 239, 36);
		frame.getContentPane().add(lblUnderTheGuidance);
		
		JLabel lblNewLabel = new JLabel("Ms. HANNABEL H.ALVA ");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(448, 579, 166, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAssistantProfessoriseDept = new JLabel("ASSISTANT PROFESSOR,ISE DEPT");
		lblAssistantProfessoriseDept.setForeground(new Color(0, 0, 0));
		lblAssistantProfessoriseDept.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAssistantProfessoriseDept.setBounds(642, 579, 256, 22);
		frame.getContentPane().add(lblAssistantProfessoriseDept);
		
		JLabel lblMrcsaroja = new JLabel("Mr. Sudharshan  G.K");
		lblMrcsaroja.setForeground(new Color(0, 0, 139));
		lblMrcsaroja.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMrcsaroja.setBounds(448, 605, 174, 36);
		frame.getContentPane().add(lblMrcsaroja);
		
		JLabel label_1 = new JLabel("ASSISTANT PROFESSOR,ISE DEPT");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(642, 605, 256, 36);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("DEPT. OF  INFORMATION  SCIENCE AND ENGINEERING");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		//lblNewLabel_1.setBounds(46, 11, 640, 47);
		//frame.getContentPane().add(lblMalnadCollegeofEngineering);
		lblNewLabel_1.setBounds(340, 70, 700, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 0,200));
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Image img=new ImageIcon(this.getClass().getResource("/icon2.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(625,0, 600, 400);
		frame.getContentPane().add(label);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SortingAnimatorThreaded sorter = new SortingAnimatorThreaded();
				sorter.setVisible(true);
				dispose();
			}

			private void dispose() {
				
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStart.setBounds(1205, 589, 89, 47);
		frame.getContentPane().add(btnStart);
			
	}
}	