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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.iejnnnmokkk.funnyplay.game.favourite.FavouriteAdapter;
import com.iejnnnmokkk.funnyplay.game.most.MostGameAdapter;
import com.iejnnnmokkk.funnyplay.view.CircleWaveProgressView;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class GameAdapter
 * @Description TODO
 * @date 2024/12/12 16:42
 */
public class GameAdapter extends BaseAdapter<GameBean.DataBean, RecyclerView.ViewHolder> {

    private static final int HEADER = 0;
    private static final int CONTENT = 1;

    private final FavouriteAdapter favouriteAdapter;
    private final MostGameAdapter mostGameAdapter;

    private List<GameBean.DataBean> favouriteData = new ArrayList<>();
    private List<GameBean.DataBean> mostData = new ArrayList<>();
    private UserInfoBean.DataBean userInfo = new UserInfoBean.DataBean();

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
        if (getItemViewType(position) == CONTENT && holder instanceof ViewHolder) {
            ((ViewHolder) holder).tvName.setText(getNull(data.get(position - 1).getName()));
            ((ViewHolder) holder).tvNum.setText(getNull(data.get(position - 1).getPay_money()));
            Glide.with(context).load(getNull(data.get(position - 1).getRecomm_img())).into(((ViewHolder) holder).ivLogo);
        } else if (getItemViewType(position) == HEADER && holder instanceof HeaderViewHolder) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            ((HeaderViewHolder) holder).rvFavourite.setLayoutManager(layoutManager);
            ((HeaderViewHolder) holder).rvFavourite.setAdapter(favouriteAdapter);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3, RecyclerView.HORIZONTAL, false);
            ((HeaderViewHolder) holder).rvMost.setLayoutManager(gridLayoutManager);
            ((HeaderViewHolder) holder).rvMost.setAdapter(mostGameAdapter);

            ((HeaderViewHolder) holder).clFavourite.setVisibility(favouriteData.isEmpty() ? View.GONE : View.VISIBLE);
            ((HeaderViewHolder) holder).clMost.setVisibility(mostData.isEmpty() ? View.GONE : View.VISIBLE);

            ((HeaderViewHolder) holder).llAddFriends.setVisibility(View.GONE);


            setProgressBar(((HeaderViewHolder) holder).cpTask, userInfo.getWelfare_5_star_reward(), userInfo.getWelfare_5_star_reward() + userInfo.getWelfare_complete_sum());
            ((HeaderViewHolder) holder).tvTaskNum.setText(setPercent(userInfo.getWelfare_5_star_reward(), userInfo.getWelfare_5_star_reward() + userInfo.getWelfare_complete_sum()));
            Glide.with(context).load(getNull(userInfo.getTouxiang())).into(((HeaderViewHolder) holder).ivPhoto);
            Glide.with(context).load(getNull(userInfo.getAvatar())).into(((HeaderViewHolder) holder).ivPhotoBack);
            ((HeaderViewHolder) holder).tvMoney.setText(userInfo.getBalance());

        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? HEADER : CONTENT;
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    public void setFavouriteData(List<GameBean.DataBean> favouriteData) {
        this.favouriteData = favouriteData;
        favouriteAdapter.setData(favouriteData, true);
    }

    public void setMostData(List<GameBean.DataBean> mostData) {
        this.mostData = mostData;
        mostGameAdapter.setData(mostData, true);
    }

    public void setUserInfo(UserInfoBean.DataBean userInfo) {
        this.userInfo = userInfo;
        notifyDataSetChanged();
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cp_task)
        public CircleWaveProgressView cpTask;
        @BindView(R.id.tv_taskNum)
        public TextView tvTaskNum;
        @BindView(R.id.tv_money)
        public TextView tvMoney;
        @BindView(R.id.ll_task)
        public LinearLayout llTask;
        @BindView(R.id.iv_photo)
        public RoundedImageView ivPhoto;
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
        @BindView(R.id.rv_favourite)
        public RecyclerView rvFavourite;
        @BindView(R.id.rv_most)
        public RecyclerView rvMost;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_logo)
        public RoundedImageView ivLogo;
        @BindView(R.id.tv_name)
        public TextView tvName;
        @BindView(R.id.tv_num)
        public TextView tvNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void setProgressBar(CircleWaveProgressView progressView, int progress, int max) {
        progressView.setCircleColor(context.getResources().getColor(R.color.progressCircle))
                .setWaveColor(context.getResources().getColor(R.color.progressCircle))
                .setTextColor(Color.WHITE)
                .setTextSize(40f)
                .setProgress(progress, max)
                .startAnimation();
    }

    private String setPercent(int numerator, int denominator) {
        if (denominator == 0) {
            return "0%";
        }
        int percentage = numerator * 100 / denominator;
        return percentage + "%";
    }
}
