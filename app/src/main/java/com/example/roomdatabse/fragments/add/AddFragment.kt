package com.example.roomdatabse.fragments.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabse.R
import com.example.roomdatabse.User
import com.example.roomdatabse.UserViewModel


class AddFragment : Fragment() {
    private var mFirstName:String? = null
    private  var mLastName:String? = null
    private  var mAge:String? = null
    private lateinit var mUserViewModel:UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mFirstName = view.findViewById<EditText>(R.id.editTextTextPersonName2).text.toString()
        mLastName = view.findViewById<EditText>(R.id.editTextTextPersonName3).text.toString()
        mAge = view.findViewById<EditText>(R.id.editTextTextPersonName4).text.toString()

        val addButton = view.findViewById<Button>(R.id.button)
        addButton.setOnClickListener{
            Log.d("Hello","CLICKED !!!")
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase(){
            mAge = "23"
            val user = User(0, mFirstName, mLastName, Integer.parseInt(mAge))
            // Add data  to db
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully Added", Toast.LENGTH_LONG).show()

            // Navigate back to list fragment
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }


}