package in.radongames.miwokdictionary.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import in.radongames.miwokdictionary.utils.MiwokAppConstants;

/**
 * Created by Binand on 02-10-2016.
 */

public class MainOnClickListener implements View.OnClickListener {

    private Context ctx;
    private Class next;

    public MainOnClickListener(Context ctx, Class next) {

        this.ctx = ctx;
        this.next = next;
    }

    public void onClick(View v) {

        int vId = v.getId();
        Intent intent = new Intent(ctx, next);
        intent.putExtra(MiwokAppConstants.getExtraCallingView(), vId);
        ctx.startActivity(intent);
    }
}
