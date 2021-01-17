package GUI;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Choose extends JFrame {
	private JButton _aiFirst;
	private JButton _playerFirst;
	private JPanel _panel;
	private JLabel _label;

	public Choose(String string) {
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
		this.setSize(200, 100);
		this.add(_label, BorderLayout.NORTH);
		this.add(_panel, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void BuildLabel() {
		_label = new JLabel("Ai first or You first", JLabel.CENTER);
	}

	private void BuildButtons() {
		BuildAIButton();
		BuildPlayerButton();
		_panel = new JPanel();
		_panel.setLayout(new FlowLayout());
		_panel.add(_aiFirst);
		_panel.add(_playerFirst);
	}

	private void BuildPlayerButton() {
		_playerFirst = new JButton("Player First");
		_playerFirst.addActionListener(e -> {
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			SwingUtilities.invokeLater(() -> {
				@SuppressWarnings("unused")
				PlayerFirst frame = new PlayerFirst("Game");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			});
		});
	}

	private void BuildAIButton() {
		_aiFirst = new JButton("Ai First");
		_aiFirst.addActionListener(e -> {
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			SwingUtilities.invokeLater(() -> {
				@SuppressWarnings("unused")
				AiFirst frame = new AiFirst("Game");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			});
		});
	}

}
