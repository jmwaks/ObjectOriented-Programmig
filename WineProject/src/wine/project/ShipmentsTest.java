package wine.project;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShipmentsTest {
	Shipments ship =new Shipments();
	@Test
	public void testShipments() {
		assertEquals("Delivered",ship.getStatus());
		assertEquals(1,ship.getShipmentID());
	}

}
