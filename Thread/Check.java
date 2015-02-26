import java.util.*;
import java.io.*;

public class Check {

	public static void main(String[] args) {

		Thread watchmen = new Thread( new Runnable() {

			private boolean stopRun = false;

			public void stopThread() {
				stopRun = true;
			}

			public void run() {
				while(!stopRun) {
					System.out.println(new Date(System.currentTimeMillis()));
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						System.err.print(e);
					}
				}
			}
		});

		watchmen.start();

		System.out.println("Type \"kill\" to kill the process");
		Scanner sc = new Scanner(System.in);

		String sent = "";
		while(sc.hasNext()) {
			if((sent = sc.nextLine()).equals("kill")) {
				watchmen.stopThread();
				return ;
			}
		}
	}

}