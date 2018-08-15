package my.edu.utem.simplerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        CustomAdapter adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    //Utk find view id
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView wordTextView;
        public CustomViewHolder(LayoutInflater inflater, ViewGroup parent) {
            //utk buat row kena inflater, custom_row tu file yg kita create tadi
            super(inflater.inflate(R.layout.custom_row, parent, false));
            //instead of findView shj, kita kena link kan dgn itemView
            wordTextView = itemView.findViewById(R.id.wordTextView);
        }
    }

    //utk keluarkan data
    public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

        //create constructor
        public CustomAdapter() {

        }

        //customViewHolder akan link ke custom row
        //view holder mana yg nak tunjuk --> custom row lah...
        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()),viewGroup);
        }

        //utk setiap row nak keluarkan data apa
        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
            customViewHolder.wordTextView.setText("This is row " + i);
        }

        //berapa row nak keluarkan
        @Override
        public int getItemCount() {
            return 10;
        }
    }
}
