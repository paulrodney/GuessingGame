import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess; 	//text field for the user's guess
	private JLabel lblOutput;		//label for to high/ too low output
	private int theNumber;			//the number we are trying to guess
	private boolean toggle = false;
	public void checkGuess() {//method to check to high to low
		//get users guess
		String guessText = txtGuess.getText();
		String message = "";
		
		
		try {

			//check users guess too high/too low
			int guess = Integer.parseInt(guessText);
			
			if ( guess < 0 || guess > 100) {
				throw new Exception("User entry out of range");
			}//if

			//too high
			if(guess > theNumber){
				message = guess + " is to high guess again!";
				lblOutput.setText(message);
			}//if
			//too low
			else if (guess < theNumber){
				message = guess + " is to low guess again!";
				lblOutput.setText(message);
			}else{//guessed correct
				message = guess + " was right! You win! Let's play again!";
				lblOutput.setText(message);
				newGame();
			}//else
		}//try
		catch(Exception e) {
			lblOutput.setText("Enter a whole number between 1-100"); 
		}//catch
		finally {
			
			txtGuess.requestFocus();
			txtGuess.selectAll();
			
		}//finally
	}//checkGuess

	public void newGame(){	//get new random number

		theNumber = (int)(Math.random() * 100 + 1);		//creates random number to guess

	}//newGame

	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setBackground(new Color(0, 204, 255));
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Paul's Hi-Lo Guessing Game");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 21, 450, 45);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 81, 450, 45);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Guess a number beween 1-100:");
		lblNewLabel_1.setForeground(new Color(0, 204, 255));
		lblNewLabel_1.setBounds(84, 11, 200, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);

		txtGuess = new JTextField();
		txtGuess.setForeground(new Color(0, 0, 255));
		txtGuess.setBackground(new Color(102, 204, 255));
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}//actionPerformed
		});
		txtGuess.setBounds(292, 6, 77, 26);
		panel.add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess");
		btnGuess.setForeground(new Color(0, 0, 255));
		
		//make funnyGame true for weird game
		boolean funnyGame = false;
		if(funnyGame == true) {
			
		btnGuess.setForeground(new Color(0, 0, 255));
		btnGuess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (toggle) {
					btnGuess.setBounds(50, 130, 145, 29);
					toggle = false;
				} else {
					btnGuess.setBounds(160, 162, 145, 29);
					toggle = true;
				}//if	
			}//mouseEntered
		});
		
		}//funnyGame
		btnGuess.setBackground(new Color(0, 204, 204));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}//actionPerformed
		});
		btnGuess.setBounds(161, 161, 145, 29);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and press Guess!");
		lblOutput.setForeground(new Color(0, 0, 255));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(97, 215, 270, 30);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {

		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setTitle("Hi-Lo Guessing Game");
		theGame.setSize(new Dimension(430,330));
		theGame.setVisible(true);
	}//main
}
