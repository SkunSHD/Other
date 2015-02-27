import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;



public class NumbersInFile {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("need to type filename");
			return;
		}

		int i = 0;
		String line;
		int[][] array;
		List<String> list = new LinkedList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));

			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()) {
					list.add(st.nextToken());
				}
			}

			// line = list.remove(0);
			// i = Integer.parseInt(line);
			for(int a=2; a<list.size(); a++) {
				i =(int) Math.pow(a, 2);
				if(list.size() < i) break;
			}
			array = new int[i][i];

			while(!list.isEmpty()) {
				for(int j = 0; j < (int) Math.sqrt(i)-1; j++) {
					if (list.isEmpty()) break;
					else System.out.print(list.remove(0) + " ");
				}
				System.out.println("");
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}