package com.example.optimusprime.fiftyfifty;

/**
 * Created by Optimus Prime on 4/17/2015.
 */
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class ContanctAdapter extends ArrayAdapter<ContactBean> {

    private Activity activity;
    private List<ContactBean> contacts;
    private int row;
    private ContactBean objBean;

    public ContanctAdapter(Activity act, int row, List<ContactBean> items) {
        super(act, row, items);

        this.activity = act;
        this.row = row;
        this.contacts = items;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, null);

            holder = new ViewHolder();
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if ((contacts == null) || ((position + 1) > contacts.size()))
            return view;

        objBean = contacts.get(position);

        holder.name = (TextView) view.findViewById(R.id.tvname);
        holder.PhoneNo = (TextView) view.findViewById(R.id.tvphone);

        if (holder.name != null && null != objBean.Nameget()
                && objBean.Nameget().trim().length() > 0) {
            holder.name.setText(Html.fromHtml(objBean.Nameget()));
        }
        if (holder.PhoneNo != null && null != objBean.PhoneNoget()
                && objBean.PhoneNoget().trim().length() > 0) {
            holder.PhoneNo.setText(Html.fromHtml(objBean.PhoneNoget()));
        }
        return view;
    }

    public class ViewHolder {
        public TextView name, PhoneNo;
    }

}