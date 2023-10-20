import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TaskListPanel extends JPanel {

    private TaskList taskList;
    private DefaultListModel<Task> listModel;
    private JList<Task> todoList;

    public TaskListPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255));
        taskList = new TaskList();
        initUI();
    }

    private void initUI() {
        listModel = new DefaultListModel<>();
        todoList = new JList<>(listModel);
        todoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        todoList.setCellRenderer(new TaskListCellRenderer());
        todoList.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(todoList);
        add(scrollPane, BorderLayout.CENTER);

        JTextField taskInput = new JTextField();
        taskInput.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JButton addButton = new JButton("Agregar Tarea");
        addButton.setBackground(new Color(0, 150, 136));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("SansSerif", Font.BOLD, 14));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTaskDescription = taskInput.getText();
                if (!newTaskDescription.isEmpty()) {
                    Task newTask = new Task(newTaskDescription);
                    taskList.addTask(newTask);
                    listModel.addElement(newTask);
                    taskInput.setText("");
                }
            }
        });

        JButton removeButton = new JButton("Eliminar Tarea");
        removeButton.setBackground(new Color(255, 87, 51));
        removeButton.setForeground(Color.WHITE);
        removeButton.setFont(new Font("SansSerif", Font.BOLD, 14));

        add(removeButton, BorderLayout.SOUTH);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Task selectedTask = listModel.get(selectedIndex);
                    taskList.removeTask(selectedTask);
                    listModel.remove(selectedIndex);
                }
            }
        });
    }
}