package aion.tools.dataeditor.gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import aion.tools.data.Design;
import aion.tools.data.Item;
import aion.tools.data.MaterialRequirement;

public class ItemTreeCellRenderer extends DefaultTreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree arg0, Object arg1,
			boolean arg2, boolean arg3, boolean arg4, int arg5, boolean arg6) {
		// TODO Auto-generated method stub
		return super.getTreeCellRendererComponent(arg0, arg1, arg2, arg3, arg4, arg5,
				arg6);
	
/*		
		if ( arg1.getClass().isInstance( m_dummy ) )
		{
			setText( "Design" );
		}
		else
		{
			setText( "Requirement" );
		}
		
*/				
//		setText( arg1.getClass().getName() );
				
/*				
		setText( arg1.toString() );
				
		return this;
*/		
	}

}
