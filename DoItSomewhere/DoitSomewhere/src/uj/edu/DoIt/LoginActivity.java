package uj.edu.DoIt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);
        
        _initActionBar();
        _setActionBarTitle("Please login");
        _setActionBarBtnVisible(false);
        
        
        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
			
        	/**
        	 * @TODO some login backend stuff should go here
        	 */
			public void onClick(View arg0) {
				startActivity(new Intent("uj.edu.DoIt.START"));
			}
		});
        
        Button registerBtn = (Button) findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				startActivity(new Intent("uj.edu.DoIt.REGISTER"));
			}
		});
    }
}
