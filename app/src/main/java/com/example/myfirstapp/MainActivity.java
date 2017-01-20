package com.example.myfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.myfirstapp.R.id.some_text;

public class MainActivity extends ListActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(mListAdapter);

    }


    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        //TextView textView = (TextView) findViewById(R.id.list_item/text1);
        //textView.setText(message);
    }


    private BaseAdapter mListAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position + 2;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
            }


            // Because the list item contains multiple touch targets, you should not override
            // onListItemClick. Instead, set a click listener for each target individually.

           convertView.findViewById(some_text).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            /*
                            Toast.makeText(MainActivity.this,
                                    "hello",
                                    Toast.LENGTH_SHORT).show();
                             */
                            TextView textView = (TextView) findViewById(some_text);
                            textView.setText("hello");
                        }
                    });

            return convertView;
        }
    };

}
