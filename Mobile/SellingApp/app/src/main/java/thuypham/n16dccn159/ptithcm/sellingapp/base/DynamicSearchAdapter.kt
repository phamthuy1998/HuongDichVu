package thuypham.n16dccn159.ptithcm.sellingapp.base

import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

abstract class DynamicSearchAdapter<T : DynamicSearchAdapter.Searchable>(
    private var searchableList: MutableList<T>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    // Single not-to-be-modified copy of original data in the list.
    private var originalList = searchableList?.let { ArrayList(it) }
    // a method-body to invoke when search returns nothing. It can be null.
    private var onNothingFound: (() -> Unit)? = null
    private var onResultSearch: ((MutableList<T>) -> Unit)? = null
    /**
     * Searches a specific item in the list and updates adapter.
     * if the search returns empty then onNothingFound callback is invoked if provided which can be used to update UI
     * @param s the search query or text. It can be null.
     * @param onNothingFound a method-body to invoke when search returns nothing. It can be null.
     */
    fun updateData(list: MutableList<T>?) {
        searchableList = list
        originalList = searchableList?.let { ArrayList(it) }
    }

    fun search(
        s: String?,
        onNothingFound: (() -> Unit)?,
        onSearchResult: ((MutableList<T>) -> Unit)?
    ) {
        this.onNothingFound = onNothingFound
        this.onResultSearch = onSearchResult
        filter.filter(s)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            private val filterResults = FilterResults()
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                searchableList?.clear()
                if (constraint.isNullOrBlank()) {
                    originalList?.let { searchableList?.addAll(it) }
                } else {

                    val searchResults = originalList?.filter { item ->
                        item.getSearchCriteria().toLowerCase(Locale.ROOT)
                            .contains(constraint.toString().toLowerCase(Locale.ROOT))
                    }
                    searchResults?.let { searchableList?.addAll(it) }
                }
                return filterResults.also {
                    it.values = searchableList
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                // no need to use "results" filtered list provided by this method.
                if (searchableList.isNullOrEmpty()) onNothingFound?.invoke()
                else onResultSearch?.invoke(searchableList!!)
            }
        }
    }

    interface Searchable {
        /** This method will allow to specify a search string to compare against
        your search this can be anything depending on your use case.
         */
        fun getSearchCriteria(): String
    }
}