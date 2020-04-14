package converter
//import com.sun.org.apache.xpath.internal.operations.Bool
//import java.util.*
//
//class Measurement(numToCheck: Double, firstUnit: String, midString: String, finalUnit: String) {
//    val numSet = numToCheck
//    val firstUnitSet = firstUnit
//    val midStringSet = midString
//    val finalUnitSet = finalUnit
//
//    var firstUnit1 = abbreviation(this.firstUnitSet)
//    var finalUnit1 = abbreviation(this.finalUnitSet)
//
//    val typeOfMeasure = when (firstUnit1) {
//        "m", "km", "cm", "mm", "mi", "yd", "ft", "in" -> Length.isLength(firstUnit)
//        "g", "kg", "mg", "lb", "oz" -> Weight.isWeight(firstUnit)
//        "c", "f", "k" -> Temp.isTemp(firstUnit)
//        else ->  "Nothing there"
//    }
//
//    val typeToConvert = when (finalUnit1) {
//        "m", "km", "cm", "mm", "mi", "yd", "ft", "in" -> Length.isLength(finalUnit)
//        "g", "kg", "mg", "lb", "oz" -> Weight.isWeight(finalUnit)
//        "c", "f", "k" -> Temp.isTemp(finalUnit)
//        else ->  "Nothing there"
//    }
//
//    val firstUnitFull = fullUnit(numSet, firstUnit1)
//    val finalUnitFull = fullUnit(numSet, finalUnit1)
//
//    fun goodToGo() {
//        if (typeOfMeasure == typeToConvert) {
//            val toBegin = toCentral(numSet, firstUnit1)
//            val toEnd = converter(toBegin, finalUnit1)
//            println("Enter what you want to convert (or exit): $numSet $firstUnitFull $midStringSet $finalUnitFull $numSet $firstUnitFull is $toEnd $finalUnitFull")
//        } else {
//            println("Conversion from $firstUnitFull to $finalUnitFull is impossible")
//        }
//    }
//}
//
//enum class Length(private val originalUnitToCheck: String) {
//    M("meter"),
//    KM("kilometer"),
//    CM("centimeter"),
//    MM("millimeter"),
//    MI("mile"),
//    YD("yard"),
//    FT("foot"),
//    IN("inch"),
//    Null("???");
//
//    companion object {
//        fun isLength(length: String) : String {
//            for (enum in Length.values()) {
//                if (length.toUpperCase() == enum.name) return "isLength"
//            }
//            return "???"
//        }
//    }
//
///*
//fun convert(amountToConvert: Double, initialType: String, finalType: String) {
//if (Length.isLength(initialType) == Length.isLength(finalType)) {
//val toBegin = toCentral(amountToConvert, initialType)
//val toEnd = converter(toBegin, finalType)
//} else if (Length.isLength(initialType) != Length.isLength(finalType)) {
//println("Conversion from $initialType to $finalType is impossible")
//}
//}
//*/
//}
//
//enum class Weight(private val originalUnitToCheck: String) {
//    G("gram"),
//    KG("kilogram"),
//    MG("milligram"),
//    LB("pound"),
//    OZ("ounce"),
//    Null("???");
//
//    companion object {
//        fun isWeight(weight: String) : String {
//            for (enum in Weight.values()) {
//                if (weight.toUpperCase() == enum.name) return "isWeight"
//            }
//            return "???"
//        }
//    }
//
///*
//fun convert(amountToConvert: Double, initialType: String, finalType: String) {
//if (Weight.isWeight(initialType) == Weight.isWeight(finalType)) {
//val toBegin = toCentral(amountToConvert, initialType)
//val toEnd = converter(toBegin, finalType)
//} else if (Weight.isWeight(initialType) != Weight.isWeight(finalType)) {
//println("Conversion from $initialType to $finalType is impossible")
//}
//}
//*/
//
//}
//
//enum class Temp(private val originalUnitToCheck: String) {
//    K("kelvin"),
//    C("celsius"),
//    F("fahrenheit"),
//    Null("???");
//
//    companion object {
//        fun isTemp(temp: String) : String {
//            for (enum in Temp.values()) {
//                if (temp.toUpperCase() == enum.name) return "isTemp"
//            }
//            return "???"
//        }
//    }
//
//
///*
//fun convert(amountToConvert: Double, initialType: String, finalType: String) {
//if (Temp.isTemp(initialType) == Temp.isTemp(finalType)) {
//val toBegin = toCentral(amountToConvert, initialType)
//val toEnd = converter(toBegin, finalType)
//} else if (Temp.isTemp(initialType) != Temp.isTemp(finalType)) {
//println("Conversion from $initialType to $finalType is impossible")
//}
//}
//*/
//}
//
//fun toCentral(originalNumToConvert: Double,originalUnitToConvert: String): Double {
//    var numToConvert: Double = originalNumToConvert
//
//    when (originalUnitToConvert.toLowerCase()) {
//        "m", "meter", "meters" -> numToConvert *= 1
//        "km", "kilometer", "kilometers" ->  numToConvert *= 1000
//        "cm", "centimeter", "centimeters" -> numToConvert *= 0.01
//        "mm", "millimeter", "millimeters" -> numToConvert *= 0.001
//        "mi", "mile", "miles" -> numToConvert *= 1609.35
//        "yd", "yard", "yards" -> numToConvert *= 0.9144
//        "ft", "foot", "feet" -> numToConvert *= 0.3048
//        "in", "inch", "inches" -> numToConvert *= 0.0254
//    }
//
//    when (originalUnitToConvert.toLowerCase()) {
//        "g", "gram", "grams" -> numToConvert *= 1
//        "kg", "kilogram", "kilograms" -> numToConvert *= 1000
//        "mg", "milligram", "milligrams" -> numToConvert *= 0.001
//        "lb", "pound", "pounds" -> numToConvert *= 453.592
//        "oz", "ounce", "ounces" -> numToConvert *= 28.3495
//    }
//
//    when (originalUnitToConvert.toLowerCase()) {
//        "degree Celsius", "degrees Celsius", "celsius", "dc", "c" -> numToConvert *= 1
//        "degree Fahrenheit", "degrees Fahrenheit", "fahrenheit", "df", "f" -> numToConvert = (numToConvert -32) * 5/9
//        "Kelvin", "Kelvins", "k" -> numToConvert += 273.15
//    }
//
//    return numToConvert
//
//}
//
//fun converter(originalNumToConvert: Double,originalUnitToConvert: String): Double {
//    var numToConvert: Double = originalNumToConvert
//
//    when (originalUnitToConvert.toLowerCase()) {
//        "m", "meter", "meters" -> numToConvert *= 1
//        "km", "kilometer", "kilometers" ->  numToConvert /= 1000
//        "cm", "centimeter", "centimeters" -> numToConvert /= 0.01
//        "mm", "millimeter", "millimeters" -> numToConvert /= 0.001
//        "mi", "mile", "miles" -> numToConvert /= 1609.35
//        "yd", "yard", "yards" -> numToConvert /= 0.9144
//        "ft", "foot", "feet" -> numToConvert /= 0.3048
//        "in", "inch", "inches" -> numToConvert /= 0.0254
//    }
//
//    when (originalUnitToConvert.toLowerCase()) {
//        "g", "gram", "grams" -> numToConvert *= 1
//        "kg", "kilogram", "kilograms" -> numToConvert /= 1000
//        "mg", "milligram", "milligrams" -> numToConvert /= 0.001
//        "lb", "pound", "pounds" -> numToConvert /= 453.592
//        "oz", "ounce", "ounces" -> numToConvert /= 28.3495
//    }
//
//    when (originalUnitToConvert.toLowerCase()) {
//        "degree Celsius", "degrees Celsius", "celsius", "dc", "c" -> numToConvert *= 1
//        "degree Fahrenheit", "degrees Fahrenheit", "fahrenheit", "df", "f" -> numToConvert = numToConvert * 9/5 + 32
//        "Kelvin", "Kelvins", "k" -> numToConvert -= 273.15
//    }
//
//    return numToConvert
//
//}
//
//fun fullUnit(originalNumToConvert: Double, originalUnitToConvert: String): String {
//
//    var unitToConvert: String = originalUnitToConvert
//
//    when (originalUnitToConvert.toLowerCase()) {
//        "m", "meter", "meters" -> unitToConvert = "meters"
//        "km", "kilometer", "kilometers" -> unitToConvert = "kilometers"
//        "cm", "centimeter", "centimeters" -> unitToConvert = "centimeters"
//        "mm", "millimeter", "millimeters" -> unitToConvert = "millimeters"
//        "mi", "mile", "miles" -> unitToConvert = "miles"
//        "yd", "yard", "yards" -> unitToConvert = "yards"
//        "ft", "foot", "feet" -> unitToConvert = "feet"
//        "in", "inch", "inches" -> unitToConvert = "inches"
//        "g", "gram", "grams" -> unitToConvert = "grams"
//        "kg", "kilogram", "kilograms" -> unitToConvert = "kilograms"
//        "mg", "milligram", "milligrams" -> unitToConvert = "milligrams"
//        "lb", "pound", "pounds" -> unitToConvert = "pounds"
//        "oz", "ounce", "ounces" -> unitToConvert = "ounces"
//        "degree Celsius", "degrees Celsius", "celsius", "dc", "c" -> unitToConvert = "celsius"
//        "degree Fahrenheit", "degrees Fahrenheit", "fahrenheit", "df", "f" -> unitToConvert = "fahrenheit"
//        "Kelvin", "Kelvins", "k" -> unitToConvert = "kelvin"
//        "???" -> unitToConvert = "???"
//    }
//
//    if (originalNumToConvert == 1.0 && unitToConvert != "feet") {
//        unitToConvert = unitToConvert.trim('s')
//    } else if (originalNumToConvert == 1.0 && unitToConvert == "feet") {
//        unitToConvert = "foot"
//    }
//
//    return unitToConvert
//}
//
//fun abbreviation(originalUnitToConvert: String): String {
//
//    var unitToConvert: String = originalUnitToConvert
//
//    when (originalUnitToConvert.toLowerCase()) {
//        "m", "meter", "meters" -> unitToConvert = "m"
//        "km", "kilometer", "kilometers" -> unitToConvert = "km"
//        "cm", "centimeter", "centimeters" -> unitToConvert = "cm"
//        "mm", "millimeter", "millimeters" -> unitToConvert = "mm"
//        "mi", "mile", "miles" -> unitToConvert = "mi"
//        "yd", "yard", "yards" -> unitToConvert = "yd"
//        "ft", "foot", "feet" -> unitToConvert = "ft"
//        "in", "inch", "inches" -> unitToConvert = "in"
//        "g", "gram", "grams" -> unitToConvert = "g"
//        "kg", "kilogram", "kilograms" -> unitToConvert = "kg"
//        "mg", "milligram", "milligrams" -> unitToConvert = "mg"
//        "lb", "pound", "pounds" -> unitToConvert = "lb"
//        "oz", "ounce", "ounces" -> unitToConvert = "oz"
//        "degree Celsius", "degrees Celsius", "celsius", "dc", "c" -> unitToConvert = "c"
//        "degree Fahrenheit", "degrees Fahrenheit", "fahrenheit", "df", "f" -> unitToConvert = "f"
//        "Kelvin", "Kelvins", "k" -> unitToConvert = "k"
//    }
//    return unitToConvert
//}
//
//
//fun main() {
//
//    val scanner = Scanner(System.`in`)
//    var input = scanner.next()
//
//    while (input != "exit") {
//        val numToCentral = input.toDouble()
//        val unitToStart = scanner.next()
//        val fillerString = scanner.next()
//        val unitToEnd = scanner.next()
//
//        val toConvert = Measurement(numToCentral, unitToStart, fillerString, unitToEnd).goodToGo()
//
//        input = scanner.next()
///*
//val centralNum = toCentral(numToCentral, unitToStart)
//val convertedNum = converter(centralNum, unitToEnd)
//val fullStartUnit = fullUnit(numToCentral, unitToStart)
//val fullEndUnit = fullUnit(convertedNum, unitToEnd)
//
////        println("Enter what you want to convert (or exit): $numToCentral $fullStartUnit $fillerString $fullEndUnit")
//println("Enter what you want to convert (or exit): $numToCentral $fullStartUnit is $convertedNum $fullEndUnit")
//        println("Enter what you want to convert (or exit): $numToCentral $fullStartUnit $fillerString $fullEndUnit $numToCentral $fullStartUnit is $convertedNum $fullEndUnit")
//input = scanner.next()
//*/
//    }
//
//    println("Enter what you want to convert (or exit):")
//}
