package au.edu.swin.sdmd.l06_detailedimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //get text views from activity
        val vName = findViewById<TextView>(R.id.name)
        val vAuthor = findViewById<TextView>(R.id.author)
        val vLatitude = findViewById<TextView>(R.id.latitude)
        val vLongitude = findViewById<TextView>(R.id.longitude)

        //populate text views with data from intent extras
        vName.text = intent.getStringExtra("name")
        vAuthor.text = intent.getStringExtra("author")
        vLatitude.text = intent.getStringExtra("lat")
        vLongitude.text = intent.getStringExtra("long")
    }
}