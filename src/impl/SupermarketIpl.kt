package impl

interface SupermarketIpl {
    val seed: Int
    val sells: LinkedHashMap<ProductImpl, Double>
    val products: LinkedHashMap<ProductImpl, Double>
    fun open(seed: Int)
    fun close()
    fun getRowStatistics(sells: LinkedHashMap<ProductImpl, Double>)
    fun addToStatistic(product: ProductImpl, count: Double)
    fun getProductList(): LinkedHashMap<ProductImpl, Double>
    fun addToProductList(product: ProductImpl, count: Double)
//    fun getProductCount(product: ProductImpl): Double
    fun setDiscounts()
    fun createCashDesk()
}