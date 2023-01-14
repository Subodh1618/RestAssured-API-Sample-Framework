package runner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sample.cucumber.MasterClass;
import com.sample.cucumber.reportInitializer.FrameworkReportInitializer;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		
features = { 			 
				 "src/main/java/sample/cucumber/feature/SampleTest.feature",
				 
				 
			}

 ,plugin = {"html:target/site/cucumber-pretty","json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml",
		 	"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extentReport.html"}

 ,tags = {"@Run"}

 ,glue = {  "com.daimler.daivb.mdc.cucumber.hooks",
			"com.daimler.daivb.mdc.cucumber.stepdefinition"
			
		}
)

public class RunCukesTest extends AbstractTestNGCucumberTests{
	static MasterClass refMasterClass;
	@BeforeSuite
	public void TestNGBeforeSuite() throws Exception {
		refMasterClass = new MasterClass();
		refMasterClass.SuiteAssembly();
	}
	
	@Test(enabled = false)
	public void sample(){
		System.out.println("@Test");
	}
	
	@AfterSuite
	public void TestNGAfterSuite() throws IOException {
		FrameworkReportInitializer.flush();
	}

}

