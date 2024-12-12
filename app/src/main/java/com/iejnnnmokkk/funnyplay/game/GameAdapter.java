package com.iejnnnmokkk.funnyplay.game;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.favourite.FavouriteAdapter;
import com.iejnnnmokkk.funnyplay.game.most.MostGameAdapter;
import com.iejnnnmokkk.funnyplay.view.CircleImageView;
import com.iejnnnmokkk.funnyplay.view.CircleWaveProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class GameAdapter
 * @Description TODO
 * @date 2024/12/12 16:42
 */
public class GameAdapter extends BaseAdapter<GameBean, RecyclerView.ViewHolder> {

    private static final int HEADER = 0;
    private static final int CONTENT = 1;

    private FavouriteAdapter favouriteAdapter;
    private MostGameAdapter mostGameAdapter;

    public GameAdapter(Context context) {
        super(context);
        favouriteAdapter = new FavouriteAdapter(context);
        mostGameAdapter = new MostGameAdapter(context);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            return new HeaderViewHolder(inflater.inflate(R.layout.header_game, parent, false));
        }
        return new ViewHolder(inflater.inflate(R.layout.content_game, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? HEADER : CONTENT;
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cp_task)
        public CircleWaveProgressView cpTask;
        @BindView(R.id.tv_taskNum)
        public TextView tvTaskNum;
        @BindView(R.id.ll_task)
        public LinearLayout llTask;
        @BindView(R.id.iv_photo)
        public ImageView ivPhoto;
        @BindView(R.id.iv_photoBack)
        public ImageView ivPhotoBack;
        @BindView(R.id.tv_name)
        public TextView tvName;
        @BindView(R.id.iv_sgnIn)
        public ImageView ivSgnIn;
        @BindView(R.id.iv_game)
        public ImageView ivGame;
        @BindView(R.id.iv_shop)
        public ImageView ivShop;
        @BindView(R.id.iv_personal)
        public ImageView ivPersonal;
        @BindView(R.id.tv_tomorrow)
        public TextView tvTomorrow;
        @BindView(R.id.tv_signIn)
        public TextView tvSignIn;
        @BindView(R.id.ll_signIn)
        public LinearLayout llSignIn;
        @BindView(R.id.tv_gameNum)
        public TextView tvGameNum;
        @BindView(R.id.ll_addFriends)
        public LinearLayout llAddFriends;
        @BindView(R.id.tv_favouriteAll)
        public TextView tvFavouriteAll;
        @BindView(R.id.cl_favourite)
        public ConstraintLayout clFavourite;
        @BindView(R.id.tv_mostAll)
        public TextView tvMostAll;
        @BindView(R.id.cl_most)
        public ConstraintLayout clMost;
        @BindView(R.id.tv_newAll)
        public TextView tvNewAll;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
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

    private void setProgressBar(CircleWaveProgressView progressView) {
        progressView.setCircleColor(context.getResources().getColor(R.color.progressCircle))
                .setWaveColor(context.getResources().getColor(R.color.progressCircle))
                .setTextColor(Color.WHITE)
                .setTextSize(40f)
                .setProgress(50)
                .startAnimation();
    }
}
