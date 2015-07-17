package com.example.mrson.menudemo.peoples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mrson.menudemo.R;

import java.util.ArrayList;

import static com.example.mrson.menudemo.R.id;

/**
 * Created by son on 5/22/2015.
 */
public class  AwesomeAdapter extends BaseAdapter {
    Context m_context;
    ArrayList<Message> arr_mess ;
    Message message;
  //  AwesomeAdapter messadater;

    ArrayList<Message> messarr= new ArrayList<Message>();

    public  AwesomeAdapter(Context context, ArrayList<Message> messages) {
        this.m_context = context;
        this.arr_mess = messages;
    }

    @Override
    public int getCount() {
        return arr_mess.size();
    }

    @Override
    public Message getItem(int position) {
        return arr_mess.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
   // Button bntfl;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if(convertView==null){

            convertView= LayoutInflater.from(m_context).inflate(R.layout.sms_row, parent, false);
            viewHolder= new ViewHolder();
          //  viewHolder.img_ava=(ImageView) convertView.findViewById(R.id.img_peo);
            viewHolder.txt_message=(TextView)convertView.findViewById(id.message_text);

         //   viewHolder.frag=(ImageView) convertView.findViewById((id.fr));
           // viewHolder.txt_message=(TextView) convertView.findViewById(id.txt_message);
          // viewHolder.rlmain=(RelativeLayout) convertView.findViewById(R.id.rlmain);



            // viewHolder.textView = (TextView) convertView.findViewById(R.id.text);
            // bntfl=(Button)convertView.findViewById(R.id.btn_f);
            // viewHolder.folow=(Button)convertView.findViewById(R.id.btn_f);

            convertView.setTag(viewHolder);


        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }

        setValue(viewHolder, position);

        return convertView;
    }




    private static class  ViewHolder{

        TextView txt_message;


    }


    private void setValue(final ViewHolder holder, final int position) {
        message = getItem(position);

        holder.txt_message.setText(message.getMessage());



//        if(people.isFollow()==true){
//            holder.folow.setBackgroundResource(drawable.check);
//        }else{
//
//            holder.folow.setBackgroundResource(drawable.uncheck);
//        }

        //   holder.folow=people.isFollow();


//        holder.folow.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View view=(View)v.getParent();
//                Button image= (Button) view.findViewById(id.btn_f);
////                if(arrayList_people.get(position).isFollow()==true){
////                    image.setBackgroundResource(drawable.uncheck);
////                   // people.setFollow(false);
////                    arrayList_people.get(position).setFollow(false);
////                }else{
////
////                    image.setBackgroundResource(drawable.check);
////                   // people.setFollow(true);
////                    arrayList_people.get(position).setFollow(true);
////                }
//
//
//
//            }
//        });

//
//
//        holder.frag.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                //Intent myIntent = new Intent(view.getContext(), agones.class);
//                //startActivityForResult(myIntent, 0);
//              //  Collections.addAll(mOfficeListItems, getResources().getStringArray(R.array.offices));
//
//              //  DialogFragment startDialogFragment=new StartSensingDialog(this);
//               // startDialogFragment.show(getFragmentManager(),"start_dialog");
////o day ok
//
//               //<-- See This!
//                final Dialog dialog = new Dialog((Activity)view.getContext());
//                dialog.setContentView(layout.custom_dialog);
//               dialog.setTitle("Edit listview");
//
//                final EditText edt= (EditText)dialog.findViewById(id.ed_text);
//                edt.setText(holder.txt_name.getText().toString());
//                Button bnt=(Button) dialog.findViewById(id.btn_e);
//                Button bnt_in=(Button) dialog.findViewById(id.bnt_in);
//                bnt_in.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                    PeoPle ple= new PeoPle();
//                        ple.setName(edt.getText().toString());
//                        ple.setA_var(drawable.p1);
//                      //  String addnew= edt.getText().toString();
//                        arrayList_people.add(ple);
//                        MainActivity.adapter.notifyDataSetChanged();
//
//                    }
//                });
//                bnt.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        arrayList_people.get(position).setName(edt.getText().toString());
//                        MainActivity.adapter.notifyDataSetChanged();
//                        Toast.makeText(m_context, arrayList_people.get(position).getName().toString(), Toast.LENGTH_LONG).show();
//                    }
//                });
//                Button btn_delete= (Button) dialog.findViewById(id.btn_delete);
//                btn_delete.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        arrayList_people.remove(position);
//                        MainActivity.adapter.notifyDataSetChanged();
//                    }
//                });
//
//            dialog.show();
//           }
//
//        });

    }

    @Override
    public int getItemViewType(int position)
    {
        return super.getItemViewType(position);
    }
}
