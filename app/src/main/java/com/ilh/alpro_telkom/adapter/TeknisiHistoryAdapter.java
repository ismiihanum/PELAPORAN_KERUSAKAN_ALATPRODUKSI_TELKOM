package com.ilh.alpro_telkom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ilh.alpro_telkom.R;
import com.ilh.alpro_telkom.model.PelaporModel;
import com.ilh.alpro_telkom.model.ResponseErrorModel;
import com.ilh.alpro_telkom.rest.ApiConfigServer;
import com.ilh.alpro_telkom.rest.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeknisiHistoryAdapter extends RecyclerView.Adapter<TeknisiHistoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PelaporModel> pelaporModels;
    private ResponseErrorModel responseErrorModels;
    private String idPelapor;

//    private ValidatorActivity validatorActivity;

    public TeknisiHistoryAdapter(Context context, ArrayList<PelaporModel> pelaporModels) {
        this.context = context;
        this.pelaporModels = pelaporModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_teknisi_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//        validatorActivity = new ValidatorActivity();
        Glide.with(context)
                .load(pelaporModels.get(position)
                        .getUrlImage()).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(holder.ivItemValidator);
        holder.tvDeskValidator.setText(pelaporModels.get(position).getDeskripsi());
        holder.tvAlamatValidator.setText(pelaporModels.get(position).getAlamat());
        holder.tvAlamatStatus.setText(pelaporModels.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return pelaporModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivItemValidator;
        private TextView tvDeskValidator;
        private TextView tvAlamatValidator;
        private TextView tvAlamatStatus;
        private Button btnYa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivItemValidator = itemView.findViewById(R.id.iv_item_validator);
            tvDeskValidator = itemView.findViewById(R.id.tv_desk_validator);
            tvAlamatValidator = itemView.findViewById(R.id.tv_desk_alamat);
            tvAlamatStatus = itemView.findViewById(R.id.tv_desk_status);
            btnYa = itemView.findViewById(R.id.btn_ya);
        }
    }
}
