package in.radongames.miwokdictionary.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import in.radongames.miwokdictionary.R;

/**
 * Created by Binand on 02-10-2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private Context ctx;
    private int itemColour;
    private boolean hasImage;

    public WordAdapter(Context ctx, List<Word> wList, int itemColour, boolean hasImage) {
        super(ctx, 0, wList);
        this.ctx = ctx;
        this.itemColour = itemColour;
        this.hasImage = hasImage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Word currWord = getItem(position);
        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater.from(ctx).inflate(R.layout.words_listitem, parent, false);
        }

        itemView.setBackgroundResource(itemColour);

        TextView tv1 = (TextView) itemView.findViewById(R.id.list_line_1);
        TextView tv2 = (TextView) itemView.findViewById(R.id.list_line_2);

        tv1.setText(currWord.getMiwokText());
        tv2.setText(currWord.getOtherText());

        ImageView iv = (ImageView) itemView.findViewById(R.id.list_image);

        if (hasImage) {
            iv.setImageResource(currWord.getImageResource());
            iv.setVisibility(View.VISIBLE);
        } else {
            iv.setVisibility(View.GONE);
        }

        return itemView;
    }
}
