import java.util.Iterator;
import java.util.List;

public class WebPageUpdateNotifier {

	public void monitorWebPages() throws Exception {

		WebPageUpdateNotifierHelper helper = new WebPageUpdateNotifierHelper();
		List<WebPageWatcher> webPageWatchers = helper.createWebPageWatchers();

		while(true) {
			Iterator<WebPageWatcher> watcherIterator = webPageWatchers.iterator();
			while(watcherIterator.hasNext()) {
				watcherIterator.next().checkWebPageUpdated();
			}
			
			helper.saveState();
			Thread.sleep(1800000);
		}

	}
}
