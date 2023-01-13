package co.tiagoaguiar.course.instagram.camera.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R

class FragmentCamera : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

}