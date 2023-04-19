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
	private JButton btnSignup;

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setTitle("로그인");
		
		int x = 100, y = 100;
		
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 202);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setBounds(35, 54, 88, 24);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		panel.add(lblEmail);

		
		lblPasswd = new JLabel("비밀번호");
		lblPasswd.setBounds(35, 127, 88, 24);
		lblPasswd.setFont(new Font("D2Coding", Font.PLAIN, 20));
		panel.add(lblPasswd);
		
		textLogin = new JTextField();
		textLogin.setBounds(161, 48, 230, 36);
		textLogin.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textLogin.setColumns(10);
		panel.add(textLogin);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textPassword.setColumns(10);
		textPassword.setBounds(161, 121, 230, 36);
		panel.add(textPassword);
		
		loginPanel = new JPanel();
		loginPanel.setBounds(0, 202, 434, 59);
		contentPane.add(loginPanel);
		
		btnLogin = new JButton("로그인");
		loginPanel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = textLogin.getText();
				String password = textPassword.getText();
				
				Member member = dao.getLoginInfo(email, password);
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
		btnLogin.setFont(new Font("D2Coding", Font.PLAIN, 20));
		
		btnSignup = new JButton("회원가입");
		btnSignup.setFont(new Font("D2Coding", Font.PLAIN, 20));
		loginPanel.add(btnSignup);
		
	}
}
