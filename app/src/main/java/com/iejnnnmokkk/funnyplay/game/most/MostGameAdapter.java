package com.iejnnnmokkk.funnyplay.game.most;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class FavouriteAdapter
 * @Description TODO
 * @date 2024/12/12 17:33
 */
public class MostGameAdapter extends BaseAdapter<GameBean, MostGameAdapter.ViewHolder> {

    public MostGameAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_game_most, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull ViewHolder holder, int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_logo)
        public CircleImageView ivLogo;
        @BindView(R.id.tv_name)
        public TextView tvName;
        @BindView(R.id.tv_num)
        public TextView tvNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
