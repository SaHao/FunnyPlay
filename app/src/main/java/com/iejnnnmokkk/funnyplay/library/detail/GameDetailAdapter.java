package com.iejnnnmokkk.funnyplay.library.detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.funnyplay.R;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameDetailAdapter extends BaseAdapter<GameDetailBean.DataBean, RecyclerView.ViewHolder> {

    private static final int HEADER = 0;
    private static final int CONTENT = 1;
    private static final int FOOTER = 2;

    public GameDetailAdapter(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            return new HeaderViewHolder(inflater.inflate(R.layout.header_game_detail, parent, false));
        } else if(viewType == FOOTER) {
            return new FooterViewHolder(inflater.inflate(R.layout.footer_game_detail, parent, false));
        }
        return new ViewHolder(inflater.inflate(R.layout.content_game_detail, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER;
        } else if (position == data.size() + 1) {
            return FOOTER;
        } else {
            return CONTENT;
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + 2;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_background)
        ImageView ivBackground;
        @BindView(R.id.iv_logo)
        RoundedImageView ivLogo;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_score)
        TextView tvScore;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.textView0)
        TextView textView0;
        @BindView(R.id.ll_light)
        LinearLayout llLight;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_logo)
        ImageView ivLogo;
        @BindView(R.id.tv_level)
        TextView tvLevel;
        @BindView(R.id.tv_money)
        TextView tvMoney;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
