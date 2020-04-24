package impl

interface BasketImpl {
    val content: LinkedHashMap<ProductImpl, Double>
    fun add(product: ProductImpl, count: Double)
    fun getAll():LinkedHashMap<ProductImpl, Double>
    fun getBill(): Double
}