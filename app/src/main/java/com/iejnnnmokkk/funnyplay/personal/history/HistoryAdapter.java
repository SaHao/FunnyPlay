package com.iejnnnmokkk.funnyplay.personal.history;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.common.utils.DateUtils;
import com.iejnnnmokkk.funnyplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryAdapter extends BaseAdapter<HistoryBean.DataBean, HistoryAdapter.ViewHolder> {

    public HistoryAdapter(Context context) {
        super(context);
    }

    @Override
    protected HistoryAdapter.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_history, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(getNull(data.get(position).getSub_type_name()));
        holder.tvContent.setText(getNull(data.get(position).getRemark()));
        holder.tvMoney.setText(data.get(position).getBalance() + "");
        holder.tvDate.setText(DateUtils.timestampToDate(data.get(position).getCreate_time(), "yyyy-MM-dd HH:mm"));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_date)
        TextView tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
