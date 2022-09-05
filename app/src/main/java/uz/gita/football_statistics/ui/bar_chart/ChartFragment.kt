package uz.gita.football_statistics.ui.bar_chart

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import uz.gita.football_statistics.R
import uz.gita.football_statistics.databinding.FragmentChartBinding
import uz.gita.football_statistics.ui.bar_chart.impl.ChartViewModelImpl

class ChartFragment : Fragment(R.layout.fragment_chart) {

    private val viewBinding: FragmentChartBinding by viewBinding()

    private val viewModel: ChartViewModel by viewModels<ChartViewModelImpl>()

    private val args: ChartFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Glide.with(requireContext())
            .load(args.logo)
            .centerCrop()
            .placeholder(R.drawable.premier)
            .into(viewBinding.imageLeague)

        viewModel.getAllTeams(args.leagueId)

        viewModel.allSeasonsByLeague.observe(viewLifecycleOwner) {

            val barList = ArrayList<BarEntry>()
            val list = it.standings.map { team ->
                team.stats[6].value
            }.toIntArray()
            for (i in list.indices) {
                barList.add(BarEntry(i.toFloat(), list[i].toFloat()))
            }
            setBarChart(barList)

        }
    }


    private fun setBarChart(list: List<BarEntry>) {
        val barData = BarDataSet(list, "Statistics")
        barData.color = Color.parseColor("#17D837")
        barData.valueTextColor = Color.parseColor("#ffffff")
        barData.barBorderColor = Color.parseColor("#ffffff")
        barData.valueTextSize = 13f
        val bar = BarData(barData)
        viewBinding.barChartFootball.apply {
            setFitBars(true)
            data = bar
            setNoDataTextColor(Color.parseColor("#ffffff"))
            description.text = ""
            animateY(2000)
        }
    }
}