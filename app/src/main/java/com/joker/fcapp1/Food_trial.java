package com.joker.fcapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.joker.fcapp1.Database.Database;
import com.joker.fcapp1.Model.Food;
import com.joker.fcapp1.Model.Order;

public class Food_trial extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference foodlist,cart;

    TextView food_name,total,total_cost,summa;
    Button inc,dec,cartbutton;
    EditText quantity;

    String FoodId,fn;
    int n=1;
    String cost,userKey;
    int int_cost,t_cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_trial);
//        String dish=getIntent().getStringExtra("Dish");
        database=FirebaseDatabase.getInstance();
        foodlist=database.getReference("Foods");
        cart=database.getReference("Cart");

        food_name=findViewById(R.id.textView2);
        total=findViewById(R.id.textView3);
        total_cost=findViewById(R.id.textView4);
        dec=findViewById(R.id.button5);
        inc=findViewById(R.id.button6);
        quantity=findViewById(R.id.editText);
        cartbutton=findViewById(R.id.button7);
//        summa=findViewById(R.id.textView5);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userKey = user.getUid();
        foodlist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(FoodId).exists()){
                    int_cost=dataSnapshot.child(FoodId).child("Cost").getValue(Integer.class);
//                    final Food food=dataSnapshot.child(FoodId).getValue(Food.class);
//                    fn=food.getName();
//                    food_name.setText(food.getName());
//                    cost=int_cost.toString();
                    cost=Integer.toString(int_cost);
                    total_cost.setText(cost);
                    cartbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            cart.child(userKey).child(FoodId).setValue(n);
//                                new Database(getBaseContext()).addToCart(new Order(FoodId,food.getName(),quantity.getText().toString(),total_cost.getText().toString()));
                            Toast.makeText(Food_trial.this,"Added to Cart",Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        if(getIntent()!=null)
            FoodId=getIntent().getStringExtra("Dish");
        if(!FoodId.isEmpty()&&FoodId!=null){
//            summa.setText(FoodId);
            food_name.setText(FoodId);

//            summa.setVisibility(View.GONE);
            quantity.setText(Integer.toString(n));
            inc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    n++;
                    quantity.setText(Integer.toString(n));
                    t_cost=n*int_cost;
                    total_cost.setText(Integer.toString(t_cost));
                }
            });
            dec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    n--;
                    quantity.setText(Integer.toString(n));
                    t_cost=n*int_cost;
                    total_cost.setText(Integer.toString(t_cost));
                }
            });



        }


    }
}
