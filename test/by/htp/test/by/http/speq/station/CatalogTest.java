package by.htp.test.by.http.speq.station;

import org.junit.Before;

import by.htp.speq.station.Catalog;

public class CatalogTest {
	
	private Catalog catalog;
	
	
	@Before
	public void initCatalog() {
		catalog = new Catalog();
	}
	
//	@Test
//	public void testCatalogRentUnitNotNull() {
//		
//		RentUnit[] units = catalog.getUnits();
//		assertNotNull("RentUnit storage was not initialized properly", units);
//		
//	}
//	
//	@Test
//	public void testAddedRentUnitPresent() {
//		Equipment eq = new Equipment("Equipment 1");
//		
//		RentUnit unit = new RentUnit();
//		unit.setEquimpent(eq);
//		unit.setHourRate(2.5);
//		
//		catalog.addRentUnit(unit);
//		
//		RentUnit[] units = catalog.getUnits();
//		RentUnit lastItem = catalog.getLastRentUnit();
//		
//		assertEquals("RentUnit wasn't added" , unit, lastItem);
//	}
	

}
