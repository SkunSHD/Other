import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	public static void main(String[] args) {
		new Main().go();
	}

	public void go() {
		File kvazyRequest = new File("C://Parse.txt");
		String requestAnswer = readFile(kvazyRequest);
		System.out.println(requestAnswer);
//		Gson gson = new GsonBuilder().create();
//		Profile json = (Profile) gson.fromJson(requestAnswer, Profile.class);
//		
//		System.out.println(json);
		
	}
	
	public String readFile(File file) {
		String result = null;
		byte[] buf = null;
		
		if(!file.exists()) {
			System.out.println("dose not exist");
			System.exit(1);
		}
		
		try {
			RandomAccessFile randAccess = new RandomAccessFile(file, "r");
			try {
				buf = new byte[(int) file.length()];
				randAccess.read(buf);
			} finally {
				randAccess.close();
			}
			result = new String(buf, "US-ASCII");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}