import java.util.*;
import java.util.Map.Entry;

public class GiochiamoConLeMappe
{
	static List<Person> allPeople = new ArrayList<>();

	public static void main(String[] args)
	{
		init();


		//Mappa con chiavi le città e valori le liste di persone di quella città
		Map<String,List<Person>> citta_listapersone = new HashMap<>();

		for(Person person : allPeople)
			if(!citta_listapersone.containsKey(person.city))
			{
				List<Person> personeDiQuellaCitta = new ArrayList<>();
				personeDiQuellaCitta.add(person);
				citta_listapersone.put(person.city, personeDiQuellaCitta);
			}
			else
				citta_listapersone.get(person.city).add(person);

		Set<String> lemiecitta = citta_listapersone.keySet();
		//keySet() prende di una mappa solo l'insieme delle chiavi

		Map<String,Integer> citta_popolazione = new HashMap<>();

		for(String citta : lemiecitta)
		{
//			String chiave = citta;
//			List<Person> valoreDiChiave = citta_listapersone.get(chiave);
//			int numeroPersone = valoreDiChiave.size();
//			citta_popolazione.put(chiave,numeroPersone );

			citta_popolazione.put(citta,citta_listapersone.get(citta).size());
		}

		//for(SingoloElemento in collezione)

		//for(String s : listaString)
//		{
//			s qui dentro è equivalente a
//		}
//		for(int i=0;i<listaString.size();i++)
//		{
//			String s = listaString.get(i);
//		}

		//Ora divertitevi
		//una Entry è una singola coppia chiave-valore
		Entry<String,Integer> max = null;

		//citta_popolazione.entrySet() ci da la mappa come un insieme di coppie chiave-valore staccate tra loro
		//per ogni coppia chiave valore dentro la mappa
		//cittaIesima conterrà come key il nome della citta
		//e come value il numero di abitanti di quella citta
		//es
		//cittaIesima.getKey() -> "Bologna"
		//cittaIesima.getValue() -> 9
		for(Entry<String,Integer> cittaIesima : citta_popolazione.entrySet())
			if(max==null || cittaIesima.getValue()>max.getValue())
				max = cittaIesima;

		System.out.println("La città più popolosa è "+max.getKey()+" e ha "+max.getValue()+" abitanti");

		//darmi una mappa con chiavi le città e valori età media degli abitanti

		Map<String,Integer> citta_etamedia = new HashMap<>();
		//v1
		for(String citta : citta_listapersone.keySet())
		{
			int sommaeta = 0;
			List<Person> personeDiQuellaCitta = citta_listapersone.get(citta);
			for (Person person : personeDiQuellaCitta)
				sommaeta+=person.age;

			int media = sommaeta/personeDiQuellaCitta.size();
			citta_etamedia.put(citta,media);
		}

		//v2
		for(Entry<String,List<Person>> coppia : citta_listapersone.entrySet())
		{
			int sommaeta = 0;
			List<Person> personeDiQuellaCitta = coppia.getValue();
			for (Person person : personeDiQuellaCitta)
				sommaeta+=person.age;

			int media = sommaeta/personeDiQuellaCitta.size();
			citta_etamedia.put(coppia.getKey(),media);
		}

		//v3
		for(Entry<String,List<Person>> coppia : citta_listapersone.entrySet())
		{
			int sommaeta = 0;
			for (Person person : coppia.getValue())
				sommaeta+=person.age;
			citta_etamedia.put(coppia.getKey(),sommaeta/coppia.getValue().size());
		}

		System.out.println(citta_etamedia);
	}



	private static void init()
	{
		 allPeople = Arrays.asList(
				new Person("Sofia", "Conti", 18, "Pescara"),
				new Person("Marta", "Esposito", 21, "Torino"),
				new Person("Chiara", "Ferrari", 29, "Bologna"),
				new Person("Giulia", "Ferrari", 29, "Torino"),
				new Person("Giulia", "Marino", 25, "Milano"),
				new Person("Giulia", "Russo", 52, "Torino"),
				new Person("Marco", "Russo", 71, "Milano"),
				new Person("Andrea", "Russo", 57, "Reggio Calabria"),
				new Person("Chiara", "Marino", 71, "Pescara"),
				new Person("Sofia", "Marino", 28, "Bari"),
				new Person("Andrea", "Greco", 74, "Torino"),
				new Person("Marco", "Ricci", 72, "Bologna"),
				new Person("Simone", "Ricci", 72, "Milano"),
				new Person("Marta", "Ricci", 56, "Milano"),
				new Person("Andrea", "Marino", 71, "Pescara"),
				new Person("Andrea", "Greco", 45, "Torino"),
				new Person("Chiara", "Marino", 46, "Torino"),
				new Person("Sofia", "Esposito", 51, "Bologna"),
				new Person("Simone", "Marino", 75, "Torino"),
				new Person("Marco", "Esposito", 70, "Milano"),
				new Person("Andrea", "Russo", 41, "Reggio Calabria"),
				new Person("Francesco", "Greco", 21, "Bologna"),
				new Person("Marta", "Greco", 19, "Pescara"),
				new Person("Chiara", "Conti", 64, "Reggio Calabria"),
				new Person("Marta", "Galli", 27, "Pescara"),
				new Person("Francesco", "Galli", 40, "Bari"),
				new Person("Chiara", "Galli", 43, "Reggio Calabria"),
				new Person("Luca", "Greco", 30, "Reggio Calabria"),
				new Person("Simone", "Marino", 80, "Pescara"),
				new Person("Marco", "Bianchi", 71, "Bari"),
				new Person("Marco", "Esposito", 34, "Bari"),
				new Person("Francesco", "Bianchi", 63, "Reggio Calabria"),
				new Person("Luca", "Greco", 73, "Milano"),
				new Person("Chiara", "Esposito", 33, "Bologna"),
				new Person("Chiara", "Russo", 20, "Bari"),
				new Person("Marta", "Conti", 35, "Torino"),
				new Person("Andrea", "Greco", 68, "Bologna"),
				new Person("Simone", "Greco", 46, "Milano"),
				new Person("Marco", "Marino", 23, "Pescara"),
				new Person("Marta", "Ricci", 23, "Bologna"),
				new Person("Giulia", "Russo", 53, "Bari"),
				new Person("Chiara", "Esposito", 45, "Bologna"),
				new Person("Marta", "Ricci", 31, "Pescara"),
				new Person("Chiara", "Russo", 20, "Reggio Calabria"),
				new Person("Marco", "Bianchi", 68, "Bologna"),
				new Person("Elisa", "Marino", 76, "Pescara"),
				new Person("Marco", "Marino", 80, "Milano"),
				new Person("Chiara", "Ricci", 61, "Pescara"),
				new Person("Marta", "Rossi", 22, "Pescara"),
				new Person("Andrea", "Marino", 43, "Bari")
		);

	}
}
