package uj.edu.DoIt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerform);
        
        _initActionBar();
        _setActionBarTitle("Create new account");
        _setActionBarBtnLabel("back");
        _setActionBarBtnOnClick(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent("uj.edu.DoIt.LOGIN"));
			}
		});
        
        
        Button registerBtn = (Button) findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
			
        	/**
        	 * @TODO some login backend stuff should go here
        	 */
			public void onClick(View arg0) {
				startActivity(new Intent("uj.edu.DoIt.START"));
			}
		});
    }
}
