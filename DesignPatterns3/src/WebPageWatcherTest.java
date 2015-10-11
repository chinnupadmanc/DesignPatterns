import static org.junit.Assert.*;

import java.io.File;
import java.net.URLConnection;

import org.junit.Test;


public class WebPageWatcherTest {

	@Test
	public void testObserversWithMock() throws Exception {
		MockModificationWatcher  modificationWatcher = new MockModificationWatcher("http://www.eli.sdsu.edu/index.html");
		
		System.out.println("first last Mofidfied: " + modificationWatcher.getLastModifiedAt());
		
		PrintNotifier printNotifier = new PrintNotifier();
		MailNotifier mailNotifier = new MailNotifier();
		
		modificationWatcher.addObserver(printNotifier);
		modificationWatcher.addObserver(mailNotifier);
		
		Boolean isUpdated = modificationWatcher.checkWebPageUpdated();
		assertTrue(isUpdated);
		
		assertTrue(printNotifier.isMessagePrinted());
		assertTrue(mailNotifier.isSentMail());
		
	}
	
	@Test
	public void testMemento() throws Exception {

		WebPageWatcherCareTaker careTaker = new WebPageWatcherCareTaker();
		
		String stateFilePath = "C:\\Project\\state.txt";
		File fileTemp = new File(stateFilePath);
		if (fileTemp.exists()){
			fileTemp.delete();
		} 
		
		assertFalse(careTaker.isRestoreNeeded());
		
		WebPageWatcher  webPageWatcher = new WebPageWatcher("http://www.eli.sdsu.edu/index.html");
		long stateBeforeRestore = webPageWatcher.getLastModifiedAt();
		
		assertTrue(careTaker.addMemento(webPageWatcher));
		
		assertTrue(careTaker.saveState());
		
		assertTrue(careTaker.isRestoreNeeded());
		
		assertTrue(careTaker.restoreState());
		
		long stateAfterRestore = webPageWatcher.getLastModifiedAt();
		
		assertEquals(stateBeforeRestore, stateAfterRestore);
		System.out.println(stateBeforeRestore);
		System.out.println(stateAfterRestore);
	
	}


	
}
