package aion.tools.data;

public class DataTester {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new DataTester();
	}
	
	
	public DataTester()
	{
/*
		Design d = (Design) ItemFactory.instance().getByName( "Worthy Strong Jerkin" );
		Design d2 = (Design) ItemFactory.instance().getByName( "Worthy Strong Leather Gloves" );
		
		System.out.println( d + " requires:\n" + d.getRequiredSummary() );
		System.out.println( d2 + " requires:\n" + d.getRequiredSummary() );
*/		
		Design workOrder = new Design( "WorkOrder 1 for Geer lvl 33" );
		workOrder.addRequired( 1, ItemFactory.instance().getByName( "Worthy Strong Jerkin" ) );
		workOrder.addRequired( 1, ItemFactory.instance().getByName( "Worthy Strong Leather Pauldrons" ) );
		workOrder.addRequired( 1, ItemFactory.instance().getByName( "Worthy Strong Leather Gloves" ) );
		
		System.out.println( workOrder + " requires:\n" + workOrder.getRequiredSummary() + workOrder.getCost() );		
	}
}
