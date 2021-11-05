package com.jamiearellano.marvel

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.request.RequestListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.target.Target

class MainActivity : AppCompatActivity() {

    lateinit var comicTitle: TextView
    lateinit var comicDescription: TextView
    lateinit var comicCover: ImageView
    lateinit var progressBar: ProgressBar

    lateinit var comicViewModel: ComicViewModel

    val wolverineNullDescription = "85505"
    val venomWithDescription = "64570"
    val venomWithHtmlTagsInDescription = "40651"
    private val defaultComic = wolverineNullDescription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
        fetchComic()
    }

    private fun fetchComic(comicId:String = defaultComic){
        // TODO: use lifecycle aware scope
        GlobalScope.launch(Dispatchers.Default){
            progressBar.visibility = View.VISIBLE
            comicViewModel.fetchComicById(applicationContext,comicId)
        }
    }


    // TODO: convert to data binding and/or view holder object
    private fun initView(){
        this.actionBar?.hide();
        setContentView(R.layout.activity_main)
        comicTitle = findViewById(R.id.comicTitle)
        comicDescription = findViewById(R.id.comicDescription)
        comicCover = findViewById(R.id.comicCover)
        progressBar = findViewById(R.id.progressBar)
        comicViewModel = ComicViewModel(application)
    }

    private fun initData(){
        comicViewModel.comicViewModelLiveData.observe(
            this,
            {
                if (it != null) {
                    comicTitle.text = it.title.toString()
                    comicDescription.text = HtmlCompat.fromHtml(it.description.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
                    loadComicCover(it.imageUrl)
                }
            })
    }

    private fun loadComicCover(imageUrl:String?){
        Glide.with(this)
            .load(imageUrl)
            .listener(object : RequestListener<Drawable> {
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }

                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }
            })
            .into(comicCover)
    }

}
