package com.example.csbanking;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class adapter extends FirebaseRecyclerAdapter<model, adapter.myviewholder>
{
    public adapter(@NonNull FirebaseRecyclerOptions<model> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, @SuppressLint("RecyclerView") final int position, @NonNull final model model)
    {
        holder.name.setText(model.getName());
        holder.course.setText(model.getCourse());
        holder.email.setText(model.getEmail());

        Glide.with(holder.img.getContext())
                .load(model.getSurl())
                .into(holder.img);

        Objects.requireNonNull(holder).edit.setOnClickListener(view -> {
            DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                    .setContentHolder(new ViewHolder(R.layout.update_popup))
                    .setExpanded(true,1100)
                    .create();

            View myview = dialogPlus.getHolderView();
            final EditText purl = myview.findViewById(R.id.txtImageUrl);
            final EditText name = myview.findViewById(R.id.txtName);
            final EditText course = myview.findViewById(R.id.txtCourse);
            final EditText email = myview.findViewById(R.id.txtEmail);

            Button edit = myview.findViewById(R.id.btnUpdate);

            purl.setText(model.getSurl());
            name.setText(model.getName());
            course.setText(model.getCourse());
            email.setText(model.getEmail());

            dialogPlus.show();

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Map<String,Object> map=new HashMap<>();
                    map.put("purl",purl.getText().toString());
                    map.put("name",name.getText().toString());
                    map.put("email",email.getText().toString());
                    map.put("course",course.getText().toString());

                    FirebaseDatabase.getInstance().getReference().child("students")
                            .child(Objects.requireNonNull(getRef(position).getKey())).updateChildren(map)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    dialogPlus.dismiss();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    dialogPlus.dismiss();
                                }
                            });
                }
            });


        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete Data?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("students")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });
        holder.archive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Archive Data");
                builder.setMessage("Archive Data?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //archive codes
                    }
                });
            }
        });
        holder.print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Print Data");
                builder.setMessage("Save as PDF?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //print codes
                    }
                });
            }
        });

    } // End of OnBindViewMethod

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myviewholder(view);
    }


    static class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        Button edit, archive;
        Button delete, print;
        TextView name,course,email;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(CircleImageView) itemView.findViewById(R.id.img1);
            name=(TextView)itemView.findViewById(R.id.nametext);
            course=(TextView)itemView.findViewById(R.id.amounttext);
            email=(TextView)itemView.findViewById(R.id.emailtext);

            //edit=(Button)itemView.findViewById(R.id.btnEdit);
            delete=(Button)itemView.findViewById(R.id.btnDelete);
            archive=(Button)itemView.findViewById(R.id.btnArchive);
            print=(Button)itemView.findViewById(R.id.btnPrint);
        }
    }
}
