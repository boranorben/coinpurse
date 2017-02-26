package coinpurse;

/**
 * Class for creating Thailand's currency (Baht).
 * @author Issaree Srisomboon
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	private final String DEFALUT_CURRENTCY = "Baht";
	
	/**
	 * Create money in Baht, if money is 1,2,5 or 10. It will create in Coin
	 * and it will create Banknote when money is 20,20,100,500 or 1,000.
	 * @param money that users want to create.
	 * @return valuable in Coin or Banknote from the condition.
	 * @throws IllegalArgumentException if user put other values of money. 
	 */
	@Override
	protected Valuable createMoney( double money ) throws IllegalArgumentException {
		Valuable valuable;
		if ( money == 1 || money == 2 || money == 5 || money == 10 ) {
			valuable = new Coin( money,DEFALUT_CURRENTCY );
		} else if ( money == 20 || money == 50 || money == 100 || money == 500 || money == 1000 ) {
			valuable = new BankNote( money, DEFALUT_CURRENTCY );
		} else throw new IllegalArgumentException();
		return valuable;
	}
	
//	/**
//	 * For testing ThailandMoneyFactory Class
//	 * @param args
//	 */
//	public static void main (String[] args) {
//		MoneyFactory factory = MoneyFactory.getInstance();
//		Valuable m = factory.createMoney(5);
//		System.out.println(m.toString());
//		Valuable m2 = factory.createMoney("1000.0");
//		System.out.println(m2.toString());
//	}
}
