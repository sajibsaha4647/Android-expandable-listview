package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    List <String> HeaderList;
    HashMap<String,List<String>> Headerchild;
    private Customadapter customadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandview);

        customadapter = new Customadapter(this,HeaderList,Headerchild);
        expandableListView.setAdapter(customadapter);

        preprableData();

    }

    public void  preprableData(){
        String [] HeadString = getResources().getStringArray(R.array.Abbrivation_short);
        String [] Childreds = getResources().getStringArray(R.array.Abbrivation_details);

        HeaderList  = new ArrayList<>();
        Headerchild  = new HashMap<>();

        for(int i = 0; i<HeadString.length;i++){
            HeaderList.add(HeadString[i]);

            List<String>child = new ArrayList<>();

            child.add(Childreds[i]);

            Headerchild.put(HeaderList.get(i),child);



        }


    }


}