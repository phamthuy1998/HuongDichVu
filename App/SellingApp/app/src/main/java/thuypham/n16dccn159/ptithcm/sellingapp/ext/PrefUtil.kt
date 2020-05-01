package thuypham.n16dccn159.ptithcm.sellingapp.ext

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


//KEY WORD
const val USER_PROFILE = "USER"

class PrefUtil constructor(
    private val context: Context,
    private val prefs: SharedPreferences,
    private val gSon: Gson
) {

    fun isNetworkConnected(): Boolean {
        var result = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.getNetworkCapabilities(cm.activeNetwork)?.run {
            result = when {
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
        return result
    }

    fun clearAllData() = prefs.edit().clear().commit()

    var user: User?
        get() {
            return try {
                gSon.fromJson(
                    prefs.getString(USER_PROFILE, null),
                    User::class.java
                )
            } catch (e: Exception) {
                null
            }
        }
        set(value) = prefs.edit().putString(
            USER_PROFILE,
            gSon.toJson(value)
        ).apply()
}