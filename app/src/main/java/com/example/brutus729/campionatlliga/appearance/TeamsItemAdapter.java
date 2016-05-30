package com.example.brutus729.campionatlliga.appearance;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.brutus729.campionatlliga.R;
import com.example.brutus729.campionatlliga.objects.TeamsItem;

import java.util.List;

public class TeamsItemAdapter extends BaseAdapter{
    private Context context;
    private List<TeamsItem> items;

    public TeamsItemAdapter(Context context, List<TeamsItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        /** TRY TO USE HOLDER */
        ViewHolder holder;
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.team_item, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) rowView.findViewById(R.id.team_name);
            rowView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        TeamsItem item = this.items.get(position);
        holder.name.setText(item.getTeamsName());
        /*FI TRY TO USE HOLDER */

        return rowView;
    }

    /** TRY TO USE HOLDER */
    static class ViewHolder {
        TextView name;
    }
    /*FI TRY TO USE HOLDER */
}
