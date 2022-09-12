package au.edu.swin.sdmd.l06_detailedimages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val station = Location("Glenferrie Station", "Ada May Plante",
            -37.821539f, 145.036473f)

        val vStation = findViewById<TextView>(R.id.station)
        vStation.setOnClickListener {
            //create intent for DetailActivity and put extra
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("location", station) //parcelable object extra
            }
            startActivity(intent)
        }
    }


}