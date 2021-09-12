package kz.edu.nis.hbsh.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Teachers extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView toolbar_txt;
    private ListView list_teachers;
    private String[] arrayClass;
    private ArrayAdapter<String> adapter;
    private int position;
    String Klass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar_txt = findViewById(R.id.toolbar_txt);
        toolbar_txt.setText("Выберите группу для");
        list_teachers = findViewById(R.id.lv_teachers);
        arrayClass = getResources().getStringArray(R.array.class_group);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(arrayClass)));
        list_teachers.setAdapter(adapter);
        list_teachers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Teachers.this, Teacher.class);
                intent.putExtra("position",i);
                Klass = arrayClass[i];
                intent.putExtra("Klass",Klass);
                startActivity(intent);
            }
        });



    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickScan(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickStudents(View view){
        MainActivity.redirectActivity(this, Students.class);
    }
    public void ClickSchedule(View view){
        MainActivity.redirectActivity(this, Schedule.class);
    }
    public void ClickTeachers(View view){
        recreate();
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }
    @Override
    protected  void  onPause(){
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}