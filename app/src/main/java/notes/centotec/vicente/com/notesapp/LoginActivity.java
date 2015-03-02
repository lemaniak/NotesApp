package notes.centotec.vicente.com.notesapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import notes.cenfotec.vicente.com.utils.Utils;


public class LoginActivity extends Activity {

    private TextView username;
    private TextView password;
    private final String USERNAME_KEY="usernameValue";
    private final String PASSWORD_KEY="passwordValue";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        this.username= (TextView) findViewById(R.id.login_activity_itxt_username);
        this.password= (TextView) findViewById(R.id.login_activity_ipwd_password);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        String userNameValue=username.getText().toString();
        String passwordValue=password.getText().toString();
        if(!userNameValue.isEmpty()){
            savedInstanceState.putString(USERNAME_KEY, userNameValue);
        }else if(!passwordValue.isEmpty()){
            savedInstanceState.putString(PASSWORD_KEY, passwordValue);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        String storedUsername=savedInstanceState.getString(USERNAME_KEY);
        String storedPassword=savedInstanceState.getString(PASSWORD_KEY);
        if(storedUsername!=null){
            username.setText(storedUsername);
        }else if(storedPassword!=null){
            password.setText(storedPassword);
        }
    }

    public void login(View view){
        String userNameValue=username.getText().toString();
        String passwordValue=password.getText().toString();
        if(userNameValue.isEmpty()){
            Utils.displayMessage(this,getResources().getString(R.string.username_required));
        }else if(passwordValue.isEmpty()){
            Utils.displayMessage(this,getResources().getString(R.string.password_required));
        }else if(userNameValue.compareTo("foo")==0 && passwordValue.compareTo("boo")==0){
           //TODO login
        }else{
            Utils.displayMessage(this,"invalid credentials");
        }
    }

}
