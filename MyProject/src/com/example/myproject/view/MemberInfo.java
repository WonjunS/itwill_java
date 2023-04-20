package com.example.project.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.example.project.controller.MemberDaoImpl;
import com.example.project.model.Member;

public class MemberInfo extends JFrame {

	private JPanel contentPane;
	
	private final MemberDaoImpl dao = MemberDaoImpl.getInstance();
	private Component parent;
	private MainPage app;
	private Member loginMember;
	private JLabel lblName;
	private JLabel lblNickname;
	private JLabel lblEmail;
	private JLabel lblCreatedTime;
	private JTextField textName;
	private JTextField textNickname;
	private JTextField textEmail;
	private JTextField textCreatedTime;

	/**
	 * Launch the application.
	 */
	public static void createMemberInfo(Component parent, MainPage app, Member loginMember) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInfo frame = new MemberInfo(parent, app, loginMember);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MemberInfo(Component parent, MainPage app, Member loginMember) {
		this.parent = parent;
		this.app = app;
		this.loginMember = loginMember;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("회원정보");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblName.setBounds(12, 57, 87, 33);
		contentPane.add(lblName);
		
		lblNickname = new JLabel("닉네임");
		lblNickname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblNickname.setBounds(12, 118, 87, 33);
		contentPane.add(lblNickname);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblEmail.setBounds(12, 183, 87, 33);
		contentPane.add(lblEmail);
		
		lblCreatedTime = new JLabel("가입일자");
		lblCreatedTime.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblCreatedTime.setBounds(12, 247, 87, 33);
		contentPane.add(lblCreatedTime);
		
		textName = new JTextField();
		textName.setEditable(false);
		textName.setText(loginMember.getMemberName());
		textName.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textName.setBounds(111, 57, 354, 33);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textNickname = new JTextField();
		textNickname.setEditable(false);
		textNickname.setText(loginMember.getNickname());
		textNickname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textNickname.setColumns(10);
		textNickname.setBounds(111, 118, 354, 33);
		contentPane.add(textNickname);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setText(loginMember.getEmail());
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(111, 183, 354, 33);
		contentPane.add(textEmail);
		
		textCreatedTime = new JTextField();
		textCreatedTime.setEditable(false);
		textCreatedTime.setText(loginMember.getCreatedTime().toString());
		textCreatedTime.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textCreatedTime.setColumns(10);
		textCreatedTime.setBounds(111, 247, 354, 33);
		contentPane.add(textCreatedTime);
	}

}
