package com.example.admin.report;

/**
 * Created by Admin on 8/21/2017.
 */


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 6/27/2017.
 */

class RAdapter extends ArrayAdapter<Report> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).

     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param reports   A List of AndroidFlavor objects to display in a list
     */
    public RAdapter(Activity context, List<Report> reports) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, reports);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.model, parent, false);
        }

        // Get the object located at this position in the list
        Report report = getItem(position);

        TextView nameEditText = (TextView) listItemView.findViewById(R.id.etName);
        nameEditText.setText(report.getName());

        TextView surnameEditText = (TextView) listItemView.findViewById(R.id.etSurname);
        surnameEditText.setText(report.getSurname());

        TextView emailEditText = (TextView) listItemView.findViewById(R.id.etEmail);
        emailEditText.setText(report.getEmail());

        TextView EnglistEditText = (TextView) listItemView.findViewById(R.id.etEnglish);
        EnglistEditText.setText( "" + report.getEnglish());

        TextView mathsEditText = (TextView) listItemView.findViewById(R.id.etZulu);
        mathsEditText.setText("" +report.getIsizilu());

        TextView zuluEditText = (TextView) listItemView.findViewById(R.id.etMaths);
        zuluEditText.setText("" +report.getMaths());

        TextView lifeEditText = (TextView) listItemView.findViewById(R.id.etLife);
        lifeEditText.setText("" +report.getLifeScience());

        TextView computerEditText = (TextView) listItemView.findViewById(R.id.etPhysical);
        computerEditText.setText("" +report.getPhysicalscience());

        TextView physicalEditText = (TextView) listItemView.findViewById(R.id.etComputer);
        physicalEditText.setText("" +report.getComputer());

        TextView ID = (TextView) listItemView.findViewById(R.id.etModelID);
        ID.setText("" +report.getId());

        TextView commentEditText = (TextView) listItemView.findViewById(R.id.etModelComment);
        commentEditText.setText(report.getComment());

        TextView TotalEditText = (TextView) listItemView.findViewById(R.id.etModelTotal);
        TotalEditText.setText("" + Display.total + "%");



        return listItemView;
    }
}
