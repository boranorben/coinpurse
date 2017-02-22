package coinpurse;

import java.util.*;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * @author Issaree Srisomboon
 */
public class CoinUtil {

	/**
	 * Method that examines all the values in a List and returns
	 * only the values that have a currency that matches the parameter value.
	 * @param valuelist is a List of valuable objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from valuelist
	 *     that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> valuelist, String currency) {
		List<Valuable> newlist = new ArrayList<Valuable>();
		if (currency != null) {
			for (Valuable value : valuelist) {
				if (value.getCurrency().equals(currency)) newlist.add(value);
			}
		}
		return newlist; // return a list of coin references copied from valuelist
	}

	/**
	 * Method to sort a list of values by currency.
	 * On return, the list (values) will be ordered by currency.
	 * @param values is a List of valuable objects we want to sort. 
	 */
	public static void sortByCurrency(List<Valuable> value) {
		value.sort(new CompareByCurrency());
	}
	
	/**
	 * Sum values by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * For example: 
	 * coins = { Coin(1,"Baht"), Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") }
	 * then sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht
	 * 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> value) {
		Map<String,Double> map = new HashMap<String, Double>();
		Iterator<Valuable> iterator = value.iterator();
		while (iterator.hasNext()) {
			Valuable valuable = iterator.next();
			if (map.containsKey(valuable.getCurrency())) {	
				map.put(valuable.getCurrency(),map.get(valuable.getCurrency())+valuable.getValue());
			} else map.put(valuable.getCurrency(),valuable.getValue());
		}
		for (String key : map.keySet()) {
			System.out.println(map.get(key)+"-"+key);
		}
	}
	
	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");
		
		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(coins," ");
		sortByCurrency(coins);
		System.out.print("RESULT: "); printList(coins," ");
		
		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= "); printList(coins," ");
		sumByCurrency(coins);
		
	}
	
	/**
	 * Make a list of coins containing different currencies.
	 * @return money
	 */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/**
	 * Make a list of coins using given values.
	 * @param currency of coins.
	 * @param values of coins.
	 * @return a list of coins using given values.
	 */
	public static List<Valuable> makeCoins(String currency, double ... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}
	
	/**
	 * Print the list on the console, on one line.
	 * @param items.
	 * @param separator.
	 */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
		}
		System.out.println(); // end the line
	}
	
	/**
	 * Compare currency of coins by using .compareTo method.
	 * @author Issaree Srisomboon
	 *
	 */
	static class CompareByCurrency implements Comparator<Valuable> {
		public int compare(Valuable other1 , Valuable other2) {
			return other1.getCurrency().compareTo(other2.getCurrency());
		}
	}
}
