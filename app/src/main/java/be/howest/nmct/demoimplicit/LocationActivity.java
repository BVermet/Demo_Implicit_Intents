package be.howest.nmct.demoimplicit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LocationActivity extends Activity {
    private Button btnLocatie;
    private EditText txtLatitude;
    private EditText txtLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


        txtLatitude = (EditText)findViewById(R.id.txtLatitude);

        txtLongitude = (EditText) findViewById(R.id.txtLongitude);

        btnLocatie = (Button) findViewById(R.id.btnLocatie);
        btnLocatie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendData();
            }
        });
    }

    private void SendData(){
        float Latitude = Float.parseFloat(this.txtLatitude.getText().toString());
        float Longitude = Float.parseFloat(this.txtLongitude.getText().toString());

        Uri gmmIntentUri = Uri.parse("geo:"+Latitude+","+Longitude);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location, menu);
        return true;
    }

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
}
