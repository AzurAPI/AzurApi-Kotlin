package com.github.azurapi.azurapikotlin.internal.entities

/**
 * Equipment type
 * @param focus
 * @param name
 */
data class EquipmentType(
    val focus: String,
    val name: String
)

/**
 * Damage stats
 * @param min
 * @param max
 * @param multiplier
 */
data class DamageStats(
    val type: String,
    val min: Int,
    val max: Int,
    val multiplier: Int,
    val formatted: String
)

/**
 * Rate of fire stats
 * @param min
 * @param max
 * @param per
 */
data class RateOfFireStats(
    val type: String,
    val min: Float,
    val max: Float,
    val per: String,
    val formatted: String
)

/**
 * Representation of a value with type
 */
data class TypeValue(
    val type: String,
    val value: Int,
    val formatted: String
)

/**
 * Representation of a value with type and unit
 */
data class UnitTypeValue(
    val type: String,
    val value: Int,
    val unit: String,
    val formatted: String
)

/**
 * Volley stats
 * @param multiplier
 * @param count
 * @param unit
 */
data class VolleyStats(
    val type: String,
    val multiplier: Int,
    val count: Int,
    val unit: String,
    val formatted: String
)

/**
 * Characteristic
 * @param type
 * @param value
 * @param formatted
 */
data class CharacteristicValue(
    val type: String,
    val value: String,
    val formatted: String
)

/**
 * Equipment stats
 * @param firepower
 * @param antiAir
 * @param damage
 * @param rateOfFire
 * @param spread
 * @param angle
 * @param range
 * @param volley
 * @param volleyTime
 * @param coefficient
 * @param ammoType
 * @param characteristic
 */
data class EquipmentStats(
    val firepower: TypeValue?,
    val antiAir: TypeValue?,
    val damage: DamageStats?,
    val rateOfFire: RateOfFireStats,
    val spread: UnitTypeValue,
    val angle: UnitTypeValue,
    val range: TypeValue,
    val volley: VolleyStats?,
    val volleyTime: TypeValue?,
    val coefficient: TypeValue?,
    val ammoType: TypeValue?,
    val characteristic: CharacteristicValue,
    val torpedo: TypeValue?,
    val numberOfTorpedoes: UnitTypeValue?
)

/**
 * Ship types fit
 * @param destroyer
 * @param lightCruiser
 * @param heavyCruiser
 * @param monitor
 * @param largeCruiser
 * @param battleship
 * @param battlecruiser
 * @param aviationBattleship
 * @param aircraftCarrier
 * @param lightCarrier
 * @param repairShip
 * @param submarine
 * @param submarineCarrier
 */
data class EquipmentFits(
    val destroyer: EquipmentFit,
    val lightCruiser: EquipmentFit,
    val heavyCruiser: EquipmentFit,
    val monitor: EquipmentFit,
    val largeCruiser: EquipmentFit,
    val battleship: EquipmentFit,
    val battlecruiser: EquipmentFit,
    val aviationBattleship: EquipmentFit,
    val aircraftCarrier: EquipmentFit,
    val lightCarrier: EquipmentFit,
    val repairShip: EquipmentFit,
    val submarine: EquipmentFit,
    val submarineCarrier: EquipmentFit
)

/**
 * Miscellaneous info of an equipment
 * @param obtainedFrom
 * @param notes
 * @param animation
 */
data class EquipmentMiscellaneous(
    val obtainedFrom: String,
    val notes: String,
    val animation: String
)

/**
 * Tiers stats
 */
data class Tier(
    val tier: String,
    val rarity: String,
    val stars: Stars,
    val stats: EquipmentStats
)

/**
 * Class representation of an equipment
 */
data class Equipment(
    val wikiUrl: String,
    val category: String,
    val names: Name,
    val type: EquipmentType,
    val nationality: String,
    val image: String,
    val fits: EquipmentFits,
    val misc: EquipmentMiscellaneous,
    val tiers: Map<String, Tier>
)
