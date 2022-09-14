package au.edu.swin.sdmd.l06_detailedimages

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var station : Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        station = Location("Glenferrie Station", "Ada May Plante",
            -37.821539f, 145.036473f)

        val vStation = findViewById<TextView>(R.id.station)
        vStation.setOnClickListener {
            //create intent for DetailActivity and put extra
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("location", station) //parcelable object extra
            }
            //startActivity(intent)
            startActivityForResult.launch(intent)
        }
    }

    val startActivityForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val vStation = findViewById<TextView>(R.id.station)
        when(result.resultCode){
            RESULT_OK -> {
                val data = result.data
                val location = data?.getParcelableExtra<Location>("location")
                location?.let {
                    vStation.setTextColor(if (it.visited) Color.GREEN else Color.RED) //set text color based on visited
                    station = location //update station variable with new location object from result
                }
            }
        }
    }

}