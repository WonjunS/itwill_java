package edu.java.swing07;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AppMain07 {
	
	// JTable에서 사용할 컬럼 이름들
	private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};

	private DefaultTableModel model; // 테이블의 행, 열에 대한 정보를 갖는 객체
	private JFrame frame;
	private JLabel lblKorean;
	private JLabel lblMath;
	private JLabel lblEnglish;
	private JTextField textMath;
	private JTextField textKorean;
	private JButton btnInsert;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textEnglish;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblKorean.setBounds(12, 10, 90, 50);
		frame.getContentPane().add(lblKorean);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblEnglish.setBounds(12, 78, 90, 50);
		frame.getContentPane().add(lblEnglish);
		
		lblMath = new JLabel("수학");
		lblMath.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblMath.setBounds(12, 152, 90, 50);
		frame.getContentPane().add(lblMath);
		
		textKorean = new JTextField();
		textKorean.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textKorean.setBounds(124, 10, 348, 50);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		textEnglish = new JTextField();
		textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textEnglish.setColumns(10);
		textEnglish.setBounds(124, 78, 348, 50);
		frame.getContentPane().add(textEnglish);
		
		textMath = new JTextField();
		textMath.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textMath.setColumns(10);
		textMath.setBounds(124, 152, 348, 50);
		frame.getContentPane().add(textMath);
		
		btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertData();
			}
		});
		btnInsert.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnInsert.setBounds(12, 230, 200, 50);
		frame.getContentPane().add(btnInsert);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteRow();
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnDelete.setBounds(272, 230, 200, 50);
		frame.getContentPane().add(btnDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 302, 460, 199);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Object[][] data = {}; // 테이블에 사용할 데이터
		model = new DefaultTableModel(data, COLUMN_NAMES);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.setFont(new Font("D2Coding", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
	}

	private void insertData() {		
		try {
			int korean = Integer.parseInt(textKorean.getText());
			int english = Integer.parseInt(textEnglish.getText());
			int math = Integer.parseInt(textMath.getText());
			
			if(!isValidInput(korean)) {
				displayErrorMessage();
				return;
			}
			
			if(!isValidInput(english)) {
				displayErrorMessage();
				return;
			}
			
			if(!isValidInput(math)) {
				displayErrorMessage();
				return;
			}
			
			Score score = new Score(korean, english, math);
			int total = score.getTotal();
			double mean = score.getMean();
			
			Object[] row = {korean, english, math, total, mean};
			
			model.addRow(row);
			
			clearTextField();
			
		} catch(Exception e) {
			displayErrorMessage();
			return;
		}
		
	}
	
	private void deleteRow() {
		int selectedRow = table.getSelectedRow();
		
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(frame, "삭제할 데이터가 없습니다.");
			return;
		}
		
		int response = JOptionPane.showConfirmDialog(
				frame, 
				"삭제?",
				"삭제 메시지",
				JOptionPane.YES_NO_OPTION
		);
		
		if(response == 0) {
			model.removeRow(selectedRow);
		}
	}
	
	private void clearTextField() {
		textKorean.setText("");
		textEnglish.setText("");
		textMath.setText("");
	}
	
	private boolean isValidInput(int score) {
		if(score < 0 || score > 100) {
			return false;
		}
		return true;
	}
	
	private void displayErrorMessage() {
		JOptionPane.showMessageDialog(frame, "점수는 0 이상 100 이하의 정수로 입력하세요.");	
		clearTextField();
	}
}
