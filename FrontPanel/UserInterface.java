
package FrontPanel;
/**
 * @author Dishit, Peiyu, Zhaoning, Charitha
 *
 */
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
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
import InstructionProcessing.Const;
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
	String[] inputNumbers=null;
	List inputA;
	String number1=null;
	private CU cu;
	//private Const con;
	private int prog2Step;
    private int prog1Step;
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
		return instructionsTextArea.getText();
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
		    try {
                return Integer.parseInt(txtFieldR0.getText());
            } catch (NumberFormatException e) {
		        return 0;
            }
		if (num == 1)
            try {
                return Integer.parseInt(txtFieldR1.getText());
            } catch (NumberFormatException e) {
                return 0;
            }
		if (num == 2)
            try {
                return Integer.parseInt(txtFieldR2.getText());
            } catch (NumberFormatException e) {
                return 0;
            }
		if (num == 3)
            try {
                return Integer.parseInt(txtFieldR3.getText());
            } catch (NumberFormatException e) {
                return 0;
            }
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
				validate();
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
		
//		JLabel lblInput = new JLabel("Input File");
//		lblInput.setBounds(449, 394, 70, 21);
//		contentPane.add(lblInput);
//		
//		/*JButton btnInput = new JButton("Input");
//		btnInput.setBackground(Color.LIGHT_GRAY);
//		btnInput.setBounds(521, 390, 77, 29);
//		contentPane.add(btnInput);*/
//		
//		JButton btnInputFile = new JButton("Browse");
//		btnInputFile.setBackground(Color.LIGHT_GRAY);
//		btnInputFile.setBounds(521, 390, 77, 29);
//		contentPane.add(btnInputFile);
		
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
		

//		JButton btnProgram1 = new JButton("Program1");
//        btnProgram1.setBackground(Color.LIGHT_GRAY);
//        btnProgram1.setBounds(15, 650, 123, 29);
//        contentPane.add(btnProgram1);
//


		JLabel lblNewLabel = new JLabel("INSTRUCTION INPUT");
		lblNewLabel.setBounds(201, 449, 153, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogconsole = new JLabel("LOG/CONSOLE");
		Font x = new Font("Serif",0,12);
		lblLogconsole.setFont(x);
		lblLogconsole.setBounds(497, 449, 200, 21);
		contentPane.add(lblLogconsole);

		JLabel lblProgram2 = new JLabel("Program2");
		lblProgram2.setBounds(692, 549, 100,21);
		contentPane.add(lblProgram2);

		JButton btnLoadSentences = new JButton("Load sentences");
		btnLoadSentences.setBackground(Color.LIGHT_GRAY);
		btnLoadSentences.setBounds(665, 575,123, 29);
		contentPane.add(btnLoadSentences);
		btnLoadSentences.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (prog2Step == 0) {
					/*
					String sentences = "Python is an easy to learn, powerful programming language. "
							+ "It has efficient high-level data structures and a simple but effective approach to object-oriented programming. "
							+ "Python’s elegant syntax and dynamic typing, together with its interpreted nature, make it an ideal language for scripting and rapid application development in many areas on most platforms. "
							+ "Next, install the Python interpreter on your computer. "
							+ "When you are ready to write your first program, you will need a text editor. "
							+ "Or, if you prefer to learn Python through listening to a lecture, you can attend a training course or even hire a trainer to come to your company. ";
					cu.setCardBuffer(sentences);
					//System.out.println((int)sentences.charAt(0));
					//System.out.println(cu.getCardBuffer());
					System.out.println("start to read sentences");

					cu.loadProgram(Const.PRE_PROG2);
					cu.loadProgram(Const.PROG2_0);
					cu.setPCValue(Const.PG2_0_BASE);

					do {
						//cu.setMARValue(cu.getPCValue());
						//cu.setMBRValue(cu.fetchFromMemory(cu.getMARValue()));
						//cu.setIRValue(cu.getMBRValue());
						int iAdd=cu.getPCValue();
						try {
							cu.iExec(iAdd);
							//System.out.println(cu.getR1Value());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//System.out.println(cu.getPCValue());
						//runInstruction(registers.getBinaryStringIr(), registers, mcu);
					} while (cu.getPCValue() <= Const.PG2_0_END && cu.getPCValue() >= Const.PG2_0_BASE);*/
					cu.LoadSentences();
					updateLogText("\nPlease enter a word in the console keyboard and press the find word button.");
					refreshRegistersPanel();
					prog2Step = 1;
				}
			}
		});


		JButton btnFindWord = new JButton("Find Word");
		btnFindWord.setBackground(Color.LIGHT_GRAY);
		btnFindWord.setBounds(665, 605,123, 29);
		contentPane.add(btnFindWord);
		btnFindWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prog2Step == 1) {
                    System.out.println("\nstart to read the word");
                    if (instructionsTextArea.getText() == null || instructionsTextArea.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "type a word in the console keyboard");

                    } else {
                        // read the word
                       /* updateLogText("\nsearch result: the word is");
                        cu.loadProgram(Const.PROG2_1);
                        cu.setPCValue(Const.PG2_1_BASE);
                        do {
//                            registers.setMAR(registers.getPC());
//                            registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
//                            registers.setIR(registers.getMBR());
//                            runInstruction(registers.getBinaryStringIr(), registers, mcu);
                            int iAdd=cu.getPCValue();
                            try {
                                cu.iExec(iAdd);
                                //System.out.println(cu.getR1Value());
                            } catch (Exception e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            System.out.println(cu.getPCValue());
                        } while (cu.getPCValue() <= Const.PG2_1_END && cu.getPCValue() >= Const.PG2_1_BASE);
                        // find the word
                        updateLogText("\nthe word number is");*/
                        System.out.println("prog2_2");
                        cu.loadProgram(Const.PROG2_2);
                        cu.setPCValue(Const.PG2_2_BASE);
                        do {
//                            cu.setMARValue(cu.getPCValue());
//                            cu.setMBRValue(cu.fetchFromMemory(cu.getMARValue()));
//                            cu.setIRValue(cu.getMBRValue());
//                            runInstruction(registers.getBinaryStringIr(), registers, mcu);
                            int iAdd=cu.getPCValue();
                            try {
                                cu.iExec(iAdd);
                                //System.out.println(cu.getR1Value());
                            } catch (Exception e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            //System.out.println(cu.getPCValue());
                        } while (cu.getPCValue() <= Const.PG2_2_END && cu.getPCValue() >= Const.PG2_2_BASE);
                        //System.out.println("\nprint the result in m(28)");

                        cu.loadProgram(Const.PG_P1);
                        cu.setPCValue(Const.PG_P1_BASE);
                        do {
//                            registers.setMAR(registers.getPC());
//                            registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
//                            registers.setIR(registers.getMBR());
//                            runInstruction(registers.getBinaryStringIr(), registers, mcu);
                            int iAdd=cu.getPCValue();
                            try {
                                cu.iExec(iAdd);
                                //System.out.println(cu.getR1Value());
                            } catch (Exception e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            //System.out.println(cu.getPCValue());
                        } while (cu.getPCValue() <= Const.PG_P1_END && cu.getPCValue() >= Const.PG_P1_BASE);
                        //System.out.println("\nprint the result in m(29)");
                        //updateLogText("\nthe sentence number is");
                        cu.loadProgram(Const.PG_P2);
                        cu.setPCValue(Const.PG_P2_BASE);
                        do {
//                            registers.setMAR(registers.getPC());
//                            registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
//                            registers.setIR(registers.getMBR());
//                            runInstruction(registers.getBinaryStringIr(), registers, mcu);
                            int iAdd=cu.getPCValue();
                            try {
                                cu.iExec(iAdd);
                                //System.out.println(cu.getR1Value());
                            } catch (Exception e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            //System.out.println(cu.getPCValue());
                        } while (cu.getPCValue() <= Const.PG_P2_END && cu.getPCValue() >= Const.PG_P2_BASE);
                        refreshRegistersPanel();
                        prog2Step = 0;
                        cu.SearchWord(instructionsTextArea.getText());
                    }
                }
            }
        });

        JLabel lblProgram1 = new JLabel("Program1");
        lblProgram1.setBounds(692, 450, 100,21);
        contentPane.add(lblProgram1);
        
//        JButton btnProgram1 = new JButton("Program1");
//        btnProgram1.setBackground(Color.LIGHT_GRAY);
//        btnProgram1.setBounds(15, 650, 123, 29);
//        contentPane.add(btnProgram1);
        
        JButton btnReadNumbers = new JButton("Read 21 Numbers");
        btnReadNumbers.setBackground(Color.LIGHT_GRAY);
        btnReadNumbers.setBounds(665, 480,123, 29);
        contentPane.add(btnReadNumbers);
        
        
        
        btnReadNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (prog1Step == 0) {
//                    // read 20 numbers from the console keyboard
//                    System.out.println("start reading numbers");
//                    if (instructionsTextArea.getText() == null || instructionsTextArea.getText().length() == 0) {
//                        JOptionPane.showMessageDialog(null, "type 20 numbers in the console keyboard");
//
//                    } else {
//                        updateLogText("\nBelow are the 20 numbers: ");
//                        cu.loadProgram(Const.Pre);
//                        cu.loadProgram(Const.PG1_20);
//                        cu.setPCValue(Const.PG_20_BASE);
//
//                        // refreshRegistersPanel();
//                        do {
//                            // refreshRegistersPanel();
////                            registers.setMAR(registers.getPC());
////                            registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
////                            registers.setIR(registers.getMBR());
////                            runInstruction(registers.getBinaryStringIr(), registers, mcu);
//                            // refreshRegistersPanel();
//                            // pushConsoleBuffer();
//                            int iAdd=cu.getPCValue();
//                            try {
//                                cu.iExec(iAdd);
//                                //System.out.println(cu.getR1Value());
//                            } catch (Exception e1) {
//                                // TODO Auto-generated catch block
//                                e1.printStackTrace();
//                            }
//                            System.out.println(cu.getPCValue());
//                        } while (cu.getPCValue() <= Const.PG_20_END && cu.getPCValue() >= Const.PG_20_BASE);
//                        refreshRegistersPanel();
//                        prog1Step = 1;
//                        updateLogText("\nPlease enter 1 number (end with ',') and press the compare button. ");
//                    }
//                }
            	logTextArea.setText("");
            	String input = instructionsTextArea.getText();

                inputNumbers = input.split(",");

                List<String> list = new ArrayList<String>(Arrays.asList(inputNumbers));

                inputA = list.subList(0, list.size()-1);

                updateLogText("The 20 numbers entered are:" + "\n");

                updateLogText(inputA+"\n");

                int len = inputNumbers.length;

                updateLogText("The search key entered is:" + "\n");

                number1 = inputNumbers[len-1];

                updateLogText(number1+"\n");

            }
        });

        JButton btnCompare = new JButton("Search Nearest Number to Key");
        btnCompare.setBackground(Color.LIGHT_GRAY);
        btnCompare.setBounds(665, 510,123, 29);
        contentPane.add(btnCompare);

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
		instructionsTextArea.setLineWrap(true);
		contentPane.add(instructionsTextArea);

		instructionsTextArea.addKeyListener(new KeyAdapter() { // TODO
            public void keyReleased(KeyEvent e) {
                cu.setKeyboardBuffer(instructionsTextArea.getText());
            }
        });

		JScrollPane instructionPanel = new JScrollPane(instructionsTextArea);
		instructionPanel.setFont(new Font("Monospaced", Font.PLAIN, 16));
		instructionPanel.setBounds(176, 485, 208, 147);
		contentPane.add(instructionPanel);
		instructionPanel.setVisible(true);
		instructionPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		instructionPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		logTextArea = new JTextArea();
		logTextArea.setEditable(false);
		logTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		logTextArea.setBounds(449, 486, 208, 147);
		logTextArea.setLineWrap(true);
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
		
//		btnProgram1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				updateLogText("Please enter 20 numbers and 1 search key in Input panel.(Use comma to separate them)");
//			}
//		});
//
//
//		/*btnInput.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String input = txtKeyboard.getText();
//				txtKeyboard.setText(input);
//			}
//		});*/
		btnCompare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//            	logTextArea.setText("");
//            	String input = instructionsTextArea.getText();
//
//                String[] inputNumbers = input.split(",");
//
//                List<String> list = new ArrayList<String>(Arrays.asList(inputNumbers));
//
//                List inputA = list.subList(0, list.size()-1);
//
//                updateLogText("The 20 numbers entered are:" + "\n");
//
//                updateLogText(inputA+"\n");
//
//                int len = inputNumbers.length;
//
//                updateLogText("The search key entered is:" + "\n");
//
//                String number1 = inputNumbers[len-1];
//
//                updateLogText(number1+"\n");

                int nearestNumber = Integer.parseInt(inputNumbers[0]);

                int[] numbersInput = new int[20];

                int temp1=Integer.parseInt(number1),temp2=0;

                for(int i=0;i<=inputA.size()-1;i++) {

                	temp2 = Integer.parseInt(inputNumbers[i]);

                	numbersInput[i] = (temp1-temp2);

                	System.out.println(numbersInput[i]);

                }

                temp1=numbersInput[0];

                for(int j=1;j<numbersInput.length;j++) {

                	if(Math.abs(temp1) > Math.abs(numbersInput[j])) {

                		nearestNumber = numbersInput[j];

                		temp1 = nearestNumber;

                	}
                	System.out.println(nearestNumber);

                }
                int finalNum = 0;
                if(nearestNumber == Integer.parseInt(inputNumbers[0])) {
                	finalNum = Integer.parseInt(number1) + Math.abs(nearestNumber);
                }
                else if(nearestNumber < 0) {
                	finalNum = Integer.parseInt(number1) + Math.abs(nearestNumber);
                }
                else {
                	finalNum = Integer.parseInt(number1) - nearestNumber;
                }

                //1,2,3,4,7,8,9,10,15,17,20,25,29,32,40,49,55,60,67,80,32

                updateLogText("The nearest number to the key is: \n"+String.valueOf(finalNum));

            }
        });

//		btnInputFile.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//按钮点击事件
//
//
//				JFileChooser chooser = new JFileChooser();             //设置选择器
//				chooser.setMultiSelectionEnabled(true);             //设为多选
//				int returnVal = chooser.showOpenDialog(btnInputFile);        //是否打开文件选择框
//				System.out.println("returnVal="+returnVal);
//
//				if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
//
//					String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
//					System.out.println(filepath);
//
//
//					System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());  //输出相对路径
//
//				}
//			}
//		});

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
			    prog1Step = 0;
				prog2Step = 0;
				//cu.loadProgram(Const.TB);
				cu.setPCValue(8);
				int register = 0;
				//setR0Text(0);
				//setR1Text(0);
				//setR2Text(0);
				//setR3Text(0);
				//setX1Text(0);
				//setX2Text(0);
				//setX3Text(0);
				while (register<4){
				    cu.setRnByNum(register, 0);
				    register++;
                }
                //cu.setX1Value(0);
				//cu.setX2Value(0);
				//cu.setX3Value(0);
				txtFieldPC.setText(String.valueOf(cu.getPCValue()));
		    	String instructions = instructionsTextArea.getText();
		    	//System.out.print(instructions);
		    	cu.strInsToMemory(instructions);//instructions stored into memory
		    	logTextArea.setText("IPL Complete\n");
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
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//contentPane.revalidate();
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
				//contentPane.revalidate();
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
		    	int iAddress = Integer.parseInt(insAddress);
		    	Boolean status = true;
		    	while (status) {
					try {
						status = cu.iExec(iAddress);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					iAddress++;
				}
		    	//contentPane.revalidate();
		    	validate();
			}
			
		});
	}

    private void pushConsoleBuffer() {
        if (cu.getPrinterBuffer() != null) {
            logTextArea.append(cu.getPrinterBuffer());
            cu.setPrinterBuffer("");
        }
        if (cu.getKeyboardBuffer() != null) {
            logTextArea.setText(cu.getKeyboardBuffer());
        }
    }

    private void refreshRegistersPanel() {
        for (Component com : contentPane.getComponents()) {
            if (com instanceof JPanel) {
                JPanel pnl = (JPanel) com;
                int regVal = 0;
                //int bitLong = 0;
                //String bitString = "";
                int i = 0;
                for (Component comm : pnl.getComponents()) {
//                    if (comm instanceof JLabel) {
//                        JLabel lbl = (JLabel) comm;
//                        regVal = registers.getRegistersByName(lbl.getText());
//                        bitLong = registers.getBitLongByName(lbl.getText());
//                        //bitString = StringUtil.decimalToBinary(regVal, bitLong);
//                        //i = bitLong;
//                    }
                    if (comm instanceof JTextField) {
                        JTextField txt = (JTextField) comm;
                        txt.setText(String.valueOf(regVal));
                    }
                }
            }
        }
    }
}