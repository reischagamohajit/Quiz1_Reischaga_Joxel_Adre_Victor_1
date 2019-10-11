package com.example.quizlogin;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    Intent intent;
    public String[] menuStrings = {"Alam Sutera", "Gading Serpong", "BSD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.row_menu_name, menuStrings);

        ListView listView = findViewById(R.id.listView_string_adapter);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    intent = new Intent(ListActivity.this, AlamSutra.class);
                    startActivity(intent);
                } else if (position == 1) {
                    intent = new Intent(ListActivity.this, GadingSerpong.class);
                    startActivity(intent);
                } else if (position == 2) {
                    intent = new Intent(ListActivity.this, BumiSerpongDamai.class);
                    startActivity(intent);
                } else {
                    Toast t = Toast.makeText(ListActivity.this , menuStrings[position], Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                    t.show();
                }
            }
        });


    }
}
