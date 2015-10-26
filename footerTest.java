import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * As a user
 * 
 * I want the site to have a footer section
 * 
 * so that I have easy access to important information and links
 *
 */
public class footerTest {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://cs.pitt.edu/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	// Given that I am on the main page
	// When I look at the footer
	// Then I see who owns the copyright to the site
	@Test
	public void testCopyright() throws Exception {
		// Verifying the information on the copyright owner is present
		WebElement e = driver.findElement(By.id("footer"));
		String elementText = e.getText();
		assertTrue(elementText.contains("2015 Department Of Computer Science"));
	}

	// Given that I am on the main page
	// When I look at the footer
	// Then I see the address to the CS Department
	@Test
	public void testAddress() throws Exception {
		// Testing if the address of the CS Department is in the footer
		String address = "Dept of Computer Science\n6135 Sennott Square\n210 S Bouquet St\nPittsburgh, PA 15260-9161\nUSA";
		WebElement e = driver.findElement(By.id("footer"));
		String elementText = e.getText();
		assertTrue(elementText.contains(address));
	}

	// Given that I am on the main page
	// When I look at the footer
	// Then I see the CS Department's phone and fax numbers
	@Test
	public void testPhone() throws Exception {
		// Checking if the footer has the phone and fax numbers for the CS
		// Department
		WebElement e = driver.findElement(By.id("footer"));
		String elementText = e.getText();
		assertTrue(elementText.contains("Tel: 412-624-8490"));
		assertTrue(elementText.contains("Fax: 412-624-8854"));
	}

	// Given that I am on the main page
	// When I look at the footer
	// Then I see the Latest Pitt News
	@Test
	public void testNews() throws Exception {
		// Checking to make sure the footer has news about Pitt
		WebElement e = driver.findElement(By.id("footer"));
		String elementText = e.getText();
		assertTrue(elementText.contains("Latest Pitt News"));
	}

	// Given that I am on the main page
	// When I look at the footer
	// Then I see links to important pages
	@Test
	public void testinks() throws Exception {
		// Checking to see if the footer has links to important pages in it
		WebElement e = driver.findElement(By.id("footer"));
		String elementText = e.getText();
		assertTrue(elementText.contains("Home"));
		assertTrue(elementText.contains("Research"));
		assertTrue(elementText.contains("Undergraduate"));
		assertTrue(elementText.contains("Graduate"));
		assertTrue(elementText.contains("Outreach"));
		assertTrue(elementText.contains("My Pitt"));
		assertTrue(elementText.contains("Login"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}