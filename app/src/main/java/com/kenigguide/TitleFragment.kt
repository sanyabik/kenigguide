package com.kenigguide

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TitleFragment : Fragment() {
    private lateinit var viewModel: TitleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.title_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listImage: RecyclerView? = view.findViewById(R.id.recyclerView)
        val myAdapter = MyAdapter(onClickTitleCard)
        listImage?.adapter = myAdapter

        viewModel = ViewModelProvider(this).get(TitleViewModel::class.java)
        viewModel.model.observe(viewLifecycleOwner, Observer {
            it?.let {
                myAdapter.submitList(it)
                myAdapter.notifyDataSetChanged()
            }
        })
    }

    private val onClickTitleCard = object : OnClickTitleCard {
        override fun onClick(model: Model) {
            val action =
                TitleFragmentDirections.actionTitleFragmentToDescriptionFragment(
                    model.image.toString(),
                    model.description.toString()
                )
            Navigation.findNavController(view!!).navigate(action)

        }
    }
}

interface OnClickTitleCard {
    fun onClick(model: Model)

}