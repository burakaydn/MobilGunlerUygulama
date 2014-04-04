package org.gdg.mobilgunleruygulama;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText kullanici_adi,sifre;
	private Button giris;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //Uygulama basligini yok eder
		setContentView(R.layout.activity_main);
		viewBagla();
		butonlarAktif();
	}

	private void viewBagla() {
		kullanici_adi=(EditText)findViewById(R.id.kullaniciAdi_id);
		sifre=(EditText)findViewById(R.id.sifre_id);
		giris=(Button)findViewById(R.id.giris_id);
	}
	
	private void butonlarAktif() {
		giris.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(kullanici_adi.getText().toString().equals("abc") &&
				   sifre.getText().toString().equals("123")){
					
					Intent intent=new Intent(MainActivity.this,SecondActivity.class);
					startActivity(intent);
					
				}
				else{
					Toast.makeText(MainActivity.this, "Hatalý Giriþ", 1000).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
