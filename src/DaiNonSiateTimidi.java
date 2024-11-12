import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaiNonSiateTimidi
{
	public static void main(String[] args)
	{

		//NON CONTIENE UNA MANNAGGINA DI CHIAVE E VALORE
		//circa
		//  una mappa è un insieme di coppie chiave-valore
		//non una
		//tante tante tante
		//coppia chiave-valore -> ENTRY

		Map<Integer,String> mappa = new HashMap<>();

		mappa.put(0,"A");
		mappa.put(1,"B");
		mappa.put(2,"C");
		mappa.put(18,"D");//chiave 18

		List<String> lista = new ArrayList<>();

		lista.add("A");
		lista.add("B");
		lista.add("C");
		lista.add("D");//chiave 3

		System.out.println(mappa.get(3).equals(lista.get(3)));

		//lista è una mappa le cui chiavi sono valori interi positivi e contigui
		//una lista è una mappa che ha fatto un binding vow


		//ora, anche gli oggetti sono mappe
		//perchè un oggetto person non è altro che una mappa con chiavi:
		//name
		//surname
		//age
		PersonInterna p = new PersonInterna();
		p.name = "Stefano";
		p.surname = "Rubinetti";
		p.birthday = LocalDate.of(1995,8,27);
		//p.height = 176;

		Map<String,Object> personaBrutta = new HashMap<>();
		personaBrutta.put("name","Stefano");
		personaBrutta.put("surname","Rubinetti");
		personaBrutta.put("birthday",LocalDate.of(1995,8,27));
		personaBrutta.put("height",176);

		System.out.println(p.birthday.equals(personaBrutta.get("birthday")));

		LocalDate ld = p.birthday;
		LocalDate ld2 = (LocalDate) personaBrutta.get("birthday");
		String nome = 	(String)	personaBrutta.get("name");

	}
}

class PersonInterna
{
	public String name,surname;
	public LocalDate birthday;
}