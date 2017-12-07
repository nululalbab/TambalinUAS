package com.ulul.tambalinuas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class CustomList extends AppCompatActivity implements SearchView.OnQueryTextListener{

    SearchView sv;
    ListView lv;
    ArrayAdapter adapter;
    String[] mobileArray;
    String[] phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        mobileArray = new String [] {"ITS","UNAIR","ubaid"};
        phone = new String [] {"081224997124","081224997124", "089678007410"};

        adapter = new ArrayAdapter<String>(this,
                R.layout.list, mobileArray);

        lv = (ListView) findViewById(R.id.list);
        sv = (SearchView) findViewById(R.id.search);

        lv.setAdapter(adapter);
        sv.setSubmitButtonEnabled(true);
        sv.setOnQueryTextListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (String.valueOf(lv.getItemAtPosition(i)).equals("ubaid")){
                    String o = "tel:";
                    o += phone[searchPosition("ubaid")];

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(o));

                    if (ActivityCompat.checkSelfPermission(CustomList.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(callIntent);
                } else if (String.valueOf(lv.getItemAtPosition(i)).equals("ITS")) {
                    String o = "tel:";
                    o += phone[searchPosition("ITS")];

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(o));

                    if (ActivityCompat.checkSelfPermission(CustomList.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(callIntent);
                }   else if (String.valueOf(lv.getItemAtPosition(i)).equals("UNAIR")) {
                    String o = "tel:";
                    o += phone[searchPosition("UNAIR")];

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(o));

                    if (ActivityCompat.checkSelfPermission(CustomList.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(callIntent);
                }
            }
        });
    }
    
    public int searchPosition(String x){
        int y = -1;
        for (int i = 0; i < mobileArray.length; i++) {
            if (x.equals(mobileArray[i])){
                y = i;
            }
        }
        return y;
    }
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.getFilter().filter(s);

        return true;
    }
}
