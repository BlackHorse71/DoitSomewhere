package uj.edu.DoIt;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Context;

public class DoitSomewhereActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        
    //    _setLoginStatus(false); // fake not logged in
    //    if (_checkLoginStatus()) {
        	startActivity(new Intent("uj.edu.DoIt.START"));
    //    }
    }
}