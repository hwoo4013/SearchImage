import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import api.Retrofit_client
import com.example.searchimage_ver2.R
import data.ImageModel
import kotlinx.coroutines.launch
import retrofit2.Response
import util.Constants

class SearchFragment : Fragment() {

    private lateinit var adapter: SearchAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewSearch)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = SearchAdapter()
        recyclerView.adapter = adapter

        // 예를 들어 검색 버튼 클릭 시 fetchImageResults 호출
        fetchImageResults("your_query")

        return view
    }

     fun fetchImageResults(query: String) = lifecycleScope.launch {
        try {
            // 여기에서 apiService를 사용하여 이미지 검색 API를 호출하고 응답을 처리
            val responseData: ImageModel? =
                Retrofit_client.api.searchImage(Constants.AUTH_HEADER, query, "recency", 1, 80)

            responseData?.meta?.let { meta ->
                if (meta.totalCount?.compareTo(0) ?: 0 > 0) {
                    val resItems = mutableListOf<SearchAdapter.SearchItemModel>()
                    responseData.documents.forEach { document ->
                        val title = document.displaySiteName
                        val datetime = document.dateTime
                        val imageUrl = document.thumbnailUrl
                        resItems.add(SearchAdapter.SearchItemModel(title, datetime, imageUrl))
                    }

                    adapter.setItems(resItems)
                }
            }
        } catch (e: Exception) {
            // 에러 처리
            e.printStackTrace()
        }
    }
}
