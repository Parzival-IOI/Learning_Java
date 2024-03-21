package DemoTwo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DemoTwo {
    JFrame frame;
    JLabel labelA, labelB, labelC;
    JButton next, prev;
    JPanel card, cardA, cardB, cardC, button;
    CardLayout layout;

    public DemoTwo() {
        frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new BorderLayout(20, 20));

        labelA = new JLabel("Card A");
        labelB = new JLabel("Card B");
        labelC = new JLabel("Card C");

        next = new JButton("Next");
        prev = new JButton("Prev");

        layout = new CardLayout();

        cardA = new JPanel(new FlowLayout());
        cardB = new JPanel(new FlowLayout());
        cardC = new JPanel(new FlowLayout());

        button = new JPanel();

        card = new JPanel(layout);

        cardA.add(labelA);
        cardB.add(labelB);
        cardC.add(labelC);

        card.add(cardA, "card 1");
        card.add(cardB, "card 2");
        card.add(cardC, "card 3");

        button.add(next);
        button.add(prev);

        frame.add(card, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        next.addActionListener(e -> {
            layout.next(card);
        });

        prev.addActionListener(e -> {
            layout.previous(card);
        });

        frame.setVisible(true);
    }

}
