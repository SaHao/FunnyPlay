package com.iejnnnmokkk.funnyplay.library;

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

public class GameLibraryAdapter extends BaseAdapter<GameLibraryBean.DataBean, GameLibraryAdapter.ViewHolder> {

    public GameLibraryAdapter(Context context) {
        super(context);
    }

    @Override
    protected GameLibraryAdapter.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_game_library, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull GameLibraryAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(getNull(data.get(position).getApp_name()));
        Glide.with(context).load(getNull(data.get(position).getIcon())).into(holder.ivPhoto);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo)
        RoundedImageView ivPhoto;
        @BindView(R.id.tv_name)
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
