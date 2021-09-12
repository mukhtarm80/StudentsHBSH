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

public class Class_schedule extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView tvKL;
    TextView less10_1,less10_2,less10_3,less10_4,less10_5,less10_6,less10_1a,less10_2a,less10_3a,less10_4a,less10_5a,less10_6a,
    less10_1b,less10_2b,less10_3b,less10_4b,less10_5b,less10_6b,less10_7b,less10_8b,less10_1c,less10_2c,less10_3c,less10_4c,less10_5c,less10_6c,less10_1e,less10_2e,less10_3e,less10_4e,less10_5e,less10_6e,less10_7e,less10_8e,less10_9e,less10_10e,less10_11e,less10_12e,
    less10_1d,less10_2d,less10_3d,less10_4d,less10_5d,less10_6d,less10_7d,less10_8d,less10_9d,less10_10d,less10_11d,less10_12d, lessMon1,lessMon2,lessMon3,lessMon4,lessMon5,lessMon6,
    lessTue1,lessTue2,lessTue3,lessTue4,lessTue5,lessTue6,lessWed1,lessWed2,lessWed3,lessWed4,lessWed5,lessWed6,lessWed7,lessWed8,lessThu1,lessThu2,lessThu3,lessThu4,lessThu5,lessThu6,
    lessFri1,lessFri2,lessFri3,lessFri4,lessFri5,lessFri6, lessFri7,lessFri8,lessFri9,lessFri10,lessFri11,lessFri12,lessSat1,lessSat2,lessSat3,lessSat4,lessSat5,lessSat6, lessSat7,lessSat8,lessSat9,lessSat10,lessSat11,lessSat12;
String kl, l10_1, l10_2, l10_3, l10_4, l10_5, l10_6, l10_7, l10_8, l10_9, l10_10, l10_11, l10_12,  l12_1, l12_2, l12_3, l12_4, l12_5, l12_6, l12_7, l12_8, l12_9, l12_10, l12_11, l12_12,
    lMon1,lMon2,lMon3,lMon4,lMon5,lMon6, lTue1,lTue2,lTue3,lTue4,lTue5,lTue6,lWed1,lWed2,lWed3,lWed4,lWed5,lWed6,lWed7,lWed8,lThu1,lThu2,lThu3,lThu4,lThu5,lThu6, lFri1,lFri2,lFri3,lFri4,lFri5,lFri6,lFri7,lFri8,lFri9,lFri10,lFri11,lFri12,
    lSat1,lSat2,lSat3,lSat4,lSat5,lSat6,lSat7,lSat8,lSat9,lSat10,lSat11,lSat12;
    FirebaseDatabase db;
    DatabaseReference rootRef,tmtbl,tm, lessons;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_schedule);

        db = FirebaseDatabase.getInstance();
       rootRef = db.getReference();
       tmtbl= db.getReference("Timetable");
        tm = tmtbl.child("time");
        lessons = tmtbl.child("Lessons");
        
        tvKL = findViewById(R.id.tv_KlassR);
        Intent i = getIntent();
        kl = i.getStringExtra("KlassR");
        tvKL.setText( i.getStringExtra("KlassR"));

        drawerLayout = findViewById(R.id.drawer_layout);
        TextView toolbar_txt = findViewById(R.id.toolbar_txt);
        toolbar_txt.setText("Расписание");

        less10_1 = findViewById(R.id.less10_1);
        less10_2 = findViewById(R.id.less10_2);
        less10_3 = findViewById(R.id.less10_3);
        less10_4 = findViewById(R.id.less10_4);
        less10_5 = findViewById(R.id.less10_5);
        less10_6 = findViewById(R.id.less10_6);
        less10_1a = findViewById(R.id.less10_1a);
        less10_2a = findViewById(R.id.less10_2a);
        less10_3a = findViewById(R.id.less10_3a);
        less10_4a = findViewById(R.id.less10_4a);
        less10_5a = findViewById(R.id.less10_5a);
        less10_6a = findViewById(R.id.less10_6a);
        less10_1b = findViewById(R.id.less10_1b);
        less10_2b = findViewById(R.id.less10_2b);
        less10_3b = findViewById(R.id.less10_3b);
        less10_4b = findViewById(R.id.less10_4b);
        less10_5b = findViewById(R.id.less10_5b);
        less10_6b = findViewById(R.id.less10_6b);
        less10_7b = findViewById(R.id.less10_7b);
        less10_8b = findViewById(R.id.less10_8b);

        less10_1c = findViewById(R.id.less10_1c);
        less10_2c = findViewById(R.id.less10_2c);
        less10_3c = findViewById(R.id.less10_3c);
        less10_4c = findViewById(R.id.less10_4c);
        less10_5c = findViewById(R.id.less10_5c);
        less10_6c = findViewById(R.id.less10_6c);
        less10_1d = findViewById(R.id.less10_1d);
        less10_2d = findViewById(R.id.less10_2d);
        less10_3d = findViewById(R.id.less10_3d);
        less10_4d = findViewById(R.id.less10_4d);
        less10_5d = findViewById(R.id.less10_5d);
        less10_6d = findViewById(R.id.less10_6d);
        less10_7d = findViewById(R.id.less10_7d);
        less10_8d = findViewById(R.id.less10_8d);
        less10_9d = findViewById(R.id.less10_9d);
        less10_10d = findViewById(R.id.less10_10d);
        less10_11d = findViewById(R.id.less10_11d);
        less10_12d = findViewById(R.id.less10_12d);
        less10_1e = findViewById(R.id.less10_1e);
        less10_2e = findViewById(R.id.less10_2e);
        less10_3e = findViewById(R.id.less10_3e);
        less10_4e = findViewById(R.id.less10_4e);
        less10_5e = findViewById(R.id.less10_5e);
        less10_6e = findViewById(R.id.less10_6e);
        less10_7e = findViewById(R.id.less10_7e);
        less10_8e = findViewById(R.id.less10_8e);
        less10_9e = findViewById(R.id.less10_9e);
        less10_10e = findViewById(R.id.less10_10e);
        less10_11e = findViewById(R.id.less10_11e);
        less10_12e = findViewById(R.id.less10_12e);
        lessMon1 = findViewById(R.id.lessMon1);
        lessMon2 = findViewById(R.id.lessMon2);
        lessMon3 = findViewById(R.id.lessMon3);
        lessMon4 = findViewById(R.id.lessMon4);
        lessMon5 = findViewById(R.id.lessMon5);
        lessMon6 = findViewById(R.id.lessMon6);
        lessTue1 = findViewById(R.id.lessTue1);
        lessTue2 = findViewById(R.id.lessTue2);
        lessTue3 = findViewById(R.id.lessTue3);
        lessTue4 = findViewById(R.id.lessTue4);
        lessTue5 = findViewById(R.id.lessTue5);
        lessTue6 = findViewById(R.id.lessTue6);
        lessWed1 = findViewById(R.id.lessWed1);
        lessWed2 = findViewById(R.id.lessWed2);
        lessWed3 = findViewById(R.id.lessWed3);
        lessWed4 = findViewById(R.id.lessWed4);
        lessWed5 = findViewById(R.id.lessWed5);
        lessWed6 = findViewById(R.id.lessWed6);
        lessWed7 = findViewById(R.id.lessWed7);
        lessWed8 = findViewById(R.id.lessWed8);
        lessThu1 = findViewById(R.id.lessThu1);
        lessThu2 = findViewById(R.id.lessThu2);
        lessThu3 = findViewById(R.id.lessThu3);
        lessThu4 = findViewById(R.id.lessThu4);
        lessThu5 = findViewById(R.id.lessThu5);
        lessThu6 = findViewById(R.id.lessThu6);
        lessFri1 = findViewById(R.id.lessFri1);
        lessFri2 = findViewById(R.id.lessFri2);
        lessFri3 = findViewById(R.id.lessFri3);
        lessFri4 = findViewById(R.id.lessFri4);
        lessFri5 = findViewById(R.id.lessFri5);
        lessFri6 = findViewById(R.id.lessFri6);
        lessFri7 = findViewById(R.id.lessFri7);
        lessFri8 = findViewById(R.id.lessFri8);
        lessFri9 = findViewById(R.id.lessFri9);
        lessFri10 = findViewById(R.id.lessFri10);
        lessFri11 = findViewById(R.id.lessFri11);
        lessFri12 = findViewById(R.id.lessFri12);
        lessSat1 = findViewById(R.id.lessSat1);
        lessSat2 = findViewById(R.id.lessSat2);
        lessSat3 = findViewById(R.id.lessSat3);
        lessSat4 = findViewById(R.id.lessSat4);
        lessSat5 = findViewById(R.id.lessSat5);
        lessSat6 = findViewById(R.id.lessSat6);
        lessSat7 = findViewById(R.id.lessSat7);
        lessSat8 = findViewById(R.id.lessSat8);
        lessSat9 = findViewById(R.id.lessSat9);
        lessSat10 = findViewById(R.id.lessSat10);
        lessSat11 = findViewById(R.id.lessSat11);
        lessSat12 = findViewById(R.id.lessSat12);

     //   tm.orderByKey().equalTo(Klass).addChildEventListener(new ChildEventListener() {
        tmtbl.orderByChild("time").addChildEventListener(new ChildEventListener() {
//FirebaseDatabase.getInstance().getReference().child("Timetable").child("time").orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String l10_1 = snapshot.child("lesson10_1").getValue(String.class);
                String l10_2 = snapshot.child("lesson10_2").getValue(String.class);
                String l10_3 = snapshot.child("lesson10_3").getValue(String.class);
                String l10_4 = snapshot.child("lesson10_4").getValue(String.class);
                String l10_5 = snapshot.child("lesson10_5").getValue(String.class);
                String l10_6 = snapshot.child("lesson10_6").getValue(String.class);
                String l10_7 = snapshot.child("lesson10_7").getValue(String.class);
                String l10_8 = snapshot.child("lesson10_8").getValue(String.class);
                String l10_9 = snapshot.child("lesson10_9").getValue(String.class);
                String l10_10 = snapshot.child("lesson10_10").getValue(String.class);
                String l10_11 = snapshot.child("lesson10_11").getValue(String.class);
                String l10_12 = snapshot.child("lesson10_12").getValue(String.class);
                String l12_1 = snapshot.child("lesson12_1").getValue(String.class);
                String l12_2 = snapshot.child("lesson12_2").getValue(String.class);
                String l12_3 = snapshot.child("lesson12_3").getValue(String.class);
                String l12_4 = snapshot.child("lesson12_4").getValue(String.class);
                String l12_5 = snapshot.child("lesson12_5").getValue(String.class);
                String l12_6 = snapshot.child("lesson12_6").getValue(String.class);

 less10_1.setText(l10_1); less10_1a.setText(l10_1); less10_1b.setText(l10_1); less10_1c.setText(l10_1); less10_1d.setText(l10_1); less10_1e.setText(l10_1);
 less10_2.setText(l10_2); less10_2a.setText(l10_2); less10_2b.setText(l10_2); less10_2c.setText(l10_2); less10_2d.setText(l10_2); less10_2e.setText(l10_2);
 less10_3.setText(l10_3); less10_3a.setText(l10_3); less10_3b.setText(l10_3); less10_3c.setText(l10_3); less10_3d.setText(l10_3); less10_3e.setText(l10_3);
 less10_4.setText(l10_4); less10_4a.setText(l10_4); less10_4b.setText(l10_4); less10_4c.setText(l10_4); less10_4d.setText(l10_4); less10_4e.setText(l10_4);
 less10_5.setText(l10_5); less10_5a.setText(l10_5); less10_5b.setText(l10_5); less10_5c.setText(l10_5); less10_5d.setText(l10_5); less10_5e.setText(l10_5);
 less10_6.setText(l10_6); less10_6a.setText(l10_6); less10_6b.setText(l10_6); less10_6c.setText(l10_6); less10_6d.setText(l10_6); less10_6e.setText(l10_6);
                                                    less10_7b.setText(l10_7);                           less10_7d.setText(l10_7); less10_7e.setText(l10_7);
                                                    less10_8b.setText(l10_8);                           less10_8d.setText(l10_8); less10_8e.setText(l10_8);
                                                                                                        less10_9d.setText(l10_9); less10_9e.setText(l10_9);
                                                                                                        less10_10d.setText(l10_10); less10_10e.setText(l10_10);
                                                                                                        less10_11d.setText(l10_11); less10_11e.setText(l10_11);
                                                                                                        less10_12d.setText(l10_12); less10_12e.setText(l10_12);
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

     /*   l10_1 = "8:30-9:30";
        l10_2 = " ";
        l10_3 = "9:50-10:50";
        l10_4 = " ";
        l10_5 = "11:20-12:20";
        l10_6 = " "; */
 FirebaseDatabase.getInstance().getReference().child("Timetable").child("Lessons").orderByKey().equalTo(kl).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
              String lMon1 = snapshot.child("lesMon1").getValue(String.class);
                String lMon2 = snapshot.child("lesMon2").getValue(String.class);
              String lMon3 = snapshot.child("lesMon3").getValue(String.class);
                String lMon4 = snapshot.child("lesMon4").getValue(String.class);
                String lMon5 = snapshot.child("lesMon5").getValue(String.class);
                String lMon6 = snapshot.child("lesMon6").getValue(String.class);
                String lTue1 = snapshot.child("lesTue1").getValue(String.class);
                String lTue2 = snapshot.child("lesTue2").getValue(String.class);
                String lTue3 = snapshot.child("lesTue3").getValue(String.class);
                String lTue4 = snapshot.child("lesTue4").getValue(String.class);
                String lTue5 = snapshot.child("lesTue5").getValue(String.class);
                String lTue6 = snapshot.child("lesTue6").getValue(String.class);
                String lWed1 = snapshot.child("lesWed1").getValue(String.class);
                String lWed2 = snapshot.child("lesWed2").getValue(String.class);
                String lWed3 = snapshot.child("lesWed3").getValue(String.class);
                String lWed4 = snapshot.child("lesWed4").getValue(String.class);
                String lWed5 = snapshot.child("lesWed5").getValue(String.class);
                String lWed6 = snapshot.child("lesWed6").getValue(String.class);
                String lWed7 = snapshot.child("lesWed7").getValue(String.class);
                String lWed8 = snapshot.child("lesWed8").getValue(String.class);

                String lThu1 = snapshot.child("lesThu1").getValue(String.class);
                String lThu2 = snapshot.child("lesThu2").getValue(String.class);
                String lThu3 = snapshot.child("lesThu3").getValue(String.class);
                String lThu4 = snapshot.child("lesThu4").getValue(String.class);
                String lThu5 = snapshot.child("lesThu5").getValue(String.class);
                String lThu6 = snapshot.child("lesThu6").getValue(String.class);
                String lFri1 = snapshot.child("lesFri1").getValue(String.class);
                String lFri2 = snapshot.child("lesFri2").getValue(String.class);
                String lFri3 = snapshot.child("lesFri3").getValue(String.class);
                String lFri4 = snapshot.child("lesFri4").getValue(String.class);
                String lFri5 = snapshot.child("lesFri5").getValue(String.class);
                String lFri6 = snapshot.child("lesFri6").getValue(String.class);
                String lFri7 = snapshot.child("lesFri7").getValue(String.class);
                String lFri8 = snapshot.child("lesFri8").getValue(String.class);
                String lFri9 = snapshot.child("lesFri9").getValue(String.class);
                String lFri10 = snapshot.child("lesFri10").getValue(String.class);
                String lFri11 = snapshot.child("lesFri11").getValue(String.class);
                String lFri12 = snapshot.child("lesFri12").getValue(String.class);

                String lSat1 = snapshot.child("lesSat1").getValue(String.class);
                String lSat2 = snapshot.child("lesSat2").getValue(String.class);
                String lSat3 = snapshot.child("lesSat3").getValue(String.class);
                String lSat4 = snapshot.child("lesSat4").getValue(String.class);
                String lSat5 = snapshot.child("lesSat5").getValue(String.class);
                String lSat6 = snapshot.child("lesSat6").getValue(String.class);
                String lSat7 = snapshot.child("lesSat7").getValue(String.class);
                String lSat8 = snapshot.child("lesSat8").getValue(String.class);
                String lSat9 = snapshot.child("lesSat9").getValue(String.class);
                String lSat10 = snapshot.child("lesSat10").getValue(String.class);
                String lSat11 = snapshot.child("lesSat11").getValue(String.class);
                String lSat12 = snapshot.child("lesSat12").getValue(String.class);

  //    Toast.makeText(getApplicationContext(), "п1 - " + lMon1+" п2 - " + lMon2, Toast.LENGTH_LONG).show();

                lessMon1.setText(lMon1);
                lessMon2.setText(lMon2);
                lessMon3.setText(lMon3);
                lessMon4.setText(lMon4);
                lessMon5.setText(lMon5);
                lessMon6.setText(lMon6);
                lessTue1.setText(lTue1);
                lessTue2.setText(lTue2);
                lessTue3.setText(lTue3);
                lessTue4.setText(lTue4);
                lessTue5.setText(lTue5);
                lessTue6.setText(lTue6);
                lessWed1.setText(lWed1);
                lessWed2.setText(lWed2);
                lessWed3.setText(lWed3);
                lessWed4.setText(lWed4);
                lessWed5.setText(lWed5);
                lessWed6.setText(lWed6);
                lessWed7.setText(lWed7);
                lessWed8.setText(lWed8);

                lessThu1.setText(lThu1);
                lessThu2.setText(lThu2);
                lessThu3.setText(lThu3);
                lessThu4.setText(lThu4);
                lessThu5.setText(lThu5);
                lessThu6.setText(lThu6);

                lessFri1.setText(lFri1);
                lessFri2.setText(lFri2);
                lessFri3.setText(lFri3);
                lessFri4.setText(lFri4);
                lessFri5.setText(lFri5);
                lessFri6.setText(lFri6);
                lessFri7.setText(lFri7);
                lessFri8.setText(lFri8);
                lessFri9.setText(lFri9);
                lessFri10.setText(lFri10);
                lessFri11.setText(lFri11);
                lessFri12.setText(lFri12);

                lessSat1.setText(lSat1);
                lessSat2.setText(lSat2);
                lessSat3.setText(lSat3);
                lessSat4.setText(lSat4);
                lessSat5.setText(lSat5);
                lessSat6.setText(lSat6);
                lessSat7.setText(lSat7);
                lessSat8.setText(lSat8);
                lessSat9.setText(lSat9);
                lessSat10.setText(lSat10);
                lessSat11.setText(lSat11);
                lessSat12.setText(lSat12);
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