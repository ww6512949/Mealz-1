package com.example.mealz.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mealz.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerGrocerylistAdapter extends RecyclerView.Adapter<RecyclerGrocerylistAdapter.ViewHolder> implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "RecyclerGrocerylistAdap";

    Context context;
    List<String> groceryNames;
    List<Integer> groceryAmount;
    List<String> groceryUnits;
    List<String> groceryShares;
    // Spinner
    Spinner editGrocerySpinner;

    public RecyclerGrocerylistAdapter(Context context, List<String> groceryNames, List<Integer> groceryAmount, List<String> groceryUnits, List<String> groceryShares) {
        this.context = context;
        this.groceryNames = groceryNames;
        this.groceryAmount = groceryAmount;
        this.groceryUnits = groceryUnits;
        this.groceryShares = groceryShares;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grocery_item, parent, false);
        this.editGrocerySpinner = view.findViewById(R.id.editGrocery);
        ArrayAdapter<String> editGroceryActionAdapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, context.getResources().getStringArray(R.array.editGroceryActions));
        editGroceryActionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editGrocerySpinner.setAdapter(editGroceryActionAdapter);
        editGrocerySpinner.setOnItemSelectedListener(this);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        holder.gName.setText(groceryNames.get(position));
        holder.gAmount.setText(groceryAmount.get(position).toString());
        holder.gUnit.setText(groceryUnits.get(position));
        if(groceryShares!=null && groceryShares.get(position)!=null) holder.gShare.setText("Shared With: "+groceryShares.get(position));
        else holder.gShare.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return groceryNames.size();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String action = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(context, action, Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gName;
        TextView gAmount;
        TextView gUnit;
        TextView gShare;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gName = itemView.findViewById(R.id.groceryName);
            gAmount = itemView.findViewById(R.id.gAmount);
            gUnit = itemView.findViewById(R.id.gUnit);
            gShare = itemView.findViewById(R.id.gShare);
        }
    }
}
