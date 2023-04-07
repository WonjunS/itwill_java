package edu.java.swing05;

import java.awt.Checkbox;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox;
	private JButton btnInfo;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPrivate = new JRadioButton("private");
		rbPrivate.setSelected(true);
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		rbPrivate.setBounds(8, 16, 117, 44);
		frame.getContentPane().add(rbPrivate);
		
		rbPackage = new JRadioButton("package");
		rbPackage.addActionListener(e -> handleRadioButtonClick(e));
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 20));
		rbPackage.setBounds(129, 16, 117, 44);
		frame.getContentPane().add(rbPackage);
		
		rbProtected = new JRadioButton("protected");
		rbProtected.addActionListener(e -> handleRadioButtonClick(e));
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 20));
		rbProtected.setBounds(250, 16, 117, 44);
		frame.getContentPane().add(rbProtected);
		
		rbPublic = new JRadioButton("public");
		rbPublic.addActionListener(e -> handleRadioButtonClick(e));
		buttonGroup.add(rbPublic);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 20));
		rbPublic.setBounds(379, 16, 117, 44);
		frame.getContentPane().add(rbPublic);
		
		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(e -> handleCheckBoxClick(e));
		cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 20));
		cbAbstract.setBounds(8, 74, 115, 33);
		frame.getContentPane().add(cbAbstract);
		
		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener(e -> handleCheckBoxClick(e));
		cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 20));
		cbFinal.setBounds(131, 74, 115, 33);
		frame.getContentPane().add(cbFinal);
		
		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(e -> handleCheckBoxClick(e));
		cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 20));
		cbStatic.setBounds(252, 74, 115, 33);
		frame.getContentPane().add(cbStatic);
		
		comboBox = new JComboBox<>();
		String[] items = {"naver.com", "gmail.com", "kakao.com"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
		comboBox.setModel(model);
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 20));
		comboBox.setBounds(8, 142, 238, 38);
		frame.getContentPane().add(comboBox);
		
		btnInfo = new JButton("확인");
		btnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printInfo();
			}
		});
		btnInfo.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnInfo.setBounds(379, 142, 117, 38);
		frame.getContentPane().add(btnInfo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 205, 488, 300);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
	}

	private void printInfo() {
		// 라디오버튼, 체크박스, 콤보박스의 상태를 JTextArea에 출력
		
		StringBuffer buffer = new StringBuffer(); // textArea에 출력할 문자열을 저장하기 위해서
		
		// 어떤 라디오 버튼이 선택됐는지 체크
		if(rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());
		} else if(rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if(rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		} else {
			buffer.append(rbPublic.getText());
		}
		
		buffer.append(" 라디오 버튼 선택됨\n");
		
		// 체크박스들의 선택 여부를 확인
		if(cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if(cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append(" ");
		}
		if(cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		
		buffer.append(" 체크박스 선택됨\n");
		
		// 콤보박스에서 선택된 아이템 찾기
		String item = (String) comboBox.getSelectedItem();
		buffer.append(item).append(" 콤보박스 선택됨\n");
		
		textArea.setText(buffer.toString());
	}

	private void handleCheckBoxClick(ActionEvent event) {
		// 클릭 이벤트가 발생한 이벤트 소스(체크박스)
		JCheckBox chbox = (JCheckBox) event.getSource();
		
		// 체크박스의 텍스트를 찾음
		String text = chbox.getText();
		
		// 체크박스의 체크(선택) 여부 확인
		boolean selected = chbox.isSelected();
		
		// 정보 출력
		textArea.setText(text + " : " + selected);
	}

	private void handleRadioButtonClick(ActionEvent event) {
		// 클릭 이벤트가 발생한 이벤트 소스(라디오버튼)
		JRadioButton btn = (JRadioButton) event.getSource();
		
		// 라디오버튼의 텍스트를 찾음
		String btnText = btn.getText();
		
		// 라디오버튼의 선택(체크) 여부를 확인
		boolean selected = btn.isSelected();
		
		// 결과를 JTextArea에 출력
		textArea.setText(btnText + " : " + selected);
		
	}
}
