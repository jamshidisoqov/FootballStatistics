package uz.gita.football_statistics.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.dzmitry_lakisau.month_year_picker_dialog.MonthYearPickerDialog
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import uz.gita.football_statistics.R
import uz.gita.football_statistics.databinding.FragmentDetailsBinding
import uz.gita.football_statistics.ui.details.adapters.TableAdapterSeason
import uz.gita.football_statistics.ui.view_models.DetailsViewModel
import uz.gita.football_statistics.ui.view_models.impl.DetailsViewModelImpl

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val viewBinding: FragmentDetailsBinding by viewBinding()

    private val viewModel: DetailsViewModel by viewModels<DetailsViewModelImpl>()

    private var tableAdapterSeason: TableAdapterSeason? = null

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openChartLiveData.observe(this, openChartObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.season(args.id, 2022, "12")
        viewModel.seasonListLiveData.observe(viewLifecycleOwner) {
            tableAdapterSeason = TableAdapterSeason(it)
            viewBinding.tableView.setAdapter(tableAdapterSeason)
            tableAdapterSeason?.setAllItems(it.columnHeaders, it.rowHeaders, it.cells)
        }
        viewModel.dateLiveData.observe(viewLifecycleOwner) {
            viewBinding.tvSeason.text = it.toString()
            viewModel.season(args.id, it, "12")
        }
        viewBinding.tvSeason.setOnClickListener {
            showDialog()
        }
        viewBinding.fabChart.setOnClickListener {
            viewModel.openChart()
        }
        Glide.with(requireContext())
            .load(args.image)
            .placeholder(R.drawable.premier)
            .into(viewBinding.imageLeague)
    }

    private fun showDialog() {
        val dialog = MonthYearPickerDialog.Builder(
            requireContext(),
            R.style.Style_MonthYearPickerDialog_Red,
            selectedYear = 2022
        )
            .setMinYear(2001)
            .setMode(MonthYearPickerDialog.Mode.YEAR_ONLY)
            .setOnYearSelectedListener { month ->
                viewModel.setYear(month)
            }
            .build()
        dialog.show()
    }

    private val openChartObserver = Observer<Unit> {
        findNavController().navigate(
            DetailsFragmentDirections.actionDetailsFragmentToChartFragment(
                args.id,
                args.image
            )
        )

    }

}