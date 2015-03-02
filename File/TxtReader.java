import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
		super("Proto Txt reader");

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
		c.add(panel, BorderLayout.NORTH);

		jta = new JTextArea(20, 30);
		jta.setFont(jta.getFont().deriveFont(14.0f));
		JScrollPane scroll = new JScrollPane(jta);
		c.add(scroll, BorderLayout.CENTER);


		WindowListener wl = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(wl);

		setVisible(true);
	}

	public void open() {
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);

		ExtFileFilter ff1 = new ExtFileFilter("txt", "*.txt - text documents");
		fc.addChoosableFileFilter(ff1);

		ExtFileFilter ff2 = new ExtFileFilter("java", "*.java - java source code files");
		fc.addChoosableFileFilter(ff2);

		if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			if(!f.isFile() || !f.canRead()) {
				System.out.println("You choosed directory, please try again");
				return;
			}
			File currentFile = f;
			BufferedReader in = null;
			try {
			 	in = new BufferedReader(new FileReader(currentFile));
			 	for(;;) {
			 		String line = in.readLine();
			 		if (line == null) {
			 			break;
			 		}
			 		jta.append(line + "\n");
			 	}
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if ( in != null)
						in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void save() {
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);

		ExtFileFilter ff1 = new ExtFileFilter("txt", "*.txt - simple text files");
		fc.addChoosableFileFilter(ff1);

		ExtFileFilter ff2 = new ExtFileFilter("java", "*.java - programms on java");
		fc.addChoosableFileFilter(ff2);


		if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			PrintWriter pw;
			File f = fc.getSelectedFile();

			try {
				if(!f.exists())
					f.createNewFile();

				pw = new PrintWriter(f);
				String[] lines = jta.getText().split("\\n");
				for(int i=0; i<lines.length; i++)
					pw.println(lines[i]);
					pw.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new TxtReader();
	}
}