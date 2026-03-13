package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public final class NotificationFrame extends JFrame {
    private static NotificationFrame instance;
    private final JTextArea messageArea;
    private final JTextField manualMessageField;

    private NotificationFrame() {
        super("Notification Center");
        this.messageArea = new JTextArea(14, 48);
        this.manualMessageField = new JTextField(24);
        this.messageArea.setEditable(false);
        this.messageArea.setLineWrap(true);
        this.messageArea.setWrapStyleWord(true);
        this.manualMessageField.setToolTipText("Type a manual message to display");
        resetHeader();

        JButton addMessageButton = new JButton("Add message");
        addMessageButton.addActionListener(e -> {
            String text = manualMessageField.getText().trim();
            if (text.isEmpty()) {
                text = "Manual message";
            }
            showMessage("MANUAL MESSAGE: " + text);
            manualMessageField.setText("");
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> resetHeader());

        JButton hideButton = new JButton("Hide");
        hideButton.addActionListener(e -> setVisible(false));

        JPanel controlsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlsPanel.add(manualMessageField);
        controlsPanel.add(addMessageButton);
        controlsPanel.add(clearButton);
        controlsPanel.add(hideButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(messageArea), BorderLayout.CENTER);
        add(controlsPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void resetHeader() {
        messageArea.setText("");
        messageArea.append("Notification history" + System.lineSeparator());
        messageArea.append("--------------------" + System.lineSeparator());
    }

    public static synchronized NotificationFrame getInstance() {
        if (instance == null) {
            instance = new NotificationFrame();
        }
        return instance;
    }

    public void showMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
            messageArea.append(message + System.lineSeparator());
            messageArea.setCaretPosition(messageArea.getDocument().getLength());
        });
    }
}


