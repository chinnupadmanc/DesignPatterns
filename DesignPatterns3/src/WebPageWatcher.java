import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.Observable;

public class WebPageWatcher extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;
	private String webPageUrl;
	transient URLConnection connect;
	private long lastModifiedAt;
	private WebPageWatcherMemento currentState = null;
	//private ArrayList<Observer> observerList = new ArrayList<Observer>();

	public WebPageWatcher(String webPageUrl) throws Exception {
		this.webPageUrl = webPageUrl;
		connect = makeURLConnection();
		//lastModified = -1;
		lastModifiedAt = connect.getLastModified();
		//observerList = new ArrayList<Observer>();
	}

	public URLConnection makeURLConnection() throws Exception {
		URL address = new URL(webPageUrl);
		return address.openConnection();
	}

	public boolean checkWebPageUpdated() throws Exception {
		//setLastModified(System.currentTimeMillis());
		long prevLastModified = getLastModifiedAt();
		long newLastModified = connect.getLastModified();
		
		System.out.println("prev:" + prevLastModified);
		System.out.println("new:" + newLastModified);
		
		/*if(prevLastModified == -1) {
			setLastModified(newLastModified);
			return false;
		}*/
		
		if(newLastModified <= prevLastModified) {
			return false;
		}

		setLastModifiedAt(newLastModified);
		
		if(currentState != null) {
			currentState.setState(newLastModified);
		}
		
		setChanged();
		notifyObservers(connect);
		return true;
	}
	
	public String getWebPageUrl() {
		return webPageUrl;
	}

	public void setWebPageUrl(String webPageUrl) {
		this.webPageUrl = webPageUrl;
	}

	public URLConnection getConnect() {
		return connect;
	}

	public void setConnect(URLConnection connect) {
		this.connect = connect;
	}

	public long getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(long lastModified) {
		this.lastModifiedAt = lastModified;
	}

	private class WebPageWatcherMemento implements Serializable {
		/*private String webPageUrl;
		private URLConnection connect;
		private long lastVisited;

		public WebPageWatcherMemento(String webPageUrlToSave, URLConnection connectToSave, long lastVisitedToSave) {
			webPageUrl = webPageUrlToSave;
			connect = connectToSave;
			lastVisited = lastVisitedToSave;
		}*/

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		//private Hashtable<String, Object> savedState = new Hashtable<String, Object>();
		private long lastModifiedValue;
		public void setState(long lastModifiedValue) {
			this.lastModifiedValue = lastModifiedValue;
		}
		
		public long getState() {
			return lastModifiedValue;
		} 
	}

	public WebPageWatcherMemento createMemento() {
		//WebPageWatcherMemento currentState = new WebPageWatcherMemento(webPageUrl, connect, lastVisited);
		currentState = new WebPageWatcherMemento();
		currentState.setState(getLastModifiedAt());
		//currentState.setState("URL", webPageUrl);
		//currentState.setState("LastVisited", lastVisited);
		//currentState.setState("Observers", ((Observable) WebPageWatcher.this).);
		return currentState;
	}

	/*private void createFileName() {
		fileName = webPageUrl.replace("://", "");
		fileName = webPageUrl.replace("/", "");
		fileName = webPageUrl.replace(".", "");
		fileName = fileName + ".ser";
	}*/

	/*public boolean saveState() throws Exception {
		WebPageWatcherMemento currentState = createMemento();
		createFileName();
		FileOutputStream fileOutStream = new FileOutputStream(fileName);
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOutStream);
		outputStream.writeObject(currentState);
		outputStream.close();
		return true;

	}*/

	public void restoreState(Object oldState) {
		long oldLastModified = ((WebPageWatcherMemento)oldState).getState();
		setLastModifiedAt(oldLastModified);
	}

}
