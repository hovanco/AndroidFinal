package com.example.androidfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// buoc la cu Alt + Enter
public class VocabularyAdapter extends RecyclerView.Adapter<VocabularyAdapter.VocabularyViewHolder> {
    //buoc 2
    List<Vocabulary> vocabularies;
    Context context;

    // buoc 8
    private OnItemClicked onClick;



    // buoc 3
    public VocabularyAdapter(Runnable mainActivity, List<Vocabulary> Vocabularies) {
        vocabularies = Vocabularies;
    }

    public  List<Vocabulary>getVocabularies(){return vocabularies;}

    // buoc 4
    public  void setVocabularies(List<Vocabulary> vocabularies){
        this.vocabularies = vocabularies;
    }

    // buoc 5
    @NonNull
    @Override
    public VocabularyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, parent, false);
        return new VocabularyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VocabularyViewHolder holder, final int position) {
        // buoc 9
        holder.textViewVocabulary.setText(vocabularies.get(position).getVocabulary());
        holder.textViewMean.setText(vocabularies.get(position).getMean());

        //Sau khi add va show thanh cong, Delete
        //Sau khi add va show thanh cong, Delete
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.onItemDeleteClick(position);
            }
        });
    }
    // buoc 10
    @Override
    public int getItemCount() {
        if (vocabularies == null) {
            return 0;
        }
        return vocabularies.size();
    }

    public class VocabularyViewHolder extends RecyclerView.ViewHolder {
        // buoc 5
        TextView textViewVocabulary, textViewMean;
        //LinearLayout item;
        Button btnDelete;


        public VocabularyViewHolder(@NonNull View itemView) {
            super(itemView);
            // buoc 6
            textViewVocabulary = itemView.findViewById(R.id.tvVocabulary);
            textViewMean = itemView.findViewById(R.id.tvMean);


            btnDelete = itemView.findViewById(R.id.btnDelete);
            //item = itemView.findViewById(R.id.item);


        }
    }

    // buoc 7
    public interface OnItemClicked {
        void onItemDeleteClick(int position);
        //void onItemUpdateClick(int position);
    }

    // buoc 11
    public void setOnClick(OnItemClicked onClick) {
        this.onClick = onClick;
    }


}
