import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

@XmlRootElement(name="query")
public class Query {
	private int count;
	private String created;
	private String lang;
	private Results results;
	private Map<QName, String> attributes = new HashMap<>();
	
	public Query() {
		
	}
	
	public Query(int count, String created, String lang, Map<QName, String> attributes) {
		this.count = count;
		this.created = created;
		this.lang = lang;
		this.attributes = attributes;
	}
	
	@XmlAnyAttribute
	public void setAttributes(Map<QName, String> attributes) {
		this.attributes = attributes;
	}
	
	public Map<QName, String> getAttributes() {
		return attributes;
	}
	
	@XmlElement(name="results")
	public void setReasults(Results results) {
		this.results = results;
	}
	
	public Results getResults() {
		return results;
	}
	
	@Override
	public String toString() {
		return "count=" + count + ", created=" + created + ", lang=" + lang;
	}
}