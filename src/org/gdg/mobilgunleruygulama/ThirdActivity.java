package org.gdg.mobilgunleruygulama;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;

public class ThirdActivity extends Activity {
	
	private WebView engine;
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		overridePendingTransition(0, 0);
		setContentView(R.layout.activity_third);
		urlAl();
		viewBagla();
	}

	private void webSiteAc() {
		engine = (WebView) findViewById(R.id.webengine_id);
		engine.getSettings().setJavaScriptEnabled(true);
		engine.getSettings().setBuiltInZoomControls(true);
		engine.loadUrl(url);
	}

	private void urlAl() {
		url=getIntent().getExtras().getString("url");
		if (url.startsWith("tel")) {
			startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(url)));
		} else if(url.startsWith("Change")) {
			Intent intent = new Intent(ThirdActivity.this, ChangeSettingsActivity.class);
			startActivity(intent);
		}else {
			webSiteAc();
		}
	}

	private void viewBagla() {
		// TODO Auto-generated method stub
		
	}
}
