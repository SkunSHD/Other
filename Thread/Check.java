import java.util.*;
import java.io.*;

public class Check {

	public static void main(String[] args) {
		int time = 0;
		String line = "";
		

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter the period of time for showing time");
			line = sc.nextLine();
			try {
				time = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				System.err.println("Enter the positive number please!");
			}
		} while(time <= 0);
		

		CheckThread.MyThread watchmen = new CheckThread.MyThread(time);

		watchmen.start();

		System.out.println("Type \"kill\" to kill the process");
		String sent = "";
		while(sc.hasNext()) {
			if((sent = sc.nextLine()).equals("kill")) {
				watchmen.stopThread();
				return ;
			}
		}
	}

}