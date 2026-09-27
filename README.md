# SecureCart - E-commerce REST API

> Hands-on backend project built with Java 17 + Spring Boot to solve real
> backend problems such as N+1 queries, pagination, caching, and authentication.



## 🚀 Performance Wins

Resolved the N+1 query problem using `JOIN FETCH` and DTO projections,
reducing unnecessary database queries and improving API response performance.

```java
@Query("""
    SELECT new com.vamshi.ecommerce.dto.ProductDTO(p.name, c.name)
    FROM Product p
    JOIN p.category c
""")
Page<ProductDTO> findAllDTO(Pageable pageable);
