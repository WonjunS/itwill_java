package com.example.myproject.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.example.myproject.controller.MemberDaoImpl;
import com.example.myproject.model.Member;

import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel loginPanel;
	private JTextField textLogin;
	private JPasswordField textPassword;
	private JLabel lblPasswd;
	private JLabel lblEmail;
	private JButton btnLogin;
	
	private Component parent;
	private MainPage app;

	/**
	 * Launch the application.
	 */
	public static void createMemberLogin(Component parent, MainPage app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage(parent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginPage(Component parent, MainPage app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}
	
	private final MemberDaoImpl dao = MemberDaoImpl.getInstance();

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setTitle("로그인");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 202);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(35, 54, 55, 24);
		lblEmail.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel.add(lblEmail);

		
		lblPasswd = new JLabel("Password");
		lblPasswd.setBounds(35, 127, 88, 24);
		lblPasswd.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel.add(lblPasswd);
		
		textLogin = new JTextField();
		textLogin.setBounds(185, 48, 206, 36);
		textLogin.setFont(new Font("Consolas", Font.PLAIN, 20));
		textLogin.setColumns(10);
		panel.add(textLogin);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Consolas", Font.PLAIN, 20));
		textPassword.setColumns(10);
		textPassword.setBounds(185, 121, 206, 36);
		panel.add(textPassword);
		
		loginPanel = new JPanel();
		loginPanel.setBounds(0, 202, 434, 59);
		contentPane.add(loginPanel);
		
		btnLogin = new JButton("Login");
		loginPanel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = textLogin.getText();
				String password = textPassword.getText();
				System.out.println(email + " " + password);
				
				Member member = dao.getLoginInfo(email, password);
				System.out.println(member);
				if(member != null) {
					app.notifyMemberLogin(member);
					dispose();
				} else {
					JOptionPane.showMessageDialog(LoginPage.this, "이메일 혹은 비밀번호를 확인해주세요.");
					textLogin.setText("");
					textPassword.setText("");
				}
			}
		});
		btnLogin.setFont(new Font("Consolas", Font.PLAIN, 20));
		
	}
}
