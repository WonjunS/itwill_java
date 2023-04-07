package edu.java.swing04;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppMain04 {

	private ImageIcon ii = null;
	private String fileName = "";
	private int page = 1;
	private JFrame frmImages;
	private JLabel imageArea;
	private JButton btnPrev;
	private JButton btnNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
					window.frmImages.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImages = new JFrame();
		frmImages.setTitle("Images");
		frmImages.setBounds(100, 100, 500, 600);
		frmImages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImages.getContentPane().setLayout(null);
		
		ii = new ImageIcon("images/image1.jpg");
		imageArea = new JLabel(ii, JLabel.CENTER);
		imageArea.setBounds(12, 10, 460, 455);
		frmImages.getContentPane().add(imageArea);
		
		btnPrev = new JButton("<");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeImage(e);
			}
		});
		btnPrev.setFont(new Font("D2Coding", Font.PLAIN, 30));
		btnPrev.setBounds(12, 490, 50, 50);
		frmImages.getContentPane().add(btnPrev);
		
		btnNext = new JButton(">");
		btnNext.setFont(new Font("D2Coding", Font.PLAIN, 30));
		btnNext.addActionListener((e) -> changeImage(e));
		btnNext.setBounds(422, 490, 50, 50);
		frmImages.getContentPane().add(btnNext);
	}
	
	private void changeImage(ActionEvent event) {
		Object source = event.getSource();
		
		try {
			if(btnPrev == source) {
				// 페이지 업데이트
				page = page - 1;
				if(page < 1) page = 5;
				
				// 불러올 이미지 파일 경로 변경
				fileName = "images/image" + String.valueOf(page) + ".jpg";
				
				// ImageIcon 값 변경
				ii = new ImageIcon(fileName);
				
				// 변경된 ImageIcon으로 저장
				imageArea.setIcon(ii);
				
				return;
				
			} else if(btnNext == source) {
				// page 업데이트
				page = page + 1;
				if(page > 5) page = 1;
				
				// 불러올 이미지 파일 경로 변경
				fileName = "images/image" + String.valueOf(page) + ".jpg";
				
				// ImageIcon 값 변경
				ii = new ImageIcon(fileName);
				
				// 변경된 ImageIcon으로 저장
				imageArea.setIcon(ii);
				
				return;
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
	}

}
