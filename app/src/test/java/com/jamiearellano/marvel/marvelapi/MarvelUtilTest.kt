package com.jamiearellano.marvel.marvelapi

import com.jamiearellano.marvel.marvelapi.model.Comic
import com.squareup.moshi.JsonAdapter
import org.junit.Assert
import org.junit.Test

class MarvelUtilTest {

    @Test
    fun getAuth_basicString_returnsTrue(){
        Assert.assertNotNull(getAuth("YO"))
    }

    @Test
    fun getAuthString_basicString_returnsTrue(){
        Assert.assertNotNull(getAuthString("YO"))
    }

    @Test
    fun parseResponse_isComic_returnsTrue(){
        val adapter = AdapterFactory().getComicById() as JsonAdapter<Any>
        Assert.assertNotNull(adapter)
        val jsonString = validComicResponse
        val response = parseResponse(jsonString, adapter)
        Assert.assertNotNull(response)
        assert(response is Comic)
    }

    @Test
    fun parseResponse_isComic_returnsException(){
        val adapter = AdapterFactory().getComicById() as JsonAdapter<Any>
        Assert.assertNotNull(adapter)
        val jsonString = invalidComicResponse
        val response = parseResponse(jsonString, adapter)
        Assert.assertNotNull(response)
        assert(response is Exception)
    }
}

const val invalidComicResponse = "{}"
const val validComicResponse = "{\"code\":200,\"status\":\"Ok\",\"copyright\":\"© 2021 MARVEL\",\"attributionText\":\"Data provided by Marvel. © 2021 MARVEL\",\"attributionHTML\":\"<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2021 MARVEL</a>\",\"etag\":\"7800f209668de898437ee53e3a1362f53b98ce87\",\"data\":{\"offset\":0,\"limit\":20,\"total\":1,\"count\":1,\"results\":[{\"id\":64570,\"digitalId\":45805,\"title\":\"Venom (2016) #154\",\"issueNumber\":154,\"variantDescription\":\"\",\"description\":\"A FIRST-OF-ITS-KIND TALE TOLD IN THE MIGHTY MARVEL MANNER!! You've seen things from Eddie Brock's perspective; now see how things look from the other side - in this, a whole issue from the perspective of the Venom Symbiote!\",\"modified\":\"2017-09-13T15:07:51-0400\",\"isbn\":\"\",\"upc\":\"75960608626915411\",\"diamondCode\":\"JUL171070\",\"ean\":\"\",\"issn\":\"\",\"format\":\"Comic\",\"pageCount\":32,\"textObjects\":[{\"type\":\"issue_solicit_text\",\"language\":\"en-us\",\"text\":\"A FIRST-OF-ITS-KIND TALE TOLD IN THE MIGHTY MARVEL MANNER!! You've seen things from Eddie Brock's perspective; now see how things look from the other side - in this, a whole issue from the perspective of the Venom Symbiote!\"}],\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/64570\",\"urls\":[{\"type\":\"detail\",\"url\":\"http://marvel.com/comics/issue/64570/venom_2016_154?utm_campaign=apiRef&utm_source=70bcfc556b9513693f947f56ef80e363\"},{\"type\":\"purchase\",\"url\":\"http://comicstore.marvel.com/Venom-154/digital-comic/45805?utm_campaign=apiRef&utm_source=70bcfc556b9513693f947f56ef80e363\"},{\"type\":\"reader\",\"url\":\"http://marvel.com/digitalcomics/view.htm?iid=45805&utm_campaign=apiRef&utm_source=70bcfc556b9513693f947f56ef80e363\"},{\"type\":\"inAppLink\",\"url\":\"https://applink.marvel.com/issue/45805?utm_campaign=apiRef&utm_source=70bcfc556b9513693f947f56ef80e363\"}],\"series\":{\"resourceURI\":\"http://gateway.marvel.com/v1/public/series/22657\",\"name\":\"Venom (2016 - 2018)\"},\"variants\":[],\"collections\":[],\"collectedIssues\":[],\"dates\":[{\"type\":\"onsaleDate\",\"date\":\"2017-09-20T00:00:00-0400\"},{\"type\":\"focDate\",\"date\":\"2017-08-28T00:00:00-0400\"},{\"type\":\"unlimitedDate\",\"date\":\"2018-03-26T00:00:00-0400\"},{\"type\":\"digitalPurchaseDate\",\"date\":\"2017-09-20T00:00:00-0400\"}],\"prices\":[{\"type\":\"printPrice\",\"price\":3.99},{\"type\":\"digitalPurchasePrice\",\"price\":3.99}],\"thumbnail\":{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/9/e0/59b93fa36fa55\",\"extension\":\"jpg\"},\"images\":[{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/9/e0/59b93fa36fa55\",\"extension\":\"jpg\"},{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/a/40/597f9c5d248bc\",\"extension\":\"jpg\"}],\"creators\":{\"available\":8,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/64570/creators\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/12452\",\"name\":\"Mike Costa\",\"role\":\"writer\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/10172\",\"name\":\"Vc Clayton Cowles\",\"role\":\"letterer\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/12457\",\"name\":\"Edward Devin Lewis\",\"role\":\"editor\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/12991\",\"name\":\"Rachelle Rosenberg\",\"role\":\"colorist\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/12369\",\"name\":\"Gerardo Sandoval\",\"role\":\"penciler (cover)\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/7413\",\"name\":\"Paulo Siqueira\",\"role\":\"inker\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/480\",\"name\":\"Cam Smith\",\"role\":\"inker\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/4074\",\"name\":\"Walden Wong\",\"role\":\"inker\"}],\"returned\":8},\"characters\":{\"available\":1,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/64570/characters\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1010787\",\"name\":\"Eddie Brock\"}],\"returned\":1},\"stories\":{\"available\":2,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/64570/stories\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/140151\",\"name\":\"cover from Venom (2016) #154\",\"type\":\"cover\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/140152\",\"name\":\"story from Venom (2016) #154\",\"type\":\"interiorStory\"}],\"returned\":2},\"events\":{\"available\":0,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/64570/events\",\"items\":[],\"returned\":0}}]}}"
