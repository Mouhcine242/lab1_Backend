package sud.inpt.lab111.data
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import javax.persistence.*


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Product : java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var description: String? = null
    var currentPrice = 0.0
    var isPromotion = false
    var isAvailable = false
    var isSelected = false
    var photoName: String? = null
    @ManyToOne
    var category: Category? = null

}