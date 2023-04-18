package com.example.project.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class PostWrite extends JFrame {

	private JPanel contentPane;
	private JTextField textTitle;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextField textContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostWrite frame = new PostWrite();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PostWrite() {
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 10, 68, 33);
		contentPane.add(lblNewLabel);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("Consolas", Font.PLAIN, 15));
		textTitle.setBounds(101, 9, 407, 33);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblContent.setBounds(12, 226, 78, 33);
		contentPane.add(lblContent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 62, 407, 368);
		contentPane.add(scrollPane);
		
		textContent = new JTextField();
		textContent.setFont(new Font("Consolas", Font.PLAIN, 15));
		textContent.setColumns(10);
		scrollPane.setViewportView(textContent);
	}
}
