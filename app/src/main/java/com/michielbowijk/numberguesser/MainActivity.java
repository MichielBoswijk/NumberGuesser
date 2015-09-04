// reference package
package com.michielbowijk.numberguesser;

// necessary imports
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

// class for the initial screen of the app
public class MainActivity extends Activity {

    // method called when screen is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // call constructor of superclass (Activity)
        super.onCreate(savedInstanceState);
        // link with layout file
        setContentView(R.layout.activity_main);
    }

    // method for creating action bar with items
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // method for handling access of items in action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // method called when button on first screen in pressed. Navigates to second screen
    public void goToSecondScreen(View view) {
        // link to the second activity
        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
    }
}
