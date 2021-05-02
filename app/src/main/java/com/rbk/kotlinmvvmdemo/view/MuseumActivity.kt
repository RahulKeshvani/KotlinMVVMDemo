package com.rbk.kotlinmvvmdemo.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rbk.kotlinmvvmdemo.di.Injection
import com.rbk.kotlinmvvmdemo.model.Museum
import com.rbk.kotlinmvvmdemo.viewmodel.MuseumViewModel
import com.rbk.kotlinmvvmdemo.R
import kotlinx.android.synthetic.main.activity_museum.*
import kotlinx.android.synthetic.main.layout_error.*
class MuseumActivity : AppCompatActivity() {

    private lateinit var viewModel: MuseumViewModel
    private lateinit var adapter: MuseumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        setupViewModel()
        setupUI()
    }

    //ui
    private fun setupUI() {
        adapter = MuseumAdapter(viewModel.museums.value ?: emptyList())
        adapter.apply {
            musuemClick = {
                itemClick(it)
            }
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


    private fun itemClick(watches: Museum) {
        Toast.makeText(this, "Hi|"+watches.phone, Toast.LENGTH_SHORT).show()
    }

    //view model
    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            Injection.provideViewModelFactory()
        ).get(MuseumViewModel::class.java)

        viewModel.museums.observe(this, renderMuseums)
        viewModel.isViewLoading.observe(this, isViewLoadingObserver)
        viewModel.onMessageError.observe(this, onMessageErrorObserver)
        viewModel.isEmptyList.observe(this, emptyListObserver)
    }

    //observers
    private val renderMuseums = Observer<List<Museum>> {
        Log.v(TAG, "data updated $it")
        layoutError.visibility = View.GONE
        layoutEmpty.visibility = View.GONE
        adapter.update(it)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        Log.v(TAG, "isViewLoading $it")
        val visibility = if (it) View.VISIBLE else View.GONE
        progressBar.visibility = visibility
    }

    @SuppressLint("SetTextI18n")
    private val onMessageErrorObserver = Observer<Any> {
        Log.v(TAG, "onMessageError $it")
        layoutError.visibility = View.VISIBLE
        layoutEmpty.visibility = View.GONE
        textViewError.text = "Error $it"
    }

    private val emptyListObserver = Observer<Boolean> {
        Log.v(TAG, "emptyListObserver $it")
        layoutEmpty.visibility = View.VISIBLE
        layoutError.visibility = View.GONE
    }

    //If you require updated data, you can call the method "loadMuseum" here
    override fun onResume() {
        super.onResume()
        viewModel.loadMuseums()
    }

    companion object {
        const val TAG = "CONSOLE"
    }
}
