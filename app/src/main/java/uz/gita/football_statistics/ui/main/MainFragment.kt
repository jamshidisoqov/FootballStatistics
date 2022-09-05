package uz.gita.football_statistics.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.football_statistics.R
import uz.gita.football_statistics.data.models.LeagueData
import uz.gita.football_statistics.databinding.FragmentMainBinding
import uz.gita.football_statistics.ui.adapters.LeagueAdapter
import uz.gita.football_statistics.ui.view_models.MainViewModel
import uz.gita.football_statistics.ui.view_models.impl.MainViewModelImpl

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()

    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()

    private val adapter: LeagueAdapter by lazy {
        LeagueAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.allLeagues.observe(this, leaguesObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.listLeague.adapter = adapter
        viewModel.getAllLeague()
        adapter.setItemClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment(it.logos.light,it.id))
        }
    }

    private val leaguesObserver = Observer<List<LeagueData>> {
        adapter.submitList(it)
    }


}