import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends JFrame {

	public static int index = 0;
	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	private String selectedServer = "";
	public static JProgressBar progressBar;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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

	public void serverSelect(JRadioButton box, String ip) {
		box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedServer = ip;
			}
		});
	}
	
	public void yourButtonClickMethod()
	{
	    Runnable runner = new Runnable()
	    {
	        public void run() {
	        //Your original code with the loop here.
	        }
	    };
	    Thread t = new Thread(runner, "Code Executer");
	    t.start();
	}

	/**
	 * Create the frame.
	 * 
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

		JRadioButton chckbxNewCheckBox = new JRadioButton("NA");
		chckbxNewCheckBox.setBounds(20, 51, 55, 23);
		serverSelect(chckbxNewCheckBox, Constants.NA.getIp());
		buttonGroup.add(chckbxNewCheckBox);
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
		
		JRadioButton chckbxEuw = new JRadioButton("EUW");
		chckbxEuw.setBounds(77, 51, 65, 23);
		serverSelect(chckbxEuw, Constants.EUW.getIp());
		buttonGroup.add(chckbxEuw);
		contentPane.add(chckbxEuw);
		
		JRadioButton chckbxNewCheckBox_1 = new JRadioButton("EUNE");
		chckbxNewCheckBox_1.setBounds(146, 51, 65, 23);
		serverSelect(chckbxNewCheckBox_1, Constants.EUNE.getIp());
		buttonGroup.add(chckbxNewCheckBox_1);
		contentPane.add(chckbxNewCheckBox_1);
		
		JRadioButton chckbxOce = new JRadioButton("OCE");
		chckbxOce.setBounds(213, 51, 65, 23);
		serverSelect(chckbxOce, Constants.OCE.getIp());
		buttonGroup.add(chckbxOce);
		contentPane.add(chckbxOce);
		
		JRadioButton chckbxNewCheckBox_2 = new JRadioButton("LAN");
		chckbxNewCheckBox_2.setBounds(280, 51, 97, 23);
		serverSelect(chckbxNewCheckBox_2, Constants.LAN.getIp());
		buttonGroup.add(chckbxNewCheckBox_2);
		contentPane.add(chckbxNewCheckBox_2);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(20, 185, 357, 14);
		progressBar.setValue(index);
		progressBar.repaint();
		System.out.println(progressBar.getValue());
		
		
//		progressBar.addChangeListener(new ChangeListener(){
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				JProgressBar change = (JProgressBar)e.getSource();
//				System.out.println("Change Changed: " + change.getValue());
//				
//			}
//			
//		});
		
		contentPane.add(progressBar);

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Console.pingChecker(selectedServer);
				} catch (IOException | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});

	}
}
