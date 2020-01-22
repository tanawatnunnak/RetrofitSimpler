package com.example.retrofitsimpler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainActvityViewModel: MainActivityViewModel by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActvityViewModel.getUser("tanawatnunnak").observe(this, Observer {
            if (it.isSuccess){
                it.data?.let {user ->
                    text_name.text = user.login
                    Picasso.get().load(user.avatar_url).into(imageView)
                }
            }
        })
    }
}
