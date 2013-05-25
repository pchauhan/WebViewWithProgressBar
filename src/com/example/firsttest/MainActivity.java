package com.example.firsttest;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MainActivity extends Activity {
	 WebView webView ;
	 ProgressDialog progressDialog;
	 Activity activity ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 // TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		activity = this;
		webView = (WebView)findViewById(R.id.webView1);

		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setPluginsEnabled(true);
		webView.getSettings().setSupportZoom(true);

		progressDialog = new ProgressDialog(this);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setCancelable(false);

		webView.setWebChromeClient(new WebChromeClient() {
		   public void onProgressChanged(WebView view, int progress) {
		       progressDialog.show();
		       progressDialog.setProgress(0);
		       activity.setProgress(progress * 1000);
		       progressDialog.incrementProgressBy(progress);
		       if(progress == 100 && progressDialog.isShowing())
		           progressDialog.dismiss();
		   }
		});
		webView.loadUrl("http://www.google.co.in/");
		}

		}