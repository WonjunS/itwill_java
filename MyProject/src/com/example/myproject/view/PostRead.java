package com.example.myproject.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.example.myproject.controller.PostDaoImpl;
import com.example.myproject.model.Member;
import com.example.myproject.model.Post;

public class PostRead extends JFrame {

	private final PostDaoImpl dao = PostDaoImpl.getInstance();
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private Member member;
	private Post post;
	
	private JPanel contentPane;
	private JTextField textTitle;
	
	private Component parent;
	private MainPage app;
	private JPanel panel;
	private JButton btnClose;
	private JButton btnDelete;
	private JButton btnEdit;
	private JTextField textContent;
	private JTextField textWriter;
	private JTextField textCreatedTime;

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
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textTitle = new JTextField();
		textTitle.setText(post.getTitle());
		textTitle.setEditable(false);
		textTitle.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textTitle.setBounds(12, 9, 496, 33);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		textWriter = new JTextField();
		textWriter.setText(post.getWriter());
		textWriter.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textWriter.setEditable(false);
		textWriter.setColumns(10);
		textWriter.setBounds(12, 52, 248, 33);
		contentPane.add(textWriter);
		
		textCreatedTime = new JTextField();
		textCreatedTime.setText(post.getCreatedTime().format(formatter));
		textCreatedTime.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textCreatedTime.setEditable(false);
		textCreatedTime.setColumns(10);
		textCreatedTime.setBounds(260, 52, 248, 33);
		contentPane.add(textCreatedTime);
		
		textContent = new JTextField();
		textContent.setText(post.getContent());
		textContent.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textContent.setEditable(false);
		textContent.setColumns(10);
		textContent.setBounds(12, 109, 496, 366);
		contentPane.add(textContent);
		
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
			btnEdit.setBounds(58, 485, 130, 40);
			contentPane.add(btnEdit);
			
			btnDelete = new JButton("글삭제");
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					deletePost();
				}
			});
			btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
			btnDelete.setBounds(216, 485, 130, 40);
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
		btnClose.setBounds(378, 485, 130, 40);
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
