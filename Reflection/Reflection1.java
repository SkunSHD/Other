import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@SaveToFile(path = "D:\\1.txt")
public class TextContainer {
	String text;

	public TextContainer(String text) {
		this.text = text;
	}

	@SaveMethod
	public void save(String path) {

		try (FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeUTF(text);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String pathToSave = null;

		// �������� � ��������� ���������� pathToSave ���� ��� ���������� �����
		// �� ����� ��������� SaveToFile
		Class<?> cl = TextContainer.class;
		if (cl.isAnnotationPresent(SaveToFile.class)) {
			SaveToFile s = cl.getAnnotation(SaveToFile.class);
			pathToSave = s.path();
		}

		// ������� ������ ������ TextContainer � �������� � ���������� ����
		// ����, ������� �� ����� ����� ���������������
		Class[] paramTypes = new Class[] { String.class };
		Constructor constr = cl.getDeclaredConstructor(paramTypes);
		TextContainer tc = (TextContainer) constr.newInstance(String
				.valueOf("Hello!"));

		// ���� �����, ������� �������� ��������� SaveMethod � �������� ��� ���
		// ������� tc
		Method[] methods = cl.getMethods();

		for (Method m : methods) {
			if (m.isAnnotationPresent(SaveMethod.class)) {
				System.out.println("Ok");
				m.invoke(tc, pathToSave);

			}
		}

		//��������
		try (FileInputStream fis = new FileInputStream(pathToSave);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			tc.text = ois.readUTF();
			System.out.println(tc.text);
		}
	}
}