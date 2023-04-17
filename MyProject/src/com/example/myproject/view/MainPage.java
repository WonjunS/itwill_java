package com.example.myproject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.example.myproject.controller.MemberDaoImpl;
import com.example.myproject.model.Member;

import javax.swing.JPanel;

public class MainPage {

	private JFrame frame;
	private JButton btnToLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private final MemberDaoImpl dao = MemberDaoImpl.getInstance();
	private boolean isAuthenticated = false;
	private Member loginMember = null;
	private JButton btnToSignup;
	private JButton btnLogout;
	private JPanel defaultPanel;
	private JPanel authenticatedPanel;
	private JTextField memberInfo;

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// 로그인 전 화면
		defaultPanel = new JPanel();
		defaultPanel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(defaultPanel);
		defaultPanel.setLayout(null);
		
		btnToLogin = new JButton("Login");
		btnToLogin.setBounds(47, 183, 142, 39);
		defaultPanel.add(btnToLogin);
		btnToLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage.createMemberLogin(frame, MainPage.this);
			}
		});
		btnToLogin.setFont(new Font("Consolas", Font.PLAIN, 20));
		
		btnToSignup = new JButton("Signup");
		btnToSignup.setBounds(238, 183, 142, 39);
		defaultPanel.add(btnToSignup);
		btnToSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignupPage.createMemberSignup(frame, MainPage.this);
			}
		});
		btnToSignup.setFont(new Font("Consolas", Font.PLAIN, 20));
		
		memberInfo = new JTextField();
		memberInfo.setBounds(235, 10, 187, 48);
		defaultPanel.add(memberInfo);
		memberInfo.setEditable(false);
		memberInfo.setFont(new Font("Consolas", Font.PLAIN, 20));
		memberInfo.setColumns(10);
		
		// 로그인 후 화면
		authenticatedPanel = new JPanel();
		authenticatedPanel.setVisible(false);
		authenticatedPanel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(authenticatedPanel);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(47, 183, 142, 39);
		authenticatedPanel.setLayout(null);
		authenticatedPanel.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyMemberLogout();
			}
		});
		btnLogout.setFont(new Font("Consolas", Font.PLAIN, 20));
		
	}
	
	public void notifyMemberLogin(Member member) {
		JOptionPane.showMessageDialog(frame, "로그인 성공");
		
		// 로그인 된 회원정보 저장
		isAuthenticated = true;
		loginMember = member;
		
		memberInfo.setText("name = " + loginMember.getMemberName());
		
		defaultPanel.setVisible(false);
		authenticatedPanel.setVisible(true);
	}
	
	public void notifyMemberLogout() {
		JOptionPane.showMessageDialog(frame, "로그아웃 성공");
		
		// 로그인된 회원 정보 초기화
		isAuthenticated = false;
		loginMember = null;
		
		defaultPanel.setVisible(true);
		authenticatedPanel.setVisible(false);
	}
	
	public void notifyMemberCreated() {
		JOptionPane.showMessageDialog(frame, "회원가입 성공");
	}
	
}
