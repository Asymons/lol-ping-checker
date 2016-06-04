import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public GUI() throws UnknownHostException, IOException, InterruptedException {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("NA");
		chckbxNewCheckBox.setBounds(20, 51, 55, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblAsymonsLeagueOf = new JLabel("Asymons' LOL Ping Checker");
		lblAsymonsLeagueOf.setBounds(10, 11, 414, 33);
		lblAsymonsLeagueOf.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
		contentPane.add(lblAsymonsLeagueOf);
		
		
		textField = new JTextField();
		textField.setBounds(146, 102, 86, 20);
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 116, 86, 20);
		
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 133, 86, 20);
		
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(146, 226, 89, 23);
		contentPane.add(btnStart);
		btnStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Console.pingChecker(Constants.NA.getIp());
					textField.setText("Max: " + Console.max);
					textField_1.setText("Average: " + Console.average/100);
					textField_2.setText("Min: " + Console.min);
				} catch (IOException | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
	}
}
