package Presentacion;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ListCellRender extends DefaultListCellRenderer {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean hasFocus) {
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected,
				hasFocus);
		renderer.setIcon(new ImageIcon(ListCellRender.class.getResource("usuario_perfil.png")));
		renderer.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(), ""));
		renderer.setHorizontalAlignment(JLabel.CENTER);
		renderer.setBackground(new Color(192,192,192));
		renderer.setForeground(Color.BLACK);
		if (isSelected)
			renderer.setBackground(new Color(200, 250, 200));
		return renderer;
	}
}
