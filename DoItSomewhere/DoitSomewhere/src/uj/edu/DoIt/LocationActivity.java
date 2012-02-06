package uj.edu.DoIt;

import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class LocationActivity extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
        
        if (_checkLoginStatus()) {
        	
        }
        
        _initActionBar();
        _setActionBarTitle("Location details");
        _setActionBarBtnVisible(true);
        _setActionBarBtnLabel("back");
        _setActionBarBtnOnClick(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				startActivity(new Intent("uj.edu.DoIt.LOCATION_LIST"));
			}
		});
        
        
    }
}
