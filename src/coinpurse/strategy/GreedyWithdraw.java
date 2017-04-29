package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

/**
 * Concrete class for a greedy withdraw strategy that using greedy algorithm.
 * @author Issaree Srisomboon
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {

	/** @see WithdrawStategy#withdraw */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<>();
		Collections.sort( money );
    	for ( int i = money.size()-1 ; i >= 0 ; i-- ) {
    		Valuable value = money.get(i);
    		if ( value.getValue() <= amount ) {
    			amount -= value.getValue();
    			templist.add( value );
    		}
    	}
    	if ( amount == 0 ) {
    		return templist;
    	}
    	return null;
	}

}
