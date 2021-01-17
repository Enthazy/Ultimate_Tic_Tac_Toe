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

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

@SuppressWarnings("serial")
public class GameWithoutAi extends JFrame {
	// Constant value
		private static final int ROWS = 3;
		private static final int COLS = 3;
		private static final String NAUGHT = "0";
		private static final String CROSS = "X";
		private static final String BLANK = " ";

		// Game information
		private Player P1;
		private Player P2;
		private Stack<JButton> _stack;
		private boolean _state;
		private boolean _end;

		// GUI Components
		private JLabel _label;
		private BigPanel _game;
		private JPanel _Panel;
		private JButton _New;
		private JButton _Quit;
		private JButton _Repeal;

		public GameWithoutAi(String name) {
			super(name);
			Build();
		}

		public void Build() {
			Initialise();
			BuildLabel();
			BuildGame();
			BuildButtons();
			BuildFrame();
		}

		private void Initialise() {
			P1 = new Player();
			P2 = new Player();
			_stack = new Stack<>();
			_state = true;
			_end = false;
		}

		private void BuildLabel() {
			_label = new JLabel("Game Start", JLabel.CENTER);
			_label.setFont(new Font("", Font.PLAIN, 13));
			_label.setForeground(Color.black);
		}

		private void BuildButtons() {
			BuildNewButton();
			BuildQuitButton();
			BuildRepealButton();
			_Panel = new JPanel();
			_Panel.setLayout(new FlowLayout());
			_Panel.add(_New);
			_Panel.add(_Quit);
			_Panel.add(_Repeal);
		}

		private void BuildNewButton() {
			_New = new JButton("New Game");
			_New.addActionListener(e -> {
				Initialise();
				ResetGame();
				ResetLabel();
			});
		}

		private void BuildQuitButton() {
			_Quit = new JButton("Quit");
			_Quit.addActionListener(e -> System.exit(0));
		}

		private void BuildRepealButton() {
			_Repeal = new JButton("Repeal");
			_Repeal.addActionListener(e -> {
				if (!_stack.empty()) {
					if (_stack.size() % 2 == 0) {
						P2.Repeal();
					} else {
						P1.Repeal();
					}
					_stack.pop().setText(BLANK);
					_label.setFont(new Font("", Font.PLAIN, 13));
					_label.setForeground(Color.black);
					_state = !_state;
					_end = false;
				}
			});
		}

		private void BuildGame() {
			_game = new BigPanel();
			for (int a = 0; a < ROWS; a++) {
				for (int b = 0; b < COLS; b++) {
					for (int c = 0; c < ROWS; c++) {
						for (int d = 0; d < COLS; d++) {
							final int A = a, B = b, C = c, D = d;
							_game.getPanel(A, B).getButton(C, D).addActionListener(e -> Work(A, B, C, D));
						}
					}
				}
			}
		}

		private void BuildFrame() {
			this.setLayout(new BorderLayout(30, 5));
			this.add(_label, BorderLayout.NORTH);
			this.add(_game, BorderLayout.CENTER);
			this.add(_Panel, BorderLayout.SOUTH);
			this.setSize(700, 700);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}

		private void ResetGame() {
			for (int a = 0; a < ROWS; a++) {
				for (int b = 0; b < COLS; b++) {
					for (int c = 0; c < ROWS; c++) {
						for (int d = 0; d < COLS; d++) {
							_game.getPanel(a, b).getButton(c, d).setText(" ");
						}
					}
				}
			}
		}

		private void ResetLabel() {
			_label.setText("Game Start");
			_label.setFont(new Font("", Font.PLAIN, 13));
			_label.setForeground(Color.black);
		}

		private void Work(int A, int B, int C, int D) {
			if (!_end && _game.getPanel(A, B).getButton(C, D).getText().equals(BLANK)) {
				if (_stack.empty() || _state && ((P2.getLast()[0] == A && P2.getLast()[1] == B))) {
					P1.set(A, B, C, D);
					_game.getPanel(A, B).getButton(C, D).setText(NAUGHT);
					_stack.add(_game.getPanel(A, B).getButton(C, D));
					_state = !_state;
					_label.setText("Player 1 " + P1.Status());
					if (P1.Status().equals("WIN")) {
						_end = true;
						_label.setFont(new Font("", Font.BOLD, 13));
						_label.setForeground(Color.RED);
					}
				} else if (!_state && P1.getLast()[0] == A && P1.getLast()[1] == B) {
					P2.set(A, B, C, D);
					_game.getPanel(A, B).getButton(C, D).setText(CROSS);
					_stack.add(_game.getPanel(A, B).getButton(C, D));
					_state = !_state;
					_label.setText("Player 2 " + P2.Status());
					if (P2.Status().equals("WIN")) {
						_end = true;
						_label.setFont(new Font("", Font.BOLD, 13));
						_label.setForeground(Color.RED);
					}
				}
			}
		}
}
