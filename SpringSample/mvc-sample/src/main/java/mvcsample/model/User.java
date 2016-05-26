package mvcsample.model;

import java.util.Date;

public class User {
	private final Long id;
	private final String name;
	private final String surname;
	private final Date birthdate;
	private Double height;
	private Double weight;
	
	public User(String name, String surname, Date time) {
		this(name, surname, time, null, null);
		}
	
	public User(String name, String surname, Date time, Double height, Double weight){
		this.id= null;
		this.name=name;
		this.surname=surname;
		this.birthdate = time;
		this.height = height;
		this.weight=weight;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}
