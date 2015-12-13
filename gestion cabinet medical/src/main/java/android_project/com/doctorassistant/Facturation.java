package android_project.com.doctorassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.databasehelper;


public class Facturation extends Activity implements View.OnClickListener{
    databasehelper helper = new databasehelper(this);
    Button b1,b2;
    String amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factur);

        b1 = (Button)findViewById(R.id.conform_bill);
        b1.setOnClickListener(this);

        b2 = (Button)findViewById(R.id.show_bill);
        b2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.conform_bill)
        {

            Toast temp;
            temp = Toast.makeText(Facturation.this, "Bill Added", Toast.LENGTH_SHORT);
            temp.show();
            //app_id ,app_name, app_reason, app_contact, app_date;


            EditText patidb = (EditText) findViewById(R.id.pat_bal);
            EditText patamountb = (EditText) findViewById(R.id.pat_add_amount);
            EditText patdateb = (EditText) findViewById(R.id.pat_date_bill);
            EditText aamt = (EditText)findViewById(R.id.pat_total);

            String patidstrb = patidb.getText().toString();
            String patamountstrb = patamountb.getText().toString();
            String patdatestrb = patdateb.getText().toString();

            amt = patamountstrb;

            database.Facturation c4 = new database.Facturation();

            c4.setBillpid(patidstrb);
            c4.setAmount(patamountstrb);
            c4.setUserBilldate(patdatestrb);

            helper.insert4(c4);
            aamt.setText(amt +"  "+ "Le " +"  " + patdatestrb);

        }

        if(v.getId()==R.id.show_bill)
        {
          //  Intent i = new Intent(getApplicationContext(), BillingInfo.class);
           // startActivity(i);

        }
    }
}

