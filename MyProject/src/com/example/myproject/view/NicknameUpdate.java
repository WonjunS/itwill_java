package com.example.myproject.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.myproject.controller.MemberDaoImpl;
import com.example.myproject.model.Member;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NicknameUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField nicknameField;
	private JLabel lblNickname;
	private JButton btnSave;
	
	private final MemberDaoImpl dao = MemberDaoImpl.getInstance();
	private Member loginMember;
	private Component parent;
	private MainPage app;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void createNicknameUpdate(Component parent, MainPage app, Member loginMember) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NicknameUpdate frame = new NicknameUpdate(parent, app, loginMember);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public NicknameUpdate(Component parent, MainPage app, Member member) {
		this.parent = parent;
		this.app = app;
		this.loginMember = member;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("닉네임 변경");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNickname = new JLabel("닉네임");
		lblNickname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblNickname.setBounds(12, 67, 67, 31);
		contentPane.add(lblNickname);
		
		nicknameField = new JTextField();
		nicknameField.setFont(new Font("D2Coding", Font.PLAIN, 15));
		nicknameField.setBounds(91, 68, 243, 31);
		contentPane.add(nicknameField);
		nicknameField.setColumns(10);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = nicknameField.getText();
				
				loginMember.setNickname(input);
				
				dao.updateNickname(loginMember);
				
				app.notifyNicknameUpdate(loginMember);
				
				dispose();
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnSave.setBounds(148, 191, 121, 38);
		contentPane.add(btnSave);
		
		btnNewButton = new JButton("중복확인");
		btnNewButton.setFont(new Font("D2Coding", Font.PLAIN, 12));
		btnNewButton.setBounds(337, 67, 85, 31);
		contentPane.add(btnNewButton);
	}
}
