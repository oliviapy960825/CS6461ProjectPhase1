package FrontPanel;
/*package FrontPanel;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import CPU.Registers;
import Memory.Memory;
import WorkFlow.Constants;
import WorkFlow.MachineException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontPanel {
	private Registers registers;
	private Memory memory;
    private JFrame ClassProject;
    private JPanel pnlRegisters;
    private JPanel pnlR0;
    private JLabel lblR;
    private JTextField R0TextField;
    private JButton R0Store;
    private JTextField R1TextField;
    private JButton R1Store;
    private JTextField R2TextField;
    private JButton R2Store;
    private JTextField R3TextField;
    private JButton R3Store;
    private JTextField X1TextField;
    private JButton X1Store;
    private JTextField X2TextField;
    private JButton X2Store;
    private JTextField X3TextField;
    private JButton X3Store;
    private JTextField PCTextField;
    private JButton PCStore;
    private JTextField MARTextField;
    private JButton MARStore;
    private JTextField MBRTextField;
    private JButton MBRStore;
    private JTextField IRTextField;
    private JButton IRStore;
    private JTextField CCTextField;
    private JButton CCStore;
    private JButton IPLButton;
    private JButton SingleStepButton;
    private JButton RunButton;
    private JTextField MemoryTextField;
    private JButton MemoryStore;
    private JButton MemoryQuery;
    private JPanel registerPanel;
    private int enableFlag;
    private int prog1Step;
    private int prog2Step;
    private JPanel R0Panel;
    private JLabel R0Label;
    private JPanel R1Panel;
    private JLabel R1Label;
    private JPanel R2Panel;
    private JLabel R2Label;
    private JPanel R3Panel;
    private JLabel R3Label;
    private JPanel X1Panel;
    private JLabel X1Label;
    private JPanel X2Panel;
    private JLabel X2Label;
    private JPanel X3Panel;
    private JLabel X3Label;
    private JPanel PCPanel;
    private JLabel PCLabel;
    private JPanel MARPanel;
    private JLabel MARLabel;
    private JPanel MBRPanel;
    private JLabel MBRLabel;
    private JPanel IRPanel;
    private JLabel IRLabel;
    private JPanel CCPanel;
    private JLabel CCLabel;
    private JPanel MemoryPanel;
    private JLabel MemoryLabel;
    private JPanel InstructionPanel;
    private JLabel InstructionLabel;
    private JLabel IPLLabel;
    private JLabel RunLabel;
    private JLabel SingleStepLabel;
    private JPanel LogPanel;
    private JTextField InstructionTextField;
    private JTextField LogTextField;
    

    public FrontPanel() {
            initComponents();
            addListeners();

        }
    private void initCPU() {
            registers = new Registers();
            memory = new Memory();
        }
        private void initComponents() {
            ClassProject = new JFrame();
            ClassProject.setTitle("CSCI6461 Project, TEAM: Dishit, Zhaoning, Charitha, Peiyu");
            ClassProject.setBounds(100, 100, 1097, 980);
            ClassProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            registerPanel = new JPanel();
            registerPanel.setBounds(14, 169, 780, 721);
            
            R0Panel = new JPanel();
            R0Panel.setBounds(0,20,200,50);
            registerPanel.add(R0Panel);
            R0Label = new JLabel("R0");
            R0Panel.add(R0Label);
            R0TextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            R0TextField.setEditable(true);
            R0TextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = R0TextField.getText();
				}
            	
            });
            R0Panel.add(R0TextField);
            

            R0Store = new JButton("store");
            R0Store.setBounds(130,20,50,50);
            //registerPanel.add(R0Store);
            R0Store.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            R0Panel.add(R0Store);

            

            R1Panel = new JPanel();
            R1Panel.setBounds(0,20,200,50);
            registerPanel.add(R1Panel);
            R1Label = new JLabel("R1");
            R1Panel.add(R1Label);
            R1TextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            R1TextField.setEditable(true);
            R1TextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = R1TextField.getText();
				}
            	
            });
            R1Panel.add(R1TextField);
            

            R1Store = new JButton("store");
            R1Store.setBounds(130,20,50,50);
            //registerPanel.add(R0Store);
            R1Store.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            R1Panel.add(R1Store);
            
            R2Panel = new JPanel();
            R2Panel.setBounds(0,20,200,50);
            registerPanel.add(R2Panel);
            R2Label = new JLabel("R2");
            R2Panel.add(R2Label);
            R2TextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            R2TextField.setEditable(true);
            R2TextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = R2TextField.getText();
				}
            	
            });
            R2Panel.add(R2TextField);
            

            R2Store = new JButton("store");
            R2Store.setBounds(130,20,50,50);
            //registerPanel.add(R0Store);
            R2Store.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            R2Panel.add(R2Store);
            
            R3Panel = new JPanel();
            R3Panel.setBounds(0,20,200,50);
            registerPanel.add(R3Panel);
            R3Label = new JLabel("R3");
            R3Panel.add(R3Label);
            R3TextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            R3TextField.setEditable(true);
            R3TextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = R3TextField.getText();
				}
            	
            });
            R3Panel.add(R3TextField);
            

            R3Store = new JButton("store");
            R3Store.setBounds(130,20,50,50);
            //registerPanel.add(R0Store);
            R3Store.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            R3Panel.add(R3Store);
            
            X1Panel = new JPanel();
            X1Panel.setBounds(0,30,200,50);
            registerPanel.add(X1Panel);
            X1Label = new JLabel("X1");
            X1Panel.add(X1Label);
            X1TextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            X1TextField.setEditable(true);
            X1TextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = X1TextField.getText();
				}
            	
            });
            X1Panel.add(X1TextField);
            

            X1Store = new JButton("store");
            X1Store.setBounds(130,50,50,50);
            //registerPanel.add(R0Store);
            X1Store.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            X1Panel.add(X1Store);
            
            X2Panel = new JPanel();
            X2Panel.setBounds(0,30,200,50);
            registerPanel.add(X2Panel);
            X2Label = new JLabel("X2");
            X2Panel.add(X2Label);
            X2TextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            X2TextField.setEditable(true);
            X2TextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = X1TextField.getText();
				}
            	
            });
            X2Panel.add(X2TextField);
            

            X2Store = new JButton("store");
            X2Store.setBounds(130,50,50,50);
            //registerPanel.add(R0Store);
            X2Store.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            X2Panel.add(X2Store);
            
            X3Panel = new JPanel();
            X3Panel.setBounds(0,30,200,50);
            registerPanel.add(X3Panel);
            X3Label = new JLabel("X3");
            X3Panel.add(X3Label);
            X3TextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            X3TextField.setEditable(true);
            X3TextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = X3TextField.getText();
				}
            	
            });
            X3Panel.add(X3TextField);
            

            X3Store = new JButton("store");
            X3Store.setBounds(130,50,50,50);
            //registerPanel.add(R0Store);
            X3Store.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            X3Panel.add(X3Store);
            
            PCPanel = new JPanel();
            PCPanel.setBounds(0,30,200,50);
            registerPanel.add(PCPanel);
            PCLabel = new JLabel("PC");
            PCPanel.add(PCLabel);
            PCTextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            PCTextField.setEditable(true);
            PCTextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = PCTextField.getText();
				}
            	
            });
            PCPanel.add(PCTextField);
            

            PCStore = new JButton("store");
            PCStore.setBounds(130,50,50,50);
            //registerPanel.add(R0Store);
            PCStore.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            PCPanel.add(PCStore);
            
            MARPanel = new JPanel();
            MARPanel.setBounds(0,60,200,50);
            registerPanel.add(MARPanel);
            MARLabel = new JLabel("MAR");
            MARPanel.add(MARLabel);
            MARTextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            MARTextField.setEditable(true);
            MARTextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = MARTextField.getText();
				}
            	
            });
            MARPanel.add(MARTextField);
            

            MARStore = new JButton("store");
            MARStore.setBounds(130,50,50,50);
            //registerPanel.add(R0Store);
            MARStore.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            MARPanel.add(MARStore);
            
            MBRPanel = new JPanel();
            MBRPanel.setBounds(0,60,200,50);
            registerPanel.add(MBRPanel);
            MBRLabel = new JLabel("MBR");
            MBRPanel.add(MBRLabel);
            MBRTextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            MBRTextField.setEditable(true);
            MBRTextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = MBRTextField.getText();
				}
            	
            });
            MBRPanel.add(MBRTextField);
            

            MBRStore = new JButton("store");
            MBRStore.setBounds(130,50,50,50);
            //registerPanel.add(R0Store);
            MBRStore.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            MBRPanel.add(MBRStore);
            
            IRPanel = new JPanel();
            IRPanel.setBounds(0,60,200,50);
            registerPanel.add(IRPanel);
            IRLabel = new JLabel("IR");
            IRPanel.add(IRLabel);
            IRTextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            IRTextField.setEditable(true);
            IRTextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = IRTextField.getText();
				}
            	
            });
            IRPanel.add(IRTextField);
            

            IRStore = new JButton("store");
            IRStore.setBounds(130,50,50,50);
            //registerPanel.add(R0Store);
            IRStore.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            IRPanel.add(IRStore);
            
            CCPanel = new JPanel();
            CCPanel.setBounds(0,60,200,50);
            registerPanel.add(CCPanel);
            CCLabel = new JLabel("CC");
            CCPanel.add(CCLabel);
            CCTextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            CCTextField.setEditable(true);
            CCTextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = CCTextField.getText();
				}
            	
            });
            CCPanel.add(CCTextField);
            

            CCStore = new JButton("store");
            CCStore.setBounds(130,50,50,50);
            //registerPanel.add(R0Store);
            CCStore.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            CCPanel.add(CCStore);
            
            MemoryPanel = new JPanel();
            MemoryPanel.setBounds(500,700,200,100);
            ClassProject.getContentPane().add(MemoryPanel);
            MemoryLabel = new JLabel("Memory");
            MemoryPanel.add(MemoryLabel);
            MemoryTextField = new JTextField(10);
            //R0TextField.setBounds(10,20,100,50);
            MemoryTextField.setEditable(true);
            MemoryTextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = MemoryTextField.getText();
				}
            	
            });
            MemoryPanel.add(MemoryTextField);
            

            MemoryStore = new JButton("Store");
            MemoryStore.setBounds(130,50,80,80);
            //registerPanel.add(R0Store);
            MemoryStore.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            MemoryQuery = new JButton("Query");
            MemoryQuery.setBounds(130,50,80,80);
            //registerPanel.add(R0Store);
            MemoryQuery.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            MemoryPanel.add(MemoryStore);
            MemoryPanel.add(MemoryQuery);
            
            InstructionPanel = new JPanel();
            InstructionPanel.setBounds(300,0,200,500);
            ClassProject.getContentPane().add(InstructionPanel);
            InstructionLabel = new JLabel("Instruction");
            InstructionPanel.add(InstructionLabel);
            InstructionTextField = new JTextField(300);
            //R0TextField.setBounds(10,20,100,50);
            InstructionTextField.setEditable(true);
            InstructionTextField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = InstructionTextField.getText();
				}
            	
            });
            InstructionPanel.add(InstructionTextField);
            

            IPLButton = new JButton("IPL");
            IPLButton.setBounds(130,50,50,50);
            //registerPanel.add(R0Store);
            IPLButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            MARPanel.add(MARStore);
            IPLButton = new JButton("IPL");
            IPLButton.setBounds(100, 29, 153, 69);
            IPLButton.setEnabled(false);
            //ClassProject.getContentPane().add(IPLButton);
            
            SingleStepButton = new JButton("Single Step");
            SingleStepButton.setBounds(186, 29, 153, 69);
            SingleStepButton.setEnabled(false);
            //ClassProject.getContentPane().add(SingleStepButton);
            
            RunButton = new JButton("Run");
            RunButton.setBounds(266, 29, 153, 69);
            RunButton.setEnabled(false);
            //ClassProject.getContentPane().add(RunButton);
            
            ClassProject.getContentPane().add(registerPanel);
            
        }
        private void addListeners() {
        	
        }
public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrontPanel window = new FrontPanel();
                    window.ClassProject.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}*/
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
	protected JTextArea txtrDfasdf;
	public JTextArea txtrTtg;

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
		lblMemory.setBounds(177, 710, 60, 21);
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
		lblTeamCharitha.setBounds(154, 780, 457, 30);
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


