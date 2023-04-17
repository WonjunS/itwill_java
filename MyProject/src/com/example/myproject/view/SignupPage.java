package com.example.myproject.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.myproject.controller.MemberDaoImpl;
import com.example.myproject.model.Member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SignupPage extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;
	private JPasswordField textPassword;
	private JLabel lblName;
	private JTextField textName;
	private JLabel lblEmail;
	private JLabel lblPasswd;
	private JButton btnSignup;
	
	private Component parent;
	private MainPage app;

	/**
	 * Launch the application.
	 */
	public static void createMemberSignup(Component parent, MainPage app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupPage frame = new SignupPage(parent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public SignupPage(Component parent, MainPage app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}
	
	private final MemberDaoImpl dao = MemberDaoImpl.getInstance();

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 304);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblName.setBounds(25, 31, 130, 45);
		panel.add(lblName);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblEmail.setBounds(25, 117, 130, 45);
		panel.add(lblEmail);
		
		lblPasswd = new JLabel("Password");
		lblPasswd.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblPasswd.setBounds(25, 214, 130, 45);
		panel.add(lblPasswd);
		
		textName = new JTextField();
		textName.setFont(new Font("Consolas", Font.PLAIN, 20));
		textName.setBounds(178, 31, 278, 45);
		panel.add(textName);
		textName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Consolas", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(178, 117, 278, 45);
		panel.add(textEmail);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Consolas", Font.PLAIN, 20));
		textPassword.setBounds(178, 214, 278, 45);
		panel.add(textPassword);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 303, 484, 72);
		contentPane.add(buttonPanel);
		
		btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String email = textEmail.getText();
				String password = textPassword.getText();
				
				if(name.length() == 0) {
					JOptionPane.showMessageDialog(SignupPage.this, "이름을 입력해주세요.");
					return;
				}
				if(email.length() == 0) {
					JOptionPane.showMessageDialog(SignupPage.this, "이메일을 입력해주세요.");
					return;
				}
				if(password.length() < 6) {
					JOptionPane.showMessageDialog(SignupPage.this, "비밀번호는 6자 이상이어야 합니다.");
					return;
				}
				
				boolean isEmailExists = dao.validateEmail(email);
				if(!isEmailExists) {
					Member member = new Member(0, name, email, password);
					dao.createMember(member);
					app.notifyMemberCreated();
					dispose();
				} else {
					JOptionPane.showMessageDialog(SignupPage.this, "이미 사용중인 이메일 입니다.");
					textEmail.setText("");
				}
			}
		});
		btnSignup.setFont(new Font("Consolas", Font.PLAIN, 20));
		buttonPanel.add(btnSignup);
	}

}
