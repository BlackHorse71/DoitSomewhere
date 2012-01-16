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
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;
import android.widget.Toast;

public class DoitSomewhereActivity extends Activity implements LocationListener {
    /** Called when the activity is first created. */
	private EditText lat;
	private EditText lon;
	private TextView latituteField;
	private TextView longitudeField;
	private LocationManager locationManager;
	private String provider;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.locate);
		latituteField = (TextView) findViewById(R.id.TextView02);
		longitudeField = (TextView) findViewById(R.id.TextView04);
		
		// Get the location manager
				locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				// Define the criteria how to select the locatioin provider -> use
				// default
				Criteria criteria = new Criteria();
				provider = locationManager.getBestProvider(criteria, false);
				Location location = locationManager.getLastKnownLocation(provider);
				
				// Initialize the location fields
				if (location != null) {
					System.out.println("Provider " + provider + " has been selected.");
					int latl = (int) (location.getLatitude());
					int lngg = (int) (location.getLongitude());
					latituteField.setText(String.valueOf(latl));
					longitudeField.setText(String.valueOf(lngg));
				} else {
					latituteField.setText("Provider not available");
					longitudeField.setText("Provider not available");
				}
		
      Button btn=(Button)findViewById(R.id.map);
		lat=(EditText)findViewById(R.id.lat);
		lon=(EditText)findViewById(R.id.lon);
    
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				lat.setText(latituteField.getText());
				lon.setText(longitudeField.getText());
				String _lat=lat.getText().toString();
				String _lon=lon.getText().toString();
				Uri uri=Uri.parse("geo:"+_lat+","+_lon);
				
				startActivity(new Intent(Intent.ACTION_VIEW, uri));
			}
			
	
		});

    
    }
    
    
	public void onLocationChanged(Location location) {
		int lat = (int) (location.getLatitude());
		int lng = (int) (location.getLongitude());
		latituteField.setText(String.valueOf(lat));
		longitudeField.setText(String.valueOf(lng));
	}
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Disabled provider " + provider,
				Toast.LENGTH_SHORT).show();
	}
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Enabled new provider " + provider,
				Toast.LENGTH_SHORT).show();
		
	}
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
	
	/* Request updates at startup */
	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(provider, 400, 1, this);
	}

	/* Remove the locationlistener updates when Activity is paused */
	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(this);
	}
}