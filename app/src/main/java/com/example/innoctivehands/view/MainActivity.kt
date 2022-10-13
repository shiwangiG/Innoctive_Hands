package com.example.innoctivehands.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.innoctivehands.databinding.ActivityMainBinding
import com.example.innoctivehands.presenter.InnoPresenter

class MainActivity : AppCompatActivity() {

    lateinit var photoRV: RecyclerView
    lateinit var photoRVAdapter: PhotoAdapter
    lateinit var photoList: ArrayList<String>

    var binding: ActivityMainBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

//        val personName : ArrayList
        // on below line we are initializing
        // our views with their ids.
        photoRV = binding!!.imagesGrid

        // on below line we are
        // initializing our list
        photoList = ArrayList()

        // on below line we are initializing our adapter
        photoRVAdapter = PhotoAdapter(photoList)

        // on below line we are setting layout manager for our recycler view
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        photoRV.layoutManager = staggeredGridLayoutManager

        // on below line we are setting
        // adapter to our recycler view.
        photoRV.adapter = photoRVAdapter

        // on below line we are adding data to our list
        photoList.add("https://cdn2.thecatapi.com/images/mo.jp")
        photoList.add("https://cdn2.thecatapi.com/images/mo.jp")
        photoList.add("https://cdn2.thecatapi.com/images/mo.jp")
        photoList.add("https://cdn2.thecatapi.com/images/mo.jp")
        photoList.add("https://cdn2.thecatapi.com/images/mo.jp")
        photoList.add("https://cdn2.thecatapi.com/images/mo.jp")


        val innoPresenter = InnoPresenter()

        // Maybe it's best to call it on onResume()

        // Maybe it's best to call it on onResume()
        innoPresenter.getImages()

        // on below line we are notifying adapter
        // that data has been updated.
        photoRVAdapter.notifyDataSetChanged()


    }
}