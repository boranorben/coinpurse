package coinpurse;

/**
 * The parent class for Coin and Banknote.
 * @author Issaree Srisomboon
 *
 */
public abstract class AbstractValuable implements Valuable{

	/** Value of the coin. */
	protected double value;
	/** The currency, of course. */
	protected String currency;

	public AbstractValuable() {
		super();
	}

	/**
	 * Get the valuable of value.
	 * @return the valuable of value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of value.
	 * @return currency of value.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * @param obj is an another object to compare to this one.
	 * @return true if they have the same value and currency,
	 * return false if they have not the same value or currency. Or obj is null 
	 * or is not in the same class. 
	 */
	@Override
	public boolean equals(Object obj) {
		if ( obj == null ) return false;
		if ( obj.getClass() != this.getClass() ) return false;
		Valuable other = (Valuable) obj;
		return other.getValue() == this.getValue() && other.getCurrency() == this.getCurrency();
	}

	/**
	 * If the currency is the same, order values by values 
	 * so that the smaller value comes first.
	 * If the currency is not the same, sort the currency.
	 * @return <0 when this value is less than other value,
	 * return 0 when this value equals other value and
	 * return >0 when this value is more than other value.
	 */
	@Override
	public int compareTo(Valuable other) {
		if ( other == null ) {
			return -1;
		} else if ( this.getCurrency().equals( other.getCurrency()) ) {
			return (int) Math.signum( this.getValue() - other.getValue() );
		} else return this.getCurrency().compareTo( other.getCurrency() );
	}

}