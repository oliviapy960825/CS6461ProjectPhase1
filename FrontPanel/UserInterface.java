
package FrontPanel;
/**
 * @author Dishit, Peiyu, Zhaoning, Charitha
 *
 */
import java.awt.Color;
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

import CPUAttributes.ConditionCodeRegister;
import CPUAttributes.GeneralPurposeRegister;
import CPUAttributes.IndexRegister;
import CPUAttributes.InstructionRegister;
import CPUAttributes.MemoryAccessRegister;
import CPUAttributes.MemoryBufferRegister;
import CPUAttributes.ProgramCounter;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;


@SuppressWarnings("serial")
public class UserInterface extends JFrame {
	//This class is for the User Interface designs and interactions
	//It has one contentPanel and many fields and buttons for each user input area and button
	//It also has text areas for user input and also the log/console for displaying what's happening behind
	
	private JPanel contentPane;
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
	
	
	private static ProgramCounter PC = new ProgramCounter();
	private static MemoryAccessRegister MAR = new MemoryAccessRegister();
	private static MemoryBufferRegister MBR = new MemoryBufferRegister();
	private static InstructionRegister IR = new InstructionRegister();
	private static IndexRegister X1 = new IndexRegister();
	private static IndexRegister X2 = new IndexRegister();
	private static IndexRegister X3 = new IndexRegister();
	private static GeneralPurposeRegister R0 = new GeneralPurposeRegister();
	private static GeneralPurposeRegister R1 = new GeneralPurposeRegister();
	private static GeneralPurposeRegister R2 = new GeneralPurposeRegister();
	private static GeneralPurposeRegister R3 = new GeneralPurposeRegister();
	private static ConditionCodeRegister CC = new ConditionCodeRegister();
	
	private static Encoding encode = new Encoding();
	private static Decoding decode =  new Decoding();
	
	private static int Memory[] = new int[4096];
	
	
	/**
	 * 
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PC.setValue(10);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public UserInterface() {
		//Constructor, call initialize function to initialize the user interface
		intialize();
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
		lblTeamCharitha.setBounds(154, 780, 457, 21);
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
					R0.setValue(value);
					txtFieldR0.setText(Integer.toString(R0.getValue()));
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
					R1.setValue(value);
					txtFieldR1.setText(Integer.toString(R1.getValue()));
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
					R2.setValue(value);
					txtFieldR2.setText(Integer.toString(R2.getValue()));
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
					R3.setValue(value);
					txtFieldR3.setText(Integer.toString(R3.getValue()));
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
					X1.setValue(value);
					txtFieldX1.setText(Integer.toString(X1.getValue()));
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
					X2.setValue(value);
					txtFieldX2.setText(Integer.toString(X2.getValue()));
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
					X3.setValue(value);
					txtFieldX3.setText(Integer.toString(X3.getValue()));
				}
			}
		});
		
		btnIpl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PC.setValue(10);
				txtFieldPC.setText(String.valueOf(PC.getValue()));
		    	String instructions = instructionsTextArea.getText();
		    	strInsToMemory(instructions);
		    	logTextArea.setText("IPL Complete");
			}
		});
		
		btnSinglestep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String insAddress = txtFieldPC.getText();
				int iAdd = Integer.parseInt(insAddress,2);
				iExec(iAdd);
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
					Memory[add] = value;
				}
			}
		});
		
		btnQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String addr = txtFieldMemory.getText();
				if(addr != null) {
					int addrInt = Integer.parseInt(addr);
					int fetchedData = Memory[addrInt];
					String fetchString = Integer.toString(fetchedData);
					txtFieldMemoryValue.setText(fetchString);
				}
			}
		});
		
		btnRun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
		    	String insAddress = txtFieldPC.getText();
		    	int iAddress = Integer.parseInt(insAddress);
		    	Boolean status = true;
		    	while (status) {
					status = iExec(iAddress);
					iAddress++;
				}
			}
		});
	}
	
	public void strInsToMemory(String a) {
		//This is to get String stored in memory
		int pc = PC.getValue();
		String[] lines = a.split("\n");
		for (String line : lines) {
			int decIns = encode.insToDec(line);
			Memory[pc]=decIns;
			System.out.println(Memory[pc]);
			pc= pc+1;
		}

	}
	
	public void LDR(int R,int X,int I,int address) {
		//This function is for load instruction workflow
		if(I==0) {
			System.out.println(R);
			txtFieldMAR.setText(Integer.toString(address));
			MAR.setValue(address);
			logTextArea.append("\n MAR : " +address);
			int data = Memory[address];
			txtFieldMBR.setText(Integer.toString(data));
			MBR.setValue(data);
			logTextArea.append("\n MBR : " +data);
			switch (R) {
			case 0:
				txtFieldR0.setText(Integer.toString(data));
				R0.setValue(data);
				logTextArea.append("\n R0: "+data);
				break;
			case 1:
				txtFieldR1.setText(Integer.toString(data));
				R1.setValue(data);
				logTextArea.append("\n R1: "+data);
				break;
			case 2:
				txtFieldR2.setText(Integer.toString(data));
				R2.setValue(data);
				logTextArea.append("\n R2: "+data);
				break;
			case 3:
				txtFieldR3.setText(Integer.toString(data));
				R3.setValue(data);
				logTextArea.append("\n R3: "+data);
				break;
			default:
				break;
			}
		}
		else {
			int IX=0;
			if(X==1) {
				IX = X1.getValue();
			}
			else if(X==2) {
				IX=X2.getValue();
			}
			else {
				IX=X3.getValue();
			}
			int ADD = IX + address;
			txtFieldMAR.setText(Integer.toString(ADD));
			MAR.setValue(ADD);
			logTextArea.append("\n MAR : " + ADD);
			int data = Memory[ADD];
			txtFieldMBR.setText(Integer.toString(data));
			MBR.setValue(data);
			logTextArea.append("\n MBR : " +data);
			switch (R) {
			case 0:
				txtFieldR0.setText(Integer.toString(data));
				R0.setValue(data);
				logTextArea.append("\n R0: "+data);
				break;
			case 1:
				txtFieldR1.setText(Integer.toString(data));
				R1.setValue(data);
				logTextArea.append("\n R1: "+data);
				break;
			case 2:
				txtFieldR2.setText(Integer.toString(data));
				R2.setValue(data);
				logTextArea.append("\n R2: "+data);
				break;
			case 3:
				txtFieldR3.setText(Integer.toString(data));
				R3.setValue(data);
				logTextArea.append("\n R3: "+data);
				break;
			default:
				break;
			}
			
		}
		
	}
	
	public void STR(int R,int X,int I,int address) {
		//This function is for STR instruction workflow
		txtFieldMAR.setText(Integer.toString(address));
		MAR.setValue(address);
		int Reg = 0;
		switch (R) {
		case 0:
			Reg = R0.getValue();
			txtFieldMBR.setText(Integer.toString(Reg));
			MBR.setValue(Reg);
			logTextArea.append("MBR: "+ Reg);
			break;
		case 1:
			Reg = R1.getValue();
			txtFieldMBR.setText(Integer.toString(Reg));
			MBR.setValue(Reg);
			logTextArea.append("MBR: "+ Reg);
			break;
		case 2:
			Reg = R2.getValue();
			txtFieldMBR.setText(Integer.toString(Reg));
			MBR.setValue(Reg);
			logTextArea.append("MBR: "+ Reg);
			break;
		case 3:
			Reg = R3.getValue();
			txtFieldMBR.setText(Integer.toString(Reg));
			MBR.setValue(Reg);
			logTextArea.append("MBR: "+ Reg);
			break;
			
		default:
			break;
		}
		Memory[address] = Reg;
	}
	
	public void LDA(int R,int X,int I,int address) {
		//This function is for LDA instruction workflow
		txtFieldMBR.setText(Integer.toString(address));
		MBR.setValue(address);
		switch (R) {
		case 0:
			R0.setValue(address);
			txtFieldR0.setText(Integer.toString(address));
			break;
		case 1:
			R1.setValue(address);
			txtFieldR1.setText(Integer.toString(address));
			break;
		case 2:
			R2.setValue(address);
			txtFieldR2.setText(Integer.toString(address));
			break;
		case 3:
			R3.setValue(address);
			txtFieldR3.setText(Integer.toString(address));
			break;
			
		default:
			break;
		}
	}
	
	public void LDX(int X,int I,int address) {
		//This instruction is for LDX instruction workflow
		txtFieldMAR.setText(Integer.toString(address));
		MAR.setValue(address);
		logTextArea.append("\nMAR:"+ address);
		int Data = Memory[address];
		txtFieldMBR.setText(Integer.toString(Data));
		MBR.setValue(Data);
		logTextArea.append("\nMBR:"+ Data);
		switch (X) {
		case 1:
			X1.setValue(Data);
			txtFieldX1.setText(Integer.toString(Data));
			break;
		case 2:
			X2.setValue(Data);
			txtFieldX2.setText(Integer.toString(Data));
			break;
		case 3:
			X3.setValue(Data);
			txtFieldX3.setText(Integer.toString(Data));
			break;
		default:
			break;
		}
	}
	
	public void STX(int X,int I,int address) {
		//This function is for STX instruction workflow
		txtFieldMAR.setText(Integer.toString(address));
		MAR.setValue(address);
		logTextArea.append("\nMAR:"+ address);		
		int DataIX = 0;
		switch (X) {
		case 1:
			DataIX = X1.getValue();
			txtFieldMBR.setText(Integer.toString(DataIX));
			MBR.setValue(DataIX);
			break;
		case 2:
			DataIX = X2.getValue();
			txtFieldMBR.setText(Integer.toString(DataIX));
			MBR.setValue(DataIX);
			break;
		case 3:
			DataIX = X3.getValue();
			txtFieldMBR.setText(Integer.toString(DataIX));
			MBR.setValue(DataIX);
			break;
		default:
			break;
		}
		Memory[address] = DataIX;
	}
	
	public Boolean iExec(int Address) {
		//This function is for executing the instructions of user input
		Boolean status = true;
		String addString = Integer.toBinaryString(Address);
		int add = Integer.parseInt(addString,2);
		int value = Memory[add];
		int[] instructionDec = decode.decToBinary(value);
		txtFieldMAR.setText(String.valueOf(add));
		MAR.setValue(add);
		logTextArea.append("\n PC --> MAR");
		txtFieldMBR.setText(String.valueOf(value));
		MBR.setValue(value);
		logTextArea.append("\n MBR gets loaded with the value");
		txtFieldIR.setText(String.valueOf(value));
		IR.setValue(value);
		logTextArea.append("\n MBR --> IR");
		PC.setValue(PC.getValue() + 1);
		txtFieldPC.setText(String.valueOf(PC.getValue()));
		logTextArea.append("\n PC incremented by 1");
		int R,X,I,address;
		System.out.println(instructionDec);
		switch (instructionDec[0]) {
		case 1:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			LDR(R,X,I,address);
			break;
		case 2:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			STR(R,X,I,address);
			break;
		case 3:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			LDA(R,X,I,address);
			break;
		case 41:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			LDX(X,I,address);
			break;
		case 42:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			STX(X,I,address);
			break;
		case 00:
			status = false;
			return status;
		default:
			break;
		}
		return status;
	}
}