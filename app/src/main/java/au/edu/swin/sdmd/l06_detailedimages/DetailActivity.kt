package au.edu.swin.sdmd.l06_detailedimages

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class DetailActivity : AppCompatActivity() {
    var location : Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //get text views from activity
        val vName = findViewById<TextView>(R.id.name)
        val vAuthor = findViewById<TextView>(R.id.author)
        val vLatitude = findViewById<TextView>(R.id.latitude)
        val vLongitude = findViewById<TextView>(R.id.longitude)
        val vVisited = findViewById<Switch>(R.id.visited)

        //get location object from intent
        location = intent.getParcelableExtra<Location>("location")

        //populate text views with data location object
        location?.let {
            vName.text = it.name
            vAuthor.text = it.author
            vLatitude.text = it.latitude.toString()
            vLongitude.text = it.longitude.toString()
            vVisited.isChecked = it.visited
        }
    }

    override fun onBackPressed() {
        //when back button pressed update location object and put in intent extra
        location?.visited = findViewById<Switch>(R.id.visited).isChecked
        val intent = intent.apply {
            putExtra("location", location)
        }
        setResult(Activity.RESULT_OK, intent) //set result with updated intent
        super.onBackPressed()
    }
}