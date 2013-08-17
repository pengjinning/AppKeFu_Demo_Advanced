/**
 * 
 */
package com.appkefu.demo.advanced;

import android.app.Application;

/**
 * @author Administrator
 *
 */
public class AppKeFuApplication extends Application {

	private boolean mIsConnected = false;

	public AppKeFuApplication(){
		
	}
	 
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	@Override
	public void onTerminate() {
		super.onTerminate();
	}
	
	public boolean isConnected() {
		return mIsConnected;
	}
	
	public void setConnected(boolean isConnected) {
		mIsConnected = isConnected;
	}
	
}
