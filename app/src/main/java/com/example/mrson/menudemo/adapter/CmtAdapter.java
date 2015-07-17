package com.example.mrson.menudemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mrson.menudemo.R;
import com.example.mrson.menudemo.model.Cmt;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by mrson on 02/07/2015.
 */
public class CmtAdapter extends BaseAdapter {
    Context m_context;
    ArrayList<Cmt> arrayList_cmt ;
    Cmt cmt;

    public CmtAdapter(Context m_context, ArrayList<Cmt> arrayList) {
        this.m_context = m_context;

        this.arrayList_cmt = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList_cmt.size();
    }

    @Override
    public Cmt getItem(int position) {
        return arrayList_cmt.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    Button bntfl;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if(convertView==null){

            convertView= LayoutInflater.from(m_context).inflate(R.layout.cmt_item,parent,false);
            viewHolder= new ViewHolder();
            viewHolder.cmt=(TextView) convertView.findViewById(R.id.cmt_id);




            // viewHolder.textView = (TextView) convertView.findViewById(R.id.text);
            // bntfl=(Button)convertView.findViewById(R.id.btn_f);


            convertView.setTag(viewHolder);


        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }

        setValue(viewHolder, position);

        return convertView;
    }




    private static class  ViewHolder{
        TextView cmt;


    }

    private String encode(String a){
        try {
            a = URLEncoder.encode(a, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return a;
    }
    private void setValue(final ViewHolder holder, final int position) {
        cmt = getItem(position);
        holder.cmt.setText(cmt.getCmt());





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