package com.aidanblant.todolast_v1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] testArray = {"Rent a car", "Turn in car title"};

    LinearLayout todoList;
    EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TodoArray = new String[100];
//        TodoArray[0] = "Rent a car";
//        TodoArray[1] = "Turn in car title";

        // Get current List from Shared Preferences
        // TODO

        mEditText = (EditText) findViewById(R.id.addtodo_text);
        todoList = (LinearLayout) findViewById(R.id.todo_list);

        addTestArrayItems();

    }

    // Test method
    void addTestArrayItems(){
        for( int i = 0; i < testArray.length; i++ ){
            todoList.addView( returnTodoItem(testArray[i]) );
        }
    }

    // Create View Element for TodoItem
    public void addTodoItem(View view) {
        // Get Text
        String newTodoDes = mEditText.getText().toString();

        Toast toast = Toast.makeText(this, newTodoDes, Toast.LENGTH_SHORT);
        toast.show();

        if(newTodoDes.isEmpty() || newTodoDes == null || newTodoDes.equals("") || newTodoDes.length() == 0){
            return;
        }else{
            todoList.addView(returnTodoItem(newTodoDes));
        }

        mEditText.setText("");
    }



    public LinearLayout returnTodoItem(String todoText){
        // Create new LinearLayout and set to Horizontal
        LinearLayout newTodoItem = (LinearLayout) new LinearLayout(this);
        newTodoItem.setOrientation(LinearLayout.HORIZONTAL);
        newTodoItem.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        //Completed Button
        Button todoDoneButton = (Button) new Button(this);
        //todoDone.setLayoutParams( new LinearLayout.LayoutParams(20,20));
        //todoDone.setHeight( (int) getResources().getDimension(R.dimen.box_size) );
        newTodoItem.addView(todoDoneButton);

        todoDoneButton.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
                todoDone(v);
            }
        }) ;

//        todoDoneButton.setOnClickListener(
//                public void onClick(View v){
//                    todoDone(v);
//                }
//        );

        //todoItem Description
        TextView todoDes = (TextView) new TextView(this);
        //todoDes.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        todoDes.setText(todoText);
        newTodoItem.addView(todoDes);

        return newTodoItem;
    }


    public void todoDone(View view) {

        ViewGroup parentView = (ViewGroup) view.getParent().getParent();
        View child = (View) view.getParent();

        parentView.removeView(child);

        Toast toast = Toast.makeText(this, "Toast: ", Toast.LENGTH_SHORT);
        toast.show();
    }

}
