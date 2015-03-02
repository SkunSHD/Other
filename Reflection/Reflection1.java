import java.io.RandomAccessFile;

/**
 * So.. what need to do:
 * 1-Figured out how work RAF
 * 2 - create his object
 * 3 - catch info from object
 */

public class Reflection1 {

	public static void main(String[] args) {
		final int i = 777;

		Class cls1 = RandomAccessFile.class;

		int mods = cls1.getModifiers();
		if(Modifier.isPublic(mods)) {
			System.out.println("public");
		}

		System.out.println(cls1);
	}
}