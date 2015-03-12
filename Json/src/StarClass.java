public class Profile {
	
	private String name;
	private String surname;
	private String[] phones;
	private String[] sites;
	public Adress adress;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String[] getPhones() {
		return phones;
	}
	
	public void setPhones(String[] phones) {
		this.phones = phones;
	}
	
	public String[] getSites() {
		return sites;
	}
	
	public void setSites(String[] sites) {
		this.sites = sites;
	}
	
	@Override
	public String toString() {
		return name + " " + surname + " " + phones.toString() + " " + sites.toString();
	}
	
}