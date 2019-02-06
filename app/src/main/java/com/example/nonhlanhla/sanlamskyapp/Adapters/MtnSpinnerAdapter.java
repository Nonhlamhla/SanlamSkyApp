package com.example.nonhlanhla.sanlamskyapp.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nonhlanhla.sanlamskyapp.Pojo.MtnSpinnerData;
import com.example.nonhlanhla.sanlamskyapp.R;

import java.util.List;



public class MtnSpinnerAdapter extends ArrayAdapter<MtnSpinnerData> {
    private Context context;
    private List<MtnSpinnerData> spinnerData;

    public MtnSpinnerAdapter(@NonNull Context context, @LayoutRes int resource, List<MtnSpinnerData> spinnerData) {
        super(context, resource, spinnerData);
        this.context = context;
        this.spinnerData = spinnerData;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return myCustomSpinnerView(position, convertView, parent);
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return myCustomSpinnerView(position, convertView, parent);
    }


    private View myCustomSpinnerView(int postion, @Nullable View myView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.spinner_item, parent, false);

        TextView textView = customView.findViewById(R.id.tv_Spinner);
        textView.setText(spinnerData.get(postion).getOffering());



        return customView;
    }
}
