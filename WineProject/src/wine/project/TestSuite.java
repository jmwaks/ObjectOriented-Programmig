package wine.project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AddressTest.class, AddSubscriberTest.class,  MonthlySelectionUseCaseTest.class,
	ReceiptTest.class,ShipmentsTest.class,WineTest.class })
public class TestSuite {

}
