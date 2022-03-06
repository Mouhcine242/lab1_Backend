package sud.inpt.lab111.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin
import sud.inpt.lab111.data.Product

@CrossOrigin("*")
@RepositoryRestResource
interface ProductRepository : JpaRepository<Product? , Long?> {
}