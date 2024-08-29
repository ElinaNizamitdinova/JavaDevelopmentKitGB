package Lesson1Seminar1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;
    private static final String SELECT_FIELD_SIZE = "Устанленный размер поля: ";
    private static final String INSTALLED_lENGHT = "Установленная длинa победы: ";

    JButton btnStart;
    JSlider sizeF = new JSlider(3,10);
    JSlider sizeW = new JSlider(3,10);
    JRadioButton btn1 = new JRadioButton("Человек против компьютера");
    JRadioButton btn2 = new JRadioButton("Человек против человека");

    GameWindow gameWindow;
    SettingWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        btnStart = new JButton("Start new game");

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);



        JPanel setting = new JPanel(new GridLayout(3,1));

        JPanel typeGame = new JPanel(new GridLayout(3,1));
        typeGame.add(new JLabel("Выберете режим игры"));
        ButtonGroup group1 = new ButtonGroup();

        btn1.setSelected(true);

        btn2.setSelected(true);
        group1.add(btn2);
        group1.add(btn1);
        typeGame.add(btn1);
        typeGame.add(btn2);



        JPanel sizeWin = new JPanel(new GridLayout(3,1));
        sizeWin.add(new JLabel("Выберете длину для победы"));
        JLabel labelInstalledLength = new JLabel(INSTALLED_lENGHT);
        sizeWin.add(labelInstalledLength);

        sizeW.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int lenght = sizeW.getValue();
                labelInstalledLength.setText(INSTALLED_lENGHT+lenght);
            }
        });

        JPanel sizeField = new JPanel(new GridLayout(3,1));
        sizeField.add(new JLabel("Выберете размер поля"));
        JLabel labelCurrentSize = new JLabel(SELECT_FIELD_SIZE);
        sizeField.add(labelCurrentSize);

        sizeF.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int size = sizeF.getValue();
                labelCurrentSize.setText(SELECT_FIELD_SIZE + size);
                sizeW.setMaximum(size);
            }
        });

        sizeField.add(sizeF);

        sizeWin.add(sizeW);

        setting.add(typeGame);
        setting.add(sizeField);
        setting.add(sizeWin);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();

            }
        });

        add(setting);

        add(btnStart,BorderLayout.SOUTH);

    }
    private void startNewGame(){
        int mode = 0;
        if(btn1.isSelected()){
            mode=1;
        } else if (btn2.isSelected()) {
            mode=2;
        }
        int sizeField = sizeF.getValue();
        int sizeWin = sizeW.getValue();
        gameWindow.startNewGame(mode, sizeField, sizeField, sizeWin);
        setVisible(false);

    }
}