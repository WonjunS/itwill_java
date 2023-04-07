package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnOptionDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnCustomFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(frame, "안녕하세요.");
				JOptionPane.showMessageDialog(
						frame, // 메시지 다이얼로그가 실행될 부모 컴포넌트
						"안녕하세요?", // 다이얼로그에 표시될 메시지
						"메시지", // 다이얼로그 타이틀(제목)
						JOptionPane.PLAIN_MESSAGE // 메시지 타입
				);
			}
		});
		btnMsgDlg.setFont(new Font("D2Coding", Font.PLAIN, 25));
		btnMsgDlg.setBounds(12, 10, 432, 64);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(
						frame, // 부모 컴포넌트
						"정말 삭제할까요?", // 메시지
						"삭제 확인", // 타이틀
						JOptionPane.YES_NO_CANCEL_OPTION, // 확인 옵션(yes-no, yes-no-cancel)
						JOptionPane.QUESTION_MESSAGE // 메시지 타입
						);
				btnConfirmDlg.setText("Confirm = " + result);
			}
		});
		btnConfirmDlg.setFont(new Font("D2Coding", Font.PLAIN, 25));
		btnConfirmDlg.setBounds(12, 101, 432, 64);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnOptionDlg = new JButton("Option Dialog");
		btnOptionDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"아니요", "어려워요", "재밌어요", "쉬어요"};
				
				int result = JOptionPane.showOptionDialog(
						frame, // 부모 컴포넌트
						"Java Swing 재미있나요?", // 메시지
						"옵션 확인", // 타이틀
						JOptionPane.YES_NO_CANCEL_OPTION, // 옵션 타입
						JOptionPane.QUESTION_MESSAGE, // 메시지 타입
						null, // 아이콘
						options, 
						options[2]
				);
				btnOptionDlg.setText("Option result = " + result);
			}
		});
		btnOptionDlg.setFont(new Font("D2Coding", Font.PLAIN, 25));
		btnOptionDlg.setBounds(12, 193, 432, 64);
		frame.getContentPane().add(btnOptionDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				String input = JOptionPane.showInputDialog(frame, "이름?");
				
				Object[] selectionValues = {"10대", "20대", "30대", "40대"};
				Object input = JOptionPane.showInputDialog(
						frame, // 부모 컴포넌트
						"나이?", // 메시지
						"나이 확인", // 타이틀
						JOptionPane.QUESTION_MESSAGE, // 메시지 타입
						null, // 아이콘
						selectionValues, // 입력으로 사용할 수 있는 선택지들의 배열
						selectionValues[1] // 선택 초깃값
				);
				
				btnInputDlg.setText("Input = " + input);
			}
		});
		btnInputDlg.setFont(new Font("D2Coding", Font.PLAIN, 25));
		btnInputDlg.setBounds(12, 285, 432, 64);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDialog.showMyDialog(frame);
			}
		});
		btnCustomDlg.setFont(new Font("D2Coding", Font.PLAIN, 25));
		btnCustomDlg.setBounds(12, 374, 432, 64);
		frame.getContentPane().add(btnCustomDlg);
		
		btnCustomFrame = new JButton("Custom Frame");
		btnCustomFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyFrame.showMyFrame(frame.getX(), frame.getY()); 
			}
		});
		btnCustomFrame.setFont(new Font("D2Coding", Font.PLAIN, 25));
		btnCustomFrame.setBounds(12, 464, 432, 64);
		frame.getContentPane().add(btnCustomFrame);
	}
}
