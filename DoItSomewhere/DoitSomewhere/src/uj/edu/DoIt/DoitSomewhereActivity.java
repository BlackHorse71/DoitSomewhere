package uj.edu.DoIt;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.NumberKeyListener;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


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
    
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				String _lat=lat.getText().toString();
				String _lon=lon.getText().toString();
				Uri uri=Uri.parse("geo:"+_lat+","+_lon);
				
				startActivity(new Intent(Intent.ACTION_VIEW, uri));
			}
		});
    
    }
}