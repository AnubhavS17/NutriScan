package project.nutriscan.utils

class UtilityFunctions {

    companion object {

        fun getAdditiveFullName(code: String): String {

            // Map of additive codes to their full names
            val additivesMap = mapOf(
                "E100" to "Curcumin",
                "E101" to "Riboflavin",
                "E102" to "Tartrazine",
                "E103" to "Alkanet",
                "E104" to "Quinoline Yellow",
                "E105" to "Fast Yellow",
                "E106" to "Carmine",
                "E106B" to "Annatto Extract",
                "E110" to "Sunset Yellow FCF",
                "E120" to "Cochineal Red A",
                "E122" to "Carmoisine",
                "E123" to "Amaranth",
                "E124" to "Ponceau 4R",
                "E125" to "Ponceau 6R",
                "E126" to "Erythrosine",
                "E127" to "Erythrosine B",
                "E128" to "Red 2G",
                "E129" to "Allura Red AC",
                "E130" to "Watermelon Red",
                "E140" to "Chlorophylls",
                "E141" to "Copper Complexes of Chlorophylls",
                "E150" to "Caramel",
                "E151" to "Black PN",
                "E160" to "Carotenoids",
                "E161" to "Lycopene",
                "E162" to "Beet Red",
                "E163" to "Anthocyanins",
                "E170" to "Calcium Carbonate",
                "E171" to "Titanium Dioxide",
                "E172" to "Iron Oxides",
                "E173" to "Aluminum",
                "E200" to "Sorbic Acid",
                "E202" to "Potassium Sorbate",
                "E210" to "Benzoic Acid",
                "E211" to "Sodium Benzoate",
                "E220" to "Sulfur Dioxide",
                "E221" to "Sodium Sulfite",
                "E222" to "Sodium Bisulfite",
                "E223" to "Sodium Metabisulfite",
                "E224" to "Potassium Metabisulfite",
                "E250" to "Sodium Nitrite",
                "E251" to "Sodium Nitrate",
                "E252" to "Potassium Nitrate",
                "E300" to "Ascorbic Acid",
                "E301" to "Sodium Ascorbate",
                "E302" to "Calcium Ascorbate",
                "E330" to "Citric Acid",
                "E331" to "Sodium Citrate",
                "E332" to "Potassium Citrate",
                "E333" to "Calcium Citrate",
                "E334" to "Tartaric Acid",
                "E335" to "Sodium Tartrate",
                "E336" to "Potassium Tartrate",
                "E337" to "Sodium Potassium Tartrate",
                "E400" to "Agar",
                "E401" to "Sodium Alginate",
                "E402" to "Potassium Alginate",
                "E500" to "Sodium carbonate.",
                "E500II" to "Sodium Bicarbonate."
            )

            // Return the full name or "Unknown Additive" if not found

            return additivesMap[code] ?: "Unknown Additive"

        }
    }
}