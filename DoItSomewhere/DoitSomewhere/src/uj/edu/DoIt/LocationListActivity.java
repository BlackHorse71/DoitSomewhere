package uj.edu.DoIt;

import java.util.ArrayList;
import java.util.List;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LocationListActivity extends ListActivity {
	/** Called when the activity is first created. */
	TextView selection;
	String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
			"consectetuer", "adipiscing", "elit", "morbi", "vel",
			"ligula", "vitae", "arcu", "aliquet", "mollis",
			"etiam", "vel", "erat", "placerat", "ante",
			"porttitor", "sodales", "pellentesque", "augue", "purus"};
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.locationlist);
        
   /*     _initActionBar();
        _setActionBarTitle("Search results");
        _setActionBarBtnVisible(true);
        _setActionBarBtnLabel("back"); 
        _setActionBarBtnOnClick(new View.OnClickListener() 
        {
	/		
			public void onClick(View arg0) {
				startActivity(new Intent("uj.edu.DoIt.START"));
			}
		});*/
        
       
        	//ArrayList<List> items = new ArrayList<List>()
  //      setListAdapter(new ListAdapter(new ArrayAdapter<String>(this, R.layout.locationlistitem, items);
          //  ListAdapter adapter = new ListAdapter(this, R.layout.locationlistitem, items);
            ListView listView = (ListView) findViewById(R.id.locationList);
  //          listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
    					long arg3) {
    				startActivity(new Intent("uj.edu.DoIt.LOCATION"));
    			
    		}
      
           });
         
    }
}
