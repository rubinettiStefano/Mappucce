import java.util.StringJoiner;

public class Person
{
	public String name,surname;
	public int age;
	public String city;


	public Person(String name, String surname, int age, String city)
	{
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.city = city;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(",")
				.add("name='" + name + "'")
				.add("surname='" + surname + "'")
				.add("age=" + age)
				.add("city='" + city + "'")
				.toString();
	}
}
