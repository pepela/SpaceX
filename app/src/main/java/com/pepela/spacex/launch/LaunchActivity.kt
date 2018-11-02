package com.pepela.spacex.launch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pepela.spacex.R
import kotlinx.android.synthetic.main.activity_launches.*
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.ext.android.bindScope
import org.koin.androidx.scope.ext.android.getOrCreateScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchActivity : AppCompatActivity() {

    private val adapter: LaunchAdapter by inject()

    private val launchViewModel: LaunchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindScope(getOrCreateScope("launch"))
        setContentView(R.layout.activity_launches)

        launchViewModel.getLaunchesLiveData().observe(this,
                Observer {
                    adapter.items = it
                })

        launches_rv.adapter = adapter
        launches_rv.layoutManager = LinearLayoutManager(this)
    }

}
