package com.app.controller;

public interface Controller {

	void executePost(Context context) throws Exception;
	void executeGet(Context context) throws Exception;
	
}
