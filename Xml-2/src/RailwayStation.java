import java.io.File;
import java.time.LocalDateTime;

public class RailwayStation {
	public static void main(String[] args) {
		Trains trains = new Trains();
		
		Train train1 = new Train(1, "Slavyansk", "Alfa Centaura", LocalDateTime.now());
		Train train2 = new Train(2, "Lugansk", "Andromeda", LocalDateTime.now());
		Train train3 = new Train(3, "Lvov", "Krim", LocalDateTime.now());
		
		trains.addTrain(train1);
		trains.addTrain(train2);
		trains.addTrain(train3);
		System.out.println(trains);
		
		XmlUtil xmlUtil = new XmlUtil();
		File file = new File("/home/skuns/git/testing/Other/Xml-2/Data.xml");
		xmlUtil.writeXml(file, trains);
	}
}