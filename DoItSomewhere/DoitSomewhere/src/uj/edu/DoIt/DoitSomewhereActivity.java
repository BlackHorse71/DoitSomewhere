package uj.edu.DoIt;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoitSomewhereActivity extends Activity {
    /** Called when the activity is first created. */
	private EditText lat;
	private EditText lon;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locate);
		
        Button btn=(Button)findViewById(R.id.map);
		lat=(EditText)findViewById(R.id.lat);
		lon=(EditText)findViewById(R.id.lon);
    
    
    }
}