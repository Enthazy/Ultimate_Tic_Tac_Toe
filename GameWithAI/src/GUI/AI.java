package GUI;

public class AI extends Player {
	private int[][] _score;
	private final Player _player;
	private final int[] _next;

	public AI(Player player) {
		_score = new int[3][3];
		_next = new int[4];
		_player = player;
	}

	public void setLast(int A, int B) {
		_next[0] = A;
		_next[1] = B;
	}

	public int[] bestPlace() {
		Calculate();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (_score[i][j] > _score[_next[2]][_next[3]]) {
					_next[2] = i;
					_next[3] = j;
				}
			}
		}
		return _next;
	}

	public void Calculate() {
		_score = new int[3][3];
		if (_next[0] == 0 && _next[1] == 0) {
			_score[0][2] = 30;
			_score[1][2] = 40;
			_score[2][2] = 50;
			_score[2][1] = 40;
			_score[2][0] = 30;
		}
		if (_next[0] == 0 && _next[1] == 1) {
			_score[0][0] = 30;
			_score[0][2] = 30;
			_score[1][0] = 40;
			_score[1][2] = 40;
			_score[2][0] = 50;
			_score[2][1] = 50;
			_score[2][2] = 50;
		}
		if (_next[0] == 0 && _next[1] == 2) {
			_score[0][0] = 30;
			_score[1][0] = 40;
			_score[2][0] = 50;
			_score[2][1] = 40;
			_score[2][2] = 30;
		}
		if (_next[0] == 1 && _next[1] == 0) {
			_score[0][0] = 30;
			_score[2][0] = 30;
			_score[0][1] = 40;
			_score[2][1] = 40;
			_score[0][2] = 50;
			_score[1][2] = 50;
			_score[2][2] = 50;
		}
		if (_next[0] == 1 && _next[1] == 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					_score[i][j] = 50;
				}
			}
		}
		if (_next[0] == 1 && _next[1] == 2) {
			_score[0][2] = 30;
			_score[2][2] = 30;
			_score[0][1] = 40;
			_score[2][1] = 40;
			_score[0][0] = 50;
			_score[1][0] = 50;
			_score[2][0] = 50;
		}
		if (_next[0] == 2 && _next[1] == 0) {
			_score[0][0] = 30;
			_score[0][1] = 40;
			_score[0][2] = 50;
			_score[1][2] = 40;
			_score[2][2] = 30;
		}
		if (_next[0] == 2 && _next[1] == 1) {
			_score[2][0] = 30;
			_score[2][2] = 30;
			_score[1][0] = 40;
			_score[1][2] = 40;
			_score[0][0] = 50;
			_score[0][1] = 50;
			_score[0][2] = 50;
		}
		if (_next[0] == 2 && _next[1] == 2) {
			_score[0][2] = 30;
			_score[0][1] = 40;
			_score[0][0] = 50;
			_score[1][0] = 40;
			_score[2][0] = 30;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int m = 0; m < 3; m++) {
					for (int n = 0; n < 3; n++) {
						if (_player.Judge(i, j, m, n)) {
							_score[i][j] = -50;
						}
					}
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.Judge(_next[0], _next[1], i, j)) {
					_score[i][j] = 1000000;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (_player._board[_next[0] * 3 + i][_next[1] * 3 + j] == 1
						|| this._board[_next[0] * 3 + i][_next[1] * 3 + j] == 1) {
					_score[i][j] = -100;
				}
			}
		}
	}
}
