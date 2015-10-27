
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
*I want a simple way to return to the home page from any page related to the web site
*
*so that I can easily navigate back to the home page if I get lost 
*
*/
public class HomeTest 
{
	//static WebDriver driver = new FirefoxDriver();
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception 
	{
		//driver.get("http://cs.pitt.edu/");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	
	// Given that I am on the faculty page
	// When I click on the 'computer science' header text
	// Then I see the home page
	@Test
	public void facultyHomeTest() 
	{
		try 
		{
			driver.get("https://cs.pitt.edu/people/faculty/tenure_stream");
			driver.findElement(By.xpath("//div[@id='header']/span[@class='homeLink']/a")).click();
			String url = driver.getCurrentUrl();
			
			assertTrue(url.equals("https://cs.pitt.edu/"));
		}
		catch (NoSuchElementException nseex) 
		{
			fail("Element does not exist");
		}
	}
	
	// Given that I am on the Directory page
	// When I click on the 'computer science' header text
	// Then I see the home page
	@Test
	public void directoryHomeTest() 
	{
		try 
		{
			driver.get("https://cs.pitt.edu/people");
			driver.findElement(By.xpath("//div[@id='header']/span[@class='homeLink']/a")).click();
			String url = driver.getCurrentUrl();
			
			assertTrue(url.equals("https://cs.pitt.edu/"));
		}
		catch (NoSuchElementException nseex) 
		{
			fail("Element does not exist");
		}
	}
	
	// Given that I am on the Staff page
	// When I click on the 'computer science' header text
	// Then I see the home page
	@Test
	public void staffHomeTest() 
	{
		try 
		{
			driver.get("https://cs.pitt.edu/people/staff");
			driver.findElement(By.xpath("//div[@id='header']/span[@class='homeLink']/a")).click();
			String url = driver.getCurrentUrl();
			
			assertTrue(url.equals("https://cs.pitt.edu/"));
		}
		catch (NoSuchElementException nseex) 
		{
			fail("Element does not exist");
		}
	}
	
	// Given that I am on the Research page
	// When I click on the 'computer science' header text
	// Then I see the home page
	@Test
	public void researchHomeTest() 
	{
		try 
		{
			driver.get("https://cs.pitt.edu/research");
			driver.findElement(By.xpath("//div[@id='header']/span[@class='homeLink']/a")).click();
			String url = driver.getCurrentUrl();
			
			assertTrue(url.equals("https://cs.pitt.edu/"));
		}
		catch (NoSuchElementException nseex) 
		{
			fail("Element does not exist");
		}
	}
	
	// Given that I am on the News page
	// When I click on the 'Computer Science' header text
	// Then I see the home page
	@Test
	public void newsHomeTest() 
	{
		try 
		{
			driver.get("https://cs.pitt.edu/News");
			driver.findElement(By.xpath("//div[@id='header']/span[@class='homeLink']/a")).click();
			String url = driver.getCurrentUrl();
			
			assertTrue(url.equals("https://cs.pitt.edu/"));
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
