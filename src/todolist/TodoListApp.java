package taskManager.src.todolist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TodoListApp extends JFrame {
  
    private ArrayList<String> tasks;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public TodoListApp() {
        setTitle("To-Do List-App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tasks = new ArrayList<>();
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);

        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField taskField = new JTextField(20);
        panel.add(taskField);

        JButton addButton = new JButton("Ajouter");
        panel.add(addButton);

        JButton removeButton = new JButton("Supprimer");
        panel.add(removeButton);

        add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    tasks.add(task);
                    taskListModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    tasks.remove(selectedIndex);
                    taskListModel.remove(selectedIndex);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TodoListApp();
    }
}

