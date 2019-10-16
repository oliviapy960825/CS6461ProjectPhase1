
package FrontPanel;
/**
 * @author Dishit, Peiyu, Zhaoning, Charitha
 *
 */
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CPUAttributes.ALU;
import CPUAttributes.CU;
import CPUAttributes.Cache;
import CPUAttributes.ConditionCodeRegister;
import CPUAttributes.GeneralPurposeRegister;
import CPUAttributes.IndexRegister;
import CPUAttributes.InstructionRegister;
import CPUAttributes.MemoryAccessRegister;
import CPUAttributes.MemoryBufferRegister;
import CPUAttributes.ProgramCounter;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;
import InstructionProcessing.MachineFaultException;
import Main.Main;
import Memory.Memory;
@SuppressWarnings("serial")
public class UserInterface extends JFrame {
	//This class is for the User Interface designs and interactions
	//It has one contentPanel and many fields and buttons for each user input area and button
	//It also has text areas for user input and also the log/console for displaying what's happening behind
	
	protected JPanel contentPane;
	private JTextField txtFieldR0;
	private JTextField txtFieldR1;
	private JTextField txtFieldR2;
	private JTextField txtFieldR3;
	private JTextField txtFieldX1;
	private JTextField txtFieldX2;
	private JTextField txtFieldX3;
	private JTextField txtFieldPC;
	private JTextField txtFieldMAR;
	private JTextField txtFieldMBR;
	private JTextField txtFieldIR;
	private JTextField txtFieldCC;
	private JTextField txtFieldMemory;
	private JTextField txtFieldMemoryValue;
	private JTextArea instructionsTextArea;
	private JTextArea logTextArea;
	
	private static CU cu=new CU();
	private static ALU alu=new ALU();
	private static Memory memory=new Memory();
	private static Cache cache=new Cache();

	
	public UserInterface() {
		cu=new CU();
		cu.setUserInterface(this);
		alu=new ALU();
		alu.setUserInterface(this);
		cache=new Cache();
		cache.setUserInterface(this);
		//memory=new Memory();
		
		//Constructor, call initialize function to initialize the user interface
		intialize();
	}
	public void setR0Text(int data){
		txtFieldR0.setText(Integer.toString(data));
	}
	public void setR1Text(int data){
		txtFieldR1.setText(Integer.toString(data));
	}
	public void setR2Text(int data){
		txtFieldR2.setText(Integer.toString(data));
	}
	public void setR3Text(int data){
		txtFieldR3.setText(Integer.toString(data));
	}
	public void setX1Text(int data){
		txtFieldX1.setText(Integer.toString(data));
	}
	public void setX2Text(int data){
		txtFieldX2.setText(Integer.toString(data));
	}
	public void setX3Text(int data){
		txtFieldX3.setText(Integer.toString(data));
	}
	public void setMARText(int address){
		txtFieldMAR.setText(Integer.toString(address));
	}
	
	public void setMBRText(int data){
		txtFieldMBR.setText(Integer.toString(data));
	}
	public void setIRText(int address){
		txtFieldIR.setText(Integer.toString(address));
	}
	public void setPCText(int address){
		txtFieldPC.setText(Integer.toString(address));
	}
	public void updateLogText(String string, int address){
		logTextArea.append(string+" "+address);
	}
	public void updateLogText(String string){
		logTextArea.append(string);
	}
	public void intialize() {
		// Initialize function is for the user interface design and layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 899);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblR = new JLabel("R0");
		lblR.setBounds(50, 62, 28, 21);
		contentPane.add(lblR);
		
		txtFieldR0 = new JTextField();
		txtFieldR0.setBounds(83, 59, 96, 27);
		contentPane.add(txtFieldR0);
		txtFieldR0.setColumns(10);
		


		
		JButton btnStoreR0 = new JButton("Store");
		btnStoreR0.setBackground(Color.LIGHT_GRAY);
		btnStoreR0.setBounds(201, 58, 77, 29);
		contentPane.add(btnStoreR0);
		
		JLabel lblR_1 = new JLabel("R1");
		lblR_1.setBounds(50, 118, 28, 21);
		contentPane.add(lblR_1);
		
		txtFieldR1 = new JTextField();
		txtFieldR1.setBounds(83, 115, 96, 27);
		contentPane.add(txtFieldR1);
		txtFieldR1.setColumns(10);
		
		JButton btnStoreR1 = new JButton("Store");
		btnStoreR1.setBackground(Color.LIGHT_GRAY);
		btnStoreR1.setBounds(201, 114, 77, 29);
		contentPane.add(btnStoreR1);
		
		JLabel lblR_2 = new JLabel("R2");
		lblR_2.setBounds(50, 174, 18, 21);
		contentPane.add(lblR_2);
		
		txtFieldR2 = new JTextField();
		txtFieldR2.setBounds(83, 171, 96, 27);
		contentPane.add(txtFieldR2);
		txtFieldR2.setColumns(10);
		
		JButton btnStoreR2 = new JButton("Store");
		btnStoreR2.setBackground(Color.LIGHT_GRAY);
		btnStoreR2.setBounds(201, 170, 77, 29);
		contentPane.add(btnStoreR2);
		
		JLabel lblR_3 = new JLabel("R3");
		lblR_3.setBounds(50, 235, 18, 21);
		contentPane.add(lblR_3);
		
		txtFieldR3 = new JTextField();
		txtFieldR3.setBounds(83, 232, 96, 27);
		contentPane.add(txtFieldR3);
		txtFieldR3.setColumns(10);
		
		JButton btnStoreR3 = new JButton("Store");
		btnStoreR3.setBackground(Color.LIGHT_GRAY);
		btnStoreR3.setBounds(201, 231, 77, 29);
		contentPane.add(btnStoreR3);
		
		JLabel lblX = new JLabel("X1");
		lblX.setBounds(449, 62, 18, 21);
		contentPane.add(lblX);
		
		txtFieldX1 = new JTextField();
		txtFieldX1.setBounds(482, 59, 96, 27);
		contentPane.add(txtFieldX1);
		txtFieldX1.setColumns(10);
		
		JButton btnStoreX1 = new JButton("Store");
		btnStoreX1.setBackground(Color.LIGHT_GRAY);
		btnStoreX1.setBounds(603, 58, 77, 29);
		contentPane.add(btnStoreX1);
		
		JLabel lblX_1 = new JLabel("X2");
		lblX_1.setBounds(449, 118, 18, 21);
		contentPane.add(lblX_1);
		
		txtFieldX2 = new JTextField();
		txtFieldX2.setBounds(482, 115, 96, 27);
		contentPane.add(txtFieldX2);
		txtFieldX2.setColumns(10);
		
		JButton btnStoreX2 = new JButton("Store");
		btnStoreX2.setBackground(Color.LIGHT_GRAY);
		btnStoreX2.setBounds(603, 114, 77, 29);
		contentPane.add(btnStoreX2);
		
		JLabel lblX_2 = new JLabel("X3");
		lblX_2.setBounds(449, 174, 18, 21);
		contentPane.add(lblX_2);
		
		txtFieldX3 = new JTextField();
		txtFieldX3.setBounds(482, 171, 96, 27);
		contentPane.add(txtFieldX3);
		txtFieldX3.setColumns(10);
		
		JButton btnStoreX3 = new JButton("Store");
		btnStoreX3.setBackground(Color.LIGHT_GRAY);
		btnStoreX3.setBounds(603, 170, 77, 29);
		contentPane.add(btnStoreX3);
		
		JLabel lblPc = new JLabel("PC");
		lblPc.setBounds(50, 331, 18, 21);
		contentPane.add(lblPc);
		
		txtFieldPC = new JTextField();
		txtFieldPC.setBounds(83, 328, 96, 27);
		contentPane.add(txtFieldPC);
		txtFieldPC.setColumns(10);
		
		JLabel lblMar = new JLabel("MAR");
		lblMar.setBounds(257, 331, 28, 21);
		contentPane.add(lblMar);
		
		txtFieldMAR = new JTextField();
		txtFieldMAR.setBounds(300, 328, 96, 27);
		contentPane.add(txtFieldMAR);
		txtFieldMAR.setColumns(10);
		
		JLabel lblMbr = new JLabel("MBR");
		lblMbr.setBounds(470, 331, 81, 21);
		contentPane.add(lblMbr);
		
		txtFieldMBR = new JTextField();
		txtFieldMBR.setBounds(511, 328, 96, 27);
		contentPane.add(txtFieldMBR);
		txtFieldMBR.setColumns(10);
		
		JLabel lblIr = new JLabel("IR");
		lblIr.setBounds(50, 394, 18, 21);
		contentPane.add(lblIr);
		
		txtFieldIR = new JTextField();
		txtFieldIR.setBounds(83, 391, 96, 27);
		contentPane.add(txtFieldIR);
		txtFieldIR.setColumns(10);
		
		JLabel lblCc = new JLabel("CC");
		lblCc.setBounds(260, 394, 18, 21);
		contentPane.add(lblCc);
		
		txtFieldCC = new JTextField();
		txtFieldCC.setBounds(300, 391, 96, 27);
		contentPane.add(txtFieldCC);
		txtFieldCC.setColumns(10);
		
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
		
		txtFieldMemory = new JTextField();
		txtFieldMemory.setBounds(260, 707, 96, 27);
		contentPane.add(txtFieldMemory);
		txtFieldMemory.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(273, 681, 68, 21);
		contentPane.add(lblAddress);
		
		txtFieldMemoryValue = new JTextField();
		txtFieldMemoryValue.setBounds(392, 707, 96, 27);
		contentPane.add(txtFieldMemoryValue);
		txtFieldMemoryValue.setColumns(10);
		
		JLabel lblValue = new JLabel("VALUE");
		lblValue.setBounds(411, 681, 81, 21);
		contentPane.add(lblValue);
		
		JButton btnStore = new JButton("STORE");
		btnStore.setBackground(Color.LIGHT_GRAY);
		btnStore.setBounds(526, 706, 81, 29);
		contentPane.add(btnStore);
		
		JButton btnQuery = new JButton("QUERY");
		btnQuery.setBackground(Color.LIGHT_GRAY);
		btnQuery.setBounds(641, 706, 81, 29);
		contentPane.add(btnQuery);
		
		JLabel lblTeamCharitha = new JLabel("TEAM 4: Charitha, Dishit, Peiyu, Zhaoning");
		lblTeamCharitha.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTeamCharitha.setBounds(154, 780, 457, 30);
		contentPane.add(lblTeamCharitha);
		
		instructionsTextArea = new JTextArea();
		instructionsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		instructionsTextArea.setBounds(176, 485, 208, 147);
		contentPane.add(instructionsTextArea);
		
		logTextArea = new JTextArea();
		logTextArea.setEditable(false);
		logTextArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		logTextArea.setBounds(449, 486, 208, 147);
		contentPane.add(logTextArea);
		
		
		
		btnStoreR0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r0String = txtFieldR0.getText();
				if(r0String != null) {
					int value = Integer.parseInt(r0String);
					System.out.println(value);
					cu.setR0Value(value);
					txtFieldR0.setText(r0String);
					//here write some code to store the text typed in R0 into memory 
				}
			}
		});
		
		btnStoreR1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r1String = txtFieldR1.getText();
				if(r1String != null) {
					int value = Integer.parseInt(r1String);
					System.out.println(value);
					cu.setR1Value(value);
					//R1.setValue(value);
					txtFieldR1.setText(r1String);
					//here write some code to store the text typed in R1 into memory 
				}
			}
		});
		
		btnStoreR2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r2String = txtFieldR2.getText();
				if(r2String != null) {
					int value = Integer.parseInt(r2String);
					System.out.println(value);
					cu.setR2Value(value);
					//R2.setValue(value);
					txtFieldR2.setText(r2String);
					//here write some code to store the text typed in R2 into memory 
				}
			}
		});
		
		btnStoreR3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r3String = txtFieldR3.getText();
				if(r3String != null) {
					int value = Integer.parseInt(r3String);
					System.out.println(value);
					cu.setR3Value(value);
					//R3.setValue(value);
					txtFieldR3.setText(r3String);
					//here write some code to store the text typed in R3 into memory 
				}
			}
		});
		
		btnStoreX1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String x1String = txtFieldX1.getText();
				if(x1String != null) {
					int value = Integer.parseInt(x1String);
					System.out.println(value);
					cu.setX1Value(value);
					//X1.setValue(value);
					txtFieldX1.setText(x1String);
					//here write some code to store the text typed in X1 into memory 
				}
			}
		});
		
		btnStoreX2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String x2String = txtFieldX2.getText();
				if(x2String != null) {
					int value = Integer.parseInt(x2String);
					System.out.println(value);
					cu.setX2Value(value);
					//X2.setValue(value);
					txtFieldX2.setText(x2String);
					//here write some code to store the text typed in X2 into memory 
				}
			}
		});
		
		btnStoreX3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String x3String = txtFieldX3.getText();
				if(x3String != null) {
					int value = Integer.parseInt(x3String);
					System.out.println(value);
					cu.setX3Value(value);
					//X3.setValue(value);
					txtFieldX3.setText(x3String);
					//here write some code to store the text typed in X3 into memory 
				}
			}
		});
		
		btnIpl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cu.setPCValue(0);
				txtFieldPC.setText(String.valueOf(cu.getPCValue()));
		    	String instructions = instructionsTextArea.getText();
		    	cu.strInsToMemory(instructions);//instructions stored into memory
		    	logTextArea.setText("IPL Complete");
			}
		});
		
		btnSinglestep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String insAddress = txtFieldPC.getText();
				//System.out.println(insAddress);
				int iAdd = Integer.parseInt(insAddress,2);
				try {
					alu.iExec(iAdd);
				} catch (MachineFaultException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String addr = txtFieldMemory.getText();
				String dataValue  = txtFieldMemoryValue.getText();
				if(addr != null && dataValue != null) {
					int add = Integer.parseInt(addr);
					int value = Integer.parseInt(dataValue);
					memory.storeIntoMemory(add, value);
					//Memory[add] = value;
				}
			}
		});
		
		btnQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String addr = txtFieldMemory.getText();
				if(addr != null) {
					int addrInt = Integer.parseInt(addr,2);
					int fetchedData=memory.fetchFromMemory(addrInt);
					//int fetchedData = Memory[addrInt];
					String fetchString = Integer.toString(fetchedData);
					txtFieldMemoryValue.setText(fetchString);
				}
			}
		});
		
		btnRun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
		    	String insAddress = txtFieldPC.getText();
		    	int iAddress = Integer.parseInt(insAddress,2);
		    	Boolean status = true;
		    	while (status) {
					try {
						status = alu.iExec(iAddress);
					} catch (MachineFaultException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					iAddress++;
				}
			}
		});
	}
	
}