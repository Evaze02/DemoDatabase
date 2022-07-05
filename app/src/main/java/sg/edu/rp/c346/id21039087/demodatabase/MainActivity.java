package sg.edu.rp.c346.id21039087.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnGetTask;
    ListView lvTasks;
    EditText editText;
    EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTask = findViewById(R.id.btnGetTask);
        lvTasks = findViewById(R.id.lvTasks);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);





        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask(editText.getText().toString(), editText2.getText().toString());

            }
        });

        btnGetTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Task> al = db.getTasks();
                db.close();

                ArrayAdapter aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,al);
                lvTasks.setAdapter(aa);


            }
        });




    }
}