package com.example.project.view;

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
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.example.project.controller.MemberDaoImpl;
import com.example.project.model.Member;

public class PasswordUpdate extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurrentPassword;
	private JLabel lblNewPasswordConfirm;
	private JLabel lblNewPassword;
	private JPasswordField currentPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField passwordConfirmField;
	private JButton btnSave;
	
	private final MemberDaoImpl dao = MemberDaoImpl.getInstance();
	private Member loginMember;
	private Component parent;
	private MainPage app;

	/**
	 * Launch the application.
	 */
	public static void createPasswordUpdate(Component parent, MainPage app, Member member) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordUpdate frame = new PasswordUpdate(parent, app, member);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PasswordUpdate(Component parent, MainPage app, Member member) {
		this.parent = parent;
		this.app = app;
		this.loginMember = member;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("비밀번호 변경");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 516, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCurrentPassword = new JLabel("현재 비밀번호");
		lblCurrentPassword.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblCurrentPassword.setBounds(12, 47, 130, 30);
		contentPane.add(lblCurrentPassword);
		
		lblNewPassword = new JLabel("새 비밀번호");
		lblNewPassword.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblNewPassword.setBounds(12, 101, 130, 30);
		contentPane.add(lblNewPassword);
		
		lblNewPasswordConfirm = new JLabel("새 비밀번호 확인");
		lblNewPasswordConfirm.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblNewPasswordConfirm.setBounds(12, 161, 160, 30);
		contentPane.add(lblNewPasswordConfirm);
		
		currentPasswordField = new JPasswordField();
		currentPasswordField.setFont(new Font("D2Coding", Font.PLAIN, 15));
		currentPasswordField.setBounds(198, 47, 290, 30);
		contentPane.add(currentPasswordField);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setFont(new Font("D2Coding", Font.PLAIN, 15));
		newPasswordField.setBounds(198, 101, 290, 30);
		contentPane.add(newPasswordField);
		
		passwordConfirmField = new JPasswordField();
		passwordConfirmField.setFont(new Font("D2Coding", Font.PLAIN, 15));
		passwordConfirmField.setBounds(198, 158, 290, 33);
		contentPane.add(passwordConfirmField);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currPassword = currentPasswordField.getText();
				String newPassword = newPasswordField.getText();
				String confirmPassword = passwordConfirmField.getText();
				
				if(!loginMember.getPassword().equals(currPassword)) {
					JOptionPane.showMessageDialog(parent, "비밀번호가 틀렸습니다.");
					return;
				}
				if(loginMember.getPassword().equals(newPassword)) {
					JOptionPane.showMessageDialog(parent, "현재 비밀번호와 같은 비밀번호로 설정할 수 없습니다.");
					return;
				}
				if(newPassword.trim().length() < 6) {
					JOptionPane.showMessageDialog(parent, "비밀번호는 6자 이상이어야 합니다.");
					return;
				}
				if(!newPassword.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(parent, "비밀번호가 일치하지 않습니다.");
					return;
				}
				
				loginMember.setPassword(newPassword);
				
				dao.updatePassword(loginMember);
				
				app.notifyPasswordUpdate(loginMember);
				
				dispose();
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnSave.setBounds(188, 220, 119, 30);
		contentPane.add(btnSave);
	}
}
