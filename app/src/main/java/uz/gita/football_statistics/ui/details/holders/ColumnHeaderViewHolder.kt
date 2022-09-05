package uz.gita.football_statistics.ui.details.holders

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.football_statistics.data.models.table_view.ColumnHeader
import uz.gita.football_statistics.databinding.TableViewColumnHeaderLayoutBinding

class ColumnHeaderViewHolder(private val viewBinding: TableViewColumnHeaderLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(data: ColumnHeader) {
        viewBinding.columnHeaderTextView.text = data.data
    }
}