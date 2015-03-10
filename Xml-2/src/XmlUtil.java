import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtil {
	
	public void writeXml(File file, List<Train> trains) {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
//			Readable format
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
//			Writing in file and showing in OutputStream
			marshaller.marshal(trains, file);
			marshaller.marshal(trains, System.out);

		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public Trains readXml(File file) {
		List<Trains> trains = new ArrayList<>();
		
		if(!file.exists()){
			System.out.println("Xml file doesn't exist");
		}
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			trains = (Trains) unmarshaller.unmarshal(file);
			
		} catch() {
			
		}
	}
}