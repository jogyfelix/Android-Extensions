package com.tunjid.androidx.adapters

import android.view.ViewGroup

import com.tunjid.androidx.R
import com.tunjid.androidx.model.Tile
import com.tunjid.androidx.recyclerview.InteractiveAdapter
import com.tunjid.androidx.view.util.inflate
import com.tunjid.androidx.viewholders.TileViewHolder

class TileAdapter(private val tiles: List<Tile>, listener: (tile: Tile) -> Unit)
    : InteractiveAdapter<TileViewHolder, (tile: Tile) -> Unit>(listener) {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TileViewHolder =
            TileViewHolder(viewGroup.inflate(R.layout.viewholder_tile), delegate)

    override fun onBindViewHolder(viewHolder: TileViewHolder, position: Int) =
            viewHolder.bind(tiles[position])

    override fun onViewRecycled(holder: TileViewHolder) {
        super.onViewRecycled(holder)
        holder.unBind()
    }

    override fun getItemId(position: Int): Long = tiles[position].number.toLong()

    override fun getItemCount(): Int = tiles.size

}