import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"name", "rate", "date", "time", "ask", "bid" })
@XmlRootElement(name="rate")
public class Rate {
	
	
	private String id;
	private String name;
	private float rate;
	private String date;
	private String time;
	private String ask;
	private String bid;
	
	@XmlAttribute(name="id")
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	@XmlElement(name="Name")
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@XmlElement(name="Rate")
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	public float getRate() {
		return rate;
	}
	
	@XmlElement(name="Date")
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	@XmlElement(name="Time")
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	@XmlElement(name="Ask")
	public void setAsk(String ask) {
		this.ask = ask;
	}
	
	public String getAsk() {
		return ask;
	}
	
	@XmlElement(name="Bid")
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	public String getBid() {
		return bid;
	}
	
	@Override
	public String toString() {
		return "Rate [id=" + id + ", Name=" + name + ", Rate=" + rate
				+ ", Date=" + date + ", Time=" + time + ", Ask=" + ask
				+ ", Bid=" + bid + "]";
	}
}