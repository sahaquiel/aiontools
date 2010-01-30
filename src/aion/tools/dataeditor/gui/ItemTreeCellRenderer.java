package aion.tools.dataeditor.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import aion.tools.data.Design;
import aion.tools.data.Item;
import aion.tools.data.ItemGetter;
import aion.tools.data.MaterialRequirement;

public class ItemTreeCellRenderer extends DefaultTreeCellRenderer {

	Item m_dummy;
	Design m_dummy2;
	Font m_fontPlain, m_fontItalic;
	
	public ItemTreeCellRenderer()
	{
		super();
		
		m_dummy = new Item("dummy");
		m_dummy = new Design("dummy2");
		
		Font currFont = new Font( "Arial", Font.PLAIN, 12 );
		
		m_fontPlain = currFont.deriveFont( Font.PLAIN );
		m_fontItalic = currFont.deriveFont( Font.ITALIC );
	}
	
	@Override
	public Component getTreeCellRendererComponent(JTree arg0, Object arg1,
			boolean arg2, boolean arg3, boolean arg4, int arg5, boolean arg6) {

//  FEFE: enable this to get default rendering		
//		return super.getTreeCellRendererComponent(arg0, arg1, arg2, arg3, arg4, arg5,
//				arg6);


//		Our tree cells can be either an Item, a Design (Subclass of Item)
//		or a MaterialRequirement. Depending on the type, we needs to find
//		the proper Item-object to render in a different way
		
		Item theItem = ((ItemGetter)arg1).getItem(); 
/*		
		if ( arg1.getClass().isInstance( m_dummy ) )
		{		
			theItem = (Item) arg1;
		}
		else if ( arg1.getClass().isInstance( m_dummy2 ) )
		{
			theItem = (Design) arg1;
		}
		else
		{
			theItem = ((MaterialRequirement)(arg1)).material;
		}
*/
		
		switch( theItem.getRarity() )
		{
		case 1:
			setForeground( Color.GREEN );
			break;
		case 2:
			setForeground( Color.BLUE );
			break;
		case 3:
			setForeground( Color.ORANGE );
			break;
		case 0:
		default:
			setForeground( Color.BLACK);
		}
		
		if ( theItem.needsToProc() )
		{
			setFont( m_fontItalic );
		}
		else
		{
			setFont( m_fontPlain );
		}
		
		setText( arg1.toString() );			
		
				
		return this;
		
	}

}
