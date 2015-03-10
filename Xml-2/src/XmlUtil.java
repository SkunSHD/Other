import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtil {
	
	public void writeXml(File file, Trains trains) {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		Trains trains = null;
		
		if(!file.exists()){
			System.out.println("Xml file doesn't exist");
			System.exit(1);
		}
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance();
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			trains = (Trains) unmarshaller.unmarshal(file);
			System.out.println(trains);
			
		} catch(JAXBException e) {
			e.printStackTrace();
		}
		
		return trains;
	}
	
	public boolean addTrain(File file, Train train) {
		boolean flag = false;
//		int idAddingTrain = train.getId();
		
		Trains trains = readXml(file);
		trains.addTrain(train);
		writeXml(file, trains);
		
		
		return flag;
	}
}