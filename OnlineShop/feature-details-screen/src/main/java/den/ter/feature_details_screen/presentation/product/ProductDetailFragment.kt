package den.ter.feature_details_screen.presentation.product

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.feature_details_screen.R.layout.*
import den.ter.core.R
import den.ter.core.di.DaggerCoreComponent
import den.ter.feature_details_screen.databinding.FragmentProductDetailBinding
import den.ter.feature_details_screen.di.DaggerDetailsComponent
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import javax.inject.Inject
import kotlin.math.abs


class ProductDetailFragment : Fragment() {
    val PRODUCT_KEY = "PRODUCT_KEY"

    @Inject
    lateinit var viewModel: ProductDetailViewModel

    lateinit var binding: FragmentProductDetailBinding
    lateinit var product: BestSeller
    lateinit var navController: NavController
    private var isCapacity1 = true
    lateinit var mViewPager: ViewPager2
    lateinit var mViewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val comp = DaggerDetailsComponent.builder()
            .coreComponent(DaggerCoreComponent.create())
            .build()
        comp.inject(this)
        binding = FragmentProductDetailBinding.inflate(layoutInflater, container, false)
        product = arguments?.getSerializable(PRODUCT_KEY) as BestSeller
        mViewPager = binding.viewPager
        mViewPagerAdapter = ViewPagerAdapter(mViewPager, requireContext())
        mViewPager.adapter = mViewPagerAdapter
        mViewPager.clipToPadding = false
        mViewPager.clipChildren = false
        mViewPager.offscreenPageLimit = 3
        mViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { page, position ->
            val r: Float = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        })
        mViewPager.setPageTransformer(compositePageTransformer)
        binding.selected2.visibility = View.INVISIBLE
        navController = findNavController()
        binding.backButton.setOnClickListener {
            navController.navigateUp()
        }
        binding.cartButton.setOnClickListener {
            navController.navigate(R.id.action_productDetailFragment_to_cartFragment)
        }
        binding.color1.setOnClickListener {
            if (binding.selected1.visibility == View.INVISIBLE) {
                binding.selected1.visibility = View.VISIBLE
                binding.selected2.visibility = View.INVISIBLE
            }
        }
        binding.color2.setOnClickListener {
            if (binding.selected2.visibility == View.INVISIBLE) {
                binding.selected2.visibility = View.VISIBLE
                binding.selected1.visibility = View.INVISIBLE
            }
        }
        binding.capacity1.setOnClickListener {
            if (!isCapacity1) {
                isCapacity1 = true
                binding.capacity1.setCardBackgroundColor(Color.parseColor("#FF6E4E"))
                binding.tvCapacity1.setTextColor(Color.WHITE)
                binding.capacity2.setCardBackgroundColor(Color.WHITE)
                binding.tvCapacity2.setTextColor(Color.parseColor("#B7B7B7"))
            }
        }
        binding.capacity2.setOnClickListener {
            if (isCapacity1) {
                isCapacity1 = false
                binding.capacity2.setCardBackgroundColor(Color.parseColor("#FF6E4E"))
                binding.tvCapacity2.setTextColor(Color.WHITE)
                binding.capacity1.setCardBackgroundColor(Color.WHITE)
                binding.tvCapacity1.setTextColor(Color.parseColor("#B7B7B7"))
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
//        viewModel.getDetailsDb().observe(viewLifecycleOwner, Observer {
//            if (it == null) {
//                if (isOnline(requireContext())) {
//                    loadData()
//                    binding.tvConnectionLost2.visibility = View.GONE
//                } else {
//                    binding.tvConnectionLost2.visibility = View.VISIBLE
//                }
//            } else {
//                if (isOnline(requireContext())) {
//                    loadDbData()
//                    binding.tvConnectionLost2.visibility = View.GONE
//                } else {
//                    binding.tvConnectionLost2.visibility = View.VISIBLE
//                }
//            }
//        })
        loadData()

    }

    @SuppressLint("SetTextI18n")
    private fun loadData() {
        viewModel.getDetails()
        viewModel.resp.observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
//                viewModel.insert(it)
            }
            mViewPagerAdapter.setList(it.images)
            binding.apply {
                camera.text = it.camera
                sd.text = "${it.sd}  "
                ssd.text = "${it.ssd}  "
                name.text = it.title
                price.text = "$${it.price}"
                if (it.isFavorites) favBut.setImageResource(R.drawable.ic_fullheart)
                color1.setCardBackgroundColor(Color.parseColor(it.color[0]))
                color2.setCardBackgroundColor(Color.parseColor(it.color[1]))
                tvCapacity1.text = "${it.capacity[0]} GB"
                tvCapacity2.text = "${it.capacity[1]} GB"
            }

        })
    }

//    @SuppressLint("SetTextI18n")
//    private fun loadDbData() {
//        viewModel.getDetailsDb().observe(viewLifecycleOwner, Observer {
//            mViewPagerAdapter.setList(it.images)
//            binding.apply {
//                camera.text = it.camera
//                sd.text = "${it.sd}  "
//                ssd.text = "${it.ssd}  "
//                name.text = it.title
//                price.text = "$${it.price}"
//                if (it.isFavorites) favBut.setImageResource(R.drawable.ic_fullheart)
//                color1.setCardBackgroundColor(Color.parseColor(it.color[0]))
//                color2.setCardBackgroundColor(Color.parseColor(it.color[1]))
//                tvCapacity1.text = "${it.capacity[0]} GB"
//                tvCapacity2.text = "${it.capacity[1]} GB"
//            }
//
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

}