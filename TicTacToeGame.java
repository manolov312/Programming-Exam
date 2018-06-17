package gui.application;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TicTacToeGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGame window = new TicTacToeGame();
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
	public TicTacToeGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 246, 316);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel textMessanger = new JLabel("new game");
		textMessanger.setBounds(0, 0, 240, 50);
		textMessanger.setHorizontalAlignment(SwingConstants.CENTER);
		textMessanger.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(textMessanger);
		
		int [] movesValue = new int[9];
		JButton[] button = new JButton[9];
		for (int i = 0; i < 9; i++) {
			String str = Integer.toString(i);
			button[i] = new JButton(str);
		}
		int i = 0 ;
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				button[i].setForeground(Color.BLACK);
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String index = arg0.getActionCommand();
						int i = Integer.parseInt(index);
						action(button, textMessanger, movesValue, i);
					}
				});
				button[i].setFont(new Font("Tahoma", Font.PLAIN, 0));
				button[i].setBounds(j * 80, 50 + k * 80, 80, 80);
				frame.getContentPane().add(button[i]);
				i++;
			}
		}
		
		move(button,textMessanger,movesValue,firstPlayer());
	}
	
	// Button action
	private void action(JButton[] button, JLabel textMessanger, int[] movesValue, int index) {
		myMove(button, movesValue, index);
		if (finTheGame(movesValue)) {
			newGame(button, textMessanger, movesValue);
		} else {
			compMove(button, movesValue);
			if (finTheGame(movesValue)) {
				newGame(button, textMessanger, movesValue);
			}
		}
	}

	// Announces who is the first and moves
	private void move(JButton[] button, JLabel textMessanger, int[] movesValue, boolean first) {
		message(textMessanger, first);
		if (first) {
			compMove(button, movesValue);
		}
	}

	// To first player message
	private void message(JLabel textMessanger, boolean first) {
		if (first) {
			textMessanger.setText("The computer is first");
		} else {
			textMessanger.setText("You're first");

		}
	}

	// Reports the result and offers a new game
	private void newGame(JButton[] button, JLabel textMessanger, int[] movesValue) {
		if (noWinner(movesValue) && winner(movesValue) == 0) {
			textMessanger.setText("No winner");
		} else if (winner(movesValue) == 1) {
			textMessanger.setText("You Winn!");
		} else {
			textMessanger.setText("You Lost!");
		}
		int action = JOptionPane.showConfirmDialog(frame, "Do you want a new game?", "", JOptionPane.OK_CANCEL_OPTION);
		if (action == JOptionPane.OK_OPTION) {
			reset(button, movesValue);
			move(button, textMessanger, movesValue, firstPlayer());
		} else {
			System.exit(0);
		}
	}

	// Decides who to be first
	private boolean firstPlayer() {
		int choicer = (int) (Math.random() * 33);
		if (choicer % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Resets the values
	private void reset(JButton[] button, int[] movesValue) {
		for (int i = 0; i < 9; i++) {
			button[i].setFont(new Font("Tahoma", Font.PLAIN, 0));
			button[i].setText(Integer.toString(i));
			movesValue[i] = 0;
		}
	}

	// Makes the player move
	private void myMove(JButton[] button, int[] movesValue, int i) {
		if (checkEmtiPosition(movesValue[i])) {
			button[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
			button[i].setText("X");
			movesValue[i] = 1;
		}
	}

	// Makes the move on the computer
	private void compMove(JButton[] button, int[] movesValue) {
		int i = 0;
		while (true) {
			i = (int) (Math.random() * 9);
			if (checkEmtiPosition(movesValue[i])) {
				break;
			}
		}
		movesValue[i] = 2;
		button[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
		button[i].setText("O");
	}

	// Checks for empty position
	private boolean checkEmtiPosition(int positionValue) {
		if (positionValue == 1 || positionValue == 2) {
			return false;
		} else {
			return true;
		}
	}

	// Checks for end of game
	private boolean finTheGame(int[] movesValue) {
		boolean fin = false;
		int winn = winner(movesValue);
		if (noWinner(movesValue) && winn == 0) {
			fin = true;
		}
		if (winn == 1 || winn == 2) {
			fin = true;
		}
		return fin;
	}

	// Checks out who is the winner
	private int winner(int[] movesValue) {
		boolean step = true;
		int winner = 0;
		int i = 0;
		int j = 0;
		int[][] arr = new int[3][3];
		for (int k = 0; k < 9; k++) {
			if (k % 3 == 0 && k != 0) {
				i++;
				j = 0;
			}
			arr[i][j] = movesValue[k];
			j++;
		}
		if (step) {
			for (int k = 1; k <= 2; k++) {
				for (i = 0; i < 3; i++) {
					if (arr[i][0] == k && arr[i][1] == k && arr[i][2] == k) {
						winner = k;
						step = false;
						k = 3;
						break;
					}
				}
			}
		}
		if (step) {
			for (int k = 1; k <= 2; k++) {
				for (j = 0; j < 3; j++) {
					if (arr[0][j] == k && arr[1][j] == k && arr[2][j] == k) {
						winner = k;
						step = false;
						k = 3;
						break;
					}
				}
			}
		}
		if (step) {
			for (int k = 1; k <= 2; k++) {
				if (arr[0][0] == k && arr[1][1] == k && arr[2][2] == k) {
					winner = k;
					break;
				}
				if (arr[2][0] == k && arr[1][1] == k && arr[0][2] == k) {
					winner = k;
					break;
				}
			}
		}
		return winner;
	}

	// Check the game has ended without a winner
	private boolean noWinner(int[] movesValue) {
		boolean winn = true;
		for (int i = 0; i < 9; i++) {
			if (movesValue[i] == 0) {
				winn = false;
				break;
			}
		}
		return winn;
	}
}
