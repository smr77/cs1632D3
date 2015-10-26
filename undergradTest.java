import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * As a user
 * 
 * I want the site to have an Undergraduates page
 * 
 * so that I have easy access to all information pertaining to undergraduates
 * pursuing the CS degree
 *
 */
public class undergradTest {

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

	// Given that I start on the main page and I click on the Undergraduates
	// link
	// When I click on the Bachelors Degree (BS) link
	// Then I see all relevant information about the bachelors degree
	@Test
	public void testBachelors() throws Exception {
		// Going to the bachelors degree page and verifying the text there is
		// about the bachelors degree
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Undergraduate")).click();
		driver.findElement(By.linkText("Bachelors Degree (BS)")).click();
		WebElement e = driver.findElement(By.cssSelector("div.single_col"));
		String elementText = e.getText();
		assertTrue(elementText.contains("Bachelors Degree"));
		assertTrue(elementText.contains("About the Degree"));
	}

	// Given that I start on the main page and I click on the Undergraduates
	// link
	// When I look at the page
	// Then I see all relevant information and links about about employment
	// opportunities for undergraduates
	@Test
	public void testEmployment() throws Exception {
		// Checking to make sure the undergraduates page has information on
		// employment
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Undergraduate")).click();
		WebElement e = driver.findElement(By.id("main"));
		String elementText = e.getText();
		assertTrue(elementText.contains("Employment"));
		assertTrue(elementText.contains("Departmental Jobs/Financial Assistance"));
		assertTrue(elementText.contains("CS Opportunities"));
		assertTrue(elementText.contains("Pitt Career Services"));
		assertTrue(elementText.contains("Internships"));
		assertTrue(elementText.contains("Co-Op Program"));
	}

	// Given that I start on the main page and I click on the Undergraduates
	// link
	// When I look at the page
	// Then I see all relevant information and links about resources for
	// undergraduates
	@Test
	public void testResources() throws Exception {
		// Checking to make sure resources available to undergraduates are
		// listed
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Undergraduate")).click();
		WebElement e = driver.findElement(By.id("main"));
		String elementText = e.getText();
		assertTrue(elementText.contains("Resources"));
		assertTrue(elementText.contains("Advising"));
		assertTrue(elementText.contains("CS Resource Center Peer Tutoring"));
		assertTrue(elementText.contains("Join CS Undergrad Email Group"));
	}

	// Given that I start on the main page and I click on the Undergraduates
	// link
	// When I click on the advising link
	// Then I see all relevant information about advising for undergraduates
	@Test
	public void testAdvising() throws Exception {
		// Checking to make sure the Advising page has relevant advising
		// information
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Undergraduate")).click();
		driver.findElement(By.linkText("Advising")).click();
		WebElement e = driver.findElement(By.cssSelector("#main > div.col1"));
		String elementText = e.getText();
		assertTrue(elementText.contains("General Advising Information"));
		assertTrue(elementText.contains("Advising Documents"));
		assertTrue(elementText.contains("Resources"));
		assertTrue(elementText.contains("Important Dates"));
		assertTrue(elementText.contains("Contact Us"));
		assertTrue(elementText.contains("John Ramirez, Undergraduate Program Director"));
		assertTrue(elementText.contains("Angela Ellis, Undergraduate Program Administrator"));
	}

	// Given that I start on the main page and I click on the Undergraduates
	// link
	// When I click on the internships link
	// Then I see all relevant information about internships for undergraduates
	@Test
	public void testInternships() throws Exception {
		// Checking to make sure information about internships is available on
		// the Internships page
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Undergraduate")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Internships')])[2]")).click();
		WebElement e = driver.findElement(By.id("main"));
		String elementText = e.getText();
		assertTrue(elementText.contains("Internships"));
		assertTrue(elementText.contains("Requirements for CS 1900"));
		assertTrue(elementText.contains("Registration Steps for CS 1900"));
		assertTrue(elementText.contains("Requirements for CS 1902"));
		assertTrue(elementText.contains("Registration Steps for CS 1902"));
		assertTrue(elementText.contains("Summer/Fall Option"));
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