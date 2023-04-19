package com.example.myproject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.myproject.controller.MemberDaoImpl;
import com.example.myproject.controller.PostDaoImpl;
import com.example.myproject.model.Member;
import com.example.myproject.model.Post;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;

public class MainPage {
	
	private static final String[] COLUMN_NAMES = {"ID", "Title", "Writer", "View", "Date"};

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
	
	private final MemberDaoImpl memberDao = MemberDaoImpl.getInstance();
	private final PostDaoImpl postDao = PostDaoImpl.getInstance();
	
	private boolean isAuthenticated = false;
	private Member loginMember = null;
	private JButton btnToSignup;
	private JPanel defaultPanel;
	
	private JPanel authenticatedPanel;
	private JTextField memberInfo;
	private JButton btnLogout;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField searchTextField;
	private JButton btnWrite;
	private JButton btnSearch;
	private JComboBox comboBox;
	
	private List<Post> postList;


	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
		loadAllPosts();
	}
	
	private void resetTableModel() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		loadAllPosts();
		table.setModel(model);
		
		table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(45);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(164);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(3).setPreferredWidth(45);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(4).setPreferredWidth(140);
	}
	
	private void loadAllPosts() {
		postList = postDao.read();
		for(Post p : postList) {
			Object[] row = {p.getPostId(), p.getTitle(), p.getWriter(), p.getViews(), p.getCreatedTime()};
			model.addRow(row);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("게시판");
		frame.setBounds(100, 100, 754, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// 로그인 전 화면
		defaultPanel = new JPanel();
		defaultPanel.setBounds(0, 0, 738, 537);
		frame.getContentPane().add(defaultPanel);
		defaultPanel.setLayout(null);
		
		btnToLogin = new JButton("로그인");
		btnToLogin.setBounds(69, 375, 142, 39);
		defaultPanel.add(btnToLogin);
		btnToLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage.createMemberLogin(frame, MainPage.this);
			}
		});
		btnToLogin.setFont(new Font("D2Coding", Font.PLAIN, 20));
		
		btnToSignup = new JButton("회원가입");
		btnToSignup.setBounds(254, 375, 142, 39);
		defaultPanel.add(btnToSignup);
		btnToSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignupPage.createMemberSignup(frame, MainPage.this);
			}
		});
		btnToSignup.setFont(new Font("D2Coding", Font.PLAIN, 20));
		
		
		// 로그인 후 화면
		authenticatedPanel = new JPanel();
		authenticatedPanel.setVisible(false);
		authenticatedPanel.setBounds(0, 0, 738, 537);
		frame.getContentPane().add(authenticatedPanel);
		authenticatedPanel.setLayout(null);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(619, 10, 107, 33);
		authenticatedPanel.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "로그아웃 되었습니다.");
				loginMember = null;
				authenticatedPanel.setVisible(false);
				defaultPanel.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("D2Coding", Font.PLAIN, 16));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 714, 326);
		authenticatedPanel.add(scrollPane);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				
				PostRead.createPostRead(frame, MainPage.this, loginMember, postList.get(selectedRow));
				postDao.updateView(postList.get(selectedRow));
				resetTableModel();
			}
		});
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		btnWrite = new JButton("글쓰기");
		btnWrite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PostWrite.createPostWrite(frame, MainPage.this, loginMember);
			}
		});
		btnWrite.setBounds(619, 462, 107, 33);
		authenticatedPanel.add(btnWrite);
		btnWrite.setFont(new Font("D2Coding", Font.PLAIN, 16));
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String keyword = searchTextField.getText();
				
				postList = postDao.read(keyword);
				
				model = new DefaultTableModel(null, COLUMN_NAMES);

				for(Post p : postList) {
					Object[] row = {p.getPostId(), p.getTitle(), p.getWriter(), p.getViews(), p.getCreatedTime()};
					model.addRow(row);
				}
				
				table.setModel(model);
			}
		});
		btnSearch.setBounds(619, 61, 107, 32);
		authenticatedPanel.add(btnSearch);
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 16));
		
		searchTextField = new JTextField();
		searchTextField.setBounds(415, 61, 192, 32);
		authenticatedPanel.add(searchTextField);
		searchTextField.setFont(new Font("Consolas", Font.PLAIN, 15));
		searchTextField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"title", "content", "writer"}));
		comboBox.setBounds(316, 61, 80, 32);
		authenticatedPanel.add(comboBox);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		
	}
	
	public void notifyMemberLogin(Member member) {
		JOptionPane.showMessageDialog(frame, "로그인 성공");
		
		// 로그인 된 회원정보 저장
		isAuthenticated = true;
		loginMember = member;
		
		defaultPanel.setVisible(false);
		authenticatedPanel.setVisible(true);
	}
	
	public void notifyMemberCreated() {
		JOptionPane.showMessageDialog(frame, "회원가입 성공");
	}
	
	public void notifyPostWrite() {
		JOptionPane.showMessageDialog(frame, "게시글 등록 성공");
		
		resetTableModel();
	}
	
	public void notifyPostUpdate() {
		JOptionPane.showMessageDialog(frame, "게시글 수정 성공");
		
		resetTableModel();
	}
	
	public void notifyPostDelete() {
		JOptionPane.showMessageDialog(frame, "게시글 삭제 성공");
		
		resetTableModel();
	}
}
