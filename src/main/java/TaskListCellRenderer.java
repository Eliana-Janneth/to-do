import javax.swing.*;
import java.awt.*;

class TaskListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Task) {
            Task task = (Task) value;
            setText("\u2022 " + task.getDescription());
        }
        return this;
    }
}