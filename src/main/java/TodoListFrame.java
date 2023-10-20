import javax.swing.*;
import java.awt.*;

class TodoListFrame extends JFrame {

    public TodoListFrame() {
        setTitle("TODO List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 240, 240));
        initUI();
    }

    private void initUI() {
        TaskListPanel panel = new TaskListPanel();
        add(panel);
    }
}
