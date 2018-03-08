package com.dajiang.app.common.context;

import java.util.*;

public class Session {
    private List<ISessionListener> listeners = new ArrayList<ISessionListener>();

    private String id;
    private long creationTime = System.currentTimeMillis();
    private long lastAccessedTime = System.currentTimeMillis();

    private Map<String, Object> map = new HashMap<String, Object>();

    public Session(String id) {
        this.id = id;
    }

    public <T> T getAttribute(String key) {
        return (T) map.get(key);
    }

    public <T> T getAttribute(String key, T defaultValue) {
        T value = (T) map.get(key);
        if (value == null) {
            return defaultValue;
        } else {
            return value;
        }
    }

    public <T> void setAttribute(String key, T value) {
        String attributeName = key;
        T oldAttribute = (T) map.get(key);
        T newAttribute = value;
        map.put(key, value);

        for (ISessionListener listener : listeners) {
            listener.afterSetAttribute(attributeName, oldAttribute, newAttribute);
        }
    }

    public List<String> getAttributeNames() {
        Set<String> keySet = map.keySet();
        List<String> names = new ArrayList<String>();
        names.addAll(keySet);
        return names;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(long lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }

    public String getId() {
        return id;
    }

    public void addListener(ISessionListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ISessionListener listener) {
        listeners.remove(listener);
    }

    public ISessionListener[] getListeners() {
        return listeners.toArray(new ISessionListener[]{});
    }

    public void clearListener() {
        listeners.clear();
    }
}
