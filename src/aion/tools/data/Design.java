package aion.tools.data;

import java.util.Vector;

public class Design extends Item
{
	public Item craftingResult;
	
	
	
	public Design(String name) {
		super(name);
	}

	public Design(String name, int rarity) {
		super(name, 0, rarity);
	}

	public Design(String name, int rarity, boolean needsToProc) {
		super(name, 0, rarity);
		this.needsToProc = true;
	}

	public void addRequired( int amount, Item item )
	{
		requiredMaterials.add( new MaterialRequirement( amount, item ) );
	}
	
	
	public Vector<MaterialRequirement> getRequirements()
	{
		return requiredMaterials;
	}
	
	
	public Vector<MaterialRequirement> getRequiredFlattened()
	{
		Vector<MaterialRequirement> ret = new Vector<MaterialRequirement>();
		
		for ( int m = 0; m < requiredMaterials.size(); m++ )
		{
			Item i = requiredMaterials.elementAt(m).material;
			
			if ( i.hasRequirements() )
			{
				Vector<MaterialRequirement> req2 = i.getRequiredFlattened();
/*				
				for ( int n = 0; n < req2.size(); n++ )
				{
					for ( int a = 0; a < req2.elementAt(n).amount; a++ )
					{
						ret.add( req2.elementAt(n) );
					}
				}
*/				
				for ( int a = 0; a < requiredMaterials.elementAt(m).amount; a++ )
				{
					ret.addAll( req2 );
				}
			}
			else
			{
				ret.add( requiredMaterials.elementAt(m) );
			}
		}
		
		return ret;
	}
	
	
	public Vector<MaterialRequirement> getRequiredSummary()
	{
		Vector<MaterialRequirement> flat = getRequiredFlattened();
		Vector<MaterialRequirement> set = new Vector<MaterialRequirement>();  
		
		MaterialRequirement req = null;
		
		for ( int i = 0; i < flat.size(); i++ )
		{
			req = flat.elementAt( i );
			
			if ( !set.contains(req) )
			{
				MaterialRequirement newReq = new MaterialRequirement( req.amount, req.material );
				set.add( newReq );
			}
			else
			{
				MaterialRequirement newReq = set.elementAt( set.indexOf( req ) );
				
				newReq.amount += req.amount;
			}			
		}
		
		return set;
		
	}
	

	public int getCost()
	{
		int ret = 0;
		
		if ( price == 0 )
		{
			// calculate cost from required materials
			Vector<MaterialRequirement> flat = getRequiredSummary();
			
			for ( int i = 0; i < flat.size(); i++ )
			{
				ret += flat.elementAt(i).getCost();
			}
		}
		else
		{
			// just return set price instead
			ret = price;
		}
		
		return ret;
	}
	
/*	
	public String toString()
	{
		return super.toString() + ", total cost: " + getCost();
	}
*/	

}
