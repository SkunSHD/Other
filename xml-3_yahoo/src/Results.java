import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="results")
public class Results {
	
	@XmlElement(name="rate")
	private Rate[] rate;
	
	@Override
	public String toString() {
		return "rate=" + Arrays.toString(rate);
	}
}