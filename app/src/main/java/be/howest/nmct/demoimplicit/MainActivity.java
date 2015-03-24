package be.howest.nmct.demoimplicit;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;


public class MainActivity extends Activity {
    private Button btnWeb;
    private Button btnCall;
    private Button btnDial;
    private Button btnGeo;
    private Button btnContact;
    private Button btnEdit;
    private Button btnCalculate;
    private static final int PICK_CONTACT = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        */

        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnDial = (Button) findViewById(R.id.btnDial);
        btnGeo = (Button) findViewById(R.id.btnGeo);
        btnContact = (Button) findViewById(R.id.btnContact);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Web();
            }
        });

    btnCall.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            Call();
    }
    }

    );

    btnDial.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            Dial();
    }
    }

    );

    btnGeo.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            Geo();
    }
    }

    );

    btnContact.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            Contact();
    }
    }

    );

    btnEdit.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            Edit();
    }
    }

    );

    btnCalculate.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            Calculate();
    }
    }

    );


}

    private void Web(){
        String url = "http://www.nmct.be";
        Intent web = new Intent(Intent.ACTION_VIEW);
        web.setData(Uri.parse(url));
        startActivity(web);
    }

    private void Call(){
        //Permission tag toevoegen in manifest
        String phoneNr = "111-333-222-4";
        String uri = "tel:" + phoneNr.trim();
        Intent call = new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse(uri));
        startActivity(call);
    }

    private void Dial(){
        String phoneNr = "111-333-222-4";
        String uri = "tel:" + phoneNr.trim();
        Intent dial = new Intent(Intent.ACTION_DIAL);
        dial.setData(Uri.parse(uri));
        startActivity(dial);
    }

    private void Geo(){
        Intent intent = new Intent(MainActivity.this,LocationActivity.class);
        startActivity(intent);
    }

    private void Contact(){
        Intent it= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(it, PICK_CONTACT);
    }

    private void Edit(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf("1"));
        intent.setData(uri);
        startActivity(intent);
    }

    private void Calculate(){
        Intent intent = new Intent(Intent.ACTION_SEND);

        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
