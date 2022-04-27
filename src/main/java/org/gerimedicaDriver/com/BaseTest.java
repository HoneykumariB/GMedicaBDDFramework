package org.gerimedicaDriver.com;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTest {


	public void openBrowser() throws Exception  {
		Driver.initDriver();

	}

 
	public void quitBrowser() throws Exception {   
		Driver.quitDriver();
	}
	
}
  



