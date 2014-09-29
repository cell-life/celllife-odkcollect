package org.odk.collect.android.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.odk.collect.android.R;
import org.odk.collect.android.logic.InstanceProviderClass;

public class TwoItemChoiceAdapter extends ArrayAdapter<InstanceProviderClass> {
    private ArrayList<InstanceProviderClass> values;

    public TwoItemChoiceAdapter(Context context, int resource, ArrayList<InstanceProviderClass> values) {
        super(context, resource, values);
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.two_item_multiple_choice, null);
        }

        TextView textViewTitle = (TextView) view.findViewById(R.id.text1);
        TextView textViewString = (TextView) view.findViewById(R.id.text2);
        TextView textViewRefNum = (TextView) view.findViewById(R.id.text3);
        TextView textViewRef = (TextView) view.findViewById(R.id.text4);

        InstanceProviderClass in = values.get(position);

        textViewTitle.setText(in.getTitle());
        if (in.getReference() != null) {
            textViewRef.setText(R.string.reference);
        }
        textViewRefNum.setText(in.getReference());
        textViewString.setText(in.getSubtext());

        return view;
    }

}
