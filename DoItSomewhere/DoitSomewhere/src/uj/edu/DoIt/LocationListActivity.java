package uj.edu.DoIt;




import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;



public class LocationListActivity extends ListActivity {
	/** Called when the activity is first created. */
	TextView selection;
	String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
			"consectetuer", "adipiscing", "elit", "morbi", "vel",
			"ligula"};
	private static final int ADD_ID = Menu.FIRST+1;
	private static final int DELETE_ID = Menu.FIRST+3;
	private static final int CLOSE_ID = Menu.FIRST+4;
	private SQLiteDatabase db=null;
	private Cursor constantsCursor=null;
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
       
    db=(new DatabaseHelper(this)).getWritableDatabase();
	constantsCursor=db.rawQuery("SELECT _ID, Name, Location "+"FROM Locations ORDER BY Name",null);
        
		ListAdapter adapter=new SimpleCursorAdapter(this,
				R.layout.row, constantsCursor,
				new String[] {"Name", "Location"},
				new int[] {R.id.itemName, R.id.itemType});
        		
        		
        		setListAdapter(adapter);
    		
        		setContentView(R.layout.list);   		
        		}
    
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		constantsCursor.close();
		db.close();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, ADD_ID, Menu.NONE, "Add")
				.setIcon(R.drawable.add)
				.setAlphabeticShortcut('a');
		menu.add(Menu.NONE, CLOSE_ID, Menu.NONE, "Close")
				.setIcon(R.drawable.eject)
				.setAlphabeticShortcut('c');
		menu.add(Menu.NONE, DELETE_ID, Menu.NONE, "Delete")
		.setIcon(R.drawable.delete)
		.setAlphabeticShortcut('d');

		return(super.onCreateOptionsMenu(menu));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case ADD_ID:
				add();
				return(true);
			case DELETE_ID:
			//	delete(RowID);
				return(true);				
			case CLOSE_ID:
				finish();
				return(true);
		}
		return(super.onOptionsItemSelected(item));
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
	ContextMenu.ContextMenuInfo menuInfo) {
		menu.add(Menu.NONE, DELETE_ID, Menu.NONE, "Delete")
				.setIcon(R.drawable.delete)
				.setAlphabeticShortcut('d');
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case DELETE_ID:
				AdapterView.AdapterContextMenuInfo info=
					(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

				delete(info.id);
				return(true);
		}

		return(super.onOptionsItemSelected(item));
	}
	private void add() {
		LayoutInflater inflater=LayoutInflater.from(this);
		View addView=inflater.inflate(R.layout.add_edit, null);
		final DialogWrapper wrapper=new DialogWrapper(addView);
		
		new AlertDialog.Builder(this)
			.setTitle(R.string.add_name)
			.setView(addView)
			.setPositiveButton(R.string.ok,
									new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
									int whichButton) {
					processAdd(wrapper);
				}
			})
			.setNegativeButton(R.string.cancel,
							new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
											int whichButton) {
					
				}
			})
			.show();
	}
	
	private void delete(final long rowId) {
		if (rowId>0) {
			new AlertDialog.Builder(this)
				.setTitle(R.string.delete_name)
				.setPositiveButton(R.string.ok,
	                 new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
																int whichButton) {
						processDelete(rowId);
					}
				})
				.setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
																int whichButton) {
					// ignore, just dismiss
					}
				})
				.show();
		}
	}
	
	private void processAdd(DialogWrapper wrapper) {
		ContentValues values=new ContentValues(2);
		
		values.put("Name", wrapper.getName());
		values.put("Location", wrapper.getLocation());
		
		db.insert("Locations", "Name", values);
		constantsCursor.requery();
	}
	
	private void processDelete(long rowId) {
		String[] args={String.valueOf(rowId)};
		
		db.delete("Locations", "_ID=?", args);
		constantsCursor.requery();
	}
	
	class DialogWrapper {
		EditText nameField=null;
		EditText locationField=null;
		View base=null;
		
		DialogWrapper(View base) {
			this.base=base;
			nameField=(EditText)base.findViewById(R.id.name);
			
		}
		
		String getName() {
			return(getNameField().getText().toString());
		}
		
		String getLocation() {
			return(getLocationField().getText().toString());
																									
		}
		
		private EditText getNameField() {
			if (nameField==null) {
				nameField=(EditText)base.findViewById(R.id.name);
			}
			
			return(nameField);
		}
		
		private EditText getLocationField() {
			if (locationField==null) {
				locationField=(EditText)base.findViewById(R.id.location);
			}
			
			return(locationField);
		}
	}
	/*
		public void onListItemClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		startActivity(new Intent("uj.edu.DoIt.LOCATION"));
		}
        		
		*/	
		public void onListItemClick(ListView parent, View v,
        		int position, long id) {
        		//selection.setText(items[position]);
        		startActivity(new Intent("uj.edu.DoIt.LOCATION"));
        		}
        	
        		
}

