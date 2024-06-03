package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name : John Doe", "Hospital Address : 123 Hospital St", "Exp : 15yrs", "Mobile No : 123-456-7890","600"},
            {"Doctor Name : Jane Smith", "Hospital Address : 456 Clinic Rd", "Exp : 10yrs", "Mobile No : 234-567-8901","900"},
            {"Doctor Name : Sam Brown", "Hospital Address : 789 Health Ave", "Exp : 8yrs", "Mobile No : 345-678-9012","300"},
            {"Doctor Name : Lisa White", "Hospital Address : 101 Medical Blvd", "Exp : 12yrs", "Mobile No : 456-789-0123","500"},
            {"Doctor Name : Mark Green", "Hospital Address : 202 Wellness Dr", "Exp : 20yrs", "Mobile No : 567-890-1234","800"}
    };
    private String[][] doctor_details2 = {
            {"Doctor Name : Emma Thompson", "Hospital Address : 321 Clinic St", "Exp : 18yrs", "Mobile No : 678-901-2345", "1600"},
            {"Doctor Name : Olivia Johnson", "Hospital Address : 654 Health Rd", "Exp : 14yrs", "Mobile No : 789-012-3456", "1400"},
            {"Doctor Name : Liam Williams", "Hospital Address : 987 Hospital Ave", "Exp : 9yrs", "Mobile No : 890-123-4567", "1100"},
            {"Doctor Name : Noah Davis", "Hospital Address : 111 Medical St", "Exp : 11yrs", "Mobile No : 901-234-5678", "1250"},
            {"Doctor Name : Ava Martinez", "Hospital Address : 222 Wellness Blvd", "Exp : 22yrs", "Mobile No : 012-345-6789", "2100"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name : Emily Johnson", "Hospital Address : 300 Health St", "Exp : 14yrs", "Mobile No : 678-123-4567", "1600"},
            {"Doctor Name : Michael Brown", "Hospital Address : 789 Clinic Ave", "Exp : 11yrs", "Mobile No : 789-234-5678", "1400"},
            {"Doctor Name : Sarah Davis", "Hospital Address : 654 Wellness Blvd", "Exp : 9yrs", "Mobile No : 890-345-6789", "1100"},
            {"Doctor Name : Robert Miller", "Hospital Address : 321 Medical Rd", "Exp : 13yrs", "Mobile No : 901-456-7890", "1700"},
            {"Doctor Name : Jessica Wilson", "Hospital Address : 222 Hospital Dr", "Exp : 18yrs", "Mobile No : 012-567-8901", "1900"}
    };

    private String[][] doctor_details4 = {
            {"Doctor Name : David Anderson", "Hospital Address : 123 Clinic St", "Exp : 16yrs", "Mobile No : 123-678-9012", "1800"},
            {"Doctor Name : Laura Martinez", "Hospital Address : 456 Health Blvd", "Exp : 12yrs", "Mobile No : 234-789-0123", "1300"},
            {"Doctor Name : Chris Harris", "Hospital Address : 789 Medical Ave", "Exp : 7yrs", "Mobile No : 345-890-1234", "900"},
            {"Doctor Name : Karen Clark", "Hospital Address : 101 Wellness Rd", "Exp : 10yrs", "Mobile No : 456-901-2345", "1200"},
            {"Doctor Name : James Lewis", "Hospital Address : 202 Clinic Dr", "Exp : 19yrs", "Mobile No : 567-012-3456", "2000"}
    };

    private String[][] doctor_details5 = {
            {"Doctor Name : Patricia Walker", "Hospital Address : 300 Medical St", "Exp : 17yrs", "Mobile No : 678-123-9012", "1700"},
            {"Doctor Name : Andrew Hall", "Hospital Address : 789 Health Blvd", "Exp : 11yrs", "Mobile No : 789-234-0123", "1400"},
            {"Doctor Name : Jennifer Allen", "Hospital Address : 654 Clinic Ave", "Exp : 9yrs", "Mobile No : 890-345-1234", "1100"},
            {"Doctor Name : Thomas Young", "Hospital Address : 321 Wellness Rd", "Exp : 13yrs", "Mobile No : 901-456-2345", "1500"},
            {"Doctor Name : Michelle King", "Hospital Address : 222 Hospital Blvd", "Exp : 20yrs", "Mobile No : 012-567-3456", "1900"}
    };


    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv= findViewById(R.id.textView_logo6);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i =0; i< doctor_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst= findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}