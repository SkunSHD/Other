import java.io.Serializable;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="train")
public class Train implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String from;
	private String to;
	private String date;
	private String time;
	
	public Train() {
		
	}
	
	public Train(int id, String from, String to, LocalDateTime date) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.date = date.toLocalDate().toString();
		this.time = date.toLocalDate().toString();
		
	}
	
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name="from")
	public void setFrom(String from) {
		this.from = from;
	}
	
	@XmlElement(name="to")
	public void setTo(String to) {
		this.to = to;
	}

	@XmlElement(name="date")
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFrom() {
		return from;
	}
	
	public String getTo() {
		return to;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	
	@XmlElement(name = "departure")
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "[Train №" + id + ")" + from + "-" + to + "  " + date + " " + time + "]";
	}
}