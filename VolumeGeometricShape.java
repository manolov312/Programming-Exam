package gui.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VolumeGeometricShape {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VolumeGeometricShape window = new VolumeGeometricShape();
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
	public VolumeGeometricShape() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImage = new JLabel(new ImageIcon("pyramid.jpg"));
		lblImage.setBounds(10, 11, 160, 150);
		frame.getContentPane().add(lblImage);
		
		JLabel lblNewLabel = new JLabel("Брой страни на основата");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(194, 11, 206, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Дължина на страната");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(194, 79, 206, 22);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Височина");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(194, 139, 206, 22);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		textField.setBounds(204, 44, 196, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(204, 108, 196, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setText("");
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(204, 165, 196, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel label_2 = new JLabel(" Резултат     ");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(10, 171, 195, 80);
		frame.getContentPane().add(label_2);
		
		JButton button = new JButton("ИЗЧИСЛИ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_2.setText("Резултат");
				try {
					int side = Integer.parseInt(textField.getText());
					double lengthSide = Double.parseDouble(textField_1.getText());
					double height = Double.parseDouble(textField_2.getText());
					if (side < 3 || lengthSide <= 0 || height < 0) {
						label_2.setText("Неправилни параметри!");
					} else {
						double area = side * lengthSide * lengthSide / Math.tan(Math.PI / side) / 4;
						double volume = area * height / 3;
						label_2.setText(String.format("V = %.2f", volume));
					}
				} catch (NumberFormatException e) {
					label_2.setText("Неправилни параметри!");
				}
			}
		});
		button.setBounds(246, 200, 113, 23);
		frame.getContentPane().add(button);
	}

}
