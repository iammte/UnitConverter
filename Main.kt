package converter
import java.util.*

var numToCentral: Double = 0.0
var degree: String = ""
var startUnit: String = ""
var fillerString: String = ""
var degree2: String = ""
var finalUnit: String = "splitInput[3]"

class Measurement(numToCheck: Double, firstUnit: String, midString: String, finalUnit: String) {
    val numSet = numToCheck
    val firstUnitSet = firstUnit
    val midStringSet = midString
    val finalUnitSet = finalUnit

    var firstUnit1 = abbreviation(this.firstUnitSet)
    var finalUnit1 = abbreviation(this.finalUnitSet)

    val typeOfMeasure = when (firstUnit1) {
        "m", "km", "cm", "mm", "mi", "yd", "ft", "in" -> Length.isLength(firstUnit1)
        "g", "kg", "mg", "lb", "oz" -> Weight.isWeight(firstUnit1)
        "c", "f", "k" -> Temp.isTemp(firstUnit1)
        else ->  "Nothing there"
    }

    val typeToConvert = when (finalUnit1) {
        "m", "km", "cm", "mm", "mi", "yd", "ft", "in" -> Length.isLength(finalUnit1)
        "g", "kg", "mg", "lb", "oz" -> Weight.isWeight(finalUnit1)
        "c", "f", "k" -> Temp.isTemp(finalUnit1)
        else ->  "Nothing there"
    }


    fun goodToGo() {
        if ((typeOfMeasure == typeToConvert) && typeToConvert != "Nothing there") {
            val toBegin = toCentral(numSet, firstUnit1)
            val toEnd = converter(toBegin, finalUnit1)
            if ((Weight.isWeight(firstUnit1) == "isWeight" && numSet < 0) || (Weight.isWeight(finalUnit1) == "isWeight" && toEnd < 0)) {
                println("Enter what you want to convert (or exit): Weight shouldn't be negative.")
            } else if ((Length.isLength(firstUnit1) == "isLength" && numSet < 0) || (Length.isLength(finalUnit1) == "isLength" && toEnd < 0)) {
                println("Enter what you want to convert (or exit): Length shouldn't be negative.")
            }else {
                val firstUnitFull = fullUnit(numSet, firstUnit1)
                val finalUnitFull = fullUnit(toEnd, finalUnit1)
                println("Enter what you want to convert (or exit): $numSet $firstUnitFull is $toEnd $finalUnitFull")
            }
        } else {
            val finalUnitFull1 = fullUnit(2.0, finalUnit1)
            val firstUnitFull1 = fullUnit(2.0, firstUnit1)
            println("Enter what you want to convert (or exit): Conversion from $firstUnitFull1 to $finalUnitFull1 is impossible")
        }
    }
}

enum class Length(private val originalUnitToCheck: String) {
    M("meter"),
    KM("kilometer"),
    CM("centimeter"),
    MM("millimeter"),
    MI("mile"),
    YD("yard"),
    FT("foot"),
    IN("inch"),
    Null("???");

    companion object {
        fun isLength(length: String) : String {
            for (enum in Length.values()) {
                if (length.toUpperCase() == enum.name) return "isLength"
            }
            return "???"
        }
    }
}

enum class Weight(private val originalUnitToCheck: String) {
    G("gram"),
    KG("kilogram"),
    MG("milligram"),
    LB("pound"),
    OZ("ounce"),
    Null("???");

    companion object {
        fun isWeight(weight: String) : String {
            for (enum in Weight.values()) {
                if (weight.toUpperCase() == enum.name) return "isWeight"
            }
            return "???"
        }
    }
}

enum class Temp(private val originalUnitToCheck: String) {
    K("kelvin"),
    C("celsius"),
    F("fahrenheit"),
    Null("???");

    companion object {
        fun isTemp(temp: String) : String {
            for (enum in Temp.values()) {
                if (temp.toUpperCase() == enum.name) return "isTemp"
            }
            return "???"
        }
    }
}

fun toCentral(originalNumToConvert: Double,originalUnitToConvert: String): Double {
    var numToConvert: Double = originalNumToConvert

    when (originalUnitToConvert.toLowerCase()) {
        "m", "meter", "meters" -> numToConvert *= 1
        "km", "kilometer", "kilometers" ->  numToConvert *= 1000
        "cm", "centimeter", "centimeters" -> numToConvert *= 0.01
        "mm", "millimeter", "millimeters" -> numToConvert *= 0.001
        "mi", "mile", "miles" -> numToConvert *= 1609.35
        "yd", "yard", "yards" -> numToConvert *= 0.9144
        "ft", "foot", "feet" -> numToConvert *= 0.3048
        "in", "inch", "inches" -> numToConvert *= 0.0254
    }

    when (originalUnitToConvert.toLowerCase()) {
        "g", "gram", "grams" -> numToConvert *= 1
        "kg", "kilogram", "kilograms" -> numToConvert *= 1000
        "mg", "milligram", "milligrams" -> numToConvert *= 0.001
        "lb", "pound", "pounds" -> numToConvert *= 453.592
        "oz", "ounce", "ounces" -> numToConvert *= 28.3495
    }

    when (originalUnitToConvert.toLowerCase()) {
        "degree celsius", "degrees celsius", "celsius", "dc", "c" -> numToConvert *= 1
        "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f" -> numToConvert = (numToConvert -32) * 5/9
        "kelvin", "kelvins", "k" -> numToConvert -= 273.15
    }

    return numToConvert

}

fun converter(originalNumToConvert: Double,originalUnitToConvert: String): Double {
    var numToConvert: Double = originalNumToConvert

    when (originalUnitToConvert.toLowerCase()) {
        "m", "meter", "meters" -> numToConvert *= 1
        "km", "kilometer", "kilometers" ->  numToConvert /= 1000
        "cm", "centimeter", "centimeters" -> numToConvert /= 0.01
        "mm", "millimeter", "millimeters" -> numToConvert /= 0.001
        "mi", "mile", "miles" -> numToConvert /= 1609.35
        "yd", "yard", "yards" -> numToConvert /= 0.9144
        "ft", "foot", "feet" -> numToConvert /= 0.3048
        "in", "inch", "inches" -> numToConvert /= 0.0254
    }

    when (originalUnitToConvert.toLowerCase()) {
        "g", "gram", "grams" -> numToConvert *= 1
        "kg", "kilogram", "kilograms" -> numToConvert /= 1000
        "mg", "milligram", "milligrams" -> numToConvert /= 0.001
        "lb", "pound", "pounds" -> numToConvert /= 453.592
        "oz", "ounce", "ounces" -> numToConvert /= 28.3495
    }

    when (originalUnitToConvert.toLowerCase()) {
        "degree celsius", "degrees celsius", "celsius", "dc", "c" -> numToConvert *= 1
        "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f" -> numToConvert = numToConvert * 9/5 + 32
        "kelvin", "kelvins", "k" -> numToConvert += 273.15
    }

    return numToConvert

}

fun fullUnit(originalNumToConvert: Double, originalUnitToConvert: String): String {

    var unitToConvert: String = originalUnitToConvert

    when (originalUnitToConvert.toLowerCase()) {
        "m", "meter", "meters" -> unitToConvert = "meters"
        "km", "kilometer", "kilometers" -> unitToConvert = "kilometers"
        "cm", "centimeter", "centimeters" -> unitToConvert = "centimeters"
        "mm", "millimeter", "millimeters" -> unitToConvert = "millimeters"
        "mi", "mile", "miles" -> unitToConvert = "miles"
        "yd", "yard", "yards" -> unitToConvert = "yards"
        "ft", "foot", "feet" -> unitToConvert = "feet"
        "in", "inch", "inches" -> unitToConvert = "inches"
        "g", "gram", "grams" -> unitToConvert = "grams"
        "kg", "kilogram", "kilograms" -> unitToConvert = "kilograms"
        "mg", "milligram", "milligrams" -> unitToConvert = "milligrams"
        "lb", "pound", "pounds" -> unitToConvert = "pounds"
        "oz", "ounce", "ounces" -> unitToConvert = "ounces"
        "degree celsius", "degrees celsius", "celsius", "dc", "c" -> unitToConvert = "degrees Celsius"
        "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f" -> unitToConvert = "degrees Fahrenheit"
        "kelvin", "kelvins", "k" -> unitToConvert = "Kelvins"
        "???" -> unitToConvert = "???"
    }

    if (originalNumToConvert == 1.0 && unitToConvert != "feet" && unitToConvert != "degrees Celsius" && unitToConvert != "degrees Fahrenheit") {
        unitToConvert = unitToConvert.trim('s')
    } else if (originalNumToConvert == 1.0 && unitToConvert == "feet" && unitToConvert != "degrees Celsius") {
        unitToConvert = "foot"
    } else if (originalNumToConvert == 1.0 && unitToConvert == "degrees Celsius") {
        unitToConvert = "degree Celsius"
    } else if (originalNumToConvert == 1.0 && unitToConvert == "degrees Fahrenheit") {
        unitToConvert = "degree Fahrenheit"
    }

    return unitToConvert
}

fun abbreviation(originalUnitToConvert: String): String {

    var unitToConvert: String = originalUnitToConvert

    when (originalUnitToConvert.toLowerCase()) {
        "m", "meter", "meters" -> unitToConvert = "m"
        "km", "kilometer", "kilometers" -> unitToConvert = "km"
        "cm", "centimeter", "centimeters" -> unitToConvert = "cm"
        "mm", "millimeter", "millimeters" -> unitToConvert = "mm"
        "mi", "mile", "miles" -> unitToConvert = "mi"
        "yd", "yard", "yards" -> unitToConvert = "yd"
        "ft", "foot", "feet" -> unitToConvert = "ft"
        "in", "inch", "inches" -> unitToConvert = "in"
        "g", "gram", "grams" -> unitToConvert = "g"
        "kg", "kilogram", "kilograms" -> unitToConvert = "kg"
        "mg", "milligram", "milligrams" -> unitToConvert = "mg"
        "lb", "pound", "pounds" -> unitToConvert = "lb"
        "oz", "ounce", "ounces" -> unitToConvert = "oz"
        "degree celsius", "degrees celsius", "celsius", "dc", "c" -> unitToConvert = "c"
        "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f" -> unitToConvert = "f"
        "kelvin", "kelvins", "k" -> unitToConvert = "k"
        else -> unitToConvert = "???"
    }

    return unitToConvert
}

fun checkParse(num: String): Boolean {
    var isNull = num.toDoubleOrNull()
    return isNull != null
}

fun main() {

    val scanner = Scanner(System.`in`)
    var input = scanner.nextLine().toLowerCase()

    while (input != "exit") {
        var splitInput = input.split(" ")
        var hasDegree = splitInput.contains("degree")
        var hasDegrees = splitInput.contains("degrees")

        val firstDegreeIndex = splitInput.indexOf("degree")
        val lastDegreeIndex = splitInput.lastIndexOf("degree")
        val firstDegreesIndex = splitInput.indexOf("degrees")
        val lastDegreesIndex = splitInput.lastIndexOf("degrees")

        val twoDegree: Boolean = (firstDegreeIndex == 1 && lastDegreeIndex == 4)
        val twoDegrees: Boolean = (firstDegreesIndex == 1 && lastDegreesIndex == 4)

        var checkInput = checkParse(splitInput[0])

        if (checkInput) {

            var numToCentral = splitInput[0].toDouble()
            var degree: String = ""
            var startUnit = splitInput[1]
            var fillerString = splitInput[2]
            var degree2: String = ""
            var finalUnit = splitInput[3]

            if (((hasDegree || hasDegrees) && (lastDegreeIndex == 1 || lastDegreesIndex == 1) && (lastDegreesIndex == 4 || lastDegreeIndex == 4)) || (twoDegree || twoDegrees)) {
                degree = splitInput[1]
                startUnit = splitInput[2]
                fillerString = splitInput[3]
                degree2 = splitInput[4]
                finalUnit = splitInput[5]
            } else if ((hasDegree && lastDegreeIndex == 3) || (hasDegrees && lastDegreesIndex == 3)) {
                startUnit = splitInput[1]
                fillerString = splitInput[2]
                degree2 = splitInput[3]
                finalUnit = splitInput[4]
            } else if ((hasDegree && lastDegreeIndex == 1 && lastDegreeIndex != 4) || (hasDegrees && lastDegreesIndex == 1 && lastDegreesIndex != 4)) {
                degree = splitInput[1]
                startUnit = splitInput[2]
                fillerString = splitInput[3]
                finalUnit = splitInput[4]
            } else if ((hasDegree && lastDegreeIndex < 2) || (hasDegrees && lastDegreesIndex < 2)) {
                degree = splitInput[1]
                startUnit = splitInput[2]
                fillerString = splitInput[3]
                finalUnit = splitInput[4]
            }

            val toConvert = Measurement(numToCentral, startUnit, fillerString, finalUnit).goodToGo()

        } else {
            println("Parse error")
        }

        input = scanner.nextLine().toLowerCase()

    }
    println("Enter what you want to convert (or exit):")
}