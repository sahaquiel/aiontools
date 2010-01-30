package aion.tools.data;

import java.util.Vector;


public class Item implements ItemGetter
{
	public static final int COMMON = 0;
	public static final int UNCOMMON = 1;
	public static final int HEROIC = 2;
	
	
	protected String name;
	protected int price;
	protected int rarity;
	protected Vector<MaterialRequirement> requiredMaterials;
	protected boolean needsToProc;
	
	public Item( String name )
	{
		this.name = name;
		
		requiredMaterials = new Vector<MaterialRequirement>();
	}
	
	public Item( String name, int price )
	{
		this.name = name;
		this.price = price;
		
		requiredMaterials = new Vector<MaterialRequirement>();
	}
	
	public Item( String name, int price, int rarity )
	{
		this.name = name;
		this.price = price;
		this.rarity = rarity;
		
		requiredMaterials = new Vector<MaterialRequirement>();
	}
	
//	FEFE: we omit this constructor for now since we only
//	want Designs to have the attribute (needs to proc) when
//	crafting. Base Items are usually harvested/dropped and
//	not crafted.
/*	
	public Item( String name, int price, int rarity, boolean needsToProc )
	{
		this.name = name;
		this.price = price;
		this.rarity = rarity;
		this.needsToProc = needsToProc;
		
		requiredMaterials = new Vector<MaterialRequirement>();
	}
*/	
	public int getRarity()
	{
		return rarity;
	}
	
	public String toString()
	{
		return name;
	}
	
	public boolean hasRequirements()
	{
		return ( requiredMaterials.size() > 0 );
	}
	
	public boolean needsToProc()
	{
		return needsToProc;
	}
	
	public Vector<MaterialRequirement> getRequirements()
	{
		return requiredMaterials;
	}
	
	public Vector<MaterialRequirement> getRequiredFlattened()
	{
		return null;
	}

	@Override
	public Item getItem()
	{
		return this;
	}
}
