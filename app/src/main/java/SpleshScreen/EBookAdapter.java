package SpleshScreen;

import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbitconnect.R;
import com.example.mbitconnect.ViewPdf;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class EBookAdapter extends FirebaseRecyclerAdapter<FileInfoModel,EBookAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public EBookAdapter(@NonNull FirebaseRecyclerOptions<FileInfoModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull FileInfoModel model) {
        holder.titleview.setText(model.getFilename());
        holder.author.setText(model.getAuthor());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.cardView.getContext(), ViewPdf.class);
                intent.putExtra("filename",model.getFilename());
                intent.putExtra("fileurl",model.getFileurl());
                intent.putExtra("author",model.getAuthor());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.cardView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.e_bookview,parent,false);
       return  new myViewHolder(view);
    }

    public  class myViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img1,vieweye;
        TextView titleview,author;
        CardView cardView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img1=(ImageView) itemView.findViewById(R.id.img1);
            vieweye=(ImageView) itemView.findViewById(R.id.vieweye);
            titleview=(TextView) itemView.findViewById(R.id.titleview);
           cardView =(CardView) itemView.findViewById(R.id.cardView);
           author=(TextView) itemView.findViewById(R.id.author);




        }
    }
}
