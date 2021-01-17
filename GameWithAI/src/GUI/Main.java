package GUI;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Main extends JFrame{
	private JButton _ai;
	private JButton _player;
	private JButton _rule;
	private JPanel _panel;
	private JLabel _label;

	public Main(String string) {
		super(string);
		Build();
	}

	public void Build() {
		BuildLabel();
		BuildButtons();
		BuildFrame();
	}

	private void BuildFrame() {
		this.setLayout(new BorderLayout(30, 5));
		this.setSize(300, 100);
		this.add(_label, BorderLayout.NORTH);
		this.add(_panel, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void BuildLabel() {
		_label = new JLabel("Do you want to play with ai or another player", JLabel.CENTER);
	}

	private void BuildButtons() {
		BuildAIButton();
		BuildPlayerButton();
		BuildRuleButton();
		_panel = new JPanel();
		_panel.setLayout(new FlowLayout());
		_panel.add(_ai);
		_panel.add(_player);
		_panel.add(_rule);
	}

	private void BuildPlayerButton() {
		_player = new JButton("Player");
		_player.addActionListener(e -> {
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			SwingUtilities.invokeLater(() -> {
				@SuppressWarnings("unused")
				GameWithoutAi frame = new GameWithoutAi("Game");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			});
		});
	}

	private void BuildAIButton() {
		_ai = new JButton("Ai");
		_ai.addActionListener(e -> {
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			SwingUtilities.invokeLater(() -> {
				@SuppressWarnings("unused")
				Choose frame = new Choose("Game");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			});
		});
	}

	private void BuildRuleButton() {
		_rule = new JButton("rule");
		_rule.addActionListener(e -> {
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			SwingUtilities.invokeLater(() -> {
				@SuppressWarnings("unused")
				RuleTextBox frame = new RuleTextBox("Game");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			});
		});
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			@SuppressWarnings("unused")
			Main frame = new Main("Game");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
	}
}
