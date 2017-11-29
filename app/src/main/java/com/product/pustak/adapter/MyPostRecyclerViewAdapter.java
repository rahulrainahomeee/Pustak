package com.product.pustak.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.product.pustak.R;
import com.product.pustak.holder.base.CellHolder;
import com.product.pustak.holder.derived.CollapsedCellHolder;
import com.product.pustak.holder.derived.ExpandedCellHolder;
import com.product.pustak.model.Post;

import java.util.ArrayList;


public class MyPostRecyclerViewAdapter extends RecyclerView.Adapter<CellHolder> implements View.OnClickListener {

    public static final String TAG = "MyPostRecyclerViewAdapter";

    /**
     * private class Data members.
     */
    private ArrayList<Post> mPostList = null;
    private Activity mActivity = null;

    private static final int EXPANDED_CELL = 2;
    private static final int COLLAPSED_CELL = 1;

    private int mExpandedCellPosition = -1;

    private int mExpandedCell = R.layout.item_expanded_rv_mypost;
    private int mCollapsedCell = R.layout.item_collapsed_rv_mypost;

    public MyPostRecyclerViewAdapter(Activity activity, ArrayList<Post> postList) {
        this.mActivity = activity;
        this.mPostList = postList;
    }

    /**
     * {@link RecyclerView.Adapter} adapter class override methods.
     */
    @Override
    public CellHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == EXPANDED_CELL) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(this.mExpandedCell, parent, false);
            ExpandedCellHolder holder = new ExpandedCellHolder(itemView, this);
            holder.setIsRecyclable(true);
            return holder;

        } else {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(this.mCollapsedCell, parent, false);
            CollapsedCellHolder holder = new CollapsedCellHolder(itemView, this);
            holder.setIsRecyclable(true);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(final CellHolder cellHolder, int position) {


        if (getItemViewType(position) == EXPANDED_CELL) {

            ExpandedCellHolder holder = (ExpandedCellHolder) cellHolder;
            holder.setTag(position);
            holder.setPositionTag(position);
            manageCells(holder.cardView, position);

        } else {

            CollapsedCellHolder holder = (CollapsedCellHolder) cellHolder;
            holder.setTag(position);
            holder.setPositionTag(position);
            manageCells(holder.cardView, position);
        }
    }

    @Override
    public int getItemCount() {

        return mPostList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (position == mExpandedCellPosition) {
            return EXPANDED_CELL;
        } else {
            return COLLAPSED_CELL;
        }
    }

    @Override
    public void onClick(View view) {

        int oldExpandedCellPosition = mExpandedCellPosition;

        switch (view.getId()) {

            case R.id.cell_collapsed_header_layout:     // Expand the cell from header click.

                mExpandedCellPosition = (int) view.getTag();
                break;

            case R.id.btn_collapsing:       // Collapse the cell from button click.

                mExpandedCellPosition = -1;
                break;

            case R.id.cell_expanded_header_layout:      // Collapse the cell from header click.

                mExpandedCellPosition = -1;
                break;
            default:

                Toast.makeText(mActivity, "Unhandled onClickListener() callback.", Toast.LENGTH_SHORT).show();
                break;
        }

        if (oldExpandedCellPosition != mExpandedCellPosition) {

            notifyItemChanged(oldExpandedCellPosition);
            notifyItemChanged(mExpandedCellPosition);
        }
    }

    private void manageCells(CardView cardView, int position) {

//        switch (position % 8) {
//
//            case 0:
//                cardView.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.bg_cell_a));
//                break;
//            case 1:
//                cardView.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.bg_cell_b));
//                break;
//            case 2:
//                cardView.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.bg_cell_c));
//                break;
//            case 3:
//                cardView.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.bg_cell_d));
//                break;
//            case 4:
//                cardView.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.bg_cell_e));
//                break;
//            case 5:
//                cardView.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.bg_cell_f));
//                break;
//            case 6:
//                cardView.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.bg_cell_g));
//                break;
//            case 7:
//                cardView.setBackground(ContextCompat.getDrawable(mActivity, R.drawable.bg_cell_h));
//                break;
//        }
    }

}