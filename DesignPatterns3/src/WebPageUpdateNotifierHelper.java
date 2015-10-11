import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WebPageUpdateNotifierHelper {

	private List<WebPageWatcher> webPageWatchers = new ArrayList<WebPageWatcher>();
	private String webpagesListFilePath = "C:\\Project\\ListOfWebpages.txt";
	private WebPageWatcherCareTaker careTaker = new WebPageWatcherCareTaker();

	public WebPageWatcherCareTaker getCareTaker() {
		return careTaker;
	}

	public List<WebPageWatcher> createWebPageWatchers() throws Exception {
		
		//List<Object> webPageWatchersMementos = new ArrayList<Object>();
		File file = new File(webpagesListFilePath);
		
		BufferedReader bufferedReader  = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
			String[] values = line.split(" ");
			
			WebPageWatcher webPageWatcher = new WebPageWatcher(values[0]);
			webPageWatchers.add(webPageWatcher);
			
			for(int i=0; i<values.length-1; i++) {
				if(values[i].equals("mail")) {
					webPageWatcher.addObserver(new PrintNotifier());				
				}
				else if(values[i].equals("transcript")) {
					webPageWatcher.addObserver(new PrintNotifier());
				}
			}
			
			//webPageWatchersMementos.add(webPageWatcher.createMemento());
			careTaker.addMemento(webPageWatcher);
		}

		bufferedReader.close();
		//saveState(webPageWatchersMementos);
		
		careTaker.doSaveOrRestore();
			
		return webPageWatchers;
	}

	public void saveState() throws Exception {
		careTaker.saveState();
	}
}
