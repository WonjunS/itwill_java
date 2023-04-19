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

public class PostRead extends JFrame {

	private final PostDaoImpl dao = PostDaoImpl.getInstance();
	private Member member;
	private Post post;
	
	private JPanel contentPane;
	private JTextField textTitle;
	private JLabel lblTitle;
	private JScrollPane scrollPane;
	private JTextField textContent;
	
	private Component parent;
	private MainPage app;
	private JPanel panel;
	private JButton btnClose;
	private JButton btnDelete;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void createPostRead(Component parent, MainPage app, Member member, Post post) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostRead frame = new PostRead(parent, app, member, post);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PostRead(Component parent, MainPage app, Member member, Post post) {
		this.parent = parent;
		this.app = app;
		this.member = member;
		this.post = post;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		int x = 100, y = 100;
		
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x, y, 532, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblTitle.setBounds(12, 10, 68, 33);
		contentPane.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setText(post.getTitle());
		textTitle.setEditable(false);
		textTitle.setFont(new Font("Consolas", Font.PLAIN, 15));
		textTitle.setBounds(101, 9, 407, 33);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblContent.setBounds(12, 226, 78, 33);
		contentPane.add(lblContent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 62, 407, 368);
		contentPane.add(scrollPane);
		
		textContent = new JTextField();
		textContent.setText(post.getContent());
		textContent.setEditable(false);
		textContent.setFont(new Font("Consolas", Font.PLAIN, 15));
		textContent.setColumns(10);
		scrollPane.setViewportView(textContent);
		
		if(post.getMemberId() == member.getMemberId()) {
			textTitle.setEditable(true);
			textContent.setEditable(true);
			
			btnEdit = new JButton("글수정");
			btnEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					updatePost();
				}
			});
			btnEdit.setFont(new Font("D2Coding", Font.PLAIN, 20));
			btnEdit.setBounds(58, 462, 130, 40);
			contentPane.add(btnEdit);
			
			btnDelete = new JButton("글삭제");
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					deletePost();
				}
			});
			btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
			btnDelete.setBounds(216, 462, 130, 40);
			contentPane.add(btnDelete);
		}
		
		btnClose = new JButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnClose.setBounds(378, 462, 130, 40);
		contentPane.add(btnClose);
		
	}
	
	private void updatePost() {
		String title = textTitle.getText();
		String content = textContent.getText();
		
		if(title.length() == 0) {
			JOptionPane.showMessageDialog(panel, "제목을 입력해주세요.");
			return;
		}
		if(content.length() == 0) {
			JOptionPane.showMessageDialog(panel, "내용을 입력해주세요.");
			return;
		}
		
		post.setTitle(title);
		post.setContent(content);
		
		dao.update(post);
		
		app.notifyPostUpdate();
		
		dispose();
	}
	
	private void deletePost() {
		int answer = JOptionPane.showConfirmDialog(panel, "정말 삭제할까요?");
		if(answer == 0) {
			dao.delete(post.getPostId());
			
			app.notifyPostDelete();
			
			dispose();
		}
	}
}
