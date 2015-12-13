package android_project.com.doctorassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.Patient;
import database.databasehelper;

public class AjoutPatient extends Activity implements View.OnClickListener{



    databasehelper helper = new databasehelper(this);

    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_patient);

        b1 = (Button)findViewById(R.id.Baddpatient);
        b1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.Baddpatient) {

            Toast temp;

            temp = Toast.makeText(AjoutPatient.this, "successfull!", Toast.LENGTH_SHORT);
            temp.show();

            EditText pname = (EditText) findViewById(R.id.nameetxt);
            EditText paddress = (EditText) findViewById(R.id.addressetxt);
            EditText pcontact = (EditText) findViewById(R.id.contactetxt);
            EditText pemail = (EditText) findViewById(R.id.emailetxt);
            EditText pgender = (EditText) findViewById(R.id.gendertxt);
            EditText pdob = (EditText) findViewById(R.id.dobetxt);
            EditText pnotes = (EditText) findViewById(R.id.notesetxt);


            String pnamestr = pname.getText().toString();
            String pemailstr = pemail.getText().toString();
            String paddressstr = paddress.getText().toString();
            String pcontactstr = pcontact.getText().toString();
            String pgenderstr = pgender.getText().toString();
            String pdobstr = pdob.getText().toString();
            String pnotestr = pnotes.getText().toString();


            Patient c1 = new Patient();

            c1.setName(pnamestr);
            c1.setEmail(pemailstr);
            c1.setAddress(paddressstr);
            c1.setContact(pcontactstr);
            c1.setGender(pgenderstr);
            c1.setDOB(pdobstr);
            c1.setNotes(pnotestr);
            helper.insert2(c1);


            Intent i = new Intent(AjoutPatient.this, homepage.class);
            startActivity(i);

        }

    }
}