package com.iejnnnmokkk.funnyplay.game.most;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class FavouriteAdapter
 * @Description TODO
 * @date 2024/12/12 17:33
 */
public class MostGameAdapter extends BaseAdapter<GameBean.DataBean, MostGameAdapter.ViewHolder> {

    public MostGameAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_game_most, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(getNull(data.get(position).getName()));
        holder.tvNum.setText(getNull(data.get(position).getPay_money()));
        Glide.with(context).load(getNull(data.get(position).getRecomm_img())).into(holder.ivLogo);
        holder.tvPlay.setOnClickListener(v -> {

        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_logo)
        public RoundedImageView ivLogo;
        @BindView(R.id.tv_name)
        public TextView tvName;
        @BindView(R.id.tv_num)
        public TextView tvNum;
        @BindView(R.id.tv_play)
        public TextView tvPlay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
