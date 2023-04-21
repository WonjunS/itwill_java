package com.example.myproject.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.myproject.controller.MemberDaoImpl;
import com.example.myproject.controller.PostDaoImpl;
import com.example.myproject.model.Member;
import com.example.myproject.model.Post;

public class MainPage {
	
	private static final String[] COLUMN_NAMES = {"번호", "제목", "작성자", "조회수", "작성일"};

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
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	private List<Post> postList;
	private boolean isAuthenticated = false;
	private Member loginMember = null;
	
	private JFrame frame;
	private JButton btnLogin;
	private JButton btnSignup;
	private JPanel defaultPanel;
	private JPanel authenticatedPanel;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField searchTextField;
	private JButton btnWrite;
	private JButton btnSearch;
	private JComboBox comboBox;
	
	private JMenuItem mntmEditPassword;
	private JMenuItem mntmLogoutMenuItem;
	private JMenu mnMember;
	private JMenuBar menuBar;
	private JMenuItem mntmEditNickname;
	private JMenuItem mntmMemberInfo;
	private JMenu mnChatMenu;
	private JMenuItem mntmNewMenuItem;
	private JLabel lblImage;


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
	}
	
	private void loadAllPosts() {
		postList = postDao.read();
		for(Post p : postList) {
			Object[] row = {p.getPostId(), p.getTitle(), p.getWriter(), p.getViews(), 
					p.getCreatedTime().format(formatter)};
			
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// 로그인 전 화면
		defaultPanel = new JPanel();
		defaultPanel.setBounds(0, 0, 738, 537);
		frame.getContentPane().add(defaultPanel);
		defaultPanel.setLayout(null);
		
		ImageIcon img = new ImageIcon("img/background.jpg");
		lblImage = new JLabel(img);
		lblImage.setBounds(0, 0, 738, 537);
		defaultPanel.add(lblImage);
		
		btnSignup = new JButton("회원가입");
		btnSignup.setForeground(SystemColor.activeCaptionBorder);
		btnSignup.setBackground(SystemColor.info);
		lblImage.add(btnSignup);
		btnSignup.setBounds(584, 425, 142, 39);
		btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignupPage.createMemberSignup(frame, MainPage.this);
			}
		});
		btnSignup.setFont(new Font("D2Coding", Font.PLAIN, 20));
		
		btnLogin = new JButton("로그인");
		btnLogin.setForeground(SystemColor.activeCaptionBorder);
		btnLogin.setBackground(SystemColor.info);
		lblImage.add(btnLogin);
		btnLogin.setBounds(584, 356, 142, 39);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage.createMemberLogin(frame, MainPage.this);
			}
		});
		btnLogin.setFont(new Font("D2Coding", Font.PLAIN, 20));
		
		
		// 로그인 후 화면
		authenticatedPanel = new JPanel();
		authenticatedPanel.setVisible(false);
		authenticatedPanel.setBounds(0, 0, 738, 537);
		frame.getContentPane().add(authenticatedPanel);
		authenticatedPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 714, 304);
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
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String keyword = searchTextField.getText();
				String searchBy = (String) comboBox.getSelectedItem();
				
				if(searchBy.equals("제목")) searchBy = "TITLE";
				if(searchBy.equals("내용")) searchBy = "CONTENT";
				if(searchBy.equals("작성자")) searchBy = "WRITER";
				
				postList = postDao.read(searchBy, keyword);
				
				model = new DefaultTableModel(null, COLUMN_NAMES);

				for(Post p : postList) {
					Object[] row = {p.getPostId(), p.getTitle(), p.getWriter(), p.getViews(), 
							p.getCreatedTime().format(formatter)};
					
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"제목", "내용", "작성자"}));
		comboBox.setBounds(306, 61, 90, 32);
		authenticatedPanel.add(comboBox);
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 16));
		
		btnWrite = new JButton("글쓰기");
		btnWrite.setBounds(619, 435, 107, 33);
		authenticatedPanel.add(btnWrite);
		btnWrite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PostWrite.createPostWrite(frame, MainPage.this, loginMember);
			}
		});
		btnWrite.setFont(new Font("D2Coding", Font.PLAIN, 16));
		
		menuBar = new JMenuBar();
		menuBar.setVisible(false);
		frame.setJMenuBar(menuBar);
		
		mnMember = new JMenu("회원");
		menuBar.add(mnMember);
		
		mntmLogoutMenuItem = new JMenuItem("로그아웃");
		mntmLogoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "로그아웃 되었습니다.");
				loginMember = null;
				authenticatedPanel.setVisible(false);
				menuBar.setVisible(false);
				defaultPanel.setVisible(true);
			}
		});
		
		mntmEditPassword = new JMenuItem("비밀번호 변경");
		mntmEditPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordUpdate.createPasswordUpdate(frame, MainPage.this, loginMember);
			}
		});
		
		mntmMemberInfo = new JMenuItem("회원정보");
		mntmMemberInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberInfo.createMemberInfo(frame, MainPage.this, loginMember);
			}
		});
		mnMember.add(mntmMemberInfo);
		mnMember.add(mntmEditPassword);
		
		mntmEditNickname = new JMenuItem("닉네임 변경");
		mntmEditNickname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NicknameUpdate.createNicknameUpdate(frame, MainPage.this, loginMember);
			}
		});
		mnMember.add(mntmEditNickname);
		mnMember.add(mntmLogoutMenuItem);
		
		mnChatMenu = new JMenu("채팅");
		menuBar.add(mnChatMenu);
		
		mntmNewMenuItem = new JMenuItem("채팅 들어가기");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnChatMenu.add(mntmNewMenuItem);
		
	}
	
	public void notifyMemberLogin(Member member) {
		JOptionPane.showMessageDialog(frame, "로그인 성공");
		
		// 로그인 된 회원정보 저장
		isAuthenticated = true;
		loginMember = member;
		
		defaultPanel.setVisible(false);
		menuBar.setVisible(true);
		authenticatedPanel.setVisible(true);
	}
	
	public void notifyMemberCreated() {
		JOptionPane.showMessageDialog(frame, "회원가입 성공");
	}
	
	public void notifyNicknameUpdate(Member member) {
		JOptionPane.showMessageDialog(frame, "닉네임 변경 성공");
		
		loginMember = member;
	}
	
	public void notifyPasswordUpdate(Member member) {
		JOptionPane.showMessageDialog(frame, "비밀번호 변경 성공");
		
		loginMember = member;
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

