package com.lylx.learn.useSealedClass

/**
 * 所有子类都必须在与密封类自身相同的文件中声明
 * 在 Kotlin 1.1 之前， 该规则更加严格：子类必须嵌套在密封类声明的内部
 */
sealed class PlayerCmd {
    /**
     * 一个实例是object，多个实例用class
     */
    class Play(val url: String, val position: Long = 0): PlayerCmd()

    class Seek(val position: Long): PlayerCmd()

    object Pause: PlayerCmd()

    object Resume: PlayerCmd()

    object Stop: PlayerCmd()
}