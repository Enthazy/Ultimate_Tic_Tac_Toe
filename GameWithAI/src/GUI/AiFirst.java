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

@SuppressWarnings("serial")
public class AiFirst extends GameWithAi {
	public AiFirst(String name) {
		super(name);
		int C=(int) (Math.random()*3),D=(int) (Math.random()*3),E=(int) (Math.random()*3),F=(int) (Math.random()*3);
		P2.set(C, D, E, F);
		_game.getPanel(C, D).getButton(E, F).setText(CROSS);
		_stack.add(_game.getPanel(C, D).getButton(E, F));
	}
}
