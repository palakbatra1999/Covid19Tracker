package com.example.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class DistrictAdapter extends ArrayAdapter<DistrictModel> {
    private List<DistrictModel> districtmodel,districtModelList;
    private Context context;

    public DistrictAdapter(@NonNull Context context, @NonNull List<DistrictModel> objects) {
        super(context,R.layout.item_item,objects);
        this.context=context;
        this.districtmodel=objects;
        this.districtModelList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item,null,true);
        TextView name=view.findViewById(R.id.name);
        name.setText(districtModelList.get(position).getState_name());
        return view;
    }

    @Override
    public int getCount() {
        return districtModelList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public DistrictModel getItem(int position) {
        return districtModelList.get(position);
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = districtModelList.size();
                    filterResults.values = districtModelList;

                }else{
                    List<DistrictModel> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(DistrictModel itemsModel:districtModelList){
                        if(itemsModel.getState_name().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                districtModelList = (List<DistrictModel>) results.values;
                MainActivity2.districtList = (List<DistrictModel>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
