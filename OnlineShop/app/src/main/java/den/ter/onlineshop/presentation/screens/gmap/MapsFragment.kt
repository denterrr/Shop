package den.ter.onlineshop.presentation.screens.gmap

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import den.ter.onlineshop.R
import den.ter.onlineshop.databinding.FragmentMapsBinding

class MapsFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var googleMap: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var fusedLocation: FusedLocationProviderClient
    private lateinit var binding: FragmentMapsBinding
    private var permGranted = false


    companion object {
        private const val LOCATION_REQUEST_CODE = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        fusedLocation = LocationServices.getFusedLocationProviderClient(requireActivity())
    }

    override fun onMapReady(gMap: GoogleMap) {
        googleMap = gMap
        googleMap.uiSettings.isZoomControlsEnabled = true
        Markers()
        binding.btnSeekme.setOnClickListener {
            setUpMap()
        }
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) setUpMap()

    }


    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_REQUEST_CODE
            )



        }

        fusedLocation.lastLocation.addOnSuccessListener(requireActivity()) { location ->
            if (location != null) {
                lastLocation = location
                val curLatLong = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(curLatLong)
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(curLatLong, 15f))
            }

        }

    }

    private fun placeMarkerOnMap(curLatLong: LatLng) {
        val markerOptions = MarkerOptions().position(curLatLong)
        googleMap.addMarker(markerOptions)
    }

    private fun Markers() {
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(55.755826,37.6173), 10f))
        googleMap.addMarker(MarkerOptions().position(LatLng(55.755826,37.6173)))
        googleMap.addMarker(MarkerOptions().position(LatLng(55.796127, 49.106414)))
        googleMap.addMarker(MarkerOptions().position(LatLng(55.796127, 46.106414)))
        googleMap.addMarker(MarkerOptions().position(LatLng(55.796127, 36.106414)))
        googleMap.addMarker(MarkerOptions().position(LatLng(55.796127, 66.106414)))
        googleMap.addMarker(MarkerOptions().position(LatLng(55.796127, 35.106414)))
    }

    override fun onMarkerClick(p0: Marker) = false
}