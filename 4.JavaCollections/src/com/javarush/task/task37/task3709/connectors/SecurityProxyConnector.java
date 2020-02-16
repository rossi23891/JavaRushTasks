package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;

public class SecurityProxyConnector implements Connector {
    private SecurityChecker securityChecker;
    private SimpleConnector simpleConnector;

    public SecurityProxyConnector(String resourceString) {
        simpleConnector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if(securityChecker.performSecurityCheck()){
            simpleConnector.connect();
        }
    }
}
