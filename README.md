# Marvel API Demo app

## How to set up the API Keys

### OPEN FILE: 

gradle.properties

### ADD (using valid public/private keys):

'''
MARVEL_PUBLIC_KEY = ""

MARVEL_PRIVATE_KEY = ""
'''

**Select build variants and select debug after updating the file. You may need to toggle to release then back to debug for it to take. 


###Coroutines used to make request to server in a thread like manner
[Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2

###Volley Library is used to make the request to the marvel api
[Volley](https://github.com/google/volley)
Usage:
- marvelapi/HttpFactory.kt

com.android.volley:volley:1.2.1

###Moshi API used for mapping json object.
[Moshi](https://github.com/square/moshi)
Usage:
- marvelapi/AdapterFactory
- marvelapi/model/comic

com.squareup.moshi:moshi:1.12.0
com.squareup.moshi:moshi-kotlin-codegen:1.12.0

###Glide API is used to download and render the comic cover to the imageview
[Glide](https://github.com/bumptech/glide)
Usage:
- MainActivity.kt

com.github.bumptech.glide:glide:4.12.0
com.github.bumptech.glide:compiler:4.12.0

