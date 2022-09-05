package uz.gita.football_statistics.ui.details.holders

import com.bumptech.glide.Glide
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.football_statistics.R
import uz.gita.football_statistics.data.models.table_view.ImageCell
import uz.gita.football_statistics.databinding.TableViewImageCellLayoutBinding

class ImageCellViewHolder(private val viewBinding: TableViewImageCellLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(url: ImageCell) {
        Glide.with(viewBinding.cellImage.context)
            .load(url.data)
            .placeholder(R.drawable.premier)
            .centerCrop()
            .into(viewBinding.cellImage)
    }

}