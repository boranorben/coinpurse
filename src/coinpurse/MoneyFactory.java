package coinpurse;

/**
 * An abstract class for providing a concrete factory
 * and defining the method used to create coins and bank notes.
 * @author Issaree Srisomboon
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory moneyFactory;
	
	/**
	 * get an instance of MoneyFactory.
	 * @return an object of ThaiMoneyFactory.
	 */
	public static MoneyFactory getInstance() {
		if ( moneyFactory == null )  moneyFactory = new ThaiMoneyFactory();
		return moneyFactory;
	}
	
	/**
	 * Create a new money object in the local currency.
	 * @param value of money.
	 * @throws IllegalArgumentException if the value is not valid currency amount.
	 */
	protected abstract Valuable createMoney( double value ) throws IllegalArgumentException;
	
	/**
	 * Accept money value as a String.
	 * @param value of money in String.
	 * @throws IllegalArgumentException if value is not a valid number.
	 * @return value in Double if value in String can parse.
	 */
	protected Valuable createMoney( String value ) {
		try {
			 double newValue = Double.parseDouble( value );
			 return createMoney(newValue);
		} catch ( IllegalArgumentException e ) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Set the initialized money's currency.
	 * @param factory is a subclass of MoneyFactory.
	 */
	public static void setMoneyFactory( MoneyFactory factory ) {
		moneyFactory = factory;
	}
	
}
