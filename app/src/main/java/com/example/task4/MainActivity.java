package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ToDoModel> toDoList;
    private RecyclerView recyclerView;
    private ImageButton addBTN;
    private EditText addTaskEDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        addBTN = findViewById(R.id.addBTN);
        addTaskEDT = findViewById(R.id.addTaskEDT);
        recyclerView = findViewById(R.id.recycler);
        toDoList = new ArrayList<>();
        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setToDoItem(addTaskEDT.getText().toString());
            }
        });

        setToDoItem();
        setAdapter();
    }



    private void setAdapter() {
        ToDoAdapter adapter = new ToDoAdapter(toDoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setToDoItem(String task){
        toDoList.add(new ToDoModel(task));
    }

    private void setToDoItem() {
        toDoList.add(new ToDoModel("Android Task"));
        toDoList.add(new ToDoModel("web Task"));
        toDoList.add(new ToDoModel("Probability Assignment"));
        toDoList.add(new ToDoModel("Probability quiz"));
        toDoList.add(new ToDoModel("Database project"));
    }
}
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        firstValue = findViewById(R.id.firstValueEDT);
//        secondValue = findViewById((R.id.secondValueEDT));
//        addBtn=findViewById(R.id.addBtn);
//        resultTV=findViewById(R.id.resultTV);
//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!(firstValue.getText().toString().equals(""))
//                        && !(secondValue.getText().toString().equals(""))){
//                    int first =Integer.parseInt(firstValue.getText().toString());
//                    int second = Integer.parseInt(secondValue.getText().toString());
//                    int result = add(first, second);
//                    resultTV.setText(String.valueOf(result));
//                }
//            }
//        });
//
//    }
//
//    private int add(int x, int y){
//        return x+y;
//    }
//
//}