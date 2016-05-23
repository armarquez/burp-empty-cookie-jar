package com.praetorian.burp;

import burp.*;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by amarquez on 5/23/16.
 */
public class EmptyCookieJarExtension implements ISessionHandlingAction {
    private static String ACTION_NAME = "Empty cookie jar action";

    private IBurpExtenderCallbacks callbacks;
    private IExtensionHelpers helpers;
    private PrintWriter stdout;
    private PrintWriter stderr;

    public EmptyCookieJarExtension(final IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        this.stderr = new PrintWriter(callbacks.getStderr(), true);
        this.helpers = callbacks.getHelpers();
    }

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

    @Override
    public void performAction(IHttpRequestResponse currentRequest, IHttpRequestResponse[] macroItems) {
        List<ICookie> cookies = this.callbacks.getCookieJarContents();
        if (!cookies.isEmpty()) {
            for (final ICookie cookie: cookies) {
                this.callbacks.updateCookieJar(new ICookie() {
                    @Override
                    public String getDomain() {
                        return cookie.getDomain();
                    }

                    @Override
                    public String getPath() {
                        return cookie.getPath();
                    }

                    @Override
                    public Date getExpiration() {
                        return cookie.getExpiration();
                    }

                    @Override
                    public String getName() {
                        return cookie.getName();
                    }

                    @Override
                    public String getValue() {
                        return null;
                    }
                });
            }
        }
    }
}


