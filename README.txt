使用说明：

详细开发指南：http://appkefu.com/AppKeFu/tutorial-android.html

1. 在 AndroidManifest.xml 的 <application></application> 中添加

   <activity
            android:name="com.appkefu.lib.ChatActivity"
            android:theme="@android:style/Theme.NoTitleBar" />
            
   <service android:name="com.appkefu.lib.service.AppService" />

2. 参见 com.appkefu.demo.simple.MainActivity.java 中
	void startChat(String kefuName) 函数，其中kefuName为客服的用户名
	
3. 用户首次打开会话窗口，系统为此手机用户生成唯一ID（基于OpenUDID,
https://github.com/UASoftware/OpenUDID-Android），如开发者需要基于自己
的用户体系，请到AppKeFu.com咨询客服，或email: appkefu@163.com

4. 开发者可以根据需要在合适的时候与服务器建立连接，以便于用户在未打开会话窗口
的情况下接收来自客服的消息，如不需接收类似消息可以参考示例： AppKeFuDemoSimple

















