package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    int cr = 0;         // Credits
    double gp = 0.0;    // Grade points
    double gpa = 0.0;   // Grade point average

    List<String> listCodes;
    List<Integer> listCredits;
    List<String> listGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCodes = new ArrayList<String>();
        listCredits = new ArrayList<Integer>();
        listGrades = new ArrayList<String>();

        //Use listCodes.add("ITS333"); to add a new course code
        //Use listCodes.size() to refer to the number of courses in the list

    }
    public void calculate()
    {
        cr = 0;         // Credits
        gp = 0.0;    // Grade points
        gpa = 0.0;   // Grade point average

        double d=0.0;
        for (int i=0;i<listCodes.size();i++)
        {
            String g=listGrades.get(i);
            int a =listCredits.get(i);
            cr+=a;
            switch(g)
            {
                case "A": d=4;
                    break;
                case "B+": d=3.5;
                    break;
                case "B": d=3;
                    break;
                case "C+": d=2.5;
                    break;
                case "C": d=2;
                    break;
                case "D+": d=1.5;
                    break;
                case "D": d=1;
                    break;
                case "F": d=0;
                    break;

            }
            gp+=(a*d);
        }
        gpa=gp/cr;
        TextView tvGP=(TextView)findViewById(R.id.tvGP);
        TextView tvCR=(TextView)findViewById(R.id.tvCR);
        TextView tvGPA=(TextView)findViewById(R.id.tvGPA);
        tvGP.setText(Double.toString(gp));
        tvCR.setText(Integer.toString(cr));
        tvGPA.setText(Double.toString(gpa));

    }
    public void buttonClicked(View v) {
        int id= v.getId();

        if(id==R.id.button4)  //add course
        {

            Intent i = new Intent(this, CourseListActivity.class);
            String s1="",s2="",s3="";
            for(int j=0;j<listCodes.size();j++)
            {
                s1= s1+listCodes.get(j)+"("+listCredits.get(j)+" credits) = "+listGrades.get(j)+"\n";
            }
            i.putExtra("codeList", s1);
            Log.d("Testttt",s1);



            startActivityForResult(i, 99);
            calculate();

        }
        else if(id==R.id.button2) //show course list
        {
            Intent i = new Intent(this,CourseActivity.class);
            // EditText etInput = (EditText)findViewById(R.id.)
            startActivityForResult(i,88);
        }
        else if(id==R.id.button) //reset
        {
            listCodes = new ArrayList<String>();
            listCredits = new ArrayList<Integer>();
            listGrades= new ArrayList<String>();
            TextView tvGP=(TextView)findViewById(R.id.tvGP);
            TextView tvCR=(TextView)findViewById(R.id.tvCR);
            TextView tvGPA=(TextView)findViewById(R.id.tvGPA);
            tvGP.setText("0.0");
            tvCR.setText("0");
            tvGPA.setText("");

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Values from child activity


        if (requestCode == 88) {
            if (resultCode == RESULT_OK) {

                listCodes.add(data.getStringExtra("v1"));
                listCredits.add(Integer.parseInt(data.getStringExtra("v2")));
                listGrades.add(data.getStringExtra("v3"));
                calculate();
                Log.d("Test",String.valueOf(listCodes.size()));
              /*  TextView test = (TextView)findViewById(R.id.testText);
                test.setText(listCodes.toString());
                TextView test2 = (TextView)findViewById(R.id.testCredit);
                test.setText(listCredits.toString());*/


            }
            else if (resultCode == RESULT_CANCELED) {

            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
