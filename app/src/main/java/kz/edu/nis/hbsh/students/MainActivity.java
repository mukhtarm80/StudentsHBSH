package kz.edu.nis.hbsh.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button scanBtn,btnFindStudent;
    String id_barcode;
    EditText etResult_txt;

    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    StorageReference mStorageRef;
    ImageView ivScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ivScan= findViewById(R.id.ivScan);
        mStorageRef = FirebaseStorage.getInstance().getReference("imgSotr");

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

    String   image_idS = "https://firebasestorage.googleapis.com/v0/b/school-plants.appspot.com/o/imgStudent%2F020314601286.jpg?alt=media&token=69432ba9-62a2-4101-9cf2-c7496504c16c";
    Picasso.get().load(image_idS).into(ivScan);
        etResult_txt = findViewById(R.id.etResult_txt);
        scanBtn = findViewById(R.id.scan_btn);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanCode();
            }
        });
        btnFindStudent = findViewById(R.id.btnFindStudent);
        btnFindStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_barcode= etResult_txt.getText().toString().substring(0,12);
                //  id_barcode= resultTxt.getText().toString();
                Intent i = new Intent(MainActivity.this,Pupil.class);
                i.putExtra("id_barcode",id_barcode);
                startActivity(i);
                // finish();
            }
        });
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }
    public void ClickScan(View view){
        recreate();
    }
    public void ClickStudents(View view){
        redirectActivity(this, Students.class);
    }
    public void ClickSchedule(View view){
        redirectActivity(this, Schedule.class);
    }
    public void ClickTeachers(View view){
        redirectActivity(this, Teachers.class);
    }
    public void ClickLogout(View view){
        logout(this);
    }
    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void logout(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Выход");
        builder.setMessage("Вы действительно хотите закрыть приложение?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {

    @Override
    public void onClick(DialogInterface dialog, int which) {
               activity.finishAffinity();
               System.exit(0);
            }
        });
        builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
    @Override
    protected  void  onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }

    private void scanCode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Сканируем...");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        final IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                builder.setTitle("Результат");
                builder.setPositiveButton("Сканировать заново", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        scanCode();
                    }
                }).setNegativeButton("Готово", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish();
                        etResult_txt.setText(result.getContents());

                        id_barcode= etResult_txt.getText().toString().substring(0,12);
                        //  id_barcode= resultTxt.getText().toString();
                        Intent i = new Intent(MainActivity.this,Pupil.class);
                        i.putExtra("id_barcode",id_barcode);
                        startActivity(i);
                        // finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                Toast.makeText(this, "штрих код не распознан", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}