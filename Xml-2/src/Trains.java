import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="trains")
public class Trains implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Train> trainsList = new ArrayList<>();
	
	
	public void addTrain(Train train) {
		trainsList.add(train);
	}
	
	public List<String> findTrains(LocalTime from, LocalTime to) {
		List<String> result = new ArrayList<>();
		LocalTime trainLocalTime = null;
		
		if(from.isBefore(to)) {
			System.out.println("Error! Enter correct period of time. Current format *from* - *to*");
		} else {
			for(Train train : trainsList) {
				String objTime = train.getTime();
				String[] objTimeSplit = objTime.split(":");
				try {
					trainLocalTime = LocalTime.of(Integer.valueOf(objTimeSplit[0]), Integer.valueOf(objTimeSplit[1]));
				} catch(NumberFormatException e) {
					e.printStackTrace();
				}
				
				if(trainLocalTime.isAfter(from) && trainLocalTime.isBefore(to)) {
					result.add(trainLocalTime.toString());
				}
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return Arrays.deepToString(trainsList.toArray());
	}
}