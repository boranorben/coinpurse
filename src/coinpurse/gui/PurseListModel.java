package coinpurse.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import coinpurse.Purse;
import coinpurse.Valuable;

/**
 * This class provides a ListModel interface for querying
 * the contents of the purse. It is a kind of adapter.
 * @author Issaree Srisomboon
 *
 */
public class PurseListModel extends AbstractListModel<Valuable> implements Observer {
	private Purse purse;
	private JFrame frame;
	private JScrollPane pane;
	private ListModel<Valuable> listModel;
	private JList<Valuable> listview;
	
	/**
	 * Constructor to set properties of window.	
	 * @param purse
	 */
	public PurseListModel( Purse purse ) {
		this.purse = purse;
		frame = new JFrame( "Purse Content" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	/** Initialize components in the window. */
	public void initComponent() {		
		listModel = new PurseListModel( purse );
		listview = new JList<Valuable>( listModel );
		pane = new JScrollPane( listview );
		
		frame.add( pane );
		frame.add( listview );
		frame.pack();
	}
	
	/** Display the graphics window. */
	public void run() {
		frame.setVisible( true );
		initComponent();
	}
	
	/** Return the size of the list. */
	@Override
	public int getSize() {
		return purse.count();
	}

	/** Get one element of the list at any indexes. */
	@Override
	public Valuable getElementAt(int index) {
		return purse.getImmutableList().get(index);
	}

	/** Update receives notification from the purse. */
	@Override
	public void update(Observable subject, Object info) {
		fireContentsChanged( info , 0 , getSize()-1 );
		listview.setModel(this);
	}

}
