package renderer;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageCellRenderer extends DefaultTableCellRenderer {
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
      int row, int column) {
    // if the value is a label, return it
    if (value instanceof JLabel) {
      return (JLabel) value;
    }
    // if not, create a new label
    else {
      JLabel label = new JLabel();
      try {
        if (value == "")
          return null;
        File file = new File("lib/Img/" + value);
        Image image = ImageIO.read(file);
        if (image == null)
          return null;
        ImageIcon icon = new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      return label;
    }
  }
}
