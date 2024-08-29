package Seminar1HomeWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    JPanel panel = new JPanel(new GridLayout(1, 2));
    private final JTextArea log = new JTextArea();
    private final String LOGING_PATH = "src/main/java";
    private boolean isServerWorking;
    private List<ClientGUI> listClients = new List<ClientGUI>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<ClientGUI> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(ClientGUI clientGUI) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends ClientGUI> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends ClientGUI> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public ClientGUI get(int index) {
            return null;
        }

        @Override
        public ClientGUI set(int index, ClientGUI element) {
            return null;
        }

        @Override
        public void add(int index, ClientGUI element) {

        }

        @Override
        public ClientGUI remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<ClientGUI> listIterator() {
            return null;
        }

        @Override
        public ListIterator<ClientGUI> listIterator(int index) {
            return null;
        }

        @Override
        public List<ClientGUI> subList(int fromIndex, int toIndex) {
            return null;
        }
    };


    public static void main(String[] args) {
        new ServerWindow();
    }

    public ServerWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X,POS_Y,WIDTH,HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        add(log);
        add(createStartStopPanel(),BorderLayout.SOUTH);
        setVisible(true);
    }
    private void answerFromServes(String text){
        for (ClientGUI clientGUI:listClients){
            clientGUI.answerFromServer(text);
        }
    }
    public void message(String text){
        if (!isServerWorking){
            return;
        }
        appendLog(text);
        answer(text);
        saveInLog(text);
    }

    private void answer(String text) {
        System.out.println(text);
    }

    private JPanel createStartStopPanel(){
        isServerWorking = true;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                System.out.println("Сервер остановлен "+ isServerWorking +"\n");
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                System.out.println("Сервер запущен "+isServerWorking +"\n");
            }
        });
        panel.add(btnStart);
        panel.add(btnStop);
        return panel;

    }


    public boolean connectUser(ClientGUI clientGUI) {
        if (isServerWorking){
            listClients.add(clientGUI);
            return true;
        }
        else {
            return false;

        }
    }
    public String getLog() {
        return readLog();
    }
    private void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOGING_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void appendLog(String text){
        log.append(text + "\n");
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOGING_PATH)){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getHistory() {
        return "History";
    }

    public void disconnectUser(ClientGUI clientGUI) {
        listClients.remove(clientGUI);
        System.out.println("Выполнено отключение от сервера");
    }
}
