package me.yokeyword.sample.demo_wechat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_wechat.entity.Ticker;
import me.yokeyword.sample.demo_wechat.listener.OnItemClickListener;

/**
 * Created by YoKeyword on 16/6/30.
 */
public class TickerAdapter extends RecyclerView.Adapter<TickerAdapter.VH> {
    private LayoutInflater mInflater;
    private List<Ticker> mItems = new ArrayList<>();

    private OnItemClickListener mClickListener;

    public TickerAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setDatas(List<Ticker> beans) {
        mItems.clear();
        mItems.addAll(beans);
        notifyDataSetChanged();
    }

    public void refreshMsg(Ticker bean) {
        int index = mItems.indexOf(bean);
        if (index < 0) return;

        notifyItemChanged(index);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_ticker, parent, false);
        final VH holder = new VH(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onItemClick(holder.getAdapterPosition(), v, holder);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Ticker item = mItems.get(position);

        holder.tickername.setText(item.ticker_name);
        holder.tickervolume.setText("量 " + String.valueOf(item.ticker_volume));
        holder.tickerhigh.setText("高 " + String.valueOf(item.ticker_high));
        holder.tickerlow.setText("低 " + String.valueOf(item.ticker_low));
        holder.tickerlast.setText("最新 ¥ " + String.valueOf(item.ticker_last));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    public Ticker getMsg(int position) {
        return mItems.get(position);
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView tickername, tickervolume, tickerlast, tickerhigh, tickerlow;

        public VH(View itemView) {
            super(itemView);
            tickername = (TextView) itemView.findViewById(R.id.ticker_name);
            tickervolume = (TextView) itemView.findViewById(R.id.ticker_volume);
            tickerlast = (TextView) itemView.findViewById(R.id.ticker_last);
            tickerhigh = (TextView) itemView.findViewById(R.id.ticker_high);
            tickerlow = (TextView) itemView.findViewById(R.id.ticker_low);
        }
    }
}
