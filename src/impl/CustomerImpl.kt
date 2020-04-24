package impl

interface CustomerImpl {
    fun getCategory(): Int
    val cash: Double
    val cardMoney: Double
    val bonuses: Int
    fun addToBasket(product: ProductImpl, count: Double)
}