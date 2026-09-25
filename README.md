# SecureCart - E-commerce REST API

**Live API:** `http://YOUR-EC2-IP/api/products?page=0&size=10`  
**Postman:** `/docs/postman_collection.json`  
**SQL Proof:** `/docs/sql-proof.png`

> Production-style backend built with Java 17 + Spring Boot to solve real backend problems such as N+1 queries, concurrent updates, pagination, caching, and authentication.

## 🚀 Performance Wins

**N+1: 11 queries → 1 query (1200ms → 120ms)**

```java
@Query("""
    SELECT new com.securecart.dto.ProductDTO(p.name, c.name)
    FROM Product p
    JOIN p.category c
""")
Page<ProductDTO> findAllDTO(Pageable pageable);
