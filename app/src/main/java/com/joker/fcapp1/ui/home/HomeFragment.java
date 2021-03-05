package com.joker.fcapp1.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.joker.fcapp1.Menu_trail2;
import com.joker.fcapp1.Menu_trail3;
import com.joker.fcapp1.Menu_trail4;
import com.joker.fcapp1.Menu_trial;
import com.joker.fcapp1.R;
import com.joker.fcapp1.mobileverification;
import com.joker.fcapp1.ui.profile.ProfileFragment;

public class HomeFragment extends Fragment {

    FirebaseDatabase database;
    DatabaseReference category;
    String key;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        database=FirebaseDatabase.getInstance();
        category=database.getReference("Shops");
        final String s1="Lakshmi Bhavan";
        final CardView c1 = root.findViewById(R.id.cardview1);
        final CardView c2 = root.findViewById(R.id.cardview2);
        final CardView c3 = root.findViewById(R.id.cardview3);
        final CardView c4 = root.findViewById(R.id.cardview4);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeFragment.this.getActivity(), Menu_trial.class));

                    }
                });
                c2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeFragment.this.getActivity(), Menu_trail2.class));

                    }
                });
                c3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeFragment.this.getActivity(), Menu_trail3.class));

                    }
                });
                c4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(HomeFragment.this.getActivity(), Menu_trail4.class));

                    }
                });
            }
        });
        return root;
    }
}
//    final Intent intent=new Intent(HomeFragment.this.getActivity(), Menu_trial.class);
//                        category.orderByChild("Name")
//                                .equalTo("Lakshmi Bhavan")
//                                .addListenerForSingleValueEvent(new ValueEventListener() {
//                                    @Override
//                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                        for(DataSnapshot childSnapshot:dataSnapshot.getChildren())
//                                            key=childSnapshot.getKey();
//                                        intent.putExtra("CategoryId",key);
//                                        startActivity(intent);
//                                    }
//
//                                    @Override
//                                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                                    }
//                                });