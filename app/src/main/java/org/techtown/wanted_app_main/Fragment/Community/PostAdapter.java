package org.techtown.wanted_app_main.Fragment.Community;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.wanted_app_main.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    static ArrayList<Post> items = new ArrayList<Post>();
    static PostAdapter.OnPostItemClickListener listener;

    public interface OnPostItemClickListener {
        public void onItemClick(PostAdapter.ViewHolder holder, View view, ArrayList<Post> items, int position); }

    public void setOnItemClicklistener(PostAdapter.OnPostItemClickListener listener){ this.listener = listener; }


    public void onItemClick(PostAdapter.ViewHolder holder, View view, ArrayList<Post> items, int position) {
        if(listener != null){
            listener.onItemClick(holder,view,items,position); } }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.post_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Post item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void clearItem() {
        items.clear();
    }

    public void addItem(Post item) {
        items.add(item);
    }

    public void setItems(ArrayList<Post> items) {
        this.items = items;
    }

    public Post getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Post item) {
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        TextView textView3;
        public ViewHolder(View itemView) {
            super(itemView);
            textView2 = itemView.findViewById(R.id.posttitle);
            textView1 = itemView.findViewById(R.id.postcomment);
//            textView3 = itemView.findViewById(R.id.postimage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(PostAdapter.ViewHolder.this, v, items, position);
                    } } });
        }

        public void setItem(Post item) {
            textView2.setText(item.getTitle());
            textView1.setText(item.getComment());
            //textView3.setText(item.getImage());
        }

    }
}