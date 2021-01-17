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

import java.util.Stack;

public class Player {
	protected int[][] _board;
	protected GameStatus _state;
	protected Stack<Integer[]> _last;
	protected Stack<Integer[]> _place;
	
	public Player(){
		_board=new int[9][9];
		_state=GameStatus.IN_PROGRESS;
		_last=new Stack<Integer[]>();
		_place=new Stack<Integer[]>();
		_place.add(new Integer[]{0,0});
	}
	
	public void set(int x1,int y1,int x2,int y2){
		int a=x1*3+x2,b=y1*3+y2;
		_board[a][b]=1;
		_place.push(new Integer[]{x2,y2});
		_last.push(new Integer[]{a,b});
		if(Judge(x1,y1,x2,y2)){
			_state=GameStatus.WIN;
		}
	}

	public Integer[] getLast(){
		return _place.peek();
	}
	public String Status() {
		return _state.toString();
	}
	
	public void Repeal(){
		_place.pop();
		Integer[] temp =_last.pop();
		_board[temp[0]][temp[1]]=0;
		_state=GameStatus.IN_PROGRESS;
	}
	
	public boolean Judge(int x1,int y1,int x2,int y2){
		int a=x1*3+x2,b=y1*3+y2;
		if(a>0&&a<8&&_board[a-1][b]==1&&_board[a+1][b]==1){return true;}
		if(b>0&&b<8&&_board[a][b-1]==1&&_board[a][b+1]==1){return true;}
		if(a>0&&a<8&&b>0&&b<8&&_board[a-1][b+1]==1&&_board[a+1][b-1]==1){return true;}
		if(a>0&&a<8&&b>0&&b<8&&_board[a-1][b-1]==1&&_board[a+1][b+1]==1){return true;}
		if(a<7&&b<7&&_board[a+2][b+2]==1&&_board[a+1][b+1]==1){return true;}
		if(a>1&&b>1&&_board[a-2][b-2]==1&&_board[a-1][b-1]==1){return true;}
		if(a>1&&b<7&&_board[a-2][b+2]==1&&_board[a-1][b+1]==1){return true;}
		if(a<7&&b>1&&_board[a+2][b-2]==1&&_board[a+1][b-1]==1){return true;}
		if(a>1&&_board[a-2][b]==1&&_board[a-1][b]==1){return true;}
		if(a<7&&_board[a+2][b]==1&&_board[a+1][b]==1){return true;}
		if(b>1&&_board[a][b-2]==1&&_board[a][b-1]==1){return true;}
		if(b<7&&_board[a][b+2]==1&&_board[a][b+1]==1){return true;}
		return false;
	}
	
	private enum GameStatus {
		WIN, IN_PROGRESS
	}
}
