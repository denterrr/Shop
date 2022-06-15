package den.ter.feature_cart_screen.presentation.cart

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import den.ter.core.di.DaggerCoreComponent
import den.ter.feature_cart_screen.R
import den.ter.feature_cart_screen.databinding.FragmentCartBinding
import den.ter.feature_cart_screen.di.DaggerCartComponent
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import javax.inject.Inject

class CartFragment : Fragment() {

    @Inject
    lateinit var viewModel: CartViewModel

    lateinit var binding: FragmentCartBinding
    lateinit var rv: RecyclerView
    lateinit var adapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val comp = DaggerCartComponent.builder()
            .coreComponent(DaggerCoreComponent.create())
            .build()
        comp.inject(this)
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)
        rv = binding.rv
        adapter = CartAdapter(requireContext())
        rv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv.adapter = adapter
        rv.isNestedScrollingEnabled = false
        binding.backButton.setOnClickListener {
            val navController = findNavController()
            navController.navigateUp()
        }
        binding.geoButton.setOnClickListener {
            goMap()
        }
        binding.tvGeo.setOnClickListener {
            goMap()
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
//        viewModel.getCartDb().observe(viewLifecycleOwner, Observer {
//            if (it == null) {
//                if (isOnline(requireContext())) {
//                    loadData()
//                    binding.cardView.visibility = View.VISIBLE
//                    binding.tvConnectionLost3.visibility = View.GONE
//                } else {
//                    binding.cardView.visibility = View.GONE
//                    binding.tvConnectionLost3.visibility = View.VISIBLE
//                }
//            }else{
//                if (isOnline(requireContext())) {
//                    loadDbData()
//                    binding.cardView.visibility = View.VISIBLE
//                    binding.tvConnectionLost3.visibility = View.GONE
//                } else {
//                    binding.cardView.visibility = View.GONE
//                    binding.tvConnectionLost3.visibility = View.VISIBLE
//                }
//            }
//        })
        loadData()

    }

    @SuppressLint("SetTextI18n")
    private fun loadData() {
        viewModel.getCart()
        viewModel.resp.observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
//                viewModel.insert(it)
            }
            adapter.setList(it.basket)
            binding.apply {
                total.text = "$${it.total}"
                delivery.text = it.delivery.toString()
            }
        })
    }

//    @SuppressLint("SetTextI18n")
//    private fun loadDbData() {
//        viewModel.getCartDb().observe(viewLifecycleOwner, Observer {
//            adapter.setList(it.basket)
//            binding.apply {
//                total.text = "$${it.total}"
//                delivery.text = it.delivery.toString()
//            }
//        })
//    }

    private fun isOnline(ctx: Context): Boolean {
        val cm = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork ?: return false
        val activeNetwork = cm.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }


    private fun goMap() {
        val navcon = findNavController()
        navcon.navigate(den.ter.core.R.id.action_cartFragment_to_mapsFragment)
    }
}