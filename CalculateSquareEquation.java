package gui.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CalculateSquareEquation {

	private JFrame frame;
	private JTextField textFirstCoefficient;
	private JLabel signSecondCoefficient;
	private JTextField texteScondCoefficient;
	private JLabel signThirdCoefficient;
	private JTextField textThirdCoefficient;
	private JLabel signFirstCoefficient;
	private JLabel labelDiscriminant;
	private JLabel labelFirstResult;
	private JLabel labelSecondResult;
	private JLabel labelResultMessages;
	private double firstCoefficient;
	private double secondCoefficient;
	private double thirdCoefficient;
	private double discrim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateSquareEquation window = new CalculateSquareEquation();
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
	public CalculateSquareEquation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 441, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Въведете нужните параметри");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(36, 11, 368, 22);
		frame.getContentPane().add(label);
		
		textFirstCoefficient = new JTextField();
		textFirstCoefficient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textFirstCoefficient.setText("");
			}
		});
		
		signFirstCoefficient = new JLabel();
		signFirstCoefficient.setForeground(Color.BLUE);
		signFirstCoefficient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				signFirstCoefficient.setText(changeSign(signFirstCoefficient.getText()));
			}
		});
		signFirstCoefficient.setText("+");
		signFirstCoefficient.setHorizontalAlignment(SwingConstants.CENTER);
		signFirstCoefficient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signFirstCoefficient.setBounds(10, 44, 34, 29);
		frame.getContentPane().add(signFirstCoefficient);
		
		textFirstCoefficient.setHorizontalAlignment(SwingConstants.CENTER);
		textFirstCoefficient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFirstCoefficient.setText("а");
		textFirstCoefficient.setBounds(54, 44, 52, 30);
		frame.getContentPane().add(textFirstCoefficient);
		textFirstCoefficient.setColumns(10);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(Color.BLUE);
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(109, 44, 19, 29);
		frame.getContentPane().add(lblX);
		
		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(125, 44, 14, 14);
		frame.getContentPane().add(label_1);
		
		signSecondCoefficient = new JLabel();
		signSecondCoefficient.setForeground(Color.BLUE);
		signSecondCoefficient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signSecondCoefficient.setText(changeSign(signSecondCoefficient.getText()));
			}
		});
		signSecondCoefficient.setHorizontalAlignment(SwingConstants.CENTER);
		signSecondCoefficient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signSecondCoefficient.setText("+");
		signSecondCoefficient.setBounds(138, 44, 34, 29);
		frame.getContentPane().add(signSecondCoefficient);
		
		texteScondCoefficient = new JTextField();
		texteScondCoefficient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				texteScondCoefficient.setText("");
			}
		});
		texteScondCoefficient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		texteScondCoefficient.setHorizontalAlignment(SwingConstants.CENTER);
		texteScondCoefficient.setText("b");
		texteScondCoefficient.setBounds(182, 44, 56, 29);
		frame.getContentPane().add(texteScondCoefficient);
		texteScondCoefficient.setColumns(10);
		
		JLabel label_2 = new JLabel("X");
		label_2.setForeground(Color.BLUE);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(241, 44, 19, 29);
		frame.getContentPane().add(label_2);
		
		signThirdCoefficient = new JLabel();
		signThirdCoefficient.setForeground(Color.BLUE);
		signThirdCoefficient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signThirdCoefficient.setText(changeSign(signThirdCoefficient.getText()));
			}
		});
		signThirdCoefficient.setText("+");
		signThirdCoefficient.setHorizontalAlignment(SwingConstants.CENTER);
		signThirdCoefficient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signThirdCoefficient.setBounds(270, 45, 34, 29);
		frame.getContentPane().add(signThirdCoefficient);
		
		textThirdCoefficient = new JTextField();
		textThirdCoefficient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textThirdCoefficient.setText("");
			}
		});
		textThirdCoefficient.setText("c");
		textThirdCoefficient.setHorizontalAlignment(SwingConstants.CENTER);
		textThirdCoefficient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textThirdCoefficient.setColumns(10);
		textThirdCoefficient.setBounds(314, 44, 55, 29);
		frame.getContentPane().add(textThirdCoefficient);
		
		JLabel label_3 = new JLabel("= O");
		label_3.setForeground(Color.BLUE);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(374, 44, 45, 25);
		frame.getContentPane().add(label_3);
		
		labelResultMessages = new JLabel("Резултат :");
		labelResultMessages.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultMessages.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelResultMessages.setBounds(10, 143, 409, 29);
		frame.getContentPane().add(labelResultMessages);
		
		JLabel label_4 = new JLabel("D =");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_4.setBounds(10, 167, 63, 44);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("X1 =");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_5.setBounds(10, 206, 82, 44);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("X2 =");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_6.setBounds(226, 206, 72, 44);
		frame.getContentPane().add(label_6);
		
		labelDiscriminant = new JLabel("");
		labelDiscriminant.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelDiscriminant.setBounds(68, 167, 351, 44);
		frame.getContentPane().add(labelDiscriminant);
		
		labelFirstResult = new JLabel("");
		labelFirstResult.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelFirstResult.setBounds(83, 207, 140, 44);
		frame.getContentPane().add(labelFirstResult);
		
		labelSecondResult = new JLabel("");
		labelSecondResult.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelSecondResult.setBounds(298, 206, 121, 44);
		frame.getContentPane().add(labelSecondResult);
		
		JButton button = new JButton("ИЗЧИСЛИ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonAction();
			}
		});

		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(10, 97, 409, 35);
		frame.getContentPane().add(button);
	}
	// The button action
	private void buttonAction() {
		try {
			String signA = signFirstCoefficient.getText();
			String signB = signSecondCoefficient.getText();
			String signC = signThirdCoefficient.getText();
			firstCoefficient = coefficientSign(Double.parseDouble(textFirstCoefficient.getText()), signA);
			secondCoefficient = coefficientSign(Double.parseDouble(texteScondCoefficient.getText()), signB);
			thirdCoefficient = coefficientSign(Double.parseDouble(textThirdCoefficient.getText()), signC);
			discrim = discriminant();
			if (discrim < 0 || (firstCoefficient == 0 && secondCoefficient == 0 && thirdCoefficient != 0)) {
				labelResultMessages.setText("Уравнението няма реални корени.");
				labelDiscriminant.setText("" + discrim);
				labelFirstResult.setText("n/a");
				labelSecondResult.setText("n/a");
			} else if (firstCoefficient == 0 && secondCoefficient == 0 && thirdCoefficient == 0) {
				labelResultMessages.setText("Всички реални числа са корени.");
				labelDiscriminant.setText("" + discrim);
				labelFirstResult.setText("(-∞,+∞)");
				labelSecondResult.setText("(-∞,+∞)");
			} else {
				labelResultMessages.setText("Резултат :");
				labelDiscriminant.setText(String.format("%.2f", discrim));
				discrim = Math.sqrt(discrim);
				double result_X1 = calculate(1);
				double result_X2 = calculate(-1);
				labelFirstResult.setText(String.format("%.2f", result_X1));
				labelSecondResult.setText(String.format("%.2f", result_X2));
			}
		} catch (Exception e) {
			labelResultMessages.setText("Некоректно въведени параметри!");
			labelDiscriminant.setText("n/a");
			labelFirstResult.setText("n/a");
			labelSecondResult.setText("n/a");
		}
	}
	
	// Changes the character before the coefficient
	private String changeSign(String sign) {
		if (sign.equals("+")) {
			return "-";
		} else {
			return "+";
		}
	}

	// Specifies the character before the coefficient
	private double coefficientSign(double coefficient, String sign) {
		if (sign.equals("-")) {
			coefficient = -coefficient;
		}
		return coefficient;
	}

	// Calculates the discriminant
	private double discriminant() {
		return  secondCoefficient * secondCoefficient - 4 * firstCoefficient * thirdCoefficient ;
		
	}
	
	// Calculates the solutions of the equation
	private double calculate(int sign) {
		if (firstCoefficient == 0) {
			return -thirdCoefficient / secondCoefficient;
		} else {
			return (-secondCoefficient + discrim * sign) / (2 * firstCoefficient);
		}
	}
}
