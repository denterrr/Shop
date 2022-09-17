package den.ter.onlineshop.presentation.screens

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import den.ter.core.R
import den.ter.onlineshop.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    var key = ""
    var uri: Uri = "".toUri()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arguments = intent.extras
        if (arguments != null) {
            key = arguments.get("key").toString()
        }
        navController = findNavController(R.id.nav_fragment)
        binding.bottomNavView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, dest, _ ->
            if (dest.id == R.id.productDetailFragment || dest.id == R.id.cartFragment ||
                dest.id == R.id.mapsFragment
            ) {
                binding.bottomNavView.visibility = View.GONE
            } else {
                binding.bottomNavView.visibility = View.VISIBLE
            }

        }
        if (intent?.data != null) uri = intent.data!!
        if (key == "1") {
            navController.navigate(R.id.action_startFragment_to_cartFragment)
        }
        if (uri.toString().isNotEmpty()) {
            val path = uri.toString()
            for(i in 1..path.length-1){
                if("${path.elementAt(i-1)}${path.elementAt(i)}" == "m/"){
                    val way = path.substring(i+1,path.length)
                    when(way){
                        "cart" -> navController.navigate(R.id.action_startFragment_to_cartFragment)
                        "details" -> navController.navigate(R.id.action_startFragment_to_productDetailFragment)
                        else -> {}
                    }
                }
            }
        }

    }


}