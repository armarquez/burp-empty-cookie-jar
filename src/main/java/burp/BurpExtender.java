package burp;

import com.praetorian.burp.EmptyCookieJarExtension;


public class BurpExtender implements IBurpExtender {
	static final String NAME = "Burp Empty Cookie Jar";

	private IBurpExtenderCallbacks callbacks;


	@Override
	public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks)
	{
		// keep a reference to our callbacks object
		this.callbacks = callbacks;

		callbacks.setExtensionName(NAME);

		this.callbacks.registerSessionHandlingAction(new EmptyCookieJarExtension(this.callbacks));
	}
}
