package com.example.rickandmortyapi.data.network

//class InternetConnectionChecker @Inject constructor(val context: Context) {
//    fun checkInternetConnection(): State<List<CharacterModel>> {
//        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//            val network = connectivityManager.activeNetwork ?:
//            return State.NoInternet(message = context.getString(R.string.no_internet_message))
//
//            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?:
//            return State.NoInternet(message = context.getString(R.string.no_internet_message))
//
//            return when {
//                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ->
//                    return State.Loading()
//                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->
//                    return State.Loading()
//                else ->
//                    return State.NoInternet(message = context.getString(R.string.no_internet_message))
//            }
//        } else {
//            @Suppress("DEPRECATION") val networkInfo =
//                connectivityManager.activeNetworkInfo ?:
//                return State.NoInternet(message = context.getString(R.string.no_internet_message))
//            @Suppress("DEPRECATION")
//            return State.Loading()
//        }
//    }
//}