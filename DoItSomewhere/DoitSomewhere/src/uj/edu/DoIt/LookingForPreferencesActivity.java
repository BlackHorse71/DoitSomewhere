package uj.edu.DoIt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LookingForPreferencesActivity extends Activity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookingforpreferences);
        
        _initActionBar();
        _setActionBarTitle("Search parameters:");
        _setActionBarBtnVisible(true);
        _setActionBarBtnLabel("back");
        _setActionBarBtnOnClick(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent("uj.edu.DoIt.START"));
			}
		});
        
        if (_checkLoginStatus()) {

        }
    }
}
