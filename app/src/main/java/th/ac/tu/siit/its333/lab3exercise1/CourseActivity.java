package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class CourseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }

    public void retClicked(View v) {
        Intent res = new Intent();

        EditText etRet1 = (EditText)findViewById(R.id.etCode);
        EditText etRet2 = (EditText)findViewById(R.id.etCR);
        int grade;

        RadioGroup rgGrade= (RadioGroup)findViewById(R.id.rgGrade);

        RadioButton rb = (RadioButton)findViewById(rgGrade.getCheckedRadioButtonId());


        res.putExtra("v1", etRet1.getText().toString());
        res.putExtra("v2", etRet2.getText().toString());
        res.putExtra("v3", rb.getText().toString()); //radio button

        setResult(RESULT_OK, res);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
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
