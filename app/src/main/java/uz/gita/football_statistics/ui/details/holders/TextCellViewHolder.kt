package uz.gita.football_statistics.ui.details.holders

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.football_statistics.data.models.table_view.TextCell
import uz.gita.football_statistics.databinding.TableViewCellLayoutBinding

class TextCellViewHolder(private val viewBinding: TableViewCellLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(data: TextCell) {
        viewBinding.cxellData.text = data.data
    }

}