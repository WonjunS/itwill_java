package edu.java.contact06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact05.ContactDaoImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ContactUpdateFrame extends JFrame {

	private JPanel contentPane;
	private JPanel buttonPanel;
	private JPanel panel;
	private JTextField textName;
	private JLabel lblPhone;
	private JTextField textPhone;
	private JLabel lblEmail;
	private JTextField textEmail;
	private JButton btnCreate;
	private JButton btnCancel;
	
	private Component parent; // 부모 컴포넌트(JFrame)를 저장하기 위한 필드
	private int index; // 업데이트할 연락처의 인덱스를 저장하기 위한 필드
	private ContactMain06 app; // 업데이트 성공한 후 알림 메서드를 호출하기 위한 객체
	
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();

	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(Component parent, int index, ContactMain06 app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parent, index, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactUpdateFrame(Component parent, int index, ContactMain06 app) {
		this.parent = parent;
		this.index = index;
		this.app = app;
		initialize();
		readContact();
	}
	
	private void readContact() {
		Contact contact = dao.read(index);
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
	}
	
	public void initialize() {
		setTitle("연락처 업데이트");
		
		// 닫기(x) 버튼의 기본 동작을 현재 창만 닫기로 설정
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// JFrame이 화면에 보이는 좌표
		int x = 100, y = 100;
		
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		
		setBounds(x, y, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblName.setBounds(12, 36, 87, 29);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textName.setBounds(161, 36, 230, 29);
		panel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblPhone.setBounds(12, 85, 87, 29);
		panel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textPhone.setColumns(10);
		textPhone.setBounds(161, 85, 230, 29);
		panel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblEmail.setBounds(12, 134, 87, 29);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(161, 134, 230, 29);
		panel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnCreate = new JButton("수정완료");
		btnCreate.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		buttonPanel.add(btnCreate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 창 닫기
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 20));
		buttonPanel.add(btnCancel);
	}

	private void updateContact() {
		// JTextField에서 업데이터 정보들을 읽음
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		Contact contact = new Contact(0, name, phone, email);
		
		int confirm = JOptionPane.showConfirmDialog(
				this, 
				"정말 업데이트 할까요?", 
				"업데이트 확인", 
				JOptionPane.YES_NO_OPTION
		);
		
		if(confirm == JOptionPane.YES_OPTION) {
			dao.update(index, contact); // 리스트를 수정하고 파일에 업데이트
			app.notifyContactUpdated(); // ContactMain 프레임에 있는 테이블을 갱신하기 위해서
			dispose(); // 현재 창 닫기
		}
	}

	
}
