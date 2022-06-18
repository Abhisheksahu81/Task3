package com.abhi.task3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhi.task3.databinding.FragmentHomeBinding
import com.abhi.task3.models.Section
import com.abhi.task3.models.SectionHeader
import com.abhi.task3.models.SectionItem
import com.shuhart.stickyheader.StickyHeaderItemDecorator

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val stickyAdapter by lazy { StickyRecyclerAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        setUpRecyclerView()
        stickyAdapter.setData(getDummyDataList())
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = stickyAdapter
            val decorator = StickyHeaderItemDecorator(stickyAdapter)
            decorator.attachToRecyclerView(this)
        }
    }

    private fun getDummyDataList(): List<Section> {
        val items = ArrayList<Section>()
        for (section in 1..5) {
            items.add(SectionHeader(section, "Field from $section"))
            for (item in 1..5) {
                items.add(
                    SectionItem(
                        section,
                        "Item title $item in section $section",
                        "Item content $item in section $section"
                    )
                )
            }
        }
        return items
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}