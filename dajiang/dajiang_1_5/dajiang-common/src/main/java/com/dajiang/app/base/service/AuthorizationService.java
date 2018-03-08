package com.dajiang.app.base.service;

public interface AuthorizationService {

    boolean authenticateUser(String username, String password);
}