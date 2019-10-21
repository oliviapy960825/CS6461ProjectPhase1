
package FrontPanel;
/**
 * @author Dishit, Peiyu, Zhaoning, Charitha
 *
 */
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
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
	
	protected static JPanel contentPane;
	private static JTextField txtFieldR0;
	private static JTextField txtFieldR1;
	private static JTextField txtFieldR2;
	private static JTextField txtFieldR3;
	private static JTextField txtFieldX1;
	private static JTextField txtFieldX2;
	private static JTextField txtFieldX3;
	private static JTextField txtFieldPC;
	private static JTextField txtFieldMAR;
	private static JTextField txtFieldMBR;
	private static JTextField txtFieldIR;
	private static JTextField txtFieldCC;
	private JTextField txtKeyboard;
	private static JTextField txtFieldMemory;
	private static JTextField txtFieldMemoryValue;
	private static JTextArea instructionsTextArea;
	private static JTextArea logTextArea;
	private CU cu;
	public UserInterface(CU cu, ALU alu) {
		/*alu=new ALU();
		cache=new Cache();
		memory=new int[4096];
		PC=new ProgramCounter();
		MAR=new MemoryAccessRegister();
		MBR=new MemoryBufferRegister();
		IR= new InstructionRegister();
		X1=new IndexRegister();
		X2=new IndexRegister();
		X3=new IndexRegister();
		R0=new GeneralPurposeRegister();
		R1= new GeneralPurposeRegister();
		R2=new GeneralPurposeRegister();
		R3=new GeneralPurposeRegister();
		CC=new ConditionCodeRegister();*/
		//cu=new CU(this,alu,cache,memory,PC,MAR,MBR,IR,X1,X2,X3,R0,R1,R2,R3,CC, encode,decode);
		
		//alu=new ALU();
		//alu.setUserInterface(this);;
		//Constructor, call initialize function to initialize the user interface
		this.cu=cu;
		cu.setUserInterface(this);
		alu.setUserInterface(this);
		intialize();
	}
	public void getR0Text(){
		System.out.print( txtFieldR0.getText());
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
	
	public void setCCText(int address){
		
		txtFieldCC.setText(Integer.toString(address));
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
	public String getInput() {
		return txtKeyboard.getText();
	}
	public void updateLogText(String string, int address){
		logTextArea.append(string+" "+address);
	}
	public void updateLogText(String string){
		logTextArea.append(string);
	}
	public void updateLogText(String[] string) {
	    for (String num:string) {
	        logTextArea.append(num+"\n");
        }
    }
	public void updateLogText(String string, String input){
		logTextArea.append(string+" "+input);
	}
    public void updateLogText(List input) {
	    for (Iterator it1 = input.iterator(); it1.hasNext();) {
	        logTextArea.append(it1.next().toString());
        }
	}
    public void setRnByNum(int num, int value) {
		if (num == 0)
			txtFieldR0.setText(Integer.toString(value));
		if (num == 1)
			txtFieldR1.setText(Integer.toString(value));
		if (num == 2)
			txtFieldR2.setText(Integer.toString(value));
		if (num == 3)
			txtFieldR3.setText(Integer.toString(value));
	}
	public int getRnByNum(int num) {
		if (num == 0)
			return Integer.parseInt(txtFieldR0.getText());
		if (num == 1)
			return Integer.parseInt(txtFieldR1.getText());
		if (num == 2)
			return Integer.parseInt(txtFieldR2.getText());
		if (num == 3)
			return Integer.parseInt(txtFieldR3.getText());
		return 0;
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
		
		txtFieldR0.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.print(cu.getR0Value());
				//SwingUtilities.invokeLater();
				txtFieldR0.setText(String.valueOf(cu.getR0Value()));
				contentPane.revalidate();
				contentPane.repaint();
			}
			
		});

		
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
		txtFieldR1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldR1.setText(String.valueOf(cu.getR1Value()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
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
		txtFieldR2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldR2.setText(String.valueOf(cu.getR2Value()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
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
		txtFieldR3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldR3.setText(String.valueOf(cu.getR3Value()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
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
		txtFieldX1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldX1.setText(String.valueOf(cu.getX1Value()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
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
		txtFieldX2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldX2.setText(String.valueOf(cu.getX2Value()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
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
		txtFieldX3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldX3.setText(String.valueOf(cu.getX3Value()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
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
		txtFieldPC.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldPC.setText(String.valueOf(cu.getPCValue()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
		JLabel lblMar = new JLabel("MAR");
		lblMar.setBounds(257, 331, 28, 21);
		contentPane.add(lblMar);
		
		txtFieldMAR = new JTextField();
		txtFieldMAR.setBounds(300, 328, 96, 27);
		contentPane.add(txtFieldMAR);
		txtFieldMAR.setColumns(10);
		txtFieldMAR.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldMAR.setText(String.valueOf(cu.getMARValue()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
		JLabel lblMbr = new JLabel("MBR");
		lblMbr.setBounds(470, 331, 81, 21);
		contentPane.add(lblMbr);
		
		txtFieldMBR = new JTextField();
		txtFieldMBR.setBounds(511, 328, 96, 27);
		contentPane.add(txtFieldMBR);
		txtFieldMBR.setColumns(10);
		txtFieldMBR.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldMBR.setText(String.valueOf(cu.getMBRValue()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
		JLabel lblIr = new JLabel("IR");
		lblIr.setBounds(50, 394, 18, 21);
		contentPane.add(lblIr);
		
		txtFieldIR = new JTextField();
		txtFieldIR.setBounds(83, 391, 96, 27);
		contentPane.add(txtFieldIR);
		txtFieldIR.setColumns(10);
		txtFieldIR.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldIR.setText(String.valueOf(cu.getIRValue()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
		JLabel lblCc = new JLabel("CC");
		lblCc.setBounds(260, 394, 18, 21);
		contentPane.add(lblCc);
		
		txtFieldCC = new JTextField();
		txtFieldCC.setBounds(300, 391, 96, 27);
		contentPane.add(txtFieldCC);
		txtFieldCC.setColumns(10);
		txtFieldCC.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtFieldCC.setText(String.valueOf(cu.getCCValue()));
				contentPane.revalidate();
				validate();
			}
			
		});
		
		JLabel lblInput = new JLabel("Input File");
		lblInput.setBounds(449, 394, 70, 21);
		contentPane.add(lblInput);
		
		/*JButton btnInput = new JButton("Input");
		btnInput.setBackground(Color.LIGHT_GRAY);
		btnInput.setBounds(521, 390, 77, 29);
		contentPane.add(btnInput);*/
		
		JButton btnInputFile = new JButton("Browse");
		btnInputFile.setBackground(Color.LIGHT_GRAY);
		btnInputFile.setBounds(521, 390, 77, 29);
		contentPane.add(btnInputFile);
		
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
		
		JButton btnProgram1 = new JButton("Program1");
        btnProgram1.setBackground(Color.LIGHT_GRAY);
        btnProgram1.setBounds(15, 604, 123, 29);
        contentPane.add(btnProgram1);
		
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
		JScrollPane instructionPanel = new JScrollPane(instructionsTextArea);
		instructionPanel.setFont(new Font("Monospaced", Font.PLAIN, 16));
		instructionPanel.setBounds(176, 485, 208, 147);
		contentPane.add(instructionPanel);
		instructionPanel.setVisible(true);
		instructionPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		instructionPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		logTextArea = new JTextArea();
		logTextArea.setEditable(false);
		logTextArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		logTextArea.setBounds(449, 486, 208, 147);
		contentPane.add(logTextArea);
		
		JScrollPane logScrollPanel = new JScrollPane(logTextArea);
		logScrollPanel.setFont(new Font("Monospaced", Font.PLAIN, 12));
		logScrollPanel.setBounds(449, 486, 208, 147);
		contentPane.add(logScrollPanel);
		
		
		/*btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = txtKeyboard.getText();
				txtKeyboard.setText(input);
			}
		});*/
		
		btnProgram1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cu.setPCValue(0);
                txtFieldPC.setText(String.valueOf(cu.getPCValue()));
                String input = instructionsTextArea.getText();
                String[] inputNumbers = input.split(",");
                List<String> list = new ArrayList<String>(Arrays.asList(inputNumbers));
                List inputA = list.subList(0, list.size()-1);
                updateLogText("The program 1:" + "\n");
                updateLogText(inputNumbers);
                //updateLogText(inputA);
                int len = inputNumbers.length;
                String number1 = inputNumbers[len-1];
                updateLogText(number1);
//                int len = inputNumbers.length;
//                String lens = String.valueOf(len);
//                updateLogText(lens);
                //int number = Integer.parseInt(number1);
                //cu.strInsToMemory(input);//instructions stored into memory

            }
        });

		btnInputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//按钮点击事件


				JFileChooser chooser = new JFileChooser();             //设置选择器
				chooser.setMultiSelectionEnabled(true);             //设为多选
				int returnVal = chooser.showOpenDialog(btnInputFile);        //是否打开文件选择框
				System.out.println("returnVal="+returnVal);

				if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型

					String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
					System.out.println(filepath);


					System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());  //输出相对路径

				}
			}
		});
		btnStoreR0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r0String = txtFieldR0.getText();
				if(r0String != null) {
					int value = Integer.parseInt(r0String);
					
					cu.setR0Value(value);
					System.out.println(cu.getR0Value());
					txtFieldR0.setText(r0String);
					//here write some code to store the text typed in R0 into memory 
					contentPane.revalidate();
					validate();
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
					contentPane.revalidate();
					validate();
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
					contentPane.revalidate();
					validate();
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
					contentPane.revalidate();
					validate();
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
				
					contentPane.revalidate();
					validate();
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
					contentPane.revalidate();
					validate();
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
					contentPane.revalidate();
					validate();
				}
			}
		});
		
		btnIpl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cu.setPCValue(0);
				txtFieldPC.setText(String.valueOf(cu.getPCValue()));
		    	String instructions = instructionsTextArea.getText();
		    	//System.out.print(instructions);
		    	cu.strInsToMemory(instructions);//instructions stored into memory
		    	logTextArea.setText("IPL Complete");
		    	contentPane.revalidate();
		    	validate();
			}
		});
		
		btnSinglestep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int iAdd=cu.getPCValue();
				System.out.println("The iAdd for the instruction is:" + iAdd);
				//String insAddress = txtFieldPC.getText();
				//System.out.println(insAddress);
				//int iAdd = Integer.parseInt(insAddress,2);
				//int iAdd=encoding.insToDec(insAddress);
				try {
					cu.iExec(iAdd);
				} catch (MachineFaultException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				contentPane.revalidate();
				validate();
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
					cu.memory.storeIntoMemory(add, value);
					//Memory[add] = value;
				}
				contentPane.revalidate();
				validate();
			}
		});
		
		btnQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String addr = txtFieldMemory.getText();
				if(addr != null) {
					int addrInt = Integer.parseInt(addr,2);
					int fetchedData=cu.memory.fetchFromMemory(addrInt);
					//int fetchedData = Memory[addrInt];
					String fetchString = Integer.toString(fetchedData);
					txtFieldMemoryValue.setText(fetchString);
				}
				contentPane.revalidate();
				validate();
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
						status = cu.iExec(iAddress);
					} catch (MachineFaultException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					iAddress++;
				}
		    	contentPane.revalidate();
		    	validate();
			}
			
		});
	}
}