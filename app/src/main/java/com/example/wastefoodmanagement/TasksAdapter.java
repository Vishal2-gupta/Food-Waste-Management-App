package com.example.wastefoodmanagement;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

        private Context mCtx;
        private List<Task> taskList;

    public TasksAdapter(Context mCtx, List<Task> taskList) {
            this.mCtx = mCtx;
            this.taskList = taskList;
        }

        @Override
        public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mCtx).inflate(R.layout.foodrv, parent, false);
            return new TasksViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TasksViewHolder holder, int position) {
            Task t = taskList.get(position);
            holder.textViewTask.setText(t.getTask());
            holder.textViewDesc.setText(t.getDesc());
            holder.textViewFinishBy.setText(t.getFinishBy());

            if (t.isFinished())
                holder.textViewStatus.setText("Donation Info");
            else
                holder.textViewStatus.setText("Donation Info");
        }

        @Override
        public int getItemCount() {
            return taskList.size();
        }

        class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;

            public TasksViewHolder(View itemView) {
                super(itemView);

                textViewStatus = itemView.findViewById(R.id.textViewStatus);
                textViewTask = itemView.findViewById(R.id.textViewTask);
                textViewDesc = itemView.findViewById(R.id.textViewDesc);
                textViewFinishBy = itemView.findViewById(R.id.textViewFinishBy);
                final Button b=(Button) itemView.findViewById(R.id.image);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mCtx,RateUs.class);
                        mCtx.startActivity(intent);
                    }
                });
                textViewDesc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url=textViewDesc.getText().toString();
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        mCtx.startActivity(intent);
                    }
                });


                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                Task task = taskList.get(getAdapterPosition());

                Intent intent = new Intent(mCtx, UpdateDonationInfo.class);
                intent.putExtra("task", task);

                mCtx.startActivity(intent);
            }
        }
    }

