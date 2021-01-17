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
