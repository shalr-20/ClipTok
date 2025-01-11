package com.tweak.cliptok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tweak.cliptok.databinding.ReelDesignerBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VideoHolder> {

    Context context;
    ArrayList<Model> modelList=new ArrayList<>();
    boolean isPlaying=false;

    public Adapter(Context context, ArrayList<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //prepares the layout for a single list item in the RecyclerView['

        View view= LayoutInflater.from(context).inflate(R.layout.reel_designer, parent, false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        //which data will go with which widget

        //Model model=modelList.get(position);
        holder.binding.videoView.setVideoPath(modelList.get(position).getVideoUrl()); //to receive video from drawable folder -> setVideoPath
        holder.binding.name.setText(modelList.get(position).getName());
        holder.binding.profileImage.setImageResource(modelList.get(position).getProfile());
        //setVideoURI -> when receiving data from the server


        //to prepare media from video's URI
        holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                isPlaying=true;
            }
        });

        //to restart the video when finished
        holder.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                isPlaying=true;
            }
        });

        //to pause the video when clicked on screen
        holder.binding.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying){
                    holder.binding.videoView.pause();
                    isPlaying=false;
                }
                else{
                    holder.binding.videoView.resume();
                    isPlaying=true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        ReelDesignerBinding binding;

        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            binding=ReelDesignerBinding.bind(itemView);
        }
    }
}
