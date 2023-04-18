package com.example.project.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class SearchPage {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblWelcome;
	private JLabel lblSearchReservation;
	private JLabel lblReservation;
	private JLabel lblMypage;
	private JLabel lblLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPage window = new SearchPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 436, 50);
		frame.getContentPane().add(panel);
		
		lblWelcome = new JLabel("환영합니다.");
		lblWelcome.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel.add(lblWelcome);
		
		lblReservation = new JLabel("예약하기");
		lblReservation.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel.add(lblReservation);
		
		lblSearchReservation = new JLabel("예약조회");
		lblSearchReservation.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel.add(lblSearchReservation);
		
		lblMypage = new JLabel("마이페이지");
		lblMypage.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel.add(lblMypage);
		
		lblLogout = new JLabel("로그아웃");
		lblLogout.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel.add(lblLogout);
	}
}
