package kz.flyingv.serverlessmessenger.activity.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.flyingv.serverlessmessenger.R
import kz.flyingv.serverlessmessenger.databinding.FragmentMainSearchUserBinding

class SearchUserFragment : Fragment() {

    private lateinit var binding: FragmentMainSearchUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainSearchUserBinding.inflate(inflater, container, false)
        return binding.root
    }

}