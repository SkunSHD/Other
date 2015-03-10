import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RailwayStation {
	public static void main(String[] args) {
		Trains trains = new Trains();
		
		Train train1 = new Train(1, "Slavyansk", "Alfa Centaura", LocalDateTime.of(2015, 03, 10, 15, 00));
		Train train2 = new Train(2, "Lugansk", "Andromeda", LocalDateTime.of(2015, 03, 10, 16, 30));
		Train train3 = new Train(3, "Lvov", "Krim", LocalDateTime.of(2015, 03, 10, 17, 45));
		
		trains.addTrain(train1);
		trains.addTrain(train2);
		trains.addTrain(train3);
		System.out.println(trains);
		
		XmlUtil xmlUtil = new XmlUtil();
		File file = new File("C://Data1.xml");
		xmlUtil.writeXml(file, trains);
		
		Train train4 = new Train(4, "Harkov", "Doneck", LocalDateTime.of(2015, 03, 10, 12, 01));
		
		xmlUtil.addTrain(file, train4);
		System.out.println("Searching trains in diapozone of 11:00-15:00");
		
		trains.findTrains(LocalTime.of(11, 00), LocalTime.of(20, 00));
		
		
	}
}