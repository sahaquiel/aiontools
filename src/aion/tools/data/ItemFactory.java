package aion.tools.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class ItemFactory
{
	private HashMap<String, Item> m_map;
	private static ItemFactory m_instance;
	
	
	private ItemFactory()
	{
		m_map = new HashMap<String, Item>();
		
		createDatabase();
	}
	
	
	public static ItemFactory instance()
	{
		if ( m_instance == null )
		{
			m_instance = new ItemFactory();
		}
		
		return m_instance;
	}
	
	
	public Vector<Item> getItems()
	{
		return new Vector<Item>( m_map.values() );
	}
	
	
	public Vector<Design> getDesignsOnly()
	{
		Vector<Design> ret = new Vector<Design>();
		
//		Collection c = m_map.values();
		Item it = null;
		
		for ( Iterator<Item> i = m_map.values().iterator(); i.hasNext(); )
		{
			it = i.next();
			
			if ( it.hasRequirements() == true )
			{
				ret.add( (Design) it );
			}
		}
		
		return ret;
	}	
	

	public int getSize()
	{
		return m_map.size();
	}
	
	
	private void createDatabase()
	{
		addBaseMaterials();
		addMaterials();
		addDesigns();
	}
	
	
	private void addBaseMaterials()
	{
		Item m;
		
		m = new Item( "High-Grade Adamantium Ore", 3500 );
		m_map.put( m.name, m );
		
		m = new Item( "High-Grade Platinum Ore", 0 );
		m_map.put( m.name, m );
		
		m = new Item( "Worthy Major Armor Flux", 3500 );
		m_map.put( m.name, m );

		m = new Item( "Worthy Fine Armor Flux", 0 );
		m_map.put( m.name, m );

		m = new Item( "Greater Aether Gem", 1500 );
		m_map.put( m.name, m );
		
		m = new Item( "Greater Leather Hardener", 200 );
		m_map.put( m.name, m );
		
		m = new Item( "Strong Rawhide", 450 );
		m_map.put( m.name, m );
		
		m = new Item( "Xilix Fiber", 0 );
		m_map.put( m.name, m );
		
		m = new Item( "Fine Dye", 450 );
		m_map.put( m.name, m );
		
	}
	
	
	private void addMaterials()
	{
		Design m;
		
		m = new Design( "Strong Leather" );
		m.addRequired( 1, getByName( "Strong Rawhide" ) );
		m_map.put( m.name, m );
		
		m = new Design( "Strong Leather Cord" );
		m.addRequired( 1, getByName( "Strong Leather" ) );
		m.addRequired( 1, getByName( "Greater Leather Hardener" ) );
		m_map.put( m.name, m );
		
		m = new Design( "Strong Luxury Leather Pad" );
		m.addRequired( 2, getByName( "Strong Leather" ) );
		m.addRequired( 2, getByName( "Greater Leather Hardener" ) );
		m_map.put( m.name, m );

		m = new Design( "Xilix Thread" );
		m.addRequired( 2, getByName( "Xilix Fiber" ) );
		m.addRequired( 1, getByName( "Fine Dye" ) );
		m_map.put( m.name, m );

		m = new Design( "Xilix Tailoring Thread" );
		m.addRequired( 1, getByName( "Xilix Thread" ) );
		m_map.put( m.name, m );

		m = new Design( "Xilix Textile" );
		m.addRequired( 2, getByName( "Xilix Thread" ) );
		m_map.put( m.name, m );

		m = new Design( "Fine Xilix Textile" );
		m.addRequired( 2, getByName( "Xilix Thread" ) );
		m_map.put( m.name, m );

	}

	
	private void addDesigns()
	{
		Design d;
		
		d = new Design( "Worthy Strong Jerkin" );
		d.addRequired( 5, getByName( "Strong Luxury Leather Pad" ) );
		d.addRequired( 16, getByName( "Strong Leather Cord" ) );
		d.addRequired( 4, getByName( "Worthy Major Armor Flux" ) );
		d.addRequired( 4, getByName( "Greater Aether Gem" ) );
		d.addRequired( 5, getByName( "High-Grade Adamantium Ore" ) );		
		m_map.put( d.name, d );
		
		d = new Design( "Worthy Strong Leather Gloves" );		
		d.addRequired( 3, getByName( "Strong Luxury Leather Pad" ) );
		d.addRequired( 8, getByName( "Strong Leather Cord" ) );
		d.addRequired( 2, getByName( "Worthy Major Armor Flux" ) );
		d.addRequired( 2, getByName( "Greater Aether Gem" ) );
		d.addRequired( 3, getByName( "High-Grade Adamantium Ore" ) );		
		m_map.put( d.name, d );

		d = new Design( "Worthy Strong Leather Pauldrons" );		
		d.addRequired( 3, getByName( "Strong Luxury Leather Pad" ) );
		d.addRequired( 8, getByName( "Strong Leather Cord" ) );
		d.addRequired( 2, getByName( "Worthy Major Armor Flux" ) );
		d.addRequired( 2, getByName( "Greater Aether Gem" ) );
		d.addRequired( 3, getByName( "High-Grade Adamantium Ore" ) );		
		m_map.put( d.name, d );

		d = new Design( "Worthy Durable Xilix Leggings" );		
		d.addRequired( 7, getByName( "Fine Xilix Textile" ) );
		d.addRequired( 26, getByName( "Xilix Tailoring Thread" ) );
		d.addRequired( 3, getByName( "Worthy Fine Armor Flux" ) );
		d.addRequired( 5, getByName( "Greater Aether Gem" ) );
		d.addRequired( 6, getByName( "High-Grade Platinum Ore" ) );		
		m_map.put( d.name, d );

	}

	
	public Item getByName( String name )
	{
		return m_map.get( name );
	}
}
