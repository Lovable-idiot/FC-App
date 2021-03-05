package com.joker.fcapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.joker.fcapp1.ui.home.HomeFragment;

public class Menu_trial extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference foodlist;
    String CategoryId,key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_trial);

        database=FirebaseDatabase.getInstance();
        foodlist=database.getReference("Food");



        final CardView c1=findViewById(R.id.cardview1);
        final CardView c2 = findViewById(R.id.cardview2);
        final CardView c3 = findViewById(R.id.cardview3);
        final CardView c4 = findViewById(R.id.cardview4);
        if(getIntent()!=null)
            CategoryId=getIntent().getStringExtra("CategoryId");
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Menu_trial.this, Food_trial.class);
                intent1.putExtra("Dish","Dosa");
                startActivity(intent1);

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Menu_trial.this, Food_trial.class);
                intent1.putExtra("Dish","Vada");
                startActivity(intent1);

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Menu_trial.this, Food_trial.class);
                intent1.putExtra("Dish","Chapathi");
                startActivity(intent1);

            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Menu_trial.this, Food_trial.class);
                intent1.putExtra("Dish","Pongal");
                startActivity(intent1);

            }
        });
//            pd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Intent intent1=new Intent(Menu_trial.this,Food_trial.class);
//                foodlist.orderByChild("Name")
//                        .equalTo(pd.getText().toString())
//                        .addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                for(DataSnapshot child1Snapshot:dataSnapshot.getChildren())
//                                    key=child1Snapshot.getKey();
//                                intent1.putExtra("FoodId",key);
//                                startActivity(intent1);
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                            }
//                        });
//        }
//    });
}
}
