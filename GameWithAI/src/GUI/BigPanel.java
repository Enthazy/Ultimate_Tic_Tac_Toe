package GUI;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BigPanel extends JPanel {
	private static final int ROWS = 3;
	private static final int COLS = 3;

	private final SmallPanel[][] _board;

	public BigPanel() {
		_board = new SmallPanel[ROWS][COLS];

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				_board[row][col] = new SmallPanel();
			}
		}

		this.setLayout(new GridLayout(3, 3, 5,5));

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				this.add(_board[row][col]);
			}
		}
	}

	public SmallPanel getPanel(int x, int y) {
		return _board[x][y];
	}
}
