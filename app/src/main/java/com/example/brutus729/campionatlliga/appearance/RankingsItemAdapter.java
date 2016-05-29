package com.example.brutus729.campionatlliga.appearance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.brutus729.campionatlliga.R;
import com.example.brutus729.campionatlliga.objects.RankingsItem;

import java.util.List;

public class RankingsItemAdapter extends BaseAdapter {

    private Context context;
    private List<RankingsItem> items;

    public RankingsItemAdapter(Context context, List<RankingsItem> items) {
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
        /** Sense HOLDER */
        if(convertView == null){
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.ranking_item, parent, false);
        }
        // Set data into the view.
        TextView rank = (TextView) rowView.findViewById(R.id.ranking_rank);
        TextView team_name = (TextView) rowView.findViewById(R.id.ranking_team);
        TextView played_games = (TextView) rowView.findViewById(R.id.ranking_games);
        TextView wins = (TextView) rowView.findViewById(R.id.ranking_wins);
        TextView draws = (TextView) rowView.findViewById(R.id.ranking_draws);
        TextView loses = (TextView) rowView.findViewById(R.id.ranking_loses);
        TextView goals = (TextView) rowView.findViewById(R.id.ranking_goals);
        TextView score = (TextView) rowView.findViewById(R.id.ranking_scores);

        RankingsItem item = this.items.get(position);
        rank.setText(item.getRank());
        team_name.setText(item.getTeamName());
        played_games.setText(item.getPlayedGames());
        wins.setText(item.getWins());
        draws.setText(item.getDraws());
        loses.setText(item.getLoses());
        goals.setText(item.getGoals());
        score.setText(item.getScore());

        /** TRY TO USE HOLDER (DOESNT WORK! DKW)
        ViewHolder holder;
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.ranking_item, parent, false);

            holder = new ViewHolder();
            holder.rank = (TextView) convertView.findViewById(R.id.ranking_rank);
            holder.team_name = (TextView) convertView.findViewById(R.id.ranking_team);
            holder.played_games = (TextView) convertView.findViewById(R.id.ranking_games);
            holder.wins = (TextView) convertView.findViewById(R.id.ranking_wins);
            holder.draws = (TextView) convertView.findViewById(R.id.ranking_draws);
            holder.loses = (TextView) convertView.findViewById(R.id.ranking_loses);
            holder.goals = (TextView) convertView.findViewById(R.id.ranking_goals);
            holder.score = (TextView) convertView.findViewById(R.id.ranking_scores);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) rowView.getTag();
        }
        holder.rank.setText(item.getRank());
        holder.team_name.setText(item.getTeamName());
        holder.played_games.setText(item.getPlayedGames());
        holder.wins.setText(item.getWins());
        holder.draws.setText(item.getDraws());
        holder.loses.setText(item.getLoses());
        holder.goals.setText(item.getGoals());
        holder.score.setText(item.getScore());
        /*FI TRY TO USE HOLDER  */

        return rowView;
    }

    /** TRY TO USE HOLDER (DOESNT WORK! DKW)
    static class ViewHolder {
        TextView rank;
        TextView team_name;
        TextView played_games;
        TextView wins;
        TextView draws;
        TextView loses;
        TextView goals;
        TextView score;
    }
    */

}