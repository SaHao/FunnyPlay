package com.iejnnnmokkk.funnyplay.shop;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class FrameAdapter
 * @Description TODO
 * @date 2024/12/18 16:12
 */
public class FrameAdapter extends BaseAdapter<ShopBean, FrameAdapter.ViewHolder> {

    public FrameAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_frame, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull ViewHolder holder, int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_logo)
        public ImageView ivLogo;
        @BindView(R.id.iv_select)
        public ImageView ivSelect;
        @BindView(R.id.tv_price)
        public TextView tvPrice;
        @BindView(R.id.cl_notBuy)
        public LinearLayout clNotBuy;
        @BindView(R.id.tv_use)
        public TextView tvUse;
        @BindView(R.id.tv_inUse)
        public TextView tvInUse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
