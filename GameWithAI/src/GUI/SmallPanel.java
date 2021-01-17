//Copyright 2015 Baiwei Chen, Hanchun Wang
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

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
