package csilva.analisedeti.quediaehoje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class AdapterListView extends BaseAdapter {
    Context context;
    private List<ItemListView> itens;
    private LayoutInflater mInflater;

    public AdapterListView(Context context2, List<ItemListView> itens2) {
        this.itens = itens2;
        this.mInflater = LayoutInflater.from(context2);
        this.context = context2;
    }

    public int getCount() {
        return this.itens.size();
    }

    public ItemListView getItem(int position) {
        return this.itens.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        if (view == null) {
            view = this.mInflater.inflate(C0345R.layout.item_list, (ViewGroup) null);
            itemHolder = new ItemSuporte(this, (ItemSuporte) null);
            itemHolder.ano = (TextView) view.findViewById(C0345R.C0347id.txvAno);
            itemHolder.imgIcon = (ImageView) view.findViewById(C0345R.C0347id.imgIcoItem);
            itemHolder.titulo = (TextView) view.findViewById(C0345R.C0347id.txvTitulo);
            view.setTag(itemHolder);
        } else {
            itemHolder = (ItemSuporte) view.getTag();
        }
        ItemListView item = this.itens.get(position);
        itemHolder.ano.setText(item.getData());
        Picasso.with(this.context).load(item.getImagem()).into(itemHolder.imgIcon);
        itemHolder.titulo.setText(item.getNome());
        return view;
    }

    private class ItemSuporte {
        public TextView ano;
        ImageView imgIcon;
        TextView titulo;

        private ItemSuporte() {
        }

        /* synthetic */ ItemSuporte(AdapterListView adapterListView, ItemSuporte itemSuporte) {
            this();
        }
    }
}
