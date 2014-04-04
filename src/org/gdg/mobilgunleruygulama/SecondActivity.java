package org.gdg.mobilgunleruygulama;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class SecondActivity extends Activity {
	
	private ListView listview;
	private ListAdapter adapter;
	private ArrayList<String> liste;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_second);
		listeHazirla();
		viewBagla();
		itemlerAktif();
	}

	private void viewBagla() {
		listview=(ListView)findViewById(R.id.listview_id);
		adapter=new ListAdapter(this, liste);
		listview.setAdapter(adapter);
	}
	
	private void itemlerAktif(){
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
				intent.putExtra("url", liste.get(arg2));
				startActivity(intent);
			}
		});
	}

	private void listeHazirla() {
		liste=new ArrayList<String>();
		liste.add("http://www.google.com");
		liste.add("http://www.webrazzi.com");
		liste.add("http://www.milliyet.com");
		liste.add("tel:123456");
		liste.add("Change_Settings");
//		liste.add("http://www.webrazzi.com");
//		liste.add("http://www.milliyet.com");
//		liste.add("http://www.google.com");
//		liste.add("http://www.webrazzi.com");
//		liste.add("http://www.milliyet.com");
	}
	
}
