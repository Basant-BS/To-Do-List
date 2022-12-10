package com.example.task4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    private ArrayList<ToDoModel> TodoList = new ArrayList<>();
    public ToDoAdapter(ArrayList<ToDoModel> TodoList){
        this.TodoList = TodoList;
    }


    @NonNull
    @Override
    public ToDoAdapter.ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoAdapter.ToDoViewHolder holder, int position) {
        holder.checkBox.setText(TodoList.get(position).getTodo());
    }

    @Override
    public int getItemCount() {
        return TodoList.size();
    }

    public void setTodoList(ArrayList<ToDoModel> ToDoList){
        this.TodoList = ToDoList;
        notifyDataSetChanged();
    }

    public class ToDoViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        public ToDoViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
