package support;

import java.io.IOException;


import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends Master {
	@Before
	public void beforeRun() throws IOException {
		driver = getWebDriver();

	}
	@After
	public void AfterRun() {
		new Master().closeBrowser();
	}

}
