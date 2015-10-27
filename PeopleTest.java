
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
*As a computer science undergraduate student user 
*
*I want a people menu on the home page
*
*so that I can find information about the faculty. staff and other department related officials 
*
*/
public class PeopleTest 
{	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception 
	{
		driver = new FirefoxDriver();
		driver.get("https://cs.pitt.edu/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	// Given that I am on the main page
	// When I look at the header
	// Then I see a drop down menu titled People
	@Test
	public void peopleMenuTest() 
	{
		try 
		{
			WebElement e = driver.findElement(By.xpath("//div[@id='cardFront']/ul/li[3]/span[@class='title']"));	
			String eText = e.getText();
			assertTrue(eText.contains("PEOPLE"));	//People was stored in all caps			
		} 
		catch (NoSuchElementException nseex) 
		{
			fail("Element does not exist");
		}
	}
	
	// Given that I am on the main page
	// When I look at the people drop down menu
	// Then I see an option for faculty that brings me to the faculty page 
	@Test
	public void peopleFacultyTest() 
	{
		try 
		{
			driver.findElement(By.xpath("//div[@id='cardFront']/ul/li[3]/span[@class='title']")).click();	
			driver.findElement(By.linkText("Faculty")).click();
			String url = driver.getCurrentUrl();
		
			assertTrue(url.equals("https://cs.pitt.edu/people/faculty/tenure_stream"));		
		} 
		catch (NoSuchElementException nseex) 
		{
			fail("Element does not exist");
		}
	}
	
	// Given that I am on the main page
	// When I look at the people drop down menu
	// Then I see an option for staff that brings me to the staff page 
	@Test
	public void peopleStaffTest() 
	{
		try 
		{
			driver.findElement(By.xpath("//div[@id='cardFront']/ul/li[3]/span[@class='title']")).click();	
			driver.findElement(By.linkText("Staff")).click();
			String url = driver.getCurrentUrl();
		
			assertTrue(url.equals("https://cs.pitt.edu/people/staff"));		
		} 
		catch (NoSuchElementException nseex) 
		{
			fail("Element does not exist");
		}
	}
	
	// Given that I am on the main page
	// When I look at the people drop down menu
	// Then I see an option for visiting scholars that brings me to the visiting scholars page 
	@Test
	public void peopleVisitingScholarsTest() 
	{
		try 
		{
			driver.findElement(By.xpath("//div[@id='cardFront']/ul/li[3]/span[@class='title']")).click();	
			driver.findElement(By.linkText("Visiting Scholars")).click();
			String url = driver.getCurrentUrl();
		
			assertTrue(url.equals("https://cs.pitt.edu/people/visiting_scholar"));		
		} 
		catch (NoSuchElementException nseex) 
		{
			fail("Element does not exist");
		}
	}
	
	// Given that I am on the main page
	// When I look at the people drop down menu
	// Then I see an option for visiting scholars that brings me to the visiting scholars page 
	@Test
	public void peopleDirectoryTest() 
	{
		try 
		{
			driver.findElement(By.xpath("//div[@id='cardFront']/ul/li[3]/span[@class='title']")).click();	
			driver.findElement(By.linkText("Directory")).click();
			WebElement e = driver.findElement(By.xpath("//div[@id='main']/h1"));
			String eText = e.getText();
		
			assertTrue(eText.equals("Welcome to the CS Department Directory"));		
		} 
		catch (NoSuchElementException nseex) 
		{
			fail("Element does not exist");
		}
	}
	
	@After
	public void tearDown() throws Exception 
	{
		driver.quit();
	}
	
}
