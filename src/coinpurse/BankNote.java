package coinpurse;

/**
 * Bank note with a fixed value and currency.
 * @author Issaree Srisomboon
 *
 */
public class BankNote implements Valuable{
	private static long nextSerialNumber = 1000000;
	private static final String DEFAULT_CURRENCY = "Baht";
	private double value;
	private String currency;
	private long serialNumber;
	
	 /**
     * A bank note with given value using the default currency.
     * @param value of bank note.
     */
	public BankNote( double value ) {
		this( value,DEFAULT_CURRENCY );
	}
	
	/**
     * A bank note with given value and currency.
     * @param value of bank note.
     * @param currency of bank note.
     */
	public BankNote( double value,String currency ) {
		this.value = value;
		this.currency = currency;
	}
	
	 /**
     * Get the valuable of bank note.
     * @return the valuable of bank note.
     */
	public double getValue() {
		return this.value;
	}
	
	/**
     * Get the currency of bank note.
     * @return currency of bank note.
     */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Get the serial number of bank note.
	 * @return bank note's serial number.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
     * @param obj is an another object to compare to this one.
     * @return true if they have the same value and currency,
     * return false if they have not the same value or currency. Or obj is null 
     * or is not in the same class. 
     */
	@Override
	public boolean equals( Object obj ) {
		if ( obj == null ) return false;
    	if ( obj.getClass() != this.getClass() ) return false;
    	Coin other = (Coin) obj;
    	if ( other.getValue() == this.value && other.getCurrency() == this.currency ) {
    		return true;
    	}
    	return false;
	}

	/**
     * Get a string representation of bank notes and currency.
     * @return string representation of bank notes and currency.
     */
	public String toString() {
		return String.format( "%.2f-%s note [%s]",this.value,this.currency,this.serialNumber );
	}
}

