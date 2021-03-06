import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class prog {
    // Объявляем переменную типа Robot
    public static Robot rob = null;

    public static void main(String[] args) {
        try {
            //Создаем новый объект класса Robot
            rob = new Robot();
        }catch (Exception e){

        }
        // Создаем окно
        JFrame wnd = new JFrame();
        // Убираем рамку окна
        wnd.setUndecorated(true);
        // Помещаем окно поверх других окон
        wnd.setAlwaysOnTop(true);
        // Помещаем окно в левый верхний угол экрана
        wnd.setLocation(0,0);
        // Располагать кнопки слева направо автоматически
        wnd.setLayout(new FlowLayout());
        // Массив из 5-ти кнопок
        JButton[] btn = new JButton[5];
        for(int i=0; i<5;i++){
            // Новая кнопка
            btn[i] = new JButton();
            // Имя кнопки
            btn[i].setName("b" +i);
            // Обработчик события при нажатии
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Определяем нажатую кнопку
                    JButton b = (JButton)e.getSource();
                    //  Определяем имя кнопки
                    String name = b.getName();

                    // БРАУЗЕР
                    if(name.equals("b0")){
                        try{
                            // Запуск браузера
                            ProcessBuilder proc = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http:\\club.1c.ru");
                            proc.start();
                        }catch (Exception ex){

                        }
                    }

                    // МЫШЬ
                    else if (name.equals("b1"))
                    {
                        // Перемещение курсора по диагонали
                        for(int i=500; i>=0; i--){
                            // Установить положение курсра мыши Х У
                            rob.mouseMove(i,i);
                            //задрежка
                            rob.delay(5);
                        }
                        // Установить положение курсра мыши над кнопкой блокнот
                    rob.mouseMove(50,30);
                        // Нажимаем левую клавишу мыши
                    rob.mousePress(MouseEvent.BUTTON1_MASK);
                    // Задержка
                        rob.delay(200);
                    // Отпускаем левую клавишу мыши
                    rob.mouseRelease(MouseEvent.BUTTON1_MASK);
                    }

                    // КАЛЬКУЛЯТОР
                    else if(name.equals("b2")) {
                        try {
                            // Запуск калькулятора
                            ProcessBuilder proc = new ProcessBuilder("calc");
                            proc.start();
                        } catch (Exception ex) {

                        }
                        //Ждем 5 секунд
                        rob.delay(5000);
                        // Закрываем калькулятор комбинацией клавиш Alt+F4
                        rob.keyPress(KeyEvent.VK_ALT);
                        rob.delay(100);
                        rob.keyPress(KeyEvent.VK_F4);
                        rob.delay(100);
                        rob.keyRelease(KeyEvent.VK_F4);
                        rob.delay(100);
                        rob.keyRelease(KeyEvent.VK_ALT);
                        rob.delay(100);
                    }



                    else if(name.equals("b3")){    //Мигание
                        for (int i = 0; i<10; i++){
                            //Нажимаем клавишу CapsLock
                            rob.keyPress(KeyEvent.VK_CAPS_LOCK);
                            // Задержка половины секунды
                            rob.delay(500);
                            // Отпускаем клавишу CapsLock
                            rob.keyRelease(KeyEvent.VK_CAPS_LOCK);
                            //Нажимаем клавишу NumLock
                            rob.keyPress(KeyEvent.VK_NUM_LOCK);
                            // Задержка половины секунды
                            rob.delay(500);
                            //Отпускаем клавишу NumLock
                            rob.keyRelease(KeyEvent.VK_NUM_LOCK);
                            // Нажимаем клавишу SCROLL_LOCK
                            rob.keyPress(KeyEvent.VK_SCROLL_LOCK);
                            // Задержка половины секунды
                            rob.delay(500);
                            // Отпускаем клавишу SCROLL_LOCK
                            rob.keyRelease(KeyEvent.VK_SCROLL_LOCK);
                        }
                    }


                    else if(name.equals("b4")){ // Выход
                        // Заверщение работы приложения
                        System.exit(0);
                    }
                }
            });
            // Добавляем кнопку
            wnd.add(btn[i]);
        }
        // Устанавливаем тексты на кнопках
        btn[0].setText("Браузер");
        btn[1].setText("Мышь");
        btn[2].setText("Калькулятор");
        btn[3].setText("Мигание");
        btn[4].setText("Выход");
        // Установить размеры окна автоматически
        wnd.pack();
        // Завершать работу приложения при закрытии окна
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Выводим окно
        wnd.setVisible(true);
    }

}
