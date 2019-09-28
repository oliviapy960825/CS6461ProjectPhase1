import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;


public class Panel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 899);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblR = new JLabel("R0");
		lblR.setBounds(50, 62, 28, 21);
		contentPane.add(lblR);
		
		textField = new JTextField();
		textField.setBounds(83, 59, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnStore = new JButton("Store");
		btnStore.setBackground(Color.LIGHT_GRAY);
		btnStore.setBounds(201, 58, 77, 29);
		contentPane.add(btnStore);
		
		JLabel lblR_1 = new JLabel("R1");
		lblR_1.setBounds(50, 118, 28, 21);
		contentPane.add(lblR_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 115, 96, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("Store");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(201, 114, 77, 29);
		contentPane.add(button);
		
		JLabel lblR_2 = new JLabel("R2");
		lblR_2.setBounds(50, 174, 18, 21);
		contentPane.add(lblR_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(83, 171, 96, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("Store");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(201, 170, 77, 29);
		contentPane.add(button_1);
		
		JLabel lblR_3 = new JLabel("R3");
		lblR_3.setBounds(50, 235, 18, 21);
		contentPane.add(lblR_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(83, 232, 96, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_2 = new JButton("Store");
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(201, 231, 77, 29);
		contentPane.add(button_2);
		
		JLabel lblX = new JLabel("X1");
		lblX.setBounds(449, 62, 18, 21);
		contentPane.add(lblX);
		
		textField_4 = new JTextField();
		textField_4.setBounds(482, 59, 96, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button_3 = new JButton("Store");
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.setBounds(603, 58, 77, 29);
		contentPane.add(button_3);
		
		JLabel lblX_1 = new JLabel("X2");
		lblX_1.setBounds(449, 118, 18, 21);
		contentPane.add(lblX_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(482, 115, 96, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton button_4 = new JButton("Store");
		button_4.setBackground(Color.LIGHT_GRAY);
		button_4.setBounds(603, 114, 77, 29);
		contentPane.add(button_4);
		
		JLabel lblX_2 = new JLabel("X3");
		lblX_2.setBounds(449, 174, 18, 21);
		contentPane.add(lblX_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(482, 171, 96, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton button_5 = new JButton("Store");
		button_5.setBackground(Color.LIGHT_GRAY);
		button_5.setBounds(603, 170, 77, 29);
		contentPane.add(button_5);
		
		JLabel lblPc = new JLabel("PC");
		lblPc.setBounds(50, 331, 18, 21);
		contentPane.add(lblPc);
		
		textField_7 = new JTextField();
		textField_7.setBounds(83, 328, 96, 27);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblMar = new JLabel("MAR");
		lblMar.setBounds(257, 331, 28, 21);
		contentPane.add(lblMar);
		
		textField_8 = new JTextField();
		textField_8.setBounds(300, 328, 96, 27);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblMbr = new JLabel("MBR");
		lblMbr.setBounds(470, 331, 81, 21);
		contentPane.add(lblMbr);
		
		textField_9 = new JTextField();
		textField_9.setBounds(511, 328, 96, 27);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblIr = new JLabel("IR");
		lblIr.setBounds(50, 394, 18, 21);
		contentPane.add(lblIr);
		
		textField_10 = new JTextField();
		textField_10.setBounds(83, 391, 96, 27);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblCc = new JLabel("CC");
		lblCc.setBounds(260, 394, 18, 21);
		contentPane.add(lblCc);
		
		textField_11 = new JTextField();
		textField_11.setBounds(300, 391, 96, 27);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnIpl = new JButton("IPL");
		btnIpl.setBackground(Color.LIGHT_GRAY);
		btnIpl.setBounds(15, 489, 123, 29);
		contentPane.add(btnIpl);
		
		JButton btnSinglestep = new JButton("SINGLESTEP");
		btnSinglestep.setBackground(Color.LIGHT_GRAY);
		btnSinglestep.setBounds(15, 544, 123, 29);
		contentPane.add(btnSinglestep);
		
		JButton btnRun = new JButton("RUN");
		btnRun.setBackground(Color.LIGHT_GRAY);
		btnRun.setBounds(15, 604, 123, 29);
		contentPane.add(btnRun);
		
		JLabel lblNewLabel = new JLabel("INSTRUCTION INPUT");
		lblNewLabel.setBounds(201, 449, 153, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogconsole = new JLabel("LOG/CONSOLE");
		lblLogconsole.setBounds(497, 449, 110, 21);
		contentPane.add(lblLogconsole);
		
		JLabel lblMemory = new JLabel("MEMORY");
		lblMemory.setBounds(177, 710, 54, 21);
		contentPane.add(lblMemory);
		
		textField_14 = new JTextField();
		textField_14.setBounds(260, 707, 96, 27);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(273, 681, 68, 21);
		contentPane.add(lblAddress);
		
		textField_15 = new JTextField();
		textField_15.setBounds(392, 707, 96, 27);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblValue = new JLabel("VALUE");
		lblValue.setBounds(411, 681, 81, 21);
		contentPane.add(lblValue);
		
		JButton btnStore_1 = new JButton("STORE");
		btnStore_1.setBackground(Color.LIGHT_GRAY);
		btnStore_1.setBounds(526, 706, 81, 29);
		contentPane.add(btnStore_1);
		
		JButton btnQuery = new JButton("QUERY");
		btnQuery.setBackground(Color.LIGHT_GRAY);
		btnQuery.setBounds(641, 706, 81, 29);
		contentPane.add(btnQuery);
		
		JLabel lblTeamCharitha = new JLabel("TEAM 4: Charitha, Dishit, Peiyu, Zhaoning");
		lblTeamCharitha.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTeamCharitha.setBounds(154, 780, 457, 21);
		contentPane.add(lblTeamCharitha);
		
		JTextArea txtrDfasdf = new JTextArea();
		txtrDfasdf.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrDfasdf.setBounds(176, 485, 208, 147);
		contentPane.add(txtrDfasdf);
		
		JTextArea txtrTtg = new JTextArea();
		txtrTtg.setEditable(false);
		txtrTtg.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrTtg.setBounds(449, 486, 208, 147);
		contentPane.add(txtrTtg);
	}
}
