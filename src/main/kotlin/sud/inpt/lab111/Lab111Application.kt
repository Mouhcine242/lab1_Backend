package sud.inpt.lab111

import net.bytebuddy.utility.RandomString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import sud.inpt.lab111.dao.CategoryRepository
import sud.inpt.lab111.dao.ProductRepository
import sud.inpt.lab111.data.Category
import sud.inpt.lab111.data.Product
import java.util.function.Consumer
import kotlin.random.Random

@SpringBootApplication
class Lab111Application  :CommandLineRunner {

	@Autowired
	var productRepository : ProductRepository?= null

	@Autowired
	var categoryRepository : CategoryRepository?=null


	@Throws(Exception :: class)
	override fun run(vararg args: String?) {

		val category1 = Category()
		val category2 = Category()
		val category3 = Category()
		category1.name = "Computers"
		category2.name = "Smartphons"
		category3.name = "Printers"
		categoryRepository?.save(category1)
		categoryRepository?.save(category2)
		categoryRepository?.save(category3)

		var rnd = Random
		categoryRepository?.findAll()?.forEach(Consumer { category : Category? ->
			for (i in 0..9) {
				val product = Product()
				product.name = RandomString.make(10)
				product.currentPrice = 100 + rnd.nextDouble()
				product.isAvailable = rnd.nextBoolean()
				product.isPromotion = rnd.nextBoolean()
				product.isSelected = rnd.nextBoolean()
				product.category = category
				product.photoName = "unknown.png"
				productRepository!!.save(product)
			}
		})
	}
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(Lab111Application::class.java, *args)
		}
	}
}
