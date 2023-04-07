package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class AppMain03 {

	private JFrame frmCalculator;
	private JTextField textNum1;
	private JTextField textNum2;
	private JLabel lblNum1;
	private JLabel lblNum2;
	private JTextArea textArea;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiply;
	private JButton btnDivide;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 438, 549);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		lblNum1 = new JLabel("num1");
		lblNum1.setBackground(new Color(255, 255, 255));
		lblNum1.setFont(new Font("D2Coding", Font.PLAIN, 32));
		lblNum1.setBounds(30, 30, 108, 38);
		frmCalculator.getContentPane().add(lblNum1);
		
		lblNum2 = new JLabel("num2");
		lblNum2.setFont(new Font("D2Coding", Font.PLAIN, 32));
		lblNum2.setBackground(new Color(255, 255, 255));
		lblNum2.setBounds(30, 93, 108, 38);
		frmCalculator.getContentPane().add(lblNum2);
		
		textNum1 = new JTextField();
		textNum1.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textNum1.setBounds(167, 30, 222, 38);
		frmCalculator.getContentPane().add(textNum1);
		textNum1.setColumns(10);
		
		textNum2 = new JTextField();
		textNum2.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textNum2.setColumns(10);
		textNum2.setBounds(167, 93, 222, 38);
		frmCalculator.getContentPane().add(textNum2);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnPlus.setFont(new Font("D2Coding", Font.PLAIN, 32));
		btnPlus.setBounds(30, 169, 50, 50);
		frmCalculator.getContentPane().add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnMinus.setFont(new Font("D2Coding", Font.PLAIN, 32));
		btnMinus.setBounds(130, 169, 50, 50);
		frmCalculator.getContentPane().add(btnMinus);
		
		btnMultiply = new JButton("x");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnMultiply.setFont(new Font("D2Coding", Font.PLAIN, 32));
		btnMultiply.setBounds(238, 169, 50, 50);
		frmCalculator.getContentPane().add(btnMultiply);
		
		btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnDivide.setFont(new Font("D2Coding", Font.PLAIN, 32));
		btnDivide.setBounds(339, 169, 50, 50);
		frmCalculator.getContentPane().add(btnDivide);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("D2Coding", Font.BOLD, 16));
		textArea.setBounds(30, 263, 359, 190);
		frmCalculator.getContentPane().add(textArea);
	}
	
	protected void handleButtonClick(ActionEvent event) {
		// argument로 전달된 ActionEvent 객체에서 이벤트가 발생한 GUI 컴포넌트 정보를 알 수 있다
		
		// JTextField에 입력된 문자열을 읽어서 double 타입으로 변환
		double number1 = 0;
		double number2 = 0;
		try {
			number1 = Double.parseDouble(textNum1.getText());
			number2 = Double.parseDouble(textNum2.getText());
			
		} catch(NumberFormatException e) {
			textArea.setText("number1, 2는 숫자로 입력하세요...");
			return;
		}
		
		double result = 0; // 사칙 연산 결과를 저장할 변수
		String op = ""; // 사칙 연산 연산자를 저장할 변수
		
		Object source = event.getSource(); // 이벤트가 발생한 컴포넌트
		if(source == btnPlus) {
			result = number1 + number2;
			op = "+";
		} else if(source == btnMinus) {
			result = number1 - number2;
			op = "-";
		} else if(source == btnMultiply) {
			result = number1 * number2;
			op = "x";
		} else if(source == btnDivide) {
			result = number1 / number2;
			op = "/";
		}
		
		String msg = String.format("%f %s %f = %f", number1, op, number2, (number1 * number2));
		textArea.setText(msg);
	}


}
