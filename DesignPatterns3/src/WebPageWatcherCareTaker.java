import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class WebPageWatcherCareTaker {
	
	private String stateFilePath = "C:\\Project\\state.txt";
	private List<WebPageWatcher> webPageWatchers =  new ArrayList<WebPageWatcher>();
	private List<Object> listOfMementos = new ArrayList<Object>();
	
	
	public boolean addMemento(WebPageWatcher webPageWatcher) {
		webPageWatchers.add(webPageWatcher);
		Object memento = webPageWatcher.createMemento();
		listOfMementos.add(memento);
		return true;
	}
	
	public boolean saveState() throws Exception {
		Iterator<Object> mementoIterator = listOfMementos.iterator();
		ObjectOutputStream objectOutputStream = null;
		while(mementoIterator.hasNext()) {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(stateFilePath));
			objectOutputStream.writeObject((mementoIterator.next()));
			objectOutputStream.flush();
		}
		objectOutputStream.close();
		return true;
	}
	
	private List<Object> retrieveMementos() throws Exception {	
		List<Object> listOfRetrievedMementos = new ArrayList<Object>();
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(stateFilePath));
		System.out.println("hi1");
		
		Object memento;
		try {
		  while ((memento = objectInputStream.readObject()) != null) {
			  listOfRetrievedMementos.add(memento);
		  }
		}catch (EOFException e) {
				System.out.println("hi3");
				System.out.println("#watchers: " + webPageWatchers.size());
				System.out.println("#mementos: " + listOfMementos.size());
				return listOfRetrievedMementos;
		  }finally {
				objectInputStream.close();
			}

		  return listOfRetrievedMementos;
		  
		  
		  /*
		while(true) {
			try {
				Object memento = objectInputStream.readObject();
				listOfMementos.add(memento);
				System.out.println("hi2");
			} catch (EOFException e) {
				System.out.println("hi3");
				return listOfMementos;
			} finally {
				objectInputStream.close();
			}
		}*/

	}

	public boolean restoreState() throws Exception {
		List<Object> retrievedMementos = retrieveMementos();
		
		Iterator<Object> mementoIterator = retrievedMementos.iterator();
		Iterator<WebPageWatcher> watcherIterator = webPageWatchers.iterator();
		while(mementoIterator.hasNext()) {
			watcherIterator.next().restoreState(mementoIterator.next());
		}
		return true;
	}
	
	
	public boolean isRestoreNeeded() {
		File file = new File(stateFilePath);

		if(!file.exists()) {
			return false;
		}
		return true;
	}
	
	public boolean doSaveOrRestore() throws Exception {
		if(isRestoreNeeded()) {
			restoreState();
		}
		else {
			saveState();
		}
		return true;
	}
}
