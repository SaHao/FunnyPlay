package com.iejnnnmokkk.funnyplay.personal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.funnyplay.R;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalAdapter extends BaseAdapter<PersonalBean, PersonalAdapter.ViewHolder> {

    public PersonalAdapter(Context context) {
        super(context);
    }

    @Override
    protected PersonalAdapter.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_personal, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull PersonalAdapter.ViewHolder holder, int position) {
//        holder.tvName.setText(getNull(data.get(position).getName()));
//        holder.tvTask.setText(getNull(data.get(position).getTask_label()));
//        Glide.with(context).load(getNull(data.get(position).getRecomm_img())).into(holder.ivLogo);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_logo)
        RoundedImageView ivLogo;
        @BindView(R.id.tv_task)
        TextView tvTask;
        @BindView(R.id.tv_name)
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
