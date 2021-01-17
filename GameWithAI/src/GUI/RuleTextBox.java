package GUI;

import javax.swing.*;
import java.awt.*;

public class RuleTextBox extends JFrame {
    private JButton _back;
    private JPanel _panel;
    private JLabel _label;

    public RuleTextBox(String string) {
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
        this.setSize(800, 400);
        this.add(_label, BorderLayout.NORTH);
        this.add(_panel, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void BuildLabel() {
        String message = "<html>" +
                "The Rule<BR>" +
                "<BR>" +
                "This is a variation of Ultimate Tic Tac Toe game with an AI. <BR><BR>" +
                "The board is composed by 9 tic-tac-toe game board into a big tic-tac-toe game board.<BR>" +
                "Each small 3 × 3 tic-tac-toe board is referred to as a local board, and the larger 3 × 3 board<BR>" +
                " is referred to as the global board.<BR><BR>" +
                "Rule of Moving:<BR>" +
                "The game starts with X playing wherever they want in any of the 81 empty spots.<BR>" +
                "This move sends their opponent to its relative location. For example, if X played<BR>" +
                "in the top right square of their local board, then O needs to play next in the<BR>" +
                "local board at the top right of the global board. O can then play in any one of<BR>" +
                "the nine available spots in that local board, each move sending X to a different local board.<BR><BR>" +
                "Rule of wining:<BR>" +
                "When any three move are adjacent in a line that is either horizontal, vertical or diagonal.<BR>";
        _label = new JLabel(message, JLabel.CENTER);
    }

    private void BuildButtons() {
        BuildBackButton();
        _panel = new JPanel();
        _panel.setLayout(new FlowLayout());
        _panel.add(_back);
    }

    private void BuildBackButton() {
        _back = new JButton("Ok!");
        _back.addActionListener(e -> {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
            SwingUtilities.invokeLater(() -> {
                @SuppressWarnings("unused")
                Main frame = new Main("Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            });
        });
    }

}