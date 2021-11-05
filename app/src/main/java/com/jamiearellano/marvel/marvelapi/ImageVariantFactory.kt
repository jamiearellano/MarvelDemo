package com.jamiearellano.marvel.marvelapi

class ImageVariantFactory(var extension:String = "jpg") {

    fun getUrl(rootUrl:String, variant: ImageVariant): String{
        return makeUrl(rootUrl, variant.name)
    }
    private fun makeUrl(rootUrl:String, variantName:String) : String{
        return "$rootUrl/${variantName}.$extension"
    }
}
enum class ImageVariant {
    portrait_small, portrait_medium, portrait_xlarge, portrait_fantastic, portrait_uncanny, portrait_incredible,

    standard_small, standard_medium, standard_large, standard_xlarge, standard_fantastic, standard_amazing,

    landscape_small, landscape_medium, landscape_large, landscape_xlarge, landscape_amazing, landscape_incredible,

    detail
}
