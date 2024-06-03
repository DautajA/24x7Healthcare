package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Medicine 1: Paracetamol", "", "", "", "100"},
            {"Medicine 2: Ibuprofen", "", "", "", "150"},
            {"Medicine 3: Amoxicillin", "", "", "", "200"},
            {"Medicine 4: Cough Syrup", "", "", "", "120"},
            {"Medicine 5: Vitamin C", "", "", "", "80"},
            {"Medicine 6: Aspirin", "", "", "", "110"},
            {"Medicine 7: Metformin", "", "", "", "180"},
            {"Medicine 8: Amlodipine", "", "", "", "220"},
            {"Medicine 9: Omeprazole", "", "", "", "250"},
            {"Medicine 10: Atorvastatin", "", "", "", "300"}
    };

    private String[] package_details = {
            "Active Ingredient: Paracetamol\n" +
                    "Strength: 500mg\n" +
                    "Form: Tablet\n" +
                    "Uses: Pain relief, fever reduction\n" +
                    "Side Effects: Nausea, rash\n" +
                    "Dosage: 1-2 tablets every 4-6 hours\n" +
                    "Manufacturer: XYZ Pharmaceuticals",
            "Active Ingredient: Ibuprofen\n" +
                    "Strength: 200mg\n" +
                    "Form: Tablet\n" +
                    "Uses: Pain relief, anti-inflammatory\n" +
                    "Side Effects: Stomach upset, dizziness\n" +
                    "Dosage: 1-2 tablets every 4-6 hours\n" +
                    "Manufacturer: ABC Pharma",
            "Active Ingredient: Amoxicillin\n" +
                    "Strength: 250mg\n" +
                    "Form: Capsule\n" +
                    "Uses: Bacterial infections\n" +
                    "Side Effects: Diarrhea, allergic reactions\n" +
                    "Dosage: 1 capsule every 8 hours\n" +
                    "Manufacturer: HealthMed Inc.",
            "Active Ingredient: Dextromethorphan\n" +
                    "Strength: 10mg/5ml\n" +
                    "Form: Syrup\n" +
                    "Uses: Cough suppression\n" +
                    "Side Effects: Drowsiness, dizziness\n" +
                    "Dosage: 10ml every 6-8 hours\n" +
                    "Manufacturer: Cough Relief Co.",
            "Active Ingredient: Vitamin C (Ascorbic Acid)\n" +
                    "Strength: 500mg\n" +
                    "Form: Tablet\n" +
                    "Uses: Immune support, antioxidant\n" +
                    "Side Effects: Stomach upset, diarrhea\n" +
                    "Dosage: 1 tablet daily\n" +
                    "Manufacturer: VitaHealth Ltd.",
            "Active Ingredient: Aspirin\n" +
                    "Strength: 300mg\n" +
                    "Form: Tablet\n" +
                    "Uses: Pain relief, anti-inflammatory, blood thinner\n" +
                    "Side Effects: Stomach upset, bleeding\n" +
                    "Dosage: 1 tablet every 4-6 hours\n" +
                    "Manufacturer: PharmaCorp",
            "Active Ingredient: Metformin\n" +
                    "Strength: 500mg\n" +
                    "Form: Tablet\n" +
                    "Uses: Blood sugar control\n" +
                    "Side Effects: Nausea, diarrhea\n" +
                    "Dosage: 1 tablet twice daily\n" +
                    "Manufacturer: HealthPlus",
            "Active Ingredient: Amlodipine\n" +
                    "Strength: 5mg\n" +
                    "Form: Tablet\n" +
                    "Uses: Blood pressure control\n" +
                    "Side Effects: Swelling, dizziness\n" +
                    "Dosage: 1 tablet daily\n" +
                    "Manufacturer: CardioMed",
            "Active Ingredient: Omeprazole\n" +
                    "Strength: 20mg\n" +
                    "Form: Capsule\n" +
                    "Uses: Acid reflux, stomach ulcers\n" +
                    "Side Effects: Headache, nausea\n" +
                    "Dosage: 1 capsule daily\n" +
                    "Manufacturer: GastroCare",
            "Active Ingredient: Atorvastatin\n" +
                    "Strength: 10mg\n" +
                    "Form: Tablet\n" +
                    "Uses: Cholesterol control\n" +
                    "Side Effects: Muscle pain, nausea\n" +
                    "Dosage: 1 tablet daily\n" +
                    "Manufacturer: CholesterolRx"
    };


    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_medicine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMAddToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i< packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" +packages[i][4]+ "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}