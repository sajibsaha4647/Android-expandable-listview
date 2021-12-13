package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    List <String> HeaderList;
    HashMap<String,List<String>> Headerchild;
    private CustomAdaptar customadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preprableData();
        expandableListView = findViewById(R.id.expandview);
        customadapter = new CustomAdaptar(this,HeaderList,Headerchild);
        expandableListView.setAdapter(customadapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                String groupName = HeaderList.get(i);

                Toast.makeText(MainActivity.this,groupName,Toast.LENGTH_LONG).show();

                return false;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                String groupname = HeaderList.get(i);
                Toast.makeText(MainActivity.this,groupname + "is collups",Toast.LENGTH_LONG).show();
            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                String ChildString = Headerchild.get(HeaderList.get(i)).get(i1);
                Toast.makeText(MainActivity.this,ChildString + "ChildString",Toast.LENGTH_LONG).show();

                return false;

            }
        });

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