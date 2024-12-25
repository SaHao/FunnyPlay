package com.iejnnnmokkk.funnyplay.game.favourite;

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
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.library.detail.GameDetailActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class FavouriteAdapter
 * @Description TODO
 * @date 2024/12/12 17:33
 */
public class FavouriteAdapter extends BaseAdapter<GameBean.DataBean, FavouriteAdapter.ViewHolder> {

    public FavouriteAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_game_favourite, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(getNull(data.get(position).getName()));
        holder.tvNum.setText(data.get(position).getReward() + "");
        Glide.with(context).load(getNull(data.get(position).getIcon())).into(holder.ivLogo);

        holder.itemView.setOnClickListener(v -> {
            if(data.get(position).getType() == 18) {
                context.startActivity(new Intent(context, GameDetailActivity.class).putExtra("id", getNull(data.get(position).getNo())));
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_logo)
        public RoundedImageView ivLogo;
        @BindView(R.id.tv_num)
        public TextView tvNum;
        @BindView(R.id.tv_name)
        public TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
