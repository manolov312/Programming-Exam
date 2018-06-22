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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class TicTacToeGame {
	
	private JFrame frame;
	private JLabel textMessanger;
	private JLabel languageEditor;
    private JButton[] button;
    private int[] movesValue;
    private int messageNumber;
    private Random random;

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
		movesValue = new int[9];
		button = new JButton[9];
		random = new Random();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 246, 316);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textMessanger = new JLabel("Tic Tac Toe");
		textMessanger.setBounds(0, 0, 240, 50);
		textMessanger.setHorizontalAlignment(SwingConstants.CENTER);
		textMessanger.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(textMessanger);
		
		languageEditor = new JLabel("en");
		languageEditor.setForeground(Color.RED);
		languageEditor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeLanguage();
			}
		});
		languageEditor.setHorizontalAlignment(SwingConstants.CENTER);
		languageEditor.setBounds(214, 0, 26, 20);
		frame.getContentPane().add(languageEditor);
		
		for (int i = 0; i < 9; i++) {                 
			String index = Integer.toString(i);       // Initializes the buttons and records them in an array
			button[i] = new JButton(index);          //          and adds an index to the button.
		}
		int i = 0 ;                                    //
		for (int j = 0; j < 3; j++) {                 // Distributes the buttons on the board
			for (int k = 0; k < 3; k++) {            //
				button[i].setForeground(Color.BLACK);
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String index = arg0.getActionCommand();     //
						int position = Integer.parseInt(index);    // Takes the index and takes action.
						action(position);                         //
					}
				});
				button[i].setFont(new Font("Tahoma", Font.PLAIN, 0));
				button[i].setBounds(k * 80, 50 + j * 80, 80, 80);
				frame.getContentPane().add(button[i]);
				i++;
			}
		}
		
		firstMove();
	}
	// Gives first move to the chosen player.
	private void firstMove() {
		boolean first = random.nextBoolean();      // Decides who to be first
		message(first);
		if (first) {
			compMove();
		}
	}
	
	// Buttons action
	private void action(int position) {
		myMove(position);
		if (finTheGame()) {
			newGame();
		} else {
			compMove();
			if (finTheGame()) {
				newGame();
			}
		}
	}
	
	// Change the language
	private void changeLanguage() {
		if(languageEditor.getText().equals("en")) {
			languageEditor.setText("bg");
		} else {
			languageEditor.setText("en");
		}
		textMessanger.setText(language());
	}
	
	// Bg/en messages in the game
	private String language() {
		String message = "";
		if (languageEditor.getText().equals("en")) {
			switch (messageNumber) {
			case 1:
				message = "The computer is first";
				break;
			case 2:
				message = "You're first";
				break;
			case 3:
				message = "No winner";
				break;
			case 4:
				message = "You Winn!";
				break;
			case 5:
				message = "You Lost!";
				break;
			case 6:
				message = "Do you want a new game?";
				break;
			}
		} else {
			switch (messageNumber) {
			case 1:
				message = "Компютъра е пръв";
				break;
			case 2:
				message = "Вие сте пръв";
				break;
			case 3:
				message = "Няма победител";
				break;
			case 4:
				message = "Вие спечелихте!";
				break;
			case 5:
				message = "Вие загубихте!";
				break;
			case 6:
				message = "Желаете ли да играете отново?";
				break;
			}
		}

		return message;
	}

	// Message who is first
	private void message(boolean first) {
			if (first) {
				messageNumber = 1;
				textMessanger.setText(language());
			} else {
				messageNumber = 2;
				textMessanger.setText(language());
			}
	}

	// Reports the result and offers for a new game
	private void newGame() {
		if (winner() == 0) {
			messageNumber =  3;
			textMessanger.setText(language());
		} else if (winner() == 1) {
			messageNumber = 4;
			textMessanger.setText(language());
		} else {
			messageNumber = 5;
			textMessanger.setText(language());
		}
		messageNumber = 6;
		int action = JOptionPane.showConfirmDialog(frame, language(), "", JOptionPane.OK_CANCEL_OPTION);
		if (action == JOptionPane.OK_OPTION) {
			reset();
			firstMove();
		} else {
			System.exit(0);
		}
	}

	// Resets the values
	private void reset() {
			messageNumber = 0;
		for (int i = 0; i < 9; i++) {
			button[i].setFont(new Font("Tahoma", Font.PLAIN, 0));
			button[i].setText(Integer.toString(i));
			movesValue[i] = 0;
		}
	}

	// Makes a player move
	private void myMove(int move) {
		if (checkEmtyPosition(movesValue[move])) {
			button[move].setFont(new Font("Tahoma", Font.PLAIN, 30));
			button[move].setText("X");
			movesValue[move] = 1;
		}
	}

	// Makes the computer's move
	private void compMove() {
		int position = 0;
		boolean check = false;
		for(int j = 0 ; j < 9 ; j += 2) {
			if(checkEmtyPosition(movesValue[j]) && j != 4) {
				check = true;
				break;
			}
		}
		if (checkEmtyPosition(movesValue[4])) {                 // Chooses the center if it is empty.
			position = 4;
		} else if (check) {                             // Selects an angle if it is empty
			while (true) {
				position = random.nextInt(9);
				if (checkEmtyPosition(movesValue[position])) {
					if (position % 2 == 0 && position != 4) {
						break;
					} 
				}
			}
		} else {                               // Choose any empty position.
			while (true) {
				position = random.nextInt(8);
				if (checkEmtyPosition(movesValue[position])) {
					break;
				}
			}
		}
		movesValue[position] = 2;
		button[position].setFont(new Font("Tahoma", Font.PLAIN, 30));
		button[position].setText("O");
	}

	// Checks for empty position.Returns true if the position is empty.
	private boolean checkEmtyPosition(int positionValue) {
		if (positionValue == 1 || positionValue == 2) {
			return false;
		} else {
			return true;
		}
	}

	// Checks for end of the game. Returns true if the game has finished.
	private boolean finTheGame() {
		boolean endGame = true;
		int winn = winner();
		for (int i = 0; i < 9; i++) {
			if (movesValue[i] == 0) {
				endGame = false;
				break;
			}
			
		} 
		if (winn == 1 || winn == 2) {
			endGame = true;
		}
		return endGame;
	}

	// Checks who is the winner. Returns 0 if no winner, 1 if the winner is the 
	//                 player, and 2 if the winner is the computer.
	private int winner() {
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

}
