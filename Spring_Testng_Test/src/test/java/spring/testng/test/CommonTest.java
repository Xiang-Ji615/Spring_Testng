package test.java.spring.testng.test;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.spring.testng.config.TestConfig;


@SpringBootTest(classes= {TestConfig.class}, webEnvironment=WebEnvironment.DEFINED_PORT)
public class CommonTest extends AbstractTestNGSpringContextTests{

	@DataProvider
	public Object[][] ValidDataProvider() {
		return new Object[][]{
			{"A"},{"a"}
		};
	}

	
	
	@Parameters({"helloWorld"})
	@Test(dataProvider="ValidDataProvider")
	public void helloWorldTest(String helloWorld) {
		Assert.assertNotNull(helloWorld);
	}
}
