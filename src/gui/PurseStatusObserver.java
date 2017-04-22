package gui;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import coinpurse.Purse;

/**
 * Show the status (FULL, EMPTY, or show the number of items) of the purse in window.
 * @author Issaree Srisomboon
 *
 */
public class PurseStatusObserver extends JFrame implements Observer {
	private JTextArea textArea;
	private JProgressBar progressBar;
	
	/** Constructor to set properties of window. */	
	public PurseStatusObserver() {
		super( "Purse Status" );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		initComponent();
	}
	
	/** Initialize components in the window. */
	public void initComponent() {
		textArea = new JTextArea( 5,40 );
		progressBar = new JProgressBar( 0,10 );
		this.add( textArea , BorderLayout.CENTER );
		this.add( progressBar , BorderLayout.SOUTH );
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
			progressBar.setMaximum( purse.getCapacity() );
			progressBar.setValue( purse.count() );
			if ( purse.getCapacity() == purse.count() ) textArea.setText( "FULL" );
			else if ( purse.count() == 0 ) textArea.setText( "EMPTY" );
			else textArea.setText( purse.count() + "" );
		}	
	}

}
