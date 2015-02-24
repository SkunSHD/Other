import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
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

		JButton btn1 = new JButton("Open");
		panel.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});

		JButton btn2 = new JButton("Save");
		panel.add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});

		jta = new JTextArea();
		JScrollPane scrollArea = new JScrollPane(jta);
		c.add(scrollArea, BorderLayout.CENTER);

		c.add(panel, BorderLayout.NORTH);

		WindowListener wndCloser = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(wndCloser);

		setVisible(true);
	}

	public void open() {
		JFileChooser fc = new JFileChooser();
		ExtFileFilter ff1 = new ExtFileFilter("txt", "*.txt - text files");
		fc.addChoosableFileFilter(ff1);

		ExrFileFilter eff2 = new ExtFileFilter("java", "*.java - java programms");
		fc.addChoosableFileFilter(ff2);

		if(fc.showOpenDialog(this)) == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectdFile();
		}
	}

	public void save() {

	}

	public class ExtFileFilter extends javax.swing.filechooser.FileFilter {
		String ext;
		String description;

		ExtFileFilter(String ext, String description) {
			this.ext = ext;
			this.description = description;
		}

		public boolean accept(File f) {
			String ext = getExtention(f);
		}

		public String getExtention(File f) {
			String s = f.getName();
		}
	}

	public static void main(String[] args) {
		new TxtReader();
	}

}