package eu.stamp.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LuteceFormTest {

	private static final String LUTECE_SITE_FORMS_URL = "http://localhost:8081/site-forms-demo/";

	@Test
	public void checkServerIsRunning() throws IOException {
		try {
			URL url = new URL(LUTECE_SITE_FORMS_URL);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			int statusCode = http.getResponseCode();
			assertEquals(200, statusCode);
		} catch (IOException e) {
			fail();
		}

	}
}
