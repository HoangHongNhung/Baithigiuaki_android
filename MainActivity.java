package com.example.giuaky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnBang;
    ListView  listView;
    TextView txt1, txt2;
    EditText edt1, edt2;
    ArrayAdapter<String> adapter = null;
    ArrayList<String> arrayList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        btnBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edt1.getText().toString().equals("") || edt2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập số", Toast.LENGTH_SHORT).show();
                } else {


                        String chuoi1 = edt1.getText().toString();
                        int so1 = Integer.parseInt(chuoi1);

                        String chuoi2 = edt2.getText().toString();
                        int so2 = Integer.parseInt(chuoi2);

                        int thuong = so1 / so2;
                        txt2.setText(String.valueOf(edt1.getText().toString()+"/"+edt2.getText().toString()+"="+thuong));

                        arrayList.add(edt1.getText()+"/"+edt2.getText()+"="+thuong);
                        adapter.notifyDataSetChanged();
                        edt1.setText("");
                        edt2.setText("");

                        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                                arrayList.remove(position);
                                adapter.notifyDataSetChanged();
                                return false;
                            }
                        });


                }
            }

        });

    }


    public void AnhXa(){

        edt1 = (EditText) findViewById(R.id.editText2);
        edt2 = (EditText) findViewById(R.id.editText3);
        btnBang = (Button) findViewById(R.id.button);
        txt1 = (TextView) findViewById(R.id.textView);
        txt2 = (TextView) findViewById(R.id.textView2);
        listView = (ListView) findViewById(R.id.listview1);

    }

}
