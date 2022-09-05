package uz.gita.football_statistics.ui.details.holders

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.football_statistics.data.models.table_view.RowHeader
import uz.gita.football_statistics.databinding.TableViewRowHeaderLayoutBinding

class RowHeaderViewHolder(private val viewBinding: TableViewRowHeaderLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(data: RowHeader) {
        viewBinding.rowHeaderTextview.text = data.data
    }

}