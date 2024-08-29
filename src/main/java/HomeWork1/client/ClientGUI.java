package HomeWork1.client;

import HomeWork1.server.ServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame implements ClientView{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private ServerGUI server;

    JTextArea log;
    JTextField IPAdress, PortAdress, login, message;
    JPasswordField password;
    JButton connectButton;
    JButton send;

    JPanel header;
    JPanel footer;

    private ClientController clientController;

    public ClientGUI() {
        settings();
        createPanel();

        setVisible(true);
    }

    @Override
    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    private void settings() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createPanel() {
        add(createHeader(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private Component createHeader() {
        header = new JPanel(new GridLayout(2, 3));
        IPAdress = new JTextField("127.0.0.1");
        PortAdress = new JTextField("3456");
        login = new JTextField("Иван Петрович");
        password = new JPasswordField("123qwerty");

        connectButton = new JButton("Войти");

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login();
            }
        });

        header.add(IPAdress);
        header.add(PortAdress);
        header.add(login);
        header.add(password);
        header.add(connectButton);
        return header;
    }

    private void message() {
        clientController.message(message.getText());
        message.setText("");
    }

    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);

        return new JScrollPane(log);
    }

    private Component createFooter() {
        footer = new JPanel(new GridLayout(1, 2));

        message = new JTextField();
        send = new JButton("Send");

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                message();
            }
        });

        footer.add(message);
        footer.add(send);

        return footer;
    }

    private void login() {
        if (clientController.connectToServer(login.getText())) {
            header.setVisible(false);
        }
    }

    @Override
    public void showMessage(String message) {
        log.append(message + "\n");
    }

}