package com.example.noel.inyouropinion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

public class HomeActivity extends AppCompatActivity {

    String question4reply;
    String Jstring;
    String Cstring;
    String Pstring;
    String question2reply;
    String question3reply;
    String question5reply;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void Java_clicked(View view) {
        CheckBox JBox = findViewById(R.id.Java_Checkbox);
        boolean isJchecked = JBox.isChecked();
        if (isJchecked){
            Jstring = "Java";
        }
    }


    public void C_clicked(View view) {
        CheckBox CBox = findViewById(R.id.C_Checkbox);
        boolean isCchecked = CBox.isChecked();
        if (isCchecked){
            Cstring = "C++";
        }
    }

    public void Python_clicked(View view) {
        CheckBox PBox = findViewById(R.id.Python_Checkbox);
        boolean isPchecked = PBox.isChecked();
        if (isPchecked){
            Pstring = "Python";
        }
    }

    public void question2_rb(View view) {
        RadioButton Question2a = findViewById(R.id.inPerson_rb);
        RadioButton Question2b = findViewById(R.id.inGroup_rb);
        boolean personIsClicked = Question2a.isChecked();
        boolean groupIsClicked = Question2b.isChecked();

        if (personIsClicked){
            question2reply = "Person";
        }else {
            question2reply = "Group";
        }
    }
    public void question3_rb(View view) {
        RadioButton Question3a = findViewById(R.id.Yes3_rb);
        RadioButton Question3b = findViewById(R.id.Maybe3_rb);
        boolean yes3IsClicked = Question3a.isChecked();
        boolean maybe3IsClicked = Question3b.isChecked();

        if (yes3IsClicked){
            question3reply = "Yes";
        }else {
            question3reply = "Maybe";
        }
    }

    public void question4_rb(View view) {
        RadioButton Question4a = findViewById(R.id.yes4_rb);
        RadioButton Question4b = findViewById(R.id.No4_rb);
        boolean yes4IsClicked = Question4a.isChecked();
        boolean no4IsClicked = Question4b.isChecked();

        if (yes4IsClicked){
            question4reply = "Yes";
        }else {
            question4reply = "No";
        }
    }

    public void question5_rb(View view) {
        RadioButton Question5a = findViewById(R.id.sure5_rb);
        RadioButton Question5b = findViewById(R.id.Nope5_rb);
        boolean sureIsClicked = Question5a.isChecked();
        boolean NopeIsClicked = Question5b.isChecked();

        if (sureIsClicked){
            question5reply = "Sure";
        }else {
            question5reply = "Nope";
        }
    }
    public String finalMessage(){
        String message;
        message = "** Send this mail to \"noelnwaelugo@gmail\".com **";
        message = message + "\n    ";
        message = message +"\n1: Programming Language: " + Jstring +" "+ Cstring +" " + Pstring;
        message = message + "\n2: I prefer coding in: " + question2reply;
        message = message + "\n3: My reply is: " + question3reply;
        message = message + "\n4: For the Meetups: " + question4reply;
        message = message + "\n5: Project for FUTO: " + question5reply;
        return message;
    }

    public void SubmitButton(View view) {
        EditText theName = findViewById(R.id.your_name);
        String name = theName.getText().toString();
        String theMessage = finalMessage();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, name +"'s Opinion:" );
        intent.putExtra(Intent.EXTRA_TEXT, theMessage );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}



