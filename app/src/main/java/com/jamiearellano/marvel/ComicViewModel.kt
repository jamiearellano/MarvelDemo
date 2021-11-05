package com.jamiearellano.marvel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.jamiearellano.marvel.marvelapi.*
import com.jamiearellano.marvel.marvelapi.model.Comic

class ComicViewModel(application: Application) : AndroidViewModel(application) {

    var comicViewModelLiveData = MutableLiveData<ComicModel?>()
    var comic:Comic? = null

    suspend fun fetchComicById(context: Context, comicId:String){
        comic = MarvelRepository(context).fetchComicById(comicId)
        updateViewModel()
    }

    private fun updateViewModel(variant:ImageVariant = ImageVariant.portrait_xlarge ){
        var title = comic?.data?.results?.get(0)?.title
        if(title == null) title = ""
        var description = comic?.data?.results?.get(0)?.description
        if(description == null) description = ""
        val thumb = comic?.data?.results?.get(0)?.thumbnail?.path
        // TODO: handle/test thumbnail null and bad urls
        var url = getImageUrl(thumb.toString(), ImageVariant.portrait_xlarge)

        comicViewModelLiveData.postValue(
            ComicModel(title, description, url)
        )
    }

    private fun getImageUrl(rootUrl:String, variant:ImageVariant = ImageVariant.portrait_xlarge):String{
        var root = rootUrl
        var variantImage = variant
        val factory = ImageVariantFactory()
        val result = factory.getUrl(root, variantImage)

        return result
    }

}

class ComicModel(val title:String? = "", val description:String? = "", val imageUrl:String?)
