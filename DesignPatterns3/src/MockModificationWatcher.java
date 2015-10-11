import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.Serializable;
import java.net.URLConnection;

public class MockModificationWatcher extends WebPageWatcher implements Serializable{

	private static final long serialVersionUID = 1L;

	public MockModificationWatcher(String webPageUrl) throws Exception {
		super(webPageUrl);
	}

	public URLConnection makeURLConnection() {	
		URLConnection MockUrlConnectionObject = mock(URLConnection.class);
		long currentTime = System.currentTimeMillis();
		//long lastModified = MockUrlConnectionObject.getLastModified();
	
		//System.out.println("in mock last modfiefied: "+lastModified );
		//when(MockUrlConnectionObject.getLastModified()).thenReturn(lastModified+100000);
		when(MockUrlConnectionObject.getLastModified()).thenReturn(currentTime, currentTime+100, currentTime+200);
		//when(MockUrlConnectionObject.getLastModified()).thenAnswer(returnCurrentTime());
		return MockUrlConnectionObject;
	}
	
	private long returnCurrentTime() {
		return System.currentTimeMillis();
	}

}
