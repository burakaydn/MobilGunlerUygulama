package org.gdg.mobilgunleruygulama;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeSettingsActivity extends Activity {

	private EditText yeniKullaniciAdi, yeniSifre;
	private Button kaydet;
	private SharedManager sharedYonetici;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		overridePendingTransition(0, 0);
		setContentView(R.layout.activity_change_settings);
		viewBagla();
		butonlarAktif();
		SharedPrefHazirla();
	}

	private void viewBagla() {
		yeniKullaniciAdi = (EditText) findViewById(R.id.yeniKullaniciAdi_id);
		yeniSifre = (EditText) findViewById(R.id.yeniSifre_id);
		kaydet = (Button) findViewById(R.id.kaydet_id);
	}
	
	private void butonlarAktif() {
		kaydet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String kullaniciAdi = yeniKullaniciAdi.getText().toString();
				String sifre = yeniSifre.getText().toString();
				SharedPrefKaydet(kullaniciAdi, sifre);
				Toast.makeText(ChangeSettingsActivity.this, "Deðiþiklikleriniz kaydedildi.", 1000).show();
			}
		});
	}
	
	
	private void SharedPrefHazirla() {
		sharedYonetici=new SharedManager(this);	
	}
	
	private void SharedPrefKaydet(String kullaniciAdi, String sifre) {
		sharedYonetici.kullaniciAdiDegistir(kullaniciAdi);
		sharedYonetici.sifreDegistir(sifre);
	}
}
