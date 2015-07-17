package com.example.mrson.menudemo.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mrson.menudemo.R;
import com.example.mrson.menudemo.model.Message;

import java.util.ArrayList;

/**
 * Created by mrson on 14/07/2015.
 */
public class Chat_holder_Adapter extends BaseAdapter {
    Message messages;
    ArrayList<Message> arrayList;

    Context mcontext;

    public Chat_holder_Adapter(ArrayList<Message> arrayList, Context mcontext) {
        this.arrayList = arrayList;
        this.mcontext = mcontext;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Message getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.chat_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.message = (TextView) convertView.findViewById(R.id.item_chat);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        setValue(viewHolder, position);

        return convertView;
    }

    private static class ViewHolder {
        TextView message;


    }

    private void setValue(final ViewHolder viewHolder, final int position) {
        messages = getItem(position);
        viewHolder.message.setText(messages.getMessages());
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) viewHolder.message.getLayoutParams();
        if (messages.istatus()) {
            ;
            viewHolder.message.setBackgroundDrawable(null);

        } else {
            if (messages.isyou()) {
                lp.gravity = Gravity.LEFT;
                viewHolder.message.setBackgroundResource(R.mipmap.speech_bubble_green);

            } else {
                lp.gravity = Gravity.RIGHT;
                viewHolder.message.setBackgroundResource(R.mipmap.speech_bubble_green);

                viewHolder.message.setLayoutParams(lp);

            }

        }
    }
}
