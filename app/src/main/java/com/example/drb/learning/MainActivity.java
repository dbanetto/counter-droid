package com.example.drb.learning;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
    import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int radix = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView countView = (TextView)findViewById(R.id.countText);
                countView.setText(Integer.toString(0, radix));
                Toast.makeText(getApplicationContext(), R.string.reset_count, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    public void addCount(View view) {
        TextView countView = (TextView)findViewById(R.id.countText);
        int count  = Integer.parseInt(countView.getText().toString(), radix);
        if (count == Integer.MAX_VALUE) {
            count = Integer.MIN_VALUE;
        } else {
            count += 1;
        }
        countView.setText(Integer.toString(count, radix));
    }

    public void minusCount(View view) {
        TextView countView = (TextView)findViewById(R.id.countText);
        int count  = Integer.parseInt(countView.getText().toString(), radix);
        if (count == Integer.MIN_VALUE) {
            count = Integer.MAX_VALUE;
        } else {
            count -= 1;
        }
        countView.setText(Integer.toString(count, radix));
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
        if (id == R.id.select_decimal || id == R.id.select_hexadecimal) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void selectDecimal(MenuItem item) {
        if (radix == 10) {
            return;
        }

        TextView countView = (TextView)findViewById(R.id.countText);
        final int count = Integer.parseInt(countView.getText().toString(), radix);
        radix = 10;
        Toast.makeText(getBaseContext(), R.string.select_decimal, Toast.LENGTH_SHORT)
                .show();countView.setText(Integer.toString(count, radix));
    }

    public void selectHexadecimal(MenuItem item) {
        if (radix == 16) {
            return;
        }

        TextView countView = (TextView)findViewById(R.id.countText);
        final int count = Integer.parseInt(countView.getText().toString(), radix);
        radix = 16;
        countView.setText(Integer.toString(count, radix));
        Toast.makeText(getBaseContext(), R.string.select_hexadecimal, Toast.LENGTH_SHORT)
                .show();
    }
}
