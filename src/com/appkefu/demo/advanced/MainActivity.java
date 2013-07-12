/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.appkefu.demo.advanced;

import com.appkefu.demo.advanced.R;
import com.appkefu.lib.ChatViewActivity;
import com.appkefu.lib.service.UsernameAndKefu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/*

*/

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private static final int LOGIN_REQUEST_CODE = 1;
	
	private static final String SERIAL_KEY = "com.appkefu.lib.username.serialize";


	private Button chatAdmin;

	private AppKeFuApplication app;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		chatAdmin = (Button)findViewById(R.id.chat_admin);
		chatAdmin.setOnClickListener(listener);
		
		app = (AppKeFuApplication)getApplication();
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart");
		
		if(!app.isConnected()){
			Log.d(TAG, "start login");
			Intent login = new Intent(this, LoginActivity.class);
			startActivityForResult(login, LOGIN_REQUEST_CODE);
		}
		else
		{
			Log.d(TAG, "already logged in");
		}

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == LOGIN_REQUEST_CODE) {
			
			if (resultCode == Activity.RESULT_OK) 
			{
				Log.d(TAG, "Activity.RESULT_OK");
				app.setConnected(true);

			}
			else if (resultCode == Activity.RESULT_CANCELED) 
			{
				Log.d(TAG, "Activity.RESULT_CANCELED");
				app.setConnected(false);
				
				chatAdmin.setEnabled(false);

				//请检查网络链接、appkey是否填写正确
				Toast.makeText(this, "链接服务器失败", Toast.LENGTH_LONG).show();
			}
		} 
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart");
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume");
		
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause");
		
	}
	
	@Override
	protected void onStop() {
		super.onStop();

		Log.d(TAG, "onStop");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");
		
	}

	private OnClickListener listener = new OnClickListener() {	    
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
        	switch(v.getId()){
        	case R.id.chat_admin:
        		startChat("testusername","admin");
        		break;
        	default:
        		break;
        	}
        }
	};
	
	private void startChat(String username, String kefuName) {
		
		String jid = kefuName + "@appkefu.com";
		Intent intent = new Intent(this, ChatViewActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		UsernameAndKefu usernameAndKefu = new UsernameAndKefu();
		usernameAndKefu.setUsername(username);
		usernameAndKefu.setKefuJID(jid);
		
		Bundle mbundle = new Bundle();
		mbundle.putSerializable(SERIAL_KEY, usernameAndKefu);
		intent.putExtras(mbundle);
			
		startActivity(intent);	
    }

}