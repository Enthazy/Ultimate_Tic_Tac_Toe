package GUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SmallPanel extends JPanel {
	private static final int ROWS = 3;
	private static final int COLS = 3;

	private final JButton[][] _board;

	public SmallPanel() {
		_board = new JButton[ROWS][COLS];

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				String BLANK = " ";
				_board[row][col] = new JButton(BLANK);
			}
		}

		this.setLayout(new GridLayout(3, 3));

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				this.add(_board[row][col]);
			}
		}
	}

	public JButton getButton(int x, int y) {
		return _board[x][y];
	}
}
