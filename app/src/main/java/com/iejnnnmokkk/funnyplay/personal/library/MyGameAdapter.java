package com.iejnnnmokkk.funnyplay.personal.library;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.library.detail.GameDetailActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyGameAdapter extends BaseAdapter<MyGameBean.DataBean, MyGameAdapter.ViewHolder> {

    public MyGameAdapter(Context context) {
        super(context);
    }

    @Override
    protected MyGameAdapter.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_my_ganme, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull MyGameAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(getNull(data.get(position).getIcon())).into(holder.ivLogo);
        holder.tvName.setText(getNull(data.get(position).getName()));
        holder.tvDate.setText(getNull(data.get(position).getDate_time()));
        holder.tvMoney.setText(data.get(position).getReward() + "");
        if (data.get(position).getStatus() == 0) {
            holder.tvProgress.setVisibility(View.VISIBLE);
            holder.tvComplete.setVisibility(View.GONE);
            holder.tvReview.setVisibility(View.GONE);
        } else if (data.get(position).getStatus() == 1) {
            holder.tvProgress.setVisibility(View.GONE);
            holder.tvComplete.setVisibility(View.VISIBLE);
            holder.tvReview.setVisibility(View.GONE);
        } else if (data.get(position).getStatus() == 2) {
            holder.tvProgress.setVisibility(View.GONE);
            holder.tvComplete.setVisibility(View.GONE);
            holder.tvReview.setVisibility(View.VISIBLE);
        } else {
            holder.tvProgress.setVisibility(View.GONE);
            holder.tvComplete.setVisibility(View.GONE);
            holder.tvReview.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(v -> {
            if(data.get(position).getType() == 18) {
                context.startActivity(new Intent(context, GameDetailActivity.class).putExtra("id", getNull(data.get(position).getNo())));
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_logo)
        RoundedImageView ivLogo;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_Date)
        TextView tvDate;
        @BindView(R.id.tv_progress)
        TextView tvProgress;
        @BindView(R.id.tv_complete)
        TextView tvComplete;
        @BindView(R.id.tv_review)
        TextView tvReview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
