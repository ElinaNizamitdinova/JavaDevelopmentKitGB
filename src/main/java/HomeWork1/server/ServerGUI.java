package HomeWork1.server;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class ServerGUI extends JFrame implements ServerView{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private ServerController serverController;

    JButton startButton;
    JButton stopButton;
    JTextArea log;

    public ServerGUI() {
        settings();

        createLog();
        setVisible(true);
    }

    @Override
    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
    }

    private void settings() {
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setTitle("Server");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private Component createButtonsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                serverController.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                serverController.stop();
            }
        });

        panel.add(startButton);
        panel.add(stopButton);
        return panel;
    }

    private void createLog() {
        log = new JTextArea();
        log.setEditable(false);

        add(log);
        add(createButtonsPanel(), BorderLayout.SOUTH);
    }

    @Override
    public void showMessage(String text) {
        log.append(text);
    }

}