package kz.edu.nis.hbsh.students;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapterStudent extends RecyclerView.Adapter<RecyclerViewAdapterStudent.RecyclerViewViewHolder> {
private ArrayList<RecyclerViewItemStudent> arrayList;
public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgView;
    public TextView tv_mFIO,tv_mSubject,tv_mClGrInn;
public RecyclerViewViewHolder(@NonNull View itemView){
    super(itemView);
    imgView = itemView.findViewById(R.id.imgView);
    tv_mFIO = itemView.findViewById(R.id.tv_mFIO);
    tv_mClGrInn = itemView.findViewById(R.id.tv_mClGrInn);
    tv_mSubject = itemView.findViewById(R.id.tv_mSubject);

}

}
public RecyclerViewAdapterStudent(ArrayList<RecyclerViewItemStudent> arrayList){
    this.arrayList = arrayList;
}

@NonNull
@Override
public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
 View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent, false);
 RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
return recyclerViewViewHolder;
}
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
 RecyclerViewItemStudent recyclerViewItem = arrayList.get(position);
//holder.imgView.setImageResource(recyclerViewItem.getImgRes());

holder.tv_mFIO.setText(recyclerViewItem.getFIO());
holder.tv_mClGrInn.setText(" класс: "+recyclerViewItem.getclsGrp()+" иин: "+recyclerViewItem.getstdntIin());
holder.tv_mSubject.setText(recyclerViewItem.getadvncd1()+", "+recyclerViewItem.getadvncd2()+",  "+recyclerViewItem.getstndrd());

Picasso.get().load(recyclerViewItem.getImgRes()).into(holder.imgView);
}

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}