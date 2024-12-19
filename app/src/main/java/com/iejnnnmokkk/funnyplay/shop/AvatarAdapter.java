package com.iejnnnmokkk.funnyplay.shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.funnyplay.R;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class AvatarAdapter
 * @Description TODO
 * @date 2024/12/18 15:31
 */
public class AvatarAdapter extends BaseAdapter<ShopBean.DataBean.AvatarGoodsBean, AvatarAdapter.ViewHolder> {

    private OnBtnClickListener listener;

    public AvatarAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_avatar, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(getNull(data.get(position).getUrl())).into(holder.ivLogo);
        holder.tvPrice.setText(data.get(position).getCoins() + "");

        holder.tvUse.setOnClickListener(v -> {
            listener.onClick(data.get(position), "use");
        });

        holder.clNotBuy.setOnClickListener(v -> {
            if (data.get(position).getStatus() == 0) {
                listener.onClick(data.get(position), "buy");
            }
        });
    }

    public void setListener(OnBtnClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_logo)
        public RoundedImageView ivLogo;
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


    public interface OnBtnClickListener {
        void onClick(ShopBean.DataBean.AvatarGoodsBean bean, String type);
    }
}
