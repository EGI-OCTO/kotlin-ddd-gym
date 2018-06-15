class CylinderVolumeCalculator(private val multiplier: CircleAreaCalculator) {

    fun calculateCylinderVolume(radius : Double, height : Double) : Double {
        return multiplier.calculateCircleArea(radius) * height
    }
}