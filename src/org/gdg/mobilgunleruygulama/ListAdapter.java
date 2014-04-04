package org.gdg.mobilgunleruygulama;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String>{
	
	private List<String> liste;
	private View view;
	private TextView text;
	private LayoutInflater inflater ;
	
	public ListAdapter(Context context, List<String> liste) {
		super(context,R.layout.liste_item,liste);
		this.liste=liste;
		inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		view=inflater.inflate(R.layout.liste_item, null, false);
		
		text=(TextView)view.findViewById(R.id.item_text_id);
		text.setText(liste.get(position));
		
		text=(TextView)view.findViewById(R.id.item_no_id);
		text.setText("No : "+position);
		return view;
	}

}
