package env


import geb.Browser
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogType

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before
import geb.binding.BindingUpdater

def theBrowser
def bindingUpdater

Before { scenario ->
	println("++++++++++++++++ Starting scenario: ${scenario.name}")
	if(!binding.hasVariable('browser')) {
		theBrowser = new Browser()
		bindingUpdater = new BindingUpdater(binding, theBrowser)
		bindingUpdater.initialize()
	} else {
		// save for later screenshot taking
		theBrowser = browser
	}
}

After { scenario ->
	//embed screenshot into Cucumber report
	
	if(scenario.failed) {
		println("---------------+ Failed scenario: ${scenario.name}")
		try {
			scenario.embed(theBrowser.driver.getScreenshotAs(OutputType.BYTES), "image/png")
			LogEntries logEntries = theBrowser.driver.manage().logs().get(LogType.BROWSER)
			for (entry in logEntries){
				println("${scenario.getName()}: ${entry}")
			}
		} catch(WebDriverException e) {
			//sometimes firefox runs out of memory trying to take a screenshot
		} catch(MissingMethodException e) {
			//HTMLUnit doesn't support screenshots
		} catch(NullPointerException err) {
			println(err.message)
		}
	}

	bindingUpdater?.remove()
}
