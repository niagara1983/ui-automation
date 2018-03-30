//import configuration.TestDataGenerator
import org.openqa.selenium.Platform
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.safari.SafariDriver

import java.awt.Toolkit;
import java.util.logging.Level

reportsDir = "geb-reports"

waiting {
	timeout = 60
	retryInterval = 1
	includeCauseInMessage = true
}

atCheckWaiting = true
baseNavigatorWaiting = true
//TestDataGenerator data = new TestDataGenerator()


// default is to use firefox
driver = { new FirefoxDriver() }

System.setProperty("geb.BS_URL", "http://pssword2:4bUJZgFGvBTeQNzFtzUG@hub.browserstack.com/wd/hub")


environments {
	chrome {
		driver = {
			DesiredCapabilities caps = DesiredCapabilities.chrome()
			LoggingPreferences logPrefs = new LoggingPreferences()
			logPrefs.enable(LogType.BROWSER, Level.ALL)
			caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs)
			def driver = new ChromeDriver(caps)
			driver.manage().window().maximize()
			return driver
		}
	}
	
	firefox {
		driver = {
			DesiredCapabilities caps = DesiredCapabilities.firefox()
			caps.setCapability("marionette", true);
			def driver = new FirefoxDriver(caps)
			driver.manage().window().maximize()
			return driver
		}
	}
	
	safari {
		driver = {
			DesiredCapabilities caps = DesiredCapabilities.safari()
			def driver = new SafariDriver()
			driver.manage().window().maximize()
			return driver
		}
	}
	
	ie11 {
		driver = {
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer()
			caps.setCapability("requireWindowFocus", true);
			def driver = new InternetExplorerDriver(caps)
//			driver.manage().window().maximize()
			return driver
		}
	}
	
	bs_ff {
		DesiredCapabilities caps = new DesiredCapabilities()
		caps.setCapability("name", "Reporting Suite");
		caps.setCapability("project", "Reporting Framework");
		caps.setCapability("browser", "Firefox");
		caps.setCapability("browser_version", "47.0");
		caps.setCapability("os", "OS X");
		caps.setCapability("os_version", "El Capitan");
		caps.setCapability("resolution", "1280x1024");
		caps.setCapability("acceptSslCerts", "true");
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.debug", "true");
		
		driver = {
			def driver = new RemoteWebDriver(new URL(System.getProperty("geb.BS_URL")), caps)
			driver.manage().window().maximize()
			return driver
		}
	}
	
	bs_chrome {
		DesiredCapabilities caps = new DesiredCapabilities()
		caps.setCapability("name", "Reporting Suite")
		caps.setCapability("project", "Reporting Framework")
		caps.setCapability("browser", "Chrome")
		caps.setCapability("browser_version", "51")
		caps.setCapability("os", "Windows")
		caps.setCapability("os_version", "7")
		caps.setCapability("resolution", "1280x1024")
		caps.setCapability("acceptSslCerts", "true")
		caps.setCapability("browserstack.local", "true")
		driver = {
			def driver = new RemoteWebDriver(new URL(System.getProperty("geb.BS_URL")), caps)
			driver.manage().window().maximize()
			return driver
		}
	}
	
	bs_ie09 {
		DesiredCapabilities caps = new DesiredCapabilities()
		caps.setCapability("name", "Reporting Suite");
		caps.setCapability("project", "Reporting Framework");
		caps.setCapability("browser", "IE");
		caps.setCapability("browser_version", "9.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "7");
		caps.setCapability("resolution", "1280x1024");
		caps.setCapability("acceptSslCerts", "true");
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.debug", "true");
		driver = {
			def driver = new RemoteWebDriver(new URL(System.getProperty("geb.BS_URL")), caps)
			driver.manage().window().maximize()
			return driver
		}
	}
	
	bs_ie10 {
		DesiredCapabilities caps = new DesiredCapabilities()
		caps.setCapability("name", "Reporting Suite");
		caps.setCapability("project", "Reporting Framework");
		caps.setCapability("browser", "IE");
		caps.setCapability("browser_version", "10.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "7");
		caps.setCapability("resolution", "1280x1024");
		caps.setCapability("acceptSslCerts", "true");
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.debug", "true");
		driver = {
			def driver = new RemoteWebDriver(new URL(System.getProperty("geb.BS_URL")), caps)
			driver.manage().window().maximize()
			return driver
		}
	}
	
	bs_ie11 {
		DesiredCapabilities caps = new DesiredCapabilities()
		caps.setCapability("name", "Reporting Suite");
		caps.setCapability("project", "Reporting Framework");
		caps.setCapability("browser", "IE");
		caps.setCapability("browser_version", "11.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "7");
		caps.setCapability("resolution", "1280x1024");
		caps.setCapability("acceptSslCerts", "true");
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.debug", "true");
		driver = {
			def driver = new RemoteWebDriver(new URL(System.getProperty("geb.BS_URL")), caps)
			driver.manage().window().maximize()
			return driver
		}
	}
	
	remote-ie {
		DesiredCapabilities caps = new DesiredCapabilities()
		caps.setBrowserName("internet explorer")
		caps.setJavascriptEnabled(true)
		caps.setPlatform(Platform.WINDOWS)
		caps.setVersion("11");
		
		driver = {
			def driver = new RemoteWebDriver(new URL("http://is20-grid-047:4444/wd/hub"), caps)
			driver.manage().window().maximize()
			return driver
		}
	}
}

//data.generateData()