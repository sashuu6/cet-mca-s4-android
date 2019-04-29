package com.sandhya.sashwat.myapplication.student_db;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener
{
    EditText empid,Name,Salary,Age;
    Button Insert,Delete,Update,View,ViewAll;
    SQLiteDatabase db;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(empid VARCHAR,name VARCHAR,Salary VARCHAR,Age VARCHAR);");

        empid=(EditText)findViewById(R.id.empid);
        Name=(EditText)findViewById(R.id.Name);
        Salary=(EditText)findViewById(R.id.Salary);
        Age=(EditText)findViewById(R.id.Age);

        Insert=(Button)findViewById(R.id.Insert);
        Delete=(Button)findViewById(R.id.Delete);
        Update=(Button)findViewById(R.id.Update);
        View=(Button)findViewById(R.id.View);
        ViewAll=(Button)findViewById(R.id.ViewAll);

        Insert.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Update.setOnClickListener(this);
        View.setOnClickListener(this);
        ViewAll.setOnClickListener(this);

        // Creating database and table

    }
    public void onClick(View view)
    {
        // Inserting a record to the Student table
        if(view==Insert)
        {            // Checking for empty fields
            if(empid.getText().toString().trim().length()==0||
                    Name.getText().toString().trim().length()==0||
                    Salary.getText().toString().trim().length()==0||
                    Age.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter all values");
                return;
            }
            Toast.makeText(getApplicationContext(),"fgffhfhf",Toast.LENGTH_LONG).show();
            db.execSQL("INSERT INTO student VALUES('"+empid.getText()+"','"+Name.getText()+"','"+Salary.getText()+"','"+Age.getText()+"');");
            showMessage("Success", "Record added");
            clearText();
        }
        // Deleting a record from the Student table
        if(view==Delete)
        {
            // Checking for empty roll number
            if(empid.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter empid");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE empid='"+empid.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM student WHERE empid='"+empid.getText()+"'");
                showMessage("Success", "Record Deleted");
            }
            else
            {
                showMessage("Error", "Invalid empid");
            }
            clearText();
        }
        // Updating a record in the Student table
        if(view==Update)
        {
            // Checking for empty roll number
            if(empid.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter empid");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE empid='"+empid.getText()+"'", null);
            if(c.moveToFirst()) {
                db.execSQL("UPDATE student SET name='" + Name.getText() + "',Salary='" + Salary.getText() +
                        "',Age='"+Age.getText()+"' WHERE empid='"+empid.getText()+"'");
                showMessage("Success", "Record Modified");
            }
            else {
                showMessage("Error", "Invalid empid");
            }
            clearText();
        }
        // Display a record from the Student table
        if(view==View)
        {
            // Checking for empty roll number
            if(empid.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter empid");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE empid='"+empid.getText()+"'", null);
            if(c.moveToFirst())
            {
                Name.setText(c.getString(1));
                Salary.setText(c.getString(2));
            }
            else
            {
                showMessage("Error", "Invalid empid");
                clearText();
            }
        }
        // Displaying all the records
        if(view==ViewAll)
        {
            Cursor c=db.rawQuery("SELECT * FROM student", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("empid: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Salary: "+c.getString(2)+"\n\n");
                buffer.append("Age: "+c.getString(3)+"\n\n");
            }
            showMessage("Student Details", buffer.toString());
        }
    }
    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        empid.setText("");
        Name.setText("");
        Salary.setText("");
        Age.setText("");
        empid.requestFocus();
    }
}