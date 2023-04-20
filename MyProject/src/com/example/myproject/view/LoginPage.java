package com.example.project.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.example.project.controller.MemberDaoImpl;
import com.example.project.model.Member;

import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
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
	private JLabel lblFindPassword;
	private JButton btnNewButton;

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
		setBounds(x, y, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 434, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setBackground(new Color(255, 255, 255));
		lblEmail.setBounds(35, 20, 88, 24);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		panel.add(lblEmail);

		
		lblPasswd = new JLabel("비밀번호");
		lblPasswd.setBounds(35, 111, 88, 24);
		lblPasswd.setFont(new Font("D2Coding", Font.PLAIN, 20));
		panel.add(lblPasswd);
		
		textLogin = new JTextField();
		textLogin.setBounds(35, 48, 356, 36);
		textLogin.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textLogin.setColumns(10);
		panel.add(textLogin);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textPassword.setColumns(10);
		textPassword.setBounds(35, 138, 356, 36);
		panel.add(textPassword);
		
		btnLogin = new JButton("로그인");
		btnLogin.setBackground(Color.black);
		btnLogin.setForeground(Color.white);
		btnLogin.setBounds(35, 235, 356, 36);
		panel.add(btnLogin);
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
		
		lblFindPassword = new JLabel("비밀번호 찾기");
		lblFindPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(panel, "비밀번호 찾기");
			}
		});
		lblFindPassword.setFont(new Font("D2Coding", Font.PLAIN, 14));
		lblFindPassword.setBounds(35, 196, 97, 15);
		panel.add(lblFindPassword);
		
	}
}