package com.example.mrson.menudemo.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mrson.menudemo.R;
import com.example.mrson.menudemo.adapter.Chat_holder_Adapter;
import com.example.mrson.menudemo.model.Message;
import com.example.mrson.menudemo.model.RandomMessage;

import java.util.ArrayList;
import java.util.Random;

public class Activity_chat extends Activity {
    Chat_holder_Adapter chat_holder_adapter;
    ArrayList<Message>messages_arr;
    Message message;
    EditText editText;
    ListView listView;
    Random ran=new Random();
    static String sender;
    Message message1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_chat);
        messages_arr=new ArrayList<Message>();
         sender = RandomMessage.sender[ran.nextInt( RandomMessage.sender.length-1)];
        listView=(ListView)findViewById(R.id.list);
         editText=(EditText)findViewById(R.id.text);

        chat_holder_adapter=new Chat_holder_Adapter(messages_arr,this);
        listView.setAdapter(chat_holder_adapter);
       //listView.setAdapter(chat_holder_adapter);
        Button button=(Button) findViewById(R.id.buton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_message=editText.getText().toString().trim();
                if(text_message.length()>0){

                    addNewMessage(new Message(text_message,true));
                    editText.setText("");
                    new Sendmessage().execute();


                }
            }
        });

    }

    private class Sendmessage extends AsyncTask<Void,String,String>{
        @Override
        protected String doInBackground(Void... params) {
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.publishProgress(String.format("Đang nhập tin nhắn",sender));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.publishProgress(String.format("Đã gửi tin nhắn",sender));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return RandomMessage.Message[ran.nextInt(RandomMessage.Message.length-1)];
        }

        @Override
        protected void onProgressUpdate(String... values) {
            if(messages_arr.get(messages_arr.size()-1).istatus()){

                messages_arr.get(messages_arr.size()-1).setMessages(values[0]);

                chat_holder_adapter.notifyDataSetChanged();



            }else {
//                if(messages_arr.get(messages_arr.size()-1).istatus()){
//                    messages_arr.remove(messages_arr.size()-1);
//                }
                addNewMessage(new Message(true,values[0]));

            }




        }

        @Override
        protected void onPostExecute(String s) {
            if(messages_arr.get(messages_arr.size()-1).istatus()){
                messages_arr.remove(messages_arr.size()-1);
            }
            addNewMessage(new Message(s,false)); //
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_chat, menu);
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

    /**
     *
     * @param m
     */
    void addNewMessage(Message m)
    {
        messages_arr.add(m);

        chat_holder_adapter.notifyDataSetChanged();
        listView.setSelection(messages_arr.size()-1);

        // getListView().setSelection(messages_arr.size()-1);
    }
}
