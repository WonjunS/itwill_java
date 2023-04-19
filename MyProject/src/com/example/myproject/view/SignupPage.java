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
	private JTextField textNickname;
	private JLabel lblNickname;
	private JPasswordField passwordConfirm;
	private JLabel lblPasswdConfirm;

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("회원가입");
		
		int x = 100, y = 100;
		
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 498, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 379);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblName.setBounds(25, 31, 130, 45);
		panel.add(lblName);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblEmail.setBounds(25, 94, 130, 45);
		panel.add(lblEmail);
		
		lblPasswd = new JLabel("비밀번호");
		lblPasswd.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblPasswd.setBounds(25, 160, 130, 45);
		panel.add(lblPasswd);
		
		lblPasswdConfirm = new JLabel("비밀번호 확인");
		lblPasswdConfirm.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblPasswdConfirm.setBounds(25, 225, 130, 45);
		panel.add(lblPasswdConfirm);
		
		lblNickname = new JLabel("닉네임");
		lblNickname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblNickname.setBounds(25, 294, 130, 45);
		panel.add(lblNickname);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textName.setBounds(178, 31, 278, 45);
		panel.add(textName);
		textName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(178, 94, 278, 45);
		panel.add(textEmail);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textPassword.setBounds(178, 160, 278, 45);
		panel.add(textPassword);
		
		passwordConfirm = new JPasswordField();
		passwordConfirm.setFont(new Font("D2Coding", Font.PLAIN, 16));
		passwordConfirm.setBounds(178, 225, 278, 45);
		panel.add(passwordConfirm);
		
		textNickname = new JTextField();
		textNickname.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textNickname.setColumns(10);
		textNickname.setBounds(178, 294, 278, 45);
		panel.add(textNickname);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 381, 484, 72);
		contentPane.add(buttonPanel);
		
		btnSignup = new JButton("회원가입");
		btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String email = textEmail.getText();
				String password = textPassword.getText();
				String passwordConf = passwordConfirm.getText();
				String nickname = textNickname.getText();
				
				if(name.trim().length() == 0) {
					JOptionPane.showMessageDialog(SignupPage.this, "이름을 입력해주세요.");
					return;
				}
				if(email.trim().length() == 0) {
					JOptionPane.showMessageDialog(SignupPage.this, "이메일을 입력해주세요.");
					return;
				}
				if(password.trim().length() < 6) {
					JOptionPane.showMessageDialog(SignupPage.this, "비밀번호는 6자 이상이어야 합니다.");
					return;
				}
				if(!password.equals(passwordConf)) {
					JOptionPane.showMessageDialog(SignupPage.this, "비밀번호가 일치하지 않습니다.");
					return;
				}
				if(nickname.trim().length() == 0) {
					JOptionPane.showMessageDialog(SignupPage.this, "닉네임을 입력해주세요.");
					return;
				}
				
				boolean isEmailExists = dao.validateEmail(email);
				if(!isEmailExists) {
					Member member = new Member(0, name, email, password, nickname);
					dao.createMember(member);
					app.notifyMemberCreated();
					dispose();
				} else {
					JOptionPane.showMessageDialog(SignupPage.this, "이미 사용중인 이메일 입니다.");
					textEmail.setText("");
				}
			}
		});
		btnSignup.setFont(new Font("D2Coding", Font.PLAIN, 20));
		buttonPanel.add(btnSignup);
	}
}
