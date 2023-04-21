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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class NicknameUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField nicknameField;
	private JLabel lblNickname;
	private JButton btnNewButton;
	private JButton btnSave;
	
	private final MemberDaoImpl dao = MemberDaoImpl.getInstance();
	private boolean flag = false;
	private Member loginMember;
	private Component parent;
	private MainPage app;
	

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
		contentPane.setBackground(SystemColor.inactiveCaption);
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
		btnSave.setBackground(SystemColor.desktop);
		btnSave.setForeground(SystemColor.window);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = nicknameField.getText();
				
				if(!flag) {
					JOptionPane.showMessageDialog(parent, "닉네임 중복 확인을 해주세요.");
					return;
				}
				
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
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = nicknameField.getText();
				
				boolean isAvailable = dao.validateNickname(input);
				if(!isAvailable) {
					JOptionPane.showMessageDialog(parent, "이미 사용중인 닉네임 입니다.");
					return;
				}
				
				JOptionPane.showMessageDialog(parent, "사용 가능한 닉네임 입니다.");
				flag = true;
			}
		});
		btnNewButton.setFont(new Font("D2Coding", Font.PLAIN, 12));
		btnNewButton.setBounds(337, 67, 85, 31);
		contentPane.add(btnNewButton);
	}
}