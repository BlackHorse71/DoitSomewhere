package uj.edu.DoIt;




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
			"ligula"};
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.list);
        setListAdapter(new ArrayAdapter<String>(this,
				R.layout.row, R.id.itemName,
				items));
        		selection=(TextView)findViewById(R.id.selection);
        		}
        		public void onListItemClick(ListView parent, View v,
        		int position, long id) {
        		selection.setText(items[position]);
        		startActivity(new Intent("uj.edu.DoIt.LOCATION"));
        		}
}
