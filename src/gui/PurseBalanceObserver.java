package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import coinpurse.ConsoleDialog;
import coinpurse.Purse;

/**
 * Show the balance of the purse in window.
 * @author Issaree Srisomboon
 *
 */
public class PurseBalanceObserver extends JFrame implements Observer {
	private JTextArea textArea;
	
	/** Constructor to set properties of window. */
	public PurseBalanceObserver() {
		super( "Purse Balance" );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		initComponent();
	}
	
	/** Initialize components in the window. */
	public void initComponent() {
		textArea = new JTextArea( 5,40 );
		this.add( textArea );
		this.pack();
	}
	
	/** Display the graphics window. */
	public void run() {
		this.setVisible( true );
	}

	/** Update receives notification from the purse. */
	@Override
	public void update(Observable subject, Object info) {
		if ( subject instanceof Purse ) {
			Purse purse = (Purse) subject;
			textArea.setText( purse.getBalance() + " " + ConsoleDialog.CURRENCY );
		}	
	}

}
