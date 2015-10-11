import java.net.URLConnection;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class PrintNotifier implements Observer {
	
	private Date modifiedDate;
	private String webPageUrl;
	private boolean messagePrinted = false;
	

	@Override
	public void update(Observable webPageWatcher, Object connect) {
		long time = ((URLConnection) connect).getLastModified();
		modifiedDate = new Date(time);
		webPageUrl = ((WebPageWatcher)webPageWatcher).getWebPageUrl();	
		messagePrinted = printMessage();
	}
	
	private boolean printMessage() {
		System.out.println("Web page " + webPageUrl + " is modified at " + modifiedDate.toString());
		return true;
	}
	
	public boolean isMessagePrinted() {
		return messagePrinted;
	}

}
