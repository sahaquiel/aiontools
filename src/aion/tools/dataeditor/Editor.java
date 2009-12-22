package aion.tools.dataeditor;

import aion.tools.dataeditor.gui.ItemSelector;

public class Editor extends javax.swing.JFrame
{
	public Editor()
	{
		super( "Editor" );
		
		add( new ItemSelector() );
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
	}
	
	public static void main( String args[] )
	{
		new Editor().setVisible( true );
	}
	
}
