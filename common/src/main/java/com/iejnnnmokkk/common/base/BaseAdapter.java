package com.iejnnnmokkk.common.base;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sun
 * @Demo class BaseAdapter
 * @Description TODO
 * @date 2024/12/6 16:02
 */
public abstract class BaseAdapter<T, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    protected Context context;
    protected LayoutInflater inflater;
    protected List<T> data = new ArrayList<T>();

    public BaseAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onCreateHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull V holder, int position) {
        onBindHolder(holder, position);
    }

    protected abstract V onCreateHolder(@NonNull ViewGroup parent, int viewType);

    protected abstract void onBindHolder(@NonNull V holder, int position);

    @Override
    public int getItemCount() {
        return data != null && !data.isEmpty() ? data.size() : 0;
    }

    public void setData(List<T> data, boolean isRefresh) {
        if (isRefresh) {
            this.data.clear();
        }
        if (data != null) {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    protected String getNull(String str) {
        return !TextUtils.isEmpty(str) ? str : "";
    }
}
