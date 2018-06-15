import kotlin.math.PI
import kotlin.math.pow

class CircleAreaCalculator {
    fun calculateCircleArea(radius : Double) : Double {
        return PI * radius.pow(2)
    }
}