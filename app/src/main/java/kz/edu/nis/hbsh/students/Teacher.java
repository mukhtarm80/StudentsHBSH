package kz.edu.nis.hbsh.students;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Teacher extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView tvKL,tvWHis,tvKMW,tvHisKaz,tvGeo,tvRUS,tvKAZ,tvENG,tvInf,tvPhys,tvChem,tvBio,tvMath10,tvMath;
    String kl;
    FirebaseDatabase db;
    DatabaseReference rootRef,subjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        drawerLayout = findViewById(R.id.drawer_layout);
        TextView toolbar_txt = findViewById(R.id.toolbar_txt);
        toolbar_txt.setText("Преподаватели");
        tvKL = findViewById(R.id.tv_Klass);
        tvWHis = findViewById(R.id.tvWHis);
        tvKMW = findViewById(R.id.tvKMW);
        tvHisKaz = findViewById(R.id.tvHisKaz);
        tvGeo = findViewById(R.id.tvGeo);
        tvRUS = findViewById(R.id.tvRUS);
        tvKAZ = findViewById(R.id.tvKAZ);
        tvENG = findViewById(R.id.tvENG);
        tvInf = findViewById(R.id.tvInf);
        tvPhys = findViewById(R.id.tvPhys);
        tvChem = findViewById(R.id.tvChem);
        tvBio = findViewById(R.id.tvBio);
        tvMath10 = findViewById(R.id.tvMath10);
        tvMath = findViewById(R.id.tvMath);

        db = FirebaseDatabase.getInstance();
        rootRef = db.getReference();
        subjects= db.getReference("Subjects");

        Intent i = getIntent();
        tvKL.setText(i.getStringExtra("Klass"));
        kl = i.getStringExtra("Klass");

        subjects.orderByKey().equalTo(kl).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String Biology = snapshot.child("Biology").getValue(String.class);
                String Chemistry = snapshot.child("Chemistry").getValue(String.class);
                String English = snapshot.child("English").getValue(String.class);
                String Geography = snapshot.child("Geography").getValue(String.class);
                String HistoryOfKazakhstan = snapshot.child("HistoryOfKazakhstan").getValue(String.class);
                String Informatics = snapshot.child("Informatics").getValue(String.class);
                String KMW = snapshot.child("KMW").getValue(String.class);
                String Kazakh = snapshot.child("Kazakh").getValue(String.class);
                String Mathematics = snapshot.child("Mathematics").getValue(String.class);
                String Mathematics_10 = snapshot.child("Mathematics_10").getValue(String.class);
                String Physics = snapshot.child("Physics").getValue(String.class);
                String Russian = snapshot.child("Russian").getValue(String.class);
                String TheWorldHistory = snapshot.child("TheWorldHistory").getValue(String.class);
                String classGroup = snapshot.child("classGroup").getValue(String.class);

                tvWHis.setText(TheWorldHistory);
                tvKMW.setText(KMW);
                tvHisKaz.setText(HistoryOfKazakhstan);
                tvGeo.setText(Geography);
                tvRUS.setText(Russian);
                tvKAZ.setText(Kazakh);
                tvENG.setText(English);
                tvInf.setText(Informatics);
                tvPhys.setText(Physics);
                tvChem.setText(Chemistry);
                tvBio.setText(Biology);
                tvMath10.setText(Mathematics_10);
                tvMath.setText(Mathematics);
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