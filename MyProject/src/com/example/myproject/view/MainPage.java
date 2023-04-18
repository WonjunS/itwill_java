package com.example.project.view;

import java.awt.EventQueue;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class MainPage {
	
	private static final String[] COLUMN_NAMES = {"ID", "Title", "Writer", "Date"};

	private DefaultTableModel model;
	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField searchTextField;

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

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 51, 562, 326);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Object[][] data = {};
		model = new DefaultTableModel(data, COLUMN_NAMES);
		
		Object[] row = {1, "title", "writer", LocalDate.now()};
		model.addRow(row);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnWrite = new JButton("Write");
		btnWrite.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnWrite.setBounds(483, 387, 91, 23);
		frame.getContentPane().add(btnWrite);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnNewButton.setBounds(483, 18, 91, 23);
		frame.getContentPane().add(btnNewButton);
		
		searchTextField = new JTextField();
		searchTextField.setFont(new Font("Consolas", Font.PLAIN, 13));
		searchTextField.setBounds(333, 18, 138, 21);
		frame.getContentPane().add(searchTextField);
		searchTextField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Consolas", Font.PLAIN, 15));
		comboBox.setBounds(253, 18, 69, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSort = new JLabel("Sort By");
		lblSort.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSort.setBounds(185, 22, 56, 15);
		frame.getContentPane().add(lblSort);
		
	}
}
