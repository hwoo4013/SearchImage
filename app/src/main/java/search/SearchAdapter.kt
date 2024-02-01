import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchimage_ver2.R
import java.util.Date

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var items: List<SearchItemModel> = emptyList()

    fun setItems(items: List<SearchItemModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val textViewImageUrl: TextView = itemView.findViewById(R.id.textViewImageUrl)

        fun bind(item: SearchItemModel) {
            // 이미지를 로드하여 ImageView에 설정 (Glide 사용)
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .into(imageView)

            // 이미지 URL을 TextView에 설정
            textViewImageUrl.text = item.imageUrl
        }
    }

    data class SearchItemModel(
        val title: String,
        val dateTime: Date,
        val imageUrl: String
    )
}