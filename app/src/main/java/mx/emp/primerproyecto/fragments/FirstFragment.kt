package mx.emp.primerproyecto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mx.emp.primerproyecto.R
/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    var name:String? = null

    companion object{
        fun newInstance(name:String):FirstFragment{
            return FirstFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_NAME",name)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = it.getString("ARG_NAME")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val tvNext = view.findViewById<TextView>(R.id.tvNext)

        tvNext.text = name

        tvNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container,SecondFragment.newInstance(name?:"Sin definir"))
                .addToBackStack("SecondFragment")
                .commit()
        }
        return view
    }

}