package com.sandhya.sashwat.employee_db;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
    EditText employeeid,employeeName,employeeSalary;
    Button Insert,Delete,Update,View,ViewAll;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=openOrCreateDatabase("EmployeeDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Employee(Emp_id VARCHAR,name VARCHAR, salary VARCHAR);");

        employeeid=(EditText)findViewById(R.id.empid);
        employeeName=(EditText)findViewById(R.id.Name);
        employeeSalary=(EditText)findViewById(R.id.Salary);

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

    }
    public void onClick(View view) {
        if(view==Insert)
        {            // Checking for empty fields
            if(employeeid.getText().toString().trim().length()==0||
                    employeeName.getText().toString().trim().length()==0||
                    employeeSalary.getText().toString().trim().length()==0)
            {
                showMessage("Eror", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO Employee VALUES('"+employeeid.getText()+"','"+employeeName.getText()+
                    "','"+employeeSalary.getText()+"');");
            showMessage("Success", "Record added");
            clearText();
        }
        if(view==Delete)
        {
            // Checking for empty roll number
            if(employeeid.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Emp_id");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM Employee WHERE Emp_id='"+employeeid.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM Employee WHERE Emp_id='"+employeeid.getText()+"'");
                showMessage("Success", "Record Deleted");
            }
            else
            {
                showMessage("Error", "Invalid Emp_id");
            }
            clearText();
        }
        if(view==Update)
        {
            // Checking for empty roll number
            if(employeeid.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Emp_id");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM Employee WHERE Emp_id='"+employeeid.getText()+"'", null);
            if(c.moveToFirst()) {
                db.execSQL("UPDATE Employee SET name='" + employeeName.getText() + "',salary='" + employeeSalary.getText()+
                        "' WHERE Emp_id='"+employeeid.getText()+"'");
                showMessage("Success", "Record Modified");
            }
            else {
                showMessage("Error", "Invalid Emp_id");
            }
            clearText();
        }
        if(view==View)
        {
            // Checking for empty roll number
            if(employeeid.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Emp_id");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM Employee WHERE Emp_id='"+employeeid.getText()+"'", null);
            if(c.moveToFirst())
            {
                employeeName.setText(c.getString(1));
                employeeSalary.setText(c.getString(2));
            }
            else
            {
                showMessage("Error", "Invalid Emp_id");
                clearText();
            }
        }
        if(view==ViewAll)
        {
            Cursor c=db.rawQuery("SELECT * FROM Employee", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Emp_id: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Salary: "+c.getString(2)+"\n\n");
            }
            showMessage("Employee Details", buffer.toString());
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
        employeeid.setText("");
        employeeName.setText("");
        employeeSalary.setText("");
        employeeid.requestFocus();
    }
}
