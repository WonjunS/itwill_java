package com.example.myproject.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.myproject.controller.PostDaoImpl;
import com.example.myproject.model.Member;
import com.example.myproject.model.Post;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import java.awt.SystemColor;

public class PostWrite extends JFrame {

	private final PostDaoImpl dao = PostDaoImpl.getInstance();
	private Member member;
	private JPanel contentPane;
	private JTextField textTitle;
	private JLabel lblTitle;
	private JScrollPane scrollPane;
	private JTextField textContent;
	
	private Component parent;
	private MainPage app;
	private JPanel panel;
	private JButton btnCancel;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void createPostWrite(Component parent, MainPage app, Member member) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostWrite frame = new PostWrite(parent, app, member);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PostWrite(Component parent, MainPage app, Member member) {
		this.parent = parent;
		this.app = app;
		this.member = member;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("글쓰기");
		
		int x = 100, y = 100;
		
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 532, 574);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblTitle.setBounds(12, 10, 68, 33);
		contentPane.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("Consolas", Font.PLAIN, 15));
		textTitle.setBounds(101, 9, 407, 33);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		JLabel lblContent = new JLabel("내용");
		lblContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblContent.setBounds(12, 226, 78, 33);
		contentPane.add(lblContent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 62, 407, 368);
		contentPane.add(scrollPane);
		
		textContent = new JTextField();
		textContent.setFont(new Font("Consolas", Font.PLAIN, 15));
		textContent.setColumns(10);
		scrollPane.setViewportView(textContent);
		
		btnRegister = new JButton("글쓰기");
		btnRegister.setForeground(SystemColor.window);
		btnRegister.setBackground(SystemColor.desktop);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = textTitle.getText();
				String content = textContent.getText();
				
				if(title.trim().length() == 0) {
					JOptionPane.showMessageDialog(lblContent, "제목을 입력해주세요.");
					return;
				}
				if(content.trim().length() == 0) {
					JOptionPane.showMessageDialog(lblContent, "내용을 입력해주세요.");
					return;
				}
				
				Post post = new Post(0, title, content, member.getNickname(), 0, 0, 
						LocalDateTime.now(), LocalDateTime.now(), member.getMemberId());
				
				dao.create(post);
				
				app.notifyPostWrite();
				
				dispose();
			}
		});
		btnRegister.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnRegister.setBounds(216, 462, 130, 40);
		contentPane.add(btnRegister);
		
		btnCancel = new JButton("취소");
		btnCancel.setForeground(SystemColor.window);
		btnCancel.setBackground(SystemColor.desktop);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnCancel.setBounds(378, 462, 130, 40);
		contentPane.add(btnCancel);
	}
}
