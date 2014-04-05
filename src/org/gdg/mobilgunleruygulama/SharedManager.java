package org.gdg.mobilgunleruygulama;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharedManager {
	
	private Context context;
	private SharedPreferences pref;
	private Editor editor;
	
	public SharedManager(Context mContext) {
		context = mContext;
		pref = PreferenceManager.getDefaultSharedPreferences(context);
		editor = pref.edit();
	}
	
	public String getKullaniciAdi() {
		return pref.getString("username", "abc");
	}
	
	public String getSifre() {
		return pref.getString("password", "123");
	}
	
	public void kullaniciAdiDegistir(String yeniKullaniciAdi){
		editor.putString("username", yeniKullaniciAdi);
		editor.commit();
	}
	
	public void sifreDegistir(String yeniSifre){
		editor.putString("password", yeniSifre);
		editor.commit();
	}

}
