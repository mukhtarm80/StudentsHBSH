package kz.edu.nis.hbsh.students;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Pupil extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView tv_iin, tv_fio,tv_class,tv_group,tv_advanced1,tv_advanced2,tv_group1,tv_group2,tv_standard,tv_groupStandard;
    FirebaseDatabase db;
    DatabaseReference rootRef, dbstd, users;
    StorageReference mStorageRef;
    ImageView image_id;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pupil);


        db = FirebaseDatabase.getInstance();
        rootRef = db.getReference();
       // dbstd = rootRef.child("Students");
        mStorageRef = FirebaseStorage.getInstance().getReference("imgStudent");
        auth = FirebaseAuth.getInstance();
        users = db.getReference("Users");
        dbstd = db.getReference("Students");

        drawerLayout = findViewById(R.id.drawer_layout);
        TextView toolbar_txt = findViewById(R.id.toolbar_txt);
        toolbar_txt.setText("Информация об ученике");

        tv_fio = findViewById(R.id.tv_fio);
        tv_class = findViewById(R.id.tv_class);
        tv_group = findViewById(R.id.tv_group);
        tv_advanced1 = findViewById(R.id.tv_advanced1);
        tv_advanced2 = findViewById(R.id.tv_advanced2);
        tv_group1 = findViewById(R.id.tv_group1);
        tv_group2 = findViewById(R.id.tv_group2);
        tv_standard = findViewById(R.id.tv_standard);
        tv_groupStandard = findViewById(R.id.tv_groupStandard);

        image_id = findViewById(R.id.image_id);
        tv_iin = findViewById(R.id.tv_iin);

        Intent j = getIntent();
        tv_class.setText(j.getStringExtra("KlassS"));

        Intent i = getIntent();
        String iin = i.getStringExtra("id_barcode");
    //  iin = "041115500098"; //020127600579
 String   image_idS = "https://firebasestorage.googleapis.com/v0/b/school-plants.appspot.com/o/imgStudent%2F020314601286.jpg?alt=media&token=69432ba9-62a2-4101-9cf2-c7496504c16c";
 Picasso.get().load(image_idS).into(image_id);
        tv_iin.setText(iin);
//Toast.makeText(getApplicationContext(), "users - " + users+" db - " + db+" dbstudents - " + dbstd, Toast.LENGTH_LONG).show();

 dbstd.orderByKey().equalTo(iin).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String fio = snapshot.child("FIO").getValue(String.class); // FIO
//  String iin = snapshot.child("iin").getValue(String.class);
                String group = snapshot.child("classGroup").getValue(String.class);
                String Klas = snapshot.child("class").getValue(String.class);
                String advanced1 = snapshot.child("advanced1").getValue(String.class);
                String advanced2 = snapshot.child("advanced2").getValue(String.class);
                String group1 = snapshot.child("group1").getValue(String.class);
                String group2 = snapshot.child("group2").getValue(String.class);
                String standard = snapshot.child("standard").getValue(String.class);
                String groupStandard = snapshot.child("groupStandard").getValue(String.class);
                String  image_idS = snapshot.child("image_id").getValue(String.class);
//Toast.makeText(getApplicationContext(), "имя - " + fio+" ИИН - " + iin+" подгруппа - " + group+" класс - " + clasS+" по выбору - " + advanced1, Toast.LENGTH_LONG).show();
                tv_fio.setText(fio);
            //    tv_iin.setText(iin);
                tv_group.setText(group);
               tv_class.setText(Klas);
                tv_advanced1.setText(advanced1);
                tv_advanced2.setText(advanced2);
                tv_group1.setText(group1);
                tv_group2.setText(group2);
               tv_standard.setText(standard);
                tv_groupStandard.setText(groupStandard);
 // image_idS = "https://firebasestorage.googleapis.com/v0/b/school-plants.appspot.com/o/imgStudent%2F020314601286.jpg?alt=media&token=69432ba9-62a2-4101-9cf2-c7496504c16c";
 Picasso.get().load(image_idS).into(image_id);
// image_id.setImageURI(Uri.parse(""));

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