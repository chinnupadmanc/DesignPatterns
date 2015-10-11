import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URLConnection;

public class MockNoModificationWatcher extends WebPageWatcher{
	
	public MockNoModificationWatcher(String webPageUrl) throws Exception {
		super(webPageUrl);
	}

	public URLConnection makeURLConnection() {	
		URLConnection MockUrlConnectionObject = mock(URLConnection.class);
		when(MockUrlConnectionObject.getLastModified()).thenReturn(Long.MIN_VALUE);
		return MockUrlConnectionObject;
	}

}
