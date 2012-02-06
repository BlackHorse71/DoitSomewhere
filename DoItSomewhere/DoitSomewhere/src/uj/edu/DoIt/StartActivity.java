package uj.edu.DoIt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.Toast;

public class StartActivity extends Activity implements LocationListener {
	private TextView latitudeField;
	private TextView longitudeField;
	private LocationManager locationManager;
	private String provider;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.start);
        
        _initActionBar();
        _setActionBarTitle("Search for locations");
        _setActionBarBtnVisible(true);
        _setActionBarBtnLabel("logout");

        latitudeField = (TextView) findViewById(R.id.latitudeField);
        longitudeField = (TextView) findViewById(R.id.longitudeField);
        
        
        _setActionBarBtnOnClick(new View.OnClickListener() {
			
        	/**
        	 * @TODO some logout backend stuff here
        	 */
			public void onClick(View v) {
				startActivity(new Intent("uj.edu.DoIt.LOGIN"));
			}
		});
        
        View lookingForPreferences = (View) findViewById(R.id.lookingForBtn);
        lookingForPreferences.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent("uj.edu.DoIt.LOOKING_FOR_PREFERENCES"));
			}
		});
        
        Button findLocationsBtn = (Button) findViewById(R.id.findLocationsBtn);
        findLocationsBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent("uj.edu.DoIt.LOCATION_LIST"));
			}
		});
        
        if (_checkLoginStatus()) {
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
				long latl = (long) (location.getLatitude());
				long lngg = (long) (location.getLongitude());
				latitudeField.setText(String.valueOf(latl));
				longitudeField.setText(String.valueOf(lngg));
			} else {
				latitudeField.setText("Provider not available");
				longitudeField.setText("Provider not available");
			}
        }
    }
    
	public void onLocationChanged(Location location) {
		int lat = (int) (location.getLatitude());
		int lng = (int) (location.getLongitude());
		latitudeField.setText(String.valueOf(lat));
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