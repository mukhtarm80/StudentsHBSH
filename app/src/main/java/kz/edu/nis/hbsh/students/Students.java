package kz.edu.nis.hbsh.students;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;


public class Students extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView toolbar_txt,tv_header;
    String Klass,choosenKlass;
    FirebaseDatabase db;
    DatabaseReference rootRef, dbstd;
    StorageReference mStorageRef;
    Spinner spinnerStdnt;
    private String[] arrayClass;
    private ArrayAdapter<String> adapterA;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        drawerLayout = findViewById(R.id.drawer_layout);
       TextView toolbar_txt = findViewById(R.id.toolbar_txt);
        tv_header = findViewById(R.id.tv_header);
       toolbar_txt.setText("Выберите");

       spinnerStdnt = findViewById(R.id.spinnerStdnt);
        arrayClass = getResources().getStringArray(R.array.class_group);
        adapterA = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(arrayClass)));
        spinnerStdnt.setAdapter(adapterA);

        db = FirebaseDatabase.getInstance();
        rootRef = db.getReference();
        dbstd = db.getReference("Students");

        ArrayList<RecyclerViewItemStudent> recyclerViewItems = new ArrayList<>();

        choosenKlass = "12A_1";

 dbstd.orderByChild("classGroup")
    //.equalTo("020709501366")
      .equalTo("12A_1")
   //   .equalTo(choosenKlass)
   //     .limitToFirst(15)
         .addChildEventListener(new ChildEventListener() { //50.  limitToFirst(50) orderByChild("classGroup").limitToFirst(25) .startAt("А").endAt("А\uF8FF")
     @Override
     public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
         String fio = snapshot.child("FIO").getValue(String.class); // FIO
         String iin = snapshot.child("iin").getValue(String.class);
         String group = snapshot.child("classGroup").getValue(String.class);
         String advanced1 = snapshot.child("advanced1").getValue(String.class);
         String advanced2 = snapshot.child("advanced2").getValue(String.class);
         String standard = snapshot.child("standard").getValue(String.class);
         String  image_idS = snapshot.child("image_id").getValue(String.class);
   recyclerViewItems.add(new RecyclerViewItemStudent(image_idS,fio,group,advanced1,advanced2,standard,iin));

         tv_header.setText(fio);
        toolbar_txt.setText("Выберите");

     }

     @Override
     public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

     }

     @Override
     public void onChildRemoved(@NonNull DataSnapshot snapshot) {

     }

     @Override
     public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

     }

     @Override
     public void onCancelled(@NonNull DatabaseError error) {

     }
 });
 //  recyclerViewItems.add(new RecyclerViewItemStudent(image_idS,fio,group,advanced1,advanced2,standard,iin));
//recyclerViewItems.add(new RecyclerViewItemStudent("https://firebasestorage.googleapis.com/v0/b/school-plants.appspot.com/o/imgStudent%2F021201600970.jpg?alt=media&token=fd1a4e0e-875f-4d88-b256-375707ad6896",
//"Бексултанова Арайлым Нурмаханбетқызы","12L_2","биология","химия","экономика","021201600970"));
//recyclerViewItems.add(new RecyclerViewItemStudent("https://firebasestorage.googleapis.com/v0/b/school-plants.appspot.com/o/imgStudent%2F021230500961.jpg?alt=media&token=3ec9fc2f-c998-47a7-8576-3ea0104b3e21",
//"Куттыбаев Ардақ Нурланбекұлы","12B_2","физика","информатика","графика и проектирование","021230500961"));
//recyclerViewItems.add(new RecyclerViewItemStudent("https://firebasestorage.googleapis.com/v0/b/school-plants.appspot.com/o/imgStudent%2F030215601280.jpg?alt=media&token=ce06b6b4-44f7-4739-a606-e208004a3d30",
//"Қалсабаева Әсем Мухтарқызы","12L_2","физика","химия","география","030215601280"));
// https://firebasestorage.googleapis.com/v0/b/school-plants.appspot.com/o/imgStudent%2F021201600970.jpg?alt=media&token=fd1a4e0e-875f-4d88-b256-375707ad6896
// https://firebasestorage.googleapis.com/v0/b/school-plants.appspot.com/o/imgStudent%2F021230500961.jpg?alt=media&token=3ec9fc2f-c998-47a7-8576-3ea0104b3e21
// https://firebasestorage.googleapis.com/v0/b/school-plants.appspot.com/o/imgStudent%2F030215601280.jpg?alt=media&token=ce06b6b4-44f7-4739-a606-e208004a3d30

        recyclerView = findViewById(R.id.rv_students);
      //  recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapterStudent(recyclerViewItems);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    //    Query query = FirebaseDatabase.getInstance()
      //          .getReference()
        //        .child("students_Temp")
          //      .limitToLast(50);
     //  Intent intent = new Intent(Students.this, Pupil.class);
     //   intent.putExtra("position",i);
       // Klass = arrayClass[i];
    //    intent.putExtra("KlassS",Klass);
    //    startActivity(intent);
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
         recreate();
    }
    public void ClickSchedule(View view){
        MainActivity.redirectActivity(this, Schedule.class);
    }
    public void ClickTeachers(View view){
        MainActivity.redirectActivity(this, Teachers.class);
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