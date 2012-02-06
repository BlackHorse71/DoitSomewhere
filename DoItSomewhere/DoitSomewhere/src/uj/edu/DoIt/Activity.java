package uj.edu.DoIt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public abstract class Activity extends android.app.Activity {
	private TextView _actionBarTitle = null;
	private Button _actionBarBtn = null;
	/**
	 * @TODO true is for testing only. Should be changed to false and checked dynamically
	 */
	private Boolean _loginStatus = true;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    protected void _setLoginStatus(Boolean value) {
    	_loginStatus = value;
    }
    
    protected Boolean _getLoginStatus() {
    	return _loginStatus;
    }
    
    protected Boolean _checkLoginStatus() {
    	if (!_getLoginStatus()) {
    		startActivity(new Intent("uj.edu.DoIt.LOGIN"));
    		return false;
    	}
    	
    	return true;
    }
    
    protected void _initActionBar() {
    	_actionBarTitle = (TextView) findViewById(R.id.actionBarTitle);
        _actionBarBtn = (Button) findViewById(R.id.actionBarBtn);
    }
    
    protected Activity _setActionBarTitle(String title) {
    	if (_actionBarTitle != null) {
    		_actionBarTitle.setText(title);
    	}
    	return this;
    }
    
    protected Activity _setActionBarBtnLabel(String label) {
    	if (_actionBarBtn != null) {
    		_actionBarBtn.setText(label);
    	}
    	return this;
    }
    
    protected Activity _setActionBarBtnVisible(Boolean isVisible) {
    	if (_actionBarBtn != null) {
    		_actionBarBtn.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    	}
    	return this;
    }
    
    protected Activity _setActionBarBtnOnClick(OnClickListener onClickListener) {
    	_actionBarBtn.setOnClickListener(onClickListener);
    	return this;
    }
    
    protected Button _getActionBarBtn() {
    	return _actionBarBtn;
    }
}