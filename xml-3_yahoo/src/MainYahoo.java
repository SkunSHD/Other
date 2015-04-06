import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MainYahoo {
	public static void main(String[] args) {
		String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
							"yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

		String respond = performRequest(request);
		try {
			File file = new File("C://Yahoo.xml");
			if(!file.exists()) {
				file.createNewFile();
			}
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
			Unmarshaller unmarshal = jaxbContext.createUnmarshaller();
			InputStream inStream = new ByteArrayInputStream(respond.getBytes());
			Query query = (Query) unmarshal.unmarshal(inStream);
			
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(query, file);
			marshaller.marshal(respond, System.out);
			
		} catch(JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static String performRequest(String request) {
		StringBuilder strBuilder = new StringBuilder();
		char[] buf = new char[1000000];
		
		int r = 0;
		try {
			URL url = new URL(request);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			
			BufferedReader bufReader = new BufferedReader(
					new InputStreamReader(http.getInputStream()));
			do {
				if( (r = bufReader.read(buf)) > 0) {
					strBuilder.append(new String(buf, 0, r));
				}
			} while(r>0);
			
			
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return strBuilder.toString();
	}
}