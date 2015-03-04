import java.io.RandomAccessFile;

/**
 * So.. what need to do:
 * 1-Figured out how work RAF
 * 2 - create his object
 * 3 - catch info from object
 * http://www.quizful.net/post/java-reflection-api
 * http://devcolibri.com/2989
 * https://dl.dropboxusercontent.com/u/28311951/Java/pdf/java-m3.pdf
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