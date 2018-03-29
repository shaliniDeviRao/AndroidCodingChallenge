package com.app.isspass.adapter;


import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.isspass.presenter.PassesListPresenter;
import com.app.isspass.view.PassRowView;

public class PassesRecyclerAdapter extends RecyclerView.Adapter<PassesRecyclerAdapter.PassViewHolder> {

    private final PassesListPresenter presenter;

    public PassesRecyclerAdapter(PassesListPresenter passesListPresenter) {
        this.presenter = passesListPresenter;
    }

    @Override
    public PassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PassViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_2, parent, false));
    }

    @Override
    public void onBindViewHolder(PassViewHolder holder, int position) {
        presenter.onBindPassRowViewAtPosition(position, holder);

    }

    @Override
    public int getItemCount() {
        return presenter.getPassesRowsCount();
    }

    public class PassViewHolder extends RecyclerView.ViewHolder implements PassRowView {

        TextView durationTextView;
        TextView riseTimeTextView;

        public PassViewHolder(View itemView) {
            super(itemView);
            durationTextView = itemView.findViewById(android.R.id.text1);
            riseTimeTextView = itemView.findViewById(android.R.id.text2);
        }

        @Override
        public void setDuration(String duration) {
            durationTextView.setText(duration);
        }

        @Override
        public void setRiseTime(long riseTime) {
            riseTimeTextView.setText(DateUtils.formatDateTime(riseTimeTextView.getContext(), riseTime, DateUtils.FORMAT_SHOW_TIME));

        }
    }
}

