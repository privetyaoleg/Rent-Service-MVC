package by.htp.test.by.htp.speq.logic;



import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.logic.read.console.ConsoleStationLogicImpl;


public class StationLogicTest {
	
	
	private StationLogic logic;
	
	@Before
	public void initSportLogic() {
		logic = new ConsoleStationLogicImpl();
	}

	@Test
	public void testReadCatalogNotNull() throws FileNotFoundException {
		
//		//fail("Not yet implemented");
//		int x = 2;
//		int y = 2;
//		int c = x + y;
//		assertEquals(c, 4);
		assertNotNull(logic.readCatalog());
		
	}

}
