import java.swing.*;

/**
* Sources:
* http://math.sgu.ru/sites/chairs/prinf/materials/java/lesson8.htm
* http://www.javable.com/tutorials/fesunov/lesson16/
*/

public class TxtReader extends JFrame {
	JTextArea jta;
	File currentFile = null;

	TxtReader() {
		super("Txt reader pro");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Appeal to content panel of framme
		Container c = getContentPane();
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 5));

		JButton pbn1 = new JButton("Open");
		panel.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});

	}


}