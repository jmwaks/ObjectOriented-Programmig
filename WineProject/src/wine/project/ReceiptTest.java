package wine.project;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReceiptTest {
	
	@Test
	public void testReceipt() {
		Receipt re = new Receipt();
		assertEquals("Anne Costa",re.getReceiver());
		assertEquals(906, re.getReceiptID());
	}

}
