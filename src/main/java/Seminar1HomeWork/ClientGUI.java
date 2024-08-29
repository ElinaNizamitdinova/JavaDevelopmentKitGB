package Seminar1HomeWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;



    private boolean connected;
    ServerWindow server = new ServerWindow();


    private JTextField tfIPAddress;
    private  JTextField tfPort;
    private  JTextField tfLogin;
    private  JPasswordField tfPassword;
    private  JButton btnLogin;


    JPanel panelBotton = new JPanel(new BorderLayout());
    JTextField tfMessage = new JTextField();
    JButton btnSend = new JButton("Send");
    JPanel panelTop = new JPanel(new GridLayout(2,3));

    private String name;



    public static void main(String[] args) {
        new ClientGUI();
    }


    private void setting(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH,HEIGHT);
        setTitle("Chat Client");

    }

    private JPanel creatingLoginPanel(){


        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Ivan_Petrivich");
        tfPassword = new JPasswordField("123456");
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop,BorderLayout.NORTH);

        return panelTop;

    }
    public void login(){
        if (connectToServer(tfLogin.getText())){
            panelTop.setVisible(false);
        }
    }
    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)){
            System.out.println("Вы подключились\n");
            connected = true;
            String log = server.getHistory();
            System.out.println(log);
            return true;
        } else {
            System.out.println("Подключение не выполнено");
            return false;
        }
    }
    public void disconnectFromServer() {
        server.disconnectUser(this);
    }
    public void message(String text) {
        if (connected) {
            if (!text.isEmpty()) {
                server.message(name + ": " + text);
            }
        } else {
            System.out.println("Нет подключения к серверу");
        }
    }
    public void answerFromServer(String text) {
        System.out.println(text);
    }


    private JTextArea creatingLog(){

        JTextArea log = new JTextArea();
        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        return log;

    }
    ClientGUI(){
        setting();
        creatingSentPanel();


        creatingLog();
        creatingLoginPanel();

        setVisible(true);

    }
    private void creatingSentPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    message("Text from User");
                }
            }
        });
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message("Text from User");
            }
        });
        panel.add(tfMessage,BorderLayout.CENTER);
        panel.add(btnSend, BorderLayout.EAST);
        add(panel,BorderLayout.SOUTH);

        //  panelBotton.add(tfMessage,BorderLayout.CENTER);
       // panelBotton.add(btnSend, BorderLayout.EAST);
       // add(panelBotton,BorderLayout.SOUTH);

    }
    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            this.disconnectFromServer();
        }
    }

    public void answer(String text) {


        System.out.println(text);

    }

}
