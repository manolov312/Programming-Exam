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

public class CalculateSquareEquation {

	private JFrame frame;
	private JTextField textCoefficient_A;
	private JTextField textField_sign_B;
	private JTextField textCoefficient_B;
	private JTextField textField_sign_C;
	private JTextField textCoefficient_C;
	private JTextField textField_sign_A;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_discriminant;
	private JLabel label_result1;
	private JLabel label_result2;

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
		
		textCoefficient_A = new JTextField();
		textCoefficient_A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textCoefficient_A.setText("");
			}
		});
		
		textField_sign_A = new JTextField();
		textField_sign_A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sign_A.setText(changeSign(textField_sign_A.getText()));
			}
		});
		textField_sign_A.setText("+/-");
		textField_sign_A.setHorizontalAlignment(SwingConstants.CENTER);
		textField_sign_A.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_sign_A.setColumns(10);
		textField_sign_A.setBounds(10, 44, 34, 29);
		frame.getContentPane().add(textField_sign_A);
		
		textCoefficient_A.setHorizontalAlignment(SwingConstants.CENTER);
		textCoefficient_A.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCoefficient_A.setText("а");
		textCoefficient_A.setBounds(54, 44, 52, 30);
		frame.getContentPane().add(textCoefficient_A);
		textCoefficient_A.setColumns(10);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(109, 44, 19, 29);
		frame.getContentPane().add(lblX);
		
		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(125, 44, 14, 14);
		frame.getContentPane().add(label_1);
		
		textField_sign_B = new JTextField();
		textField_sign_B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sign_B.setText(changeSign(textField_sign_B.getText()));
			}
		});
		textField_sign_B.setHorizontalAlignment(SwingConstants.CENTER);
		textField_sign_B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_sign_B.setText("+/-");
		textField_sign_B.setBounds(138, 44, 34, 29);
		frame.getContentPane().add(textField_sign_B);
		textField_sign_B.setColumns(10);
		
		textCoefficient_B = new JTextField();
		textCoefficient_B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textCoefficient_B.setText("");
			}
		});
		textCoefficient_B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCoefficient_B.setHorizontalAlignment(SwingConstants.CENTER);
		textCoefficient_B.setText("b");
		textCoefficient_B.setBounds(182, 44, 56, 29);
		frame.getContentPane().add(textCoefficient_B);
		textCoefficient_B.setColumns(10);
		
		JLabel label_2 = new JLabel("X");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(241, 44, 19, 29);
		frame.getContentPane().add(label_2);
		
		textField_sign_C = new JTextField();
		textField_sign_C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sign_C.setText(changeSign(textField_sign_C.getText()));
			}
		});
		textField_sign_C.setText("+/-");
		textField_sign_C.setHorizontalAlignment(SwingConstants.CENTER);
		textField_sign_C.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_sign_C.setColumns(10);
		textField_sign_C.setBounds(270, 45, 34, 29);
		frame.getContentPane().add(textField_sign_C);
		
		textCoefficient_C = new JTextField();
		textCoefficient_C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textCoefficient_C.setText("");
			}
		});
		textCoefficient_C.setText("c");
		textCoefficient_C.setHorizontalAlignment(SwingConstants.CENTER);
		textCoefficient_C.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCoefficient_C.setColumns(10);
		textCoefficient_C.setBounds(314, 44, 55, 29);
		frame.getContentPane().add(textCoefficient_C);
		
		JLabel label_3 = new JLabel("= 0");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(374, 44, 45, 25);
		frame.getContentPane().add(label_3);
		
		JLabel result = new JLabel("Резултат :");
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setFont(new Font("Tahoma", Font.PLAIN, 20));
		result.setBounds(10, 143, 409, 29);
		frame.getContentPane().add(result);
		
		label_4 = new JLabel("D =");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_4.setBounds(10, 167, 63, 44);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("X1 =");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_5.setBounds(10, 206, 82, 44);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("X2 =");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_6.setBounds(226, 206, 72, 44);
		frame.getContentPane().add(label_6);
		
		label_discriminant = new JLabel("");
		label_discriminant.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_discriminant.setBounds(68, 167, 351, 44);
		frame.getContentPane().add(label_discriminant);
		
		label_result1 = new JLabel("");
		label_result1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_result1.setBounds(83, 207, 140, 44);
		frame.getContentPane().add(label_result1);
		
		label_result2 = new JLabel("");
		label_result2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_result2.setBounds(298, 206, 121, 44);
		frame.getContentPane().add(label_result2);
		
		
		
		JButton button = new JButton("ИЗЧИСЛИ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sign_A = textField_sign_A.getText();
					String sign_B = textField_sign_B.getText();
					String sign_C = textField_sign_C.getText();
					double a = Double.parseDouble(textCoefficient_A.getText());
					double b = Double.parseDouble(textCoefficient_B.getText());
					double c = Double.parseDouble(textCoefficient_C.getText());
					double discrim;
					while (true) {
						if (check(sign_A, sign_B, sign_C)) {
							result.setText("Некоректно въведени параметри!");
							label_discriminant.setText("n/a");
							label_result1.setText("n/a");
							label_result2.setText("n/a");
							break;
						}
						a = coefficientSign(a, sign_A);
						b = coefficientSign(b, sign_B);
						c = coefficientSign(c, sign_C);
						discrim = discriminant(a, b, c);
						if (discrim < 0 || (a == 0 && b == 0 && c != 0)) {
							result.setText("Уравнението няма реални корени.");
							label_discriminant.setText("" + discrim);
							label_result1.setText("n/a");
							label_result2.setText("n/a");
							break;
						}
						if (a == 0 && b == 0 && c == 0) {
							result.setText("Всички реални числа са корени.");
							label_discriminant.setText("" + discrim);
							label_result1.setText("(-∞,+∞)");
							label_result2.setText("(-∞,+∞)");
							break;
						}
						result.setText("Резултат :");
						label_discriminant.setText(String.format("%.2f", discrim));
						discrim = Math.sqrt(discrim);
						double result_X1 = calculate(a, b, c, discrim);
						double result_X2 = calculate(a, b, c, -discrim);
						label_result1.setText(String.format("%.2f", result_X1));
						label_result2.setText(String.format("%.2f", result_X2));
						break;
					}
				} catch (NumberFormatException e) {
					result.setText("Некоректно въведени параметри!");
					label_discriminant.setText("n/a");
					label_result1.setText("n/a");
					label_result2.setText("n/a");
				}
			}
		});

		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(10, 97, 409, 35);
		frame.getContentPane().add(button);
	}
	
	// Променя знака пред коефициента
	private static String changeSign(String sign) {
		if (sign.equals("+")) {
			return "-";
		} else {
			return "+";
		}
	}

	// Уточнява знака пред коефициента
	private static double coefficientSign(double num, String sign) {
		if (sign.equals("-")) {
			num = -num;
		}
		return num;
	}

	// Проверява дали знаците пред коефициентите са зададени правилно
	private static boolean check(String signA, String signB, String signC) {
		boolean check = true;
		if((signA.equals("+") || signA.equals("-")) && (signB.equals("+")
				|| signB.equals("-")) && (signC.equals("+") || signC.equals("-"))) {
			check = false;
		}
		return check;
	}
	
	// Изчислява дискриминантата
	private static double discriminant(double a, double b, double c) {
		return  b * b - 4 * a * c ;
		
	}
	
	// Изчислява корените
	private static double calculate(double a, double b, double c, double discrim) {
		if (a == 0) {
			return -c / b;
		} else {
			return (-b + discrim) / (2 * a);
		}
	}
}
